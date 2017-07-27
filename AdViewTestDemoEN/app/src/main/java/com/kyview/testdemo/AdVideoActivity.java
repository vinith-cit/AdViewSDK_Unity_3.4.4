package com.kyview.testdemo;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.kyview.interfaces.AdViewVideoListener;
import com.kyview.manager.AdViewVideoManager;
import com.unity3d.player.UnityPlayer;

/**
 * Created by vinith on 20/04/17.
 */

public class AdVideoActivity extends Activity {


	private Context context = null;

	private final String DEFAULTCAMERA = "Main_Camera";


	private final String TAG = "AdViewUnity3DDemo";




	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_advideo);

		this.context = this;


		//Initialization For Video ads
		AdViewVideoManager.getInstance(this).init(MainActivity.initConfiguration,new String[]{MainActivity.SDK_KEY});



		//Click Listener for Requesting Ad

		findViewById(R.id.requestad).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				requestVideo();


			}
		});


		//Click Listener for Showing Video Ad
		findViewById(R.id.showad).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				showVideo();


			}
		});


	}



	/**
	 * Requesting video Ad Function
	 */
	public void requestVideo() {
		((Activity) context).runOnUiThread(new Runnable() {
			@Override
			public void run() {
				videoLayout(MainActivity.SDK_KEY);
			}
		});

	}

	/**
	 * Requesting video Ad Function
	 * @param key
	 */
	public void videoLayout(String key) {
		AdViewVideoManager.getInstance(context).requestAd(context, key,
				new AdViewVideoListener() {

					@Override
					public void onAdClose(String arg0) {
						Log.i(TAG, "onAdClose");
						UnityPlayer.UnitySendMessage(DEFAULTCAMERA,
								"onAdClose", "");

					}

					@Override
					public void onAdReady(String s) {
						Log.e(TAG,"On AdReady");
						UnityPlayer.UnitySendMessage(DEFAULTCAMERA,
								"On AdReady", "");
						Toast.makeText(AdVideoActivity.this,"On AdReady",Toast.LENGTH_SHORT).show();

					}

					@Override
					public void onAdFailed(String arg0) {
						Log.i(TAG, "onAdFailed");
						UnityPlayer.UnitySendMessage(DEFAULTCAMERA,
								"onAdFailed", "");
						Toast.makeText(AdVideoActivity.this,"onAdFailed",Toast.LENGTH_SHORT).show();


					}

					@Override
					public void onAdPlayEnd(String arg0, Boolean arg1) {
						Log.i(TAG, "onAdPlayEnd");

					}

					@Override
					public void onAdPlayStart(String arg0) {
						Log.i(TAG, "onAdPlayStart");
						UnityPlayer.UnitySendMessage(DEFAULTCAMERA,
								"onAdPlayStart", "");

					}

					@Override
					public void onAdRecieved(String arg0) {
						Log.i(TAG, "onAdRecieved");
						UnityPlayer.UnitySendMessage(DEFAULTCAMERA,
								"onAdRecieved", "");
						Toast.makeText(AdVideoActivity.this,"onReceivedAd",Toast.LENGTH_SHORT).show();

					}
				});
	}

	/**
	 * Showing Ad Video Ad
	 */
	public void showVideo() {
		((Activity) context).runOnUiThread(new Runnable() {
			@Override
			public void run() {
				AdViewVideoManager.getInstance(context).playVideo(context, MainActivity.SDK_KEY);
			}
		});
	}
}
