package com.example.wumd;

import android.app.Activity;
import android.app.ProgressDialog;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MyStreamActivity extends Activity {
	//Variables
	Button bt;
	private boolean playPause;
	private MediaPlayer mediaPlayer;
	private boolean initialStage = true;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.stream_layout);
	    bt = (Button)findViewById(R.id.button1);
	    mediaPlayer = new MediaPlayer();
	    mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);	    
	    bt.setOnClickListener(new android.view.View.OnClickListener() {
	    	
	    	public void onClick(android.view.View v){
	    		if (!playPause){
	    			//set resource
	    			if (initialStage){
//	    				new Player()
//                        	.execute("http://www.virginmegastore.me/Library/Music/CD_001214/Tracks/Track1.mp3");
	    			}
	    			else {
	    				if (!mediaPlayer.isPlaying())
	    					mediaPlayer.start();
	    			}
	    			playPause = true;
	    		}
	    		else {
	    			//change resource
	    			if (mediaPlayer.isPlaying())
	    				mediaPlayer.pause();
	    			playPause = false;
	    		}
	    		Log.v("myApp", "got here!");
	    	}
	    });
	    // TODO Auto-generated method stub
	}
	
	
    public void onMyButtonClick(View view){
    	Log.v("myApp","got here!");
    }


class Player extends AsyncTask<String, Void, Boolean>{
	private ProgressDialog progress;
	
	@Override
	protected Boolean doInBackground(String... params) {
		// TODO Auto-generated method stub
		Boolean prepared = null;
		//return prepared;
		return prepared;

	}
}
}
