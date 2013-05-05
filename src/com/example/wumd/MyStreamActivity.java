package com.example.wumd;

import java.io.IOException;

import android.app.Activity;
import android.app.ProgressDialog;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AbsoluteLayout;
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
	    bt.setBackgroundResource(R.drawable.playbutton);
//	    bt.setWidth(20);
//	    bt.setHeight(20);
	    bt.setVisibility(View.VISIBLE);
//	    AbsoluteLayout.LayoutParams OBJ = new AbsoluteLayout.LayoutParams(40,40,100,100);
//	    bt.setLayoutParams(OBJ);
	}
	
	
    public void onMyButtonClick(View view){	    	
        if (!playPause) {
            bt.setBackgroundResource(R.drawable.pause);
            if (initialStage)
                new Player()
                        .execute("http://streams.umd.umich.edu:8000/wumd.mp3");
            else {
                if (!mediaPlayer.isPlaying())
                    mediaPlayer.start();
            }
            playPause = true;
        } else {
            bt.setBackgroundResource(R.drawable.playbutton);
            if (mediaPlayer.isPlaying())
                mediaPlayer.pause();
            playPause = false;
        }
    }


    class Player extends AsyncTask<String, Void, Boolean> {
        private ProgressDialog progress;

        @Override
        protected Boolean doInBackground(String... params) {
            // TODO Auto-generated method stub
            Boolean prepared;
            try {

                mediaPlayer.setDataSource(params[0]);

                mediaPlayer.setOnCompletionListener(new OnCompletionListener() {

                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        // TODO Auto-generated method stub
                    	initialStage = true;
                        playPause=false;
                        bt.setBackgroundResource(R.drawable.playbutton);
                        if (mediaPlayer != null){
                            mediaPlayer.stop();
                            mediaPlayer.reset();

                        }
                    }
                });
                mediaPlayer.prepare();
                prepared = true;
            } catch (IllegalArgumentException e) {
                // TODO Auto-generated catch block
                Log.d("IllegarArgument", e.getMessage());
                prepared = false;
                e.printStackTrace();
            } catch (SecurityException e) {
                // TODO Auto-generated catch block
                prepared = false;
                e.printStackTrace();
            } catch (IllegalStateException e) {
                // TODO Auto-generated catch block
                prepared = false;
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                prepared = false;
                e.printStackTrace();
            }
            return prepared;
        }

        @Override
        protected void onPostExecute(Boolean result) {
            // TODO Auto-generated method stub
            super.onPostExecute(result);
            if (progress.isShowing()) {
                progress.cancel();
            }
            Log.d("Prepared", "//" + result);
            mediaPlayer.start();

            initialStage = false;
        }

        public Player() {
            progress = new ProgressDialog(MyStreamActivity.this);
        }

        @Override
        protected void onPreExecute() {
            // TODO Auto-generated method stub
            super.onPreExecute();
            this.progress.setMessage("Buffering...");
            this.progress.show();

        }
    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
    	Log.d("message", "was called pause");
        super.onPause();

    }
}
