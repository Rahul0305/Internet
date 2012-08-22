package com.rahul.webview.android;

 
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

public class WebviewProgressBarActivity extends Activity {
	private WebView webview;
	private static final String TAG = "Main";
	private ProgressDialog progressBar;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);

		setContentView(R.layout.main);

		this.webview = (WebView) findViewById(R.id.webview);

		WebSettings settings = webview.getSettings();
		settings.setJavaScriptEnabled(true);
		webview.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);

		final AlertDialog alertDialog = new AlertDialog.Builder(this).create();

		progressBar = ProgressDialog.show(WebviewProgressBarActivity.this, "MaxPowerSoft Example",
				"Loading...");

		webview.setWebViewClient(new WebViewClient() {
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				Log.i(TAG, "Processing webview url click...");
				view.loadUrl(url);
				return true;
			}

			public void onPageFinished(WebView view, String url) {
				Log.i(TAG, "Finished loading URL: " + url);
				if (progressBar.isShowing()) {
					progressBar.dismiss();
				}
			}

			public void onReceivedError(WebView view, int errorCode,
					String description, String failingUrl) {
				Log.e(TAG, "Error: " + description);
				Toast.makeText(getApplicationContext(), "Oh no! " + description,
						Toast.LENGTH_SHORT).show();
				alertDialog.setTitle("Error");
				alertDialog.setMessage(description);
				alertDialog.setButton("OK",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,
									int which) {
								return;
							}
						});
				alertDialog.show();
			}
		});
		webview.loadUrl("http://www.developercaster.com/2011/08/android-tip-enable-progress-bar-for.html");
	}
	
	
	/**
	 *   webview with horizontal progressBar
	 */
	
	/*WebView newswebview;
	ProgressBar pgb;
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		this.getWindow().requestFeature(Window.FEATURE_PROGRESS);
		setContentView(R.layout.newsdisplay);
		getWindow().setFeatureInt( Window.FEATURE_PROGRESS, Window.PROGRESS_VISIBILITY_ON); 
	 
		pgb = (ProgressBar) findViewById(R.id.progressBar);
		
		Intent indispaly = getIntent();
		String url = indispaly.getStringExtra("link");
				
		newswebview = (WebView) findViewById(R.id.news_webView);
		newswebview.setWebViewClient(new WebViewClient());
		
		WebSettings webSettings = newswebview.getSettings();
		webSettings.setJavaScriptEnabled(true);
		
		newswebview.getSettings().setSupportZoom(true);       //Zoom Control on web (You don't need this 
         //if ROM supports Multi-Touch      
		newswebview.getSettings().setBuiltInZoomControls(true); //Enable Multitouch if supported by ROM

		
		newswebview.loadUrl(url);
		
	 
		final Activity MyActivity = this;
		
	
	newswebview.setWebChromeClient(new WebChromeClient() {
        public void onProgressChanged(WebView view, int progress) 
           {
        	
        	//Make the bar disappear after URL is loaded, and changes string to Loading...
            MyActivity.setTitle("  Loading...");
            MyActivity.setProgress(progress * 100); //Make the bar disappear after URL is loaded
    
            // Return the app name after finish loading
               if(progress == 100){
            	
            	   MyActivity.setTitle(R.string.app_name);
            	   //this.requestWindowFeature(Window.FEATURE_NO_TITLE);
            	  // MyActivity.requestWindowFeature(Window.FEATURE_NO_TITLE); 
            	  // MyActivity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
               }
               
          
        }
    });
	
	}
	
	 @Override  
	    public boolean onKeyDown(int keyCode, KeyEvent event)   
	    {  
	        if ((keyCode == KeyEvent.KEYCODE_BACK) && newswebview.canGoBack()) {  
	        	newswebview.goBack();  
	            return true;  
	        }  
	        return super.onKeyDown(keyCode, event);  
	    }  */

	
	
	
}