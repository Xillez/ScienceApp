package com.example.kent.sciencetestapp;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.kent.sciencetestapp.Logging;
import com.example.kent.sciencetestapp.R;

public class MenuMgr
{
    AppCompatActivity activity;

    public boolean createMenu(AppCompatActivity activity, Menu menu)
    {
        this.activity = activity;

        // Inflate the menu; this adds items to the action bar if it is present.
        activity.getMenuInflater().inflate(R.menu.menu_main, menu);
        Log.i(Logging.LOG_INFO_TAG,"Nr Items in menu: " + menu.size());
        return true;
    }

    public boolean handleMenuEvent(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId())
        {
            case R.id.action_save:
            {
                Log.i(Logging.LOG_INFO_TAG, "Save clicked!");
                return true;
            }

            case R.id.action_saveTo:
            {
                Log.i(Logging.LOG_INFO_TAG, "SaveTo clicked!");
                return true;
            }

            case R.id.action_exportExcel:
            {
                Log.i(Logging.LOG_INFO_TAG, "Export clicked!");
                SpreadSheetMgr sheetMgr = new SpreadSheetMgr(this.activity);
                sheetMgr.test();
                return true;
            }

            case R.id.action_settings:
            {
                Log.i(Logging.LOG_INFO_TAG, "Settings clicked!");
                return true;
            }
        }

        // Couldn't handle event, indicate relaying to super class.
        return true;
    }

    /*public void closeMenu(int featureId, Menu menu)
    {
        //
    }*/
}
