package com.example.kent.sciencetestapp.nbmd;

import android.util.Log;

import androidx.annotation.RecentlyNonNull;

import com.example.kent.sciencetestapp.utils.Logging;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;

public class NBMData
{
    public static final int BUILD_PATH_IF_INVALID = 1;

    private JSONObject data = new JSONObject();

    public JSONObject getAllNBMData()
    {
        return data;
    }

    public JSONObject getNBMData(String tag)
    {
        try
        {
            return this.findFirstWithTag(this.data, tag);
        } catch (JSONException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public void add(String path, String tag, Object object, int opt)
    {
        try
        {
            // If no path is given, add to root
            if (path.isEmpty() && !this.data.has(tag))
            {
                this.data.put(tag, object);
                return;
            }

            // Path was given
            JSONObject obj = this.data;
            // Dissect the path into steps
            String[] pathSteps = path.split("/");
            // Traverse the path if possible
            for (String segment : pathSteps)
            {
                // Step is valid, move on
                if (obj.has(segment))
                    obj = obj.getJSONObject(segment);
                else if (opt == NBMData.BUILD_PATH_IF_INVALID)   // Step is non-existent and should be made, make it.
                {
                    obj.put(segment, new JSONObject());
                    obj = (JSONObject) obj.get(segment);
                }
                else    // Step invalid and shouldn't be built, abort.
                {
                    obj = null;
                    break;
                }
            }

            // Path found, add.
            if (obj != null)
                obj.put(tag, obj);

        } catch (JSONException e)
        {
            e.printStackTrace();
            Log.e(Logging.LOG_ERR_TAG, "Could not remove given element at \"" + path + "\", named \"" + tag + "\"");
        }
    }

    public void remove(String path, String tag)
    {
        try
        {
            // If no path is give, add to root
            if (path.isEmpty() && !this.data.has(tag))
            {
                this.data.remove(tag);
                return;
            }

            // Path was given
            JSONObject obj = this.data;
            // Dissect the path into steps
            String[] pathSteps = path.split(",");
            // Traverse the path if possible
            for (String segment : pathSteps)
            {
                // Step is valid, move on
                if (obj.has(segment))
                    obj = obj.getJSONObject(segment);
                else    // Step is not valid, stop.
                {
                    obj = null;
                    break;
                }
            }

            // Path found, add.
            if (obj != null)
                obj.remove(tag);

        } catch (JSONException e)
        {
            e.printStackTrace();
            Log.e(Logging.LOG_ERR_TAG, "Could not remove given element at \"" + path + "\", named \"" + tag + "\"");
        }
    }

    public String toString()
    {
        return this.data.toString();
    }

    private JSONObject findFirstWithTag(JSONObject toSearch, String tag) throws JSONException
    {
        // Go through my keys and return if found, else check children, then give nothing
        Iterator<String> keys = toSearch.keys();
        while (keys.hasNext())
        {
            String key = keys.next();
            if (key.equals(tag))            // I have the key
                return toSearch.getJSONObject(key);
            else if (toSearch.getJSONObject(key).keys().hasNext())
            {
                return this.findFirstWithTag(toSearch.getJSONObject(key), tag);
            }
        }
        return null;
    }
}
