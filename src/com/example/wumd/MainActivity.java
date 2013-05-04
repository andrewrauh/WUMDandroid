package com.example.wumd;

import android.os.Bundle;
import android.app.TabActivity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
 



public class MainActivity extends TabActivity {
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TabHost tabHost = getTabHost();
		Log.v("myApp", "got here!");

        //Tab for Streaming Page
        TabSpec myStreamSpec = tabHost.newTabSpec("Listen");
        myStreamSpec.setIndicator("Listen");
        Intent streamIntent = new Intent(this, MyStreamActivity.class);
        myStreamSpec.setContent(streamIntent);
        
        //Tab for CalView 	
        TabSpec myCalSpec = tabHost.newTabSpec("Calendar");
        myCalSpec.setIndicator("Calendar");
        Intent calendarIntent = new Intent(this, MyCalView.class);
        myCalSpec.setContent(calendarIntent);
        
        //Tab for DJ Profile
        TabSpec myDJSpec = tabHost.newTabSpec("Profiles");
        myDJSpec.setIndicator("DJ Profiles");
        Intent profilesIntent = new Intent(this, MyDJProfileActivity.class);
        myDJSpec.setContent(profilesIntent);
        
        //Tabs for Contact Page 
        tabHost.addTab(myStreamSpec); // Adding photos tab
        tabHost.addTab(myCalSpec); // Adding songs tab
        tabHost.addTab(myDJSpec); // Adding videos tab
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    

}
