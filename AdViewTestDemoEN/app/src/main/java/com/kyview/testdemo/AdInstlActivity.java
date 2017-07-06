package com.kyview.testdemo;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.kyview.InitConfiguration;
import com.kyview.interfaces.AdViewInstlListener;
import com.kyview.manager.AdViewInstlManager;
import com.unity3d.player.UnityPlayer;

public class AdInstlActivity extends  Activity {



	private Context context = null;

	private final String DEFAULTCAMERA = "Main_Camera";


	private final String TAG = "AdViewUnity3DDemo";



	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_adinstl);

		this.context = this;



		//Initialization for interstitual advertisement
		AdViewInstlManager.getInstance(this).init(MainActivity.initConfiguration,new String[]{MainActivity.SDK_KEY});

		//Requesting for Interstitual Advertisement
		findViewById(R.id.requestad).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				requestInstl();
			}
		});


		//Showing Interstitual Advertisement
		findViewById(R.id.requestshow).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				showInstl();
			}
		});




	}


	//Requesting Interstitual
	public void requestInstl() {


		((Activity) context).runOnUiThread(new Runnable() {
			@Override
			public void run() {
				instlLayout(MainActivity.SDK_KEY);
			}
		});


	}


	//Show Interstitual
	public void showInstl() {

		((Activity) context).runOnUiThread(new Runnable() {
			@Override
			public void run() {
				AdViewInstlManager.getInstance(context).showAd(context, MainActivity.SDK_KEY);
			}
		});

	}




	//InstaLayout Function for Requesting Ad
	public void instlLayout(String key) {

		AdViewInstlManager.getInstance(context).requestAd(context, key,
				new AdViewInstlListener() {

					@Override
					public void onAdRecieved(String arg0) {
						Log.i(TAG, "onReceivedAd");
						UnityPlayer.UnitySendMessage(DEFAULTCAMERA,
								"onReceivedAd", "");

						Toast.makeText(AdInstlActivity.this,"onReceivedAd",Toast.LENGTH_SHORT).show();
					}

					@Override
					public void onAdFailed(String arg0) {
						Log.i(TAG, "onReceivedAdFailed");
						UnityPlayer.UnitySendMessage(DEFAULTCAMERA,
								"onReceivedAdFailed", "");
						Toast.makeText(AdInstlActivity.this,"onReceivedAd",Toast.LENGTH_SHORT).show();

					}

					@Override
					public void onAdDisplay(String arg0) {
						Log.i(TAG, "onDisplayAd");
						UnityPlayer.UnitySendMessage(DEFAULTCAMERA,
								"onDisplayAd", "");
					}

					@Override
					public void onAdDismiss(String arg0) {
						Log.i(TAG, "onAdDismiss");
						UnityPlayer.UnitySendMessage(DEFAULTCAMERA,
								"onAdDismiss", "");
					}

					@Override
					public void onAdClick(String arg0) {
						Log.i(TAG, "onClickAd");
						UnityPlayer.UnitySendMessage(DEFAULTCAMERA,
								"onClickAd", "");
					}
				});
	}

}
