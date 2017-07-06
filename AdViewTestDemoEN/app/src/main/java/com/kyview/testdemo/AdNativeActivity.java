package com.kyview.testdemo;

import java.util.ArrayList;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.kyview.InitConfiguration;
import com.kyview.interfaces.AdViewNativeListener;
import com.kyview.manager.AdViewNativeManager;
import com.kyview.natives.NativeAdInfo;
import com.kyview.util.AdViewUtil;

public class AdNativeActivity extends Activity{

	private final String DEFAULTCAMERA = "Main_Camera";

	public static String HTML = "<meta charset='utf-8'><style type='text/css'>* { padding: 0px; margin: 0px;}a:link { text-decoration: none;}</style><div  style='width: 100%; height: 100%;'><img src=\"image_path\" width=\"100%\" height=\"100%\" ></div>";


	TextView title;
	WebView icon;
	TextView desc;
	WebView logo;
	NativeAdInfo nativeAdInfo;

	private Context context = null;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_adnative);
		this.context = this;


		//Calling AdNative Method
		addNativeAd();
	}






	//Native Advertisement

	public void addNativeAd() {

		((Activity)context).runOnUiThread(new Runnable() {

			@Override
			public void run() {
				FrameLayout frameLayout=new FrameLayout(context);
				FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
				frameLayout.setLayoutParams(params);
				frameLayout.setBackgroundColor(Color.parseColor("#dbedff"));
				params.gravity = Gravity.BOTTOM;
				addContentView(frameLayout, params);
				LayoutInflater inflater=LayoutInflater.from(context);
				final View native_parent=inflater.inflate(R.layout.native_ad_item, null);
				title=(TextView) native_parent.findViewById(R.id.title);
				icon=(WebView) native_parent.findViewById(R.id.icon);
				desc=(TextView) native_parent.findViewById(R.id.desc);
				logo=(WebView) native_parent.findViewById(R.id.logo);

				frameLayout.addView(native_parent);

				AdViewNativeManager.getInstance(context).requestAd(context,
						MainActivity.SDK_KEY, 1, new AdViewNativeListener(){

							@Override
							public void onAdFailed(String arg0) {
//                                UnityPlayer.UnitySendMessage(DEFAULTCAMERA,
//                                        "onAdFailed", "");

								Toast.makeText(getApplicationContext(),"OnAdFailed",Toast.LENGTH_LONG).show();

							}

							@Override
							public void onAdRecieved(String arg1, ArrayList arg0) {
								for (int i = 0; i < arg0.size(); i++) {
									nativeAdInfo = (NativeAdInfo) arg0.get(i);
									Log.i("原生信息：", "data.descript: " + nativeAdInfo.getDescription() + "\ndata.icon: "
											+ nativeAdInfo.getIconUrl() + "\ndata.title:" + nativeAdInfo.getTitle());
									title.setText(nativeAdInfo.getTitle());
									desc.setText(nativeAdInfo.getDescription());
									icon.setVerticalScrollBarEnabled(false);
									icon.setHorizontalScrollBarEnabled(false);
									if(null!=nativeAdInfo.getIconUrl()){
										icon.loadData((new String(HTML)).replace("image_path",nativeAdInfo.getIconUrl()), "text/html; charset=UTF-8", null);
									}
									logo.setVisibility(View.VISIBLE);
									nativeAdInfo.onDisplay(native_parent);

									Toast.makeText(getApplicationContext(),"OnAdReceived",Toast.LENGTH_LONG).show();
//                                    UnityPlayer.UnitySendMessage(DEFAULTCAMERA,
//                                            "onAdRecieved", "");
								}

							}

							@Override
							public void onAdStatusChanged(String arg0, int arg1) {

							}

						});
				native_parent.setOnClickListener(new View.OnClickListener() {

					@Override
					public void onClick(View v) {
						nativeAdInfo.onClick(v);
					}
				});

			}
		});
	}

}
