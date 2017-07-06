package com.kyview.testdemo;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;
import com.kyview.interfaces.AdViewSpreadListener;
import com.kyview.manager.AdViewSpreadManager;


public class SpreadScreenActivity extends Activity implements AdViewSpreadListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);

		final RelativeLayout layout = new RelativeLayout(this);
		layout.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.MATCH_PARENT));

		setContentView(layout);

		//Intialization for Open Screen ad
		AdViewSpreadManager.getInstance(this).init(MainActivity.initConfiguration,new String[]{MainActivity.SDK_KEY});


//		Bitmap bitmap = null;
//		try {
//			bitmap = BitmapFactory.decodeStream(getAssets().open(
//					"spread_logo.png"));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		double density = getDensity(this);
//		bitmap = Bitmap
//				.createScaledBitmap(bitmap,
//						(int) (bitmap.getWidth() * density * 2),
//						(int) (bitmap.getHeight() * density * 2), false);
		// 设置开屏下方LOGO，必须调用该方法
//		AdViewSpreadManager.getInstance(this)
//				.setSpreadLogo(
//						new BitmapDrawable(getResources(), bitmap));


		// setting logo for open screen ad
		//User Defined Logo
		AdViewSpreadManager.getInstance(this).setSpreadLogo(R.drawable.spread_logo);


		// setting background color for open screen ad
		//User Defined Background color
		AdViewSpreadManager.getInstance(this).setSpreadBackgroudColor(
				Color.WHITE);



		//how much time you want show open screen ad
		AdViewSpreadManager.getInstance(this).setSpreadNotifyType(AdViewSpreadManager.NOTIFY_COUNTER_NUM);


		// Requesting open screen ad
		AdViewSpreadManager.getInstance(this).request(this, MainActivity.SDK_KEY,layout, this);
	}

	@Override
	public void onAdClose(String arg0) {
		Toast.makeText(this, "onAdClosedAd", Toast.LENGTH_SHORT).show();
		jump();
	}

	@Override
	public void onAdDisplay(String arg0) {
		Toast.makeText(this, "onAdDisplayAd", Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onAdFailed(String arg0) {
		Toast.makeText(this, "onAdReceiveFailed "+arg0,
				Toast.LENGTH_SHORT).show();
		Toast.makeText(this, "onAdFailed", Toast.LENGTH_SHORT).show();

		jump();

	}

	@Override
	public void onAdRecieved(String arg0) {
		Toast.makeText(this, "onAdRecieved", Toast.LENGTH_SHORT).show();
	}

	/**
	 * This function will be called only when Publisher has set "adSpreadManager.setSpreadNotifyType(this,
	 * AdSpreadManager.NOTIFY_CUSTOM);"
	 *
	 * @param view
	 *            return the custom layout above (RelativeLayout)
	 * @param ruleTime
	 *
	 * @param delayTime
	 *
	 */
	@Override
	public void onAdSpreadNotifyCallback(String arg0, ViewGroup arg1, int arg2,
										 int arg3) {
		Toast.makeText(this, "onAdDisplayAd", Toast.LENGTH_SHORT).show();
		jump();
	}


	/*
	 * For better ad revenue, please disable the return key until the ad is displayed
	 */
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK)
			return false;
		return super.onKeyDown(keyCode, event);
	}

	@Override
	protected void onRestart() {
		super.onRestart();
		waitingOnRestart = true;
		jumpWhenCanClick();
	}

	public boolean waitingOnRestart = false;

	private void jump() {
		try {
			Intent intent = new Intent();
			intent.setClass(this, MainActivity.class);
			startActivity(intent);
			this.finish();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * This function will be called when the spread ad is clicked
	 */
	private void jumpWhenCanClick() {
		Log.d("test", "this.hasWindowFocus():" + this.hasWindowFocus());
		if (this.hasWindowFocus() || waitingOnRestart) {
			this.startActivity(new Intent(SpreadScreenActivity.this,
					MainActivity.class));
			this.finish();
		} else {
			waitingOnRestart = true;
		}
	}

	public static double getDensity(Activity activity) {
		double mDensity = -1.0D;
		if (mDensity == -1.0D) {
			try {
				int sdkVersion = activity.getPackageManager()
						.getApplicationInfo(activity.getPackageName(), 0).targetSdkVersion;
				if (sdkVersion < 4) {
					mDensity = 1.0D;
				} else {
					DisplayMetrics displayMetrics = new DisplayMetrics();
					activity.getWindowManager().getDefaultDisplay()
							.getMetrics(displayMetrics);
					mDensity = displayMetrics.density;
				}
			} catch (Exception e) {
				mDensity = 1.0D;
			}
		}
		return mDensity;
	}

	@Override
	public void onAdClick(String arg0) {

	}
}
