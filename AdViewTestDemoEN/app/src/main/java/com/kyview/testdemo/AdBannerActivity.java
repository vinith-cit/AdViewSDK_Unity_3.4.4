package com.kyview.testdemo;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.kyview.InitConfiguration;
import com.kyview.interfaces.AdViewBannerListener;
import com.kyview.manager.AdViewBannerManager;
import com.unity3d.player.UnityPlayer;

/**
 * Created by vinith on 19/04/17.
 */

public class AdBannerActivity extends Activity {

    private Context context = null;

    private final String DEFAULTCAMERA = "Main_Camera";


    private final String TAG = "AdViewUnity3DDemo";



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adbanner);

        this.context = this;




        //
//        /**
//         * Initialization for Banner
//         * If you want more than one  banner,native,video,native placements
//         * while you have to create new project with same configuration in AdView dashboard(in the website) and get the different SDK_KEY key ,
//         * you can follow this kind of KeySet initialization.
//         */

//        AdViewBannerManager.getInstance(this).init(initConfiguration,
//                MainActivity.keySet);



        //Initialization for Banner advertisement
        AdViewBannerManager.getInstance(this).init(MainActivity.initConfiguration,new String[]{MainActivity.SDK_KEY});


        // Click Event for Banner Advertisement
        findViewById(R.id.showBanner).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                ((Activity) context).runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        CodeLayout(MainActivity.SDK_KEY);
                        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
                                FrameLayout.LayoutParams.WRAP_CONTENT,
                                FrameLayout.LayoutParams.WRAP_CONTENT);
                        params.gravity = Gravity.BOTTOM;
                        addContentView(AdViewBannerManager.getInstance(context)
                                .getAdViewLayout(context, MainActivity.SDK_KEY), params);
                    }
                });

            }
        });




    }




    //Banner Advertisement code
    public void CodeLayout(String key) {
        View view = AdViewBannerManager.getInstance(context).getAdViewLayout(
                context, key);
        view.setTag(key);
        if (null != view) {
            ViewGroup rootView = (ViewGroup) findViewById(android.R.id.content);
            for (int i = 0; i < rootView.getChildCount(); i++) {
                if (rootView.getChildAt(i) == view) {
                    rootView.removeView(view);
                }
            }
        }

        AdViewBannerManager.getInstance(context).requestAd(context, key,
                new AdViewBannerListener() {

                    @Override
                    public void onAdReady(String arg0) {
                        Log.i(TAG, "onAdReady");
                        Toast.makeText(AdBannerActivity.this, "onAdReady",
                                Toast.LENGTH_SHORT).show();

                    }


                    @Override
                    public void onAdFailed(String arg0) {
                        Log.i(TAG, "onAdFailed");
                        Toast.makeText(AdBannerActivity.this,
                                "onAdFailed", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onAdDisplay(String arg0) {
                        Log.i(TAG, "onAdDisplay");
                        UnityPlayer.UnitySendMessage(DEFAULTCAMERA,
                                "onDisplayAd", "");
                    }

                    @Override
                    public void onAdClose(String key) {
                        Log.i(TAG, "onAdClose");
                        ViewGroup rootView = (ViewGroup) findViewById(android.R.id.content);
                        if (null != rootView)
                            rootView.removeView(rootView.findViewWithTag(key));
                        UnityPlayer.UnitySendMessage(DEFAULTCAMERA,
                                "onClosedAd", "");
                    }

                    @Override
                    public void onAdClick(String arg0) {
                        Log.i(TAG, "onAdClick");
                        UnityPlayer.UnitySendMessage(DEFAULTCAMERA,
                                "onAdClick", "");
                    }
                });
    }

}
