package com.example.wumd;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class MyCalView extends Activity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.cal_layout);
	    
	    WebView mWebView = (WebView) findViewById(R.id.webView1);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.loadUrl("https://www.google.com/calendar/embed?src=wumd.org_37quienvilt3ksaioicf5erdv0@group.calendar.google.com&color=%23668CD9&mode=AGENDA&showTitle=0&showNav=0&showDate=1&showTabs=1&showCalendars=0&hl=en");
	}

}
