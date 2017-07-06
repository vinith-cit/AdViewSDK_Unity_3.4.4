package com.kyview.testdemo;


import com.kyview.InitConfiguration;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;


public class MainActivity extends Activity {


	//If you used only one  Banner,Video,Native,Video Placement,you can follow this kind of SDK_KEY initialization.
	public static final String SDK_KEY = "SDK20171404020430v2dh6qmcf35hqui";

	//Optional while used for more than one banner,native,video placements
	/**
	 * If you want more than one  banner,native,video,native placements
	 * while you have to create same project project in AdView and get the different SDK_KEY key ,you can follow this kind of KeySet initialization.
	 */
	public static final String key1 = "SDK2016093109051932rem7dipq42aj3";//SDK20151523030620lkfznoxeda4a7i3锟斤拷SDK2016132801103979g4m0a2znmrt2a
	public static final String key2 = "SDK2016093109051932rem7dipq42aj2";//SDK20161629040641z7snyxkrbndasty
	public static final String key3 = "SDK2016093109051932rem7dipq42aja";
	public static final String keySet[] = new String[] { key1, key2, key3 };


	public static InitConfiguration initConfiguration;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.main_activity);


		//Basic Initialization for Banner,intersitial,Video,Native,Spread Screen ads
		initConfiguration = new InitConfiguration.Builder(
				this).setUpdateMode(InitConfiguration.UpdateMode.EVERYTIME)
				.setBannerCloseble(InitConfiguration.BannerSwitcher.CANCLOSED)
				.setInstlDisplayType(InitConfiguration.InstlDisplayType.POPUPWINDOW_MODE)
				.build();


		//Banner Ad
		findViewById(R.id.banner).setOnClickListener(
				new View.OnClickListener() {

					@Override
					public void onClick(View v) {
						Intent intent = new Intent(MainActivity.this,
								AdBannerActivity.class);
						startActivity(intent);
					}
				});

		//Interstial Ad
		findViewById(R.id.instl).setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this,
						AdInstlActivity.class);
				startActivity(intent);
			}
		});

		// Native Ad
		findViewById(R.id.natives).setOnClickListener(
				new View.OnClickListener() {

					@Override
					public void onClick(View v) {
						Intent intent = new Intent(MainActivity.this,
								AdNativeActivity.class);
						startActivity(intent);
					}
				});

		// Video Ad
		findViewById(R.id.video).setOnClickListener(
				new View.OnClickListener() {

					@Override
					public void onClick(View v) {
						Intent intent = new Intent(MainActivity.this,
								AdVideoActivity.class);
						startActivity(intent);
					}
				});

		// Update Information
		findViewById(R.id.release).setOnClickListener(
				new View.OnClickListener() {

					@Override
					public void onClick(View v) {
						LayoutInflater inflater = LayoutInflater
								.from(MainActivity.this);
						View view = inflater.inflate(R.layout.version_layout,
								null);
						final AlertDialog dialog = new AlertDialog.Builder(
								MainActivity.this).create();
						dialog.setView(view);
						dialog.show();
						Button ok = (Button) view.findViewById(R.id.close);
						ok.setOnClickListener(new OnClickListener() {

							@Override
							public void onClick(View v) {
								if (null != dialog)
									dialog.dismiss();
							}
						});

					}
				});



		//Spread Screen / Open Screen Ad
		findViewById(R.id.spread).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent = new Intent(MainActivity.this,
						SpreadScreenActivity.class);
				startActivity(intent);

			}
		});
	}
}