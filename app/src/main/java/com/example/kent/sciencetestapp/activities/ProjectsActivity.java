package com.example.kent.sciencetestapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.example.kent.sciencetestapp.R;
import com.example.kent.sciencetestapp.utils.ToolbarMgr;

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

        FloatingActionButton fab = findViewById(R.id.newProjectButton);
        fab.setOnClickListener(view -> {
            Intent newProject = new Intent(getApplicationContext(), NewProject.class);;
            startActivity(newProject);
        });

        /*SpreadSheetMgr sheet = new SpreadSheetMgr(this);
        sheet.test();*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_project, menu);
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