package com.example.wumd;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MyContactActivity extends Activity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.contact_layout);
	    // TODO Auto-generated method stub
	}
    public void onEmailManagerClick(View view){	 
    	Intent intent=new Intent(Intent.ACTION_SEND);
    	String[] recipients={"xyz@gmail.com"};
    	intent.putExtra(Intent.EXTRA_EMAIL, recipients);
    	intent.putExtra(Intent.EXTRA_SUBJECT,"abc");
    	intent.putExtra(Intent.EXTRA_TEXT,"def");
    	intent.putExtra(Intent.EXTRA_CC,"ghi");
    	intent.setType("text/html");
    	startActivity(Intent.createChooser(intent, "Send mail"));
    
    }
    
    public void onEmailAssManagerClick(View view){	 
    	Intent intent=new Intent(Intent.ACTION_SEND);
    	String[] recipients={"xyz@gmail.com"};
    	intent.putExtra(Intent.EXTRA_EMAIL, recipients);
    	intent.putExtra(Intent.EXTRA_SUBJECT,"abc");
    	intent.putExtra(Intent.EXTRA_TEXT,"def");
    	intent.putExtra(Intent.EXTRA_CC,"ghi");
    	intent.setType("text/html");
    	startActivity(Intent.createChooser(intent, "Send mail"));
    
    }
    

    public void onEmailHeadMusicClick(View view){	 
    	Intent intent=new Intent(Intent.ACTION_SEND);
    	String[] recipients={"xyz@gmail.com"};
    	intent.putExtra(Intent.EXTRA_EMAIL, recipients);
    	intent.putExtra(Intent.EXTRA_SUBJECT,"abc");
    	intent.putExtra(Intent.EXTRA_TEXT,"def");
    	intent.putExtra(Intent.EXTRA_CC,"ghi");
    	intent.setType("text/html");
    	startActivity(Intent.createChooser(intent, "Send mail"));
    
    }
    public void onEmailProgramDirectorClick(View view) {
    	Intent intent=new Intent(Intent.ACTION_SEND);
    	String[] recipients={"xyz@gmail.com"};
    	intent.putExtra(Intent.EXTRA_EMAIL, recipients);
    	intent.putExtra(Intent.EXTRA_SUBJECT,"abc");
    	intent.putExtra(Intent.EXTRA_TEXT,"def");
    	intent.putExtra(Intent.EXTRA_CC,"ghi");
    	intent.setType("text/html");
    	startActivity(Intent.createChooser(intent, "Send mail"));
    }
    
    public void callClick(View view){
    	Intent callIntent = new Intent(Intent.ACTION_CALL);
    	callIntent.setData(Uri.parse("tel:123456789"));
    	startActivity(callIntent);
    }

}
