package com.example.kent.sciencetestapp;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class ProjectsActivity extends AppCompatActivity
{
    public ToolbarMgr toolbarMgr = new ToolbarMgr();

    /*protected ServiceConnection mServerConn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder binder) {
            Log.i("xillez", "onServiceConnected");
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.i("xillez", "onServiceDisconnected");
        }
    };

    public void onStart()
    {
        // mContext is defined upper in code, I think it is not necessary to explain what is it
        super.onStart();
        bindService(new Intent(this, UserInteractionConfigurationManager.class), mServerConn, Context.BIND_AUTO_CREATE);
        startService(new Intent(this, UserInteractionConfigurationManager.class));
    }

    public void onStop()
    {
        super.onStop();
        stopService(new Intent(this, UserInteractionConfigurationManager.class));
        unbindService(mServerConn);
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Add toolbar
        toolbarMgr.makeToolBar(this, R.id.toolbar, false, null);

        // Add new button for adding a new project
        FloatingActionButton newProjectButton = findViewById(R.id.newProjectButton);
        newProjectButton.setOnClickListener(v -> {
            // Start new project activity.
            Intent startNewProject = new Intent(this, NewProject.class);
            startActivity(startNewProject);
        });

        /*SpreadSheetMgr sheet = new SpreadSheetMgr(this);
        sheet.test();*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onPanelClosed(int featureId, Menu menu)
    {
        super.onPanelClosed(featureId, menu);
    }
}