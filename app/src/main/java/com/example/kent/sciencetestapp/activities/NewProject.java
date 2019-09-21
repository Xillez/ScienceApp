package com.example.kent.sciencetestapp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.kent.sciencetestapp.utils.MenuMgr;
import com.example.kent.sciencetestapp.R;
import com.example.kent.sciencetestapp.utils.ToolbarMgr;

public class NewProject extends AppCompatActivity
{
    public ToolbarMgr toolbarMgr = new ToolbarMgr();
    public MenuMgr menuMgr = new MenuMgr();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_project);

        // Add toolbar and remove the title
        toolbarMgr.makeToolBar(this, R.id.toolbar02_back, true, this::finish);
    }

    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Make menu
        return menuMgr.createMenu(this, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Try handling it. If not handled relay to super class
        if (!menuMgr.handleMenuEvent(item))
            return super.onOptionsItemSelected(item);
        return true;
    }

    @Override
    public void onPanelClosed(int featureId, Menu menu)
    {
        super.onPanelClosed(featureId, menu);
    }
}
