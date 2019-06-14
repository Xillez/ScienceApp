package com.example.kent.sciencetestapp.nbmd;

import org.json.JSONObject;

import java.util.Iterator;

public class NBMData
{
    private JSONObject data = null;

    public JSONObject getAllNBMData()
    {
        return data;
    }

    public JSONObject getNBMData(String tag)
    {
        Iterator<String> keys = data.keys();
        while (keys.hasNext())
        {
            String key = keys.next();
        } (data.keys()
    }

    public void addNBMData(String tag, Object object)
    {

    }

    public void addNBMDataObjects(String tag, Object[] objects)
    {

    }
}
