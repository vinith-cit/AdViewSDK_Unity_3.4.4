# Dev Guide Book @Adview

## Contents

[I. Register and configure SDK-KEY](https://github.com/vinith-cit/AdViewSDK_Unity_Android_3.4.4#i-register-and-configure-sdk-key)

[II.About AdView_Unity3D_Android_SDK-3.4.2](https://github.com/vinith-cit/AdViewSDK_Unity_Android_3.4.4#Ⅱabout-adview_unity3d_android_sdk-342)

[III. Add SDK](https://github.com/vinith-cit/AdViewSDK_Unity_Android_3.4.4#iii-add-sdk)

[IV.Add Assets Files](https://github.com/vinith-cit/AdViewSDK_Unity_Android_3.4.4#iv-add-assets-files)

[V. AndroidManifest.xml text configuration](https://github.com/vinith-cit/AdViewSDK_Unity_Android_3.4.4#v-androidmanifestxml-text-configuration)

[VI. Acquire ad configurations](https://github.com/vinith-cit/AdViewSDK_Unity_Android_3.4.4#vi-acquire-ad-configurations)

[VII. Create banner advertising](https://github.com/vinith-cit/AdViewSDK_Unity_Android_3.4.4#vii-create-banner-advertising)

[VIII. Create interstitial advertising](https://github.com/vinith-cit/AdViewSDK_Unity_Android_3.4.4#viii-create-interstitial-advertising)

[IX. Create opening screen ad](https://github.com/vinith-cit/AdViewSDK_Unity_Android_3.4.4#ix-create-opening-screen-ad)

[X. Create native advertising ](https://github.com/vinith-cit/AdViewSDK_Unity_Android_3.4.4#x-create-native-advertising)

[XI. Create video advertising](https://github.com/vinith-cit/AdViewSDK_Unity_Android_3.4.4#xi--create-video-advertising)

[XII. Adding Proguard-rules](https://github.com/vinith-cit/AdViewSDK_Unity_Android_3.4.4#xii-adding-proguard-rules)

[XIII. Adding custom ad network](https://github.com/vinith-cit/AdViewSDK_Unity_Android_3.4.4#xiii-adding-custom-ad-network)

[XIV. Contact us](https://github.com/vinith-cit/AdViewSDK_Unity_Android_3.4.4#xiv-contact-us)



## I. Register and configure SDK-KEY
1. Visit AdView website [adview.com](http://www.adview.com) and complete the registration process.
2. After Login you will land on "My Products" page by default, select **"Publish App”** .
3. Select **“Android”** follow the prompts to complete the relevant information About the application and click on **"Next"** button at the end where you will be redirected to **“APP management”** page
4. Under "App managemnet" page Click **"Next"** button at the bottom --> you will get the sole SDK key --> click **"Finish"** button at the bottom centre of the page and you will be redirected to the below page 


![Bidding](https://raw.githubusercontent.com/vinith-cit/Images-for-github/master/III.1.png)

5. Now click on "configure" against your application, then you will be redirected to **“APP management”** page → under the Ad format you want to configure (Banner,interstitial,video,open screen and native) open the switch against Auction ads(AdView Ads) and in case you want to add any custom ad networks (like InMobi, AdMob etc..,) click “Add ad platform”  and please refer to this link [Adding custom ad network](https://github.com/vinith-cit/AdViewSDK_Unity_Android_3.4.4#xiii-adding-custom-ad-network) for further steps, the cumulative percentage muste be 100%,then click save button. Generally recommended number of platforms is 1-3.   

![Home page](https://raw.githubusercontent.com/vinith-cit/Images-for-github/master/auction%20ads.png)



6.For **video ad or native ad**,Please configure in AdView Dash board .Please click **under review or setting** label ,you will get dialog box.In the dialog box For Auction ads ,please click save button in dialog box and  click **save**   button in bottom of the page .For other platforms ,please configure those custom adNetworks ids .


![video ad1](https://raw.githubusercontent.com/vinith-cit/Images-for-github/master/videos1.png)



![video ad2](https://raw.githubusercontent.com/vinith-cit/Images-for-github/master/videos2.png)







7. (Optional) if you wish to show prompt when you click on the ad - Under app management --> select "Edit" against your app, Switch on "Twice confirmation" button under "Advertising text settings".	



![bidding-2](https://raw.githubusercontent.com/vinith-cit/Images-for-github/master/III.2.png)


**Notes:**

1. In This Github repository we have provided you with Adview Android Unity3d SDK which gives you the freedom to choose your favourite ad network. in order to add custom ad networks please refer to this [Adding custom ad network](https://github.com/vinith-cit/AdViewSDK_Unity_Android_3.4.4#xiii-adding-custom-ad-network)
2. If you are fresher, you don’t know much about ad platform, which ad platform to choose or which ad platform revenue is stable, we suggest you to use bidding first.
3. Bidding and remnant ads need to complement market information at background, if the status is **"Under review"** you will be receiving test ads. and you will get formal ads only after **"pass reviewed"** by the AdView team. 
4. Ads will be shown of only those ad platforms for which the **switch** is on against them.						
5. Only the "capacity" of those ad platforms for which the switch is on will be valid, the ad newtork with higher proportion will get prior request, for all ad platforms with status as ON, the cumulative should be 100%. Other wise the your priority can't be saved.  

6. For Banner ad, full screen/interstitial, opening screen ,etc, there’s a save button at the bottom of the page. You should click the save button every time you modify a ad format, otherwise the modification is invalid . 

7. **Region optimization:** 
Region optimization function means mobile phone displays the regional configured ads when it’s with in the region, while in foreign country it display foreign configured ads to meet the different demands to the maximum extent. When the region optimization function is closed, it does not distinguish between home and abroad. 

8. In case you wish to show the same ad format more than once (like 2 banner ads) you need to create a new project (My product page --> publish app) with same credentials to get a new SDK key and the integration process remains same, you need not create a new project if the ad formats are different

## Ⅱ.About AdView_Unity3D_Android_SDK-3.4.2

1. Clone or download AdView_Unity3D_Android_SDK-3.4.2 package to go ahead with the integration process. This package contains all files needed for smooth integration and some of the important fils include **AdViewTestDemoEN** and **libs**.

**AdViewTestDemoEN**

AdViewTestDemoEN project which includes all types of ad format (banner,interstitial,video,native,open screen) sample code with explanation.you can run the application. you can see the **test ads**.

**libs**

It contains all the .jar file SDK needed for ad platform integration. 
(Libinfo.pdf has the ad platform instructions corresponding to each jar.)


## III. Add SDK

1. Clone or download AdViewSDK_Android-3.4.2 package here.In the AdViewSDK_Android-3.4.2 folder contains libs folder ,it contains the SDK for all ad platforms. (Libinfo.pdf has the ad platform instructions corresponding to each jar.)
2. Please copy and paste **AdViewSDK_Android.jar,google-play-services.jar** into your application lib folder.you'll need to integrate the Google Play Services SDK into your app.This is mandatory; without Google Play Services, the SDK cannot function.

3. In order to add **new ad network** please copy the .jar file of that particular ad platform provided by AdView to your lib folder and follow the same for all other ad platforms you would like to integrate. In case of **InMobi** add the **InMobi.jar** and **Picaso.jar** files.Please refer for adding custom ad Network this procedure [Adding custom ad network](https://github.com/vinith-cit/AdViewSDK_Unity_Android_3.4.4#xiii-adding-custom-ad-network)

![add SDK](https://raw.githubusercontent.com/vinith-cit/Images-for-github/master/IV.png)						  


## IV. Add Assets Files
Please Create assets Folder in Android Studio and copy the assets files from AdView_Unity3D_Android_SDK-3.4.2.

**AdView_Unity3D_Android_SDK-3.4.2 -->Assets**


![Add Asset files](https://raw.githubusercontent.com/vinith-cit/Images-for-github/master/Add%20Assets%20File.png)

## V. AndroidManifest.xml text configuration

**5.1 Add permission code**

Required permissions should be added (please refer to AndroidManifest file in the **AdViewTestDemoEN** project).

```
	<uses-permission android:name="android.permission.READ_PHONE_STATE" />
	<uses-permissionandroid:name="android.permission.ACCESS_COARSE_LOCATION"/>
	<uses-permissionandroid:name="android.permission.ACCESS_FINE_LOCATION" />
	<uses-permissionandroid:name="android.permission.ACCESS_WIFI_STATE" />
	<uses-permissionandroid:name="android.permission.WRITE_EXTERNAL_STORAGE"/>
	<uses-permissionandroid:name="android.permission.READ_EXTERNAL_STORAGE"/>
```

**Note:**

-**INTERNET:** allow to visit network (required)                                                                                         
-**ACCESS_NETWORK_STATE:** allow to visit various status of mobile phone (required)                                                     
-**ACCESS_COARSE_LOCATION**: allow a procedure to visit CellID or WIFI to get the rough position.                                       
-**ACCESS_FINE_LOCATION:** allow a procedure to visit the accurate position (for example, GPS)                                           
-**ACCESS_WIFI_STATE:** allow a procedure to visit WIFI status                                                                           
-**WRITE_EXTERNAL_STORAGE:** allow a procedure to visit outside storage device and can cache ads.                                       
-**READ_EXTERNAL_STORAGE:** allow a procedure to visit outside storage device                                                           


**5.2 Add Activity declaration**

The given code should be added to in AndroidManifest file for AdView, as some platforms need to declare activity to work normal, please refer to **AndroidManifest file** in **AdViewTestDemoEN** project.  

**Configurations that adview bidding ads should add:**

```
	<service android:name="com.kyview.DownloadService" />
	<activity android:name="com.kyview.AdviewWebView" />
	<activity android:name="com.kyview.AdActivity" />
	<!-- Adiview bidding video -->
	<activity android:name="com.kuaiyou.video.vast.activity.VASTAdActivity" 
	android:hardwareAccelerated="true"
	android:screenOrientation="landscape"/>
	
```


**5.3 Appointed app channel**

Please add the below code in the AndroidMainfest file:

```
	<meta-data android:name="AdView_CHANNEL" android:value=“GFAN">
	</meta-data>
```

(You must add the above code,otherwise you application won't be able to pass the review);


##  VI. Acquire ad configurations

**Note:**

1. InitConfiguration serve for the overall procedure, just need to transfer once only.
2. The set methods above are optional, not required.
3. From 3.2.4 version, SDK supports setting up multiple ad slots (SDK-KEY) in one application. Take 3 ad slots of demo keyset for example, some APP would like to set different ad slots in multiple Activities, thus to statistic the user visit amount of each Activity based on the amount of ad display. If one ad slot can meet the demand of APP, then there’s no need to apply multiple ad slots.

```
	// Be sure to initialize before requesting ads, otherwise the ads cannot be used
	// set ad request configured parameter,
	//you can use default configuration : InitConfiguration. createDefault(this);
	InitConfiguration initConfig = new
	InitConfiguration.Builder(this)
	//real-time access to configuration, not required 
	.setUpdateMode(UpdateMode.EVERYTIME)
	// banner switcher can be closed
	.setBannerCloseble(BannerSwitcher.CANCLOSED)
	//Interstitial Type
        .setInstlDisplayType(InitConfiguration.InstlDisplayType.POPUPWINDOW_MODE).build(); 
	
	
	//respectively request banner,interstitial,native, opening screen ad configuration,SDK_KEY can be one key 
	AdViewBannerManager.getInstance(this).init(MainActivity.initConfiguration,new String[]{MainActivity.SDK_KEY});
	AdViewInstlManager.getInstance(this).init(MainActivity.initConfiguration,new String[]{MainActivity.SDK_KEY});
	AdViewNativeManager.getInstance(this).init(MainActivity.initConfiguration,new String[]{MainActivity.SDK_KEY});
	AdViewSpreadManager.getInstance(this).init(MainActivity.initConfiguration,new String[]{MainActivity.SDK_KEY});
	AdViewVideoManager.getInstance(this).init(MainActivity.initConfiguration,new String[]{MainActivity.SDK_KEY});
	
	// respectively request banner, interstitial, native, opening screen ad configuration, keyset can be one or more key.
	AdViewBannerManager.getInstance(this).init(initConfig,MainActivity.keySet);
	AdViewInstlManager.getInstance(this).init(initConfig,MainActivity.keySet);
	AdViewNativeManager.getInstance(this).init(initConfig,MainActivity.keySet);
	AdViewVideoManager.getInstance(this).init(initConfig,MainActivity.keySet);
	
```


**Note:**
You can refer to the code of Main Activity in **AdViewTestDemoEN** Project.

## VII. Create banner advertising

**7.1 Add ads through adding code**

Add a banner code on your activity .

```


//Basic Initialization 
InitConfiguration initConfiguration = new InitConfiguration.Builder(this)
				.setUpdateMode(InitConfiguration.UpdateMode.EVERYTIME)
				.setBannerCloseble(InitConfiguration.BannerSwitcher.CANCLOSED)
				.setInstlDisplayType(InitConfiguration.InstlDisplayType.POPUPWINDOW_MODE)
				.build();


//Initialization for Banner
AdViewBannerManager.getInstance(this).init(initConfiguration,new String[]{SDK_KEY});    
 

```



```
    //Showing Banner Ad
    public void showBanner(){
        
        ((Activity) context).runOnUiThread(new Runnable() {

            @Override
            public void run() {
                //Code Layout Function for Banner Ad
                CodeLayout(SDK_KEY);
                
                //Creating Frame Layout Programmatically for Banner Ad 
                FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
                        FrameLayout.LayoutParams.WRAP_CONTENT,
                        FrameLayout.LayoutParams.WRAP_CONTENT);
                params.gravity = Gravity.BOTTOM;
                addContentView(AdViewBannerManager.getInstance(context)
                        .getAdViewLayout(context, MainActivity.SDK_KEY), params);
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

         //Requesting For Banner Ad
        //To receive Banner ad events from AdViewBannerListener
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
                                
                                 
```

 
**Note:**
You can refer to the code of **AdBannerActivity** in **AdViewTestDemoEN** Project.


## VIII. Create interstitial advertising

**8.1 create interstitial**

**Note:**

Since interstitial ad has a certain life cycle, Please do not wait too long after the request to call showAd method, so as to avoid invalid advertising.

Add the following code to your activity:


```

//Basic Initialization 
InitConfiguration initConfiguration = new InitConfiguration.Builder(this)
				.setUpdateMode(InitConfiguration.UpdateMode.EVERYTIME)
				.setBannerCloseble(InitConfiguration.BannerSwitcher.CANCLOSED)
				.setInstlDisplayType(InitConfiguration.InstlDisplayType.POPUPWINDOW_MODE)
				.build();

			
			
//Initialization for interstitual advertisement
	AdViewInstlManager.getInstance(this).init(initConfiguration,new String[]{SDK_KEY});			

```


```
//Requesting Interstitual
	public void requestInstl() {

		((Activity) context).runOnUiThread(new Runnable() {
			@Override
			public void run() {
				
				// interstitial ad request after initialization, 
				//To receive Banner ad events from AdViewInstlListener
				AdViewInstlManager.getInstance(context).requestAd(context, SDK_KEY,
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
						});			}
		});


	}

				
				
```



```				


        //Show Interstitual
	public void showInstl() {

		((Activity) context).runOnUiThread(new Runnable() {
			@Override
			public void run() {
				// After ad request succeed , call the display ad
				AdViewInstlManager.getInstance(context).showAd(context, MainActivity.SDK_KEY);
			}
		});

	}
	

```




**Note:**

You can refer to the code of **AdInstlActivity** in **AdViewTestDemoEN**. Project.

## IX. Create opening screen ad

**9.1 Create opening screen ad**

Add the following code to your activity:


```

	final RelativeLayout layout = new RelativeLayout(this);
		layout.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.MATCH_PARENT));

		setContentView(layout);
```


```

//Basic Initialization 
InitConfiguration initConfiguration = new InitConfiguration.Builder(this)
				.setUpdateMode(InitConfiguration.UpdateMode.EVERYTIME)
				.setBannerCloseble(InitConfiguration.BannerSwitcher.CANCLOSED)
				.setInstlDisplayType(InitConfiguration.InstlDisplayType.POPUPWINDOW_MODE)
				.build();


			
//Intialization for Open Screen ad
	AdViewSpreadManager.getInstance(this).init(initConfiguration, new String[]{SDK_KEY});
			
		
```


```


	// Set the logo at the bottom of opening screen (not required), you can also upload local images or images 
	AdViewSpreadManager.getInstance(this).setSpreadLogo(R.drawable.spread_logo);

	// Set background color of opening screen( not required)
	AdViewSpreadManager.getInstance(this).setSpreadBackgroudColor( Color.WHITE);

	// Request opening screen ads
		AdViewSpreadManager.getInstance(this).request(this,SDK_KEY,layout, this);

```


**9.2 Ad Opening screen Event Handling**

To receive events from ad, **you should implement an event listener interface AdViewSpreadListener**.
After you implement this listener you will get the following methods.


```

public interface AdViewSpreadListener {
        /**
         * This function is called when the ad is displayed.
         */
        public void onAdDisplay(String key);

        /**
         * This function is called when the ad requestsucceeds.
         */
        public void onAdReceived(String key);

        /**
         * Click to callback .
         */
        public void onAdClick(String key);

        /**
         * This function is called when the ad request failed.
         */
        public void onAdFailed(String key);

        /**
         *This function is called when the ad is closed.
         */
        public void onAdClose(String key);

        /**
         * Custom callback
         */
        public void onAdNotifyCustomCallback(String key,ViewGroup view,int ruleTime,int delayTime);

    }
    
    
```

**Note:**

 Please refer **SpreadScreenActivity** in **AdViewTestDemoEN** Project.


	
**9.3 Custom notification on top of opening screen with countdown options** 


```

// Skip button will appears on the top after settings
	AdViewSpreadManager.getInstance(this).setSpreadNotifyType(this, AdSpreadManager.NOTIFY_COUNTER_NUM);

	// Defaults, none notification will be displayed
	public final static int NOTIFY_COUNTER_NULL = 0;

	// Countdown will be shown after settings
	public final static int NOTIFY_COUNTER_NUM = 1;

	// Skip button will be shown on the top after settings,but it will appear only after specified times.
	public final static int NOTIFY_COUNTER_TEXT = 2;

	// Will call this after settings:onAdNotifyCustomCallback(String 
	//key,ViewGroup view,intruleTime,int delayTime) interface, you can 
  //custom notification styles
	public final static int NOTIFY_COUNTER_CUSTOM = 3;

```

**Note:**

For opening advertising please make sure the exposure time is sufficient, otherwise it will affect the ad revenue. 
You can refer to the code of **SpreadScreenActivity** in **AdViewTestDemoEN** Project.

## X. Create native advertising 

**10.1 create native advertising**

Add a RecyclerView to layout file, 

```

<android.support.v7.widget.RecyclerView
        android:id="@+id/list"
        android:layout_width="match_parent"
        android:layout_height="match_parent" />
        

```



Add the following code to your activity:

```
//Basic Initialization 
InitConfiguration initConfiguration = new InitConfiguration.Builder(this)
				.setUpdateMode(InitConfiguration.UpdateMode.EVERYTIME)
				.setBannerCloseble(InitConfiguration.BannerSwitcher.CANCLOSED)
				.setInstlDisplayType(InitConfiguration.InstlDisplayType.POPUPWINDOW_MODE)
				.build();


			

//Intialization for Native advertisement
	AdViewNativeManager.getInstance(this).init(initConfiguration,new String[]{SDK_KEY});

			
```


```


	//Initialized native ads should custom ad layout in advance, and apply native ad ID at app background
	AdViewNativeManager.getInstance(this).requestAd(this,SDK_KEY, 1,this); 
	
```


```

/*** Please add this code in the onAdReceived call back.
  * For creating this call back method you can refer 9.2 
  */	 
	// Ad successfully Received
	@Override
	public void onAdRecieved(String arg1, ArrayList arg0) {
		for (int i = 0; i < arg0.size(); i++) {
			Data data = new Data();
			NativeAdInfo nativeAdInfo = (NativeAdInfo) arg0.get(i);
			data.title = ((NativeAdInfo) arg0.get(i)).getTitle();
			data.descript = nativeAdInfo.getDescription();
			data.icon = nativeAdInfo.getIconUrl();
			data.image= nativeAdInfo.getImageUrl();
			data.adInfo = (NativeAdInfo) arg0.get(i);
			((NativeAdInfo) arg0.get(i)).getIconHeight();
			data.setAd(true);
			data.setType(STREAM_AD);
			Log.i("Native info：", "data.title:" + data.title + "\ndata.descript: " + data.descript + "\ndata.icon: "
					+ data.icon + "\ndata.image: " + data.image );
			list.add(3, data);
			((NativeAdInfo) arg0.get(i)).onDisplay(new View(
					AdNativeActivity.this));
		}
		adAdapter.notifyDataSetChanged();

	}
	
```


**Note:**

 Please refer to the code of **AdNativeActivity** in **AdViewTestDemoEN** Project.
		
please add **DividerItemDecoration ,MyItemClickListener classes** for Native ad. you can get it from **AdViewTestDemoEN** Project .


**10.2 Ad Native Event Handling**

To receive events from ad, **you should implement an event listener interface AdViewNativeListener**.
After you implement this listener you will get the following methods.  


```

 public interface AdViewNativeListener {

        /**
         * This function is called when the ad request succeed.
         */
        public void onAdReceived(String key, List<NativeAdInfo> adMaps);

        /**
         * This function is called when ad request failed.
         */
        public void onAdReceived(String key);

        /**
         * When the ad status changed.
         */
        public void onAdStatusChanged(String key, int status);

    }


```


## XI . Create video advertising
**11.1 create video advertising**

Add the following code in activity,

```

//Basic Initialization 
InitConfiguration initConfiguration = new InitConfiguration.Builder(this)
				.setUpdateMode(InitConfiguration.UpdateMode.EVERYTIME)
				.setBannerCloseble(InitConfiguration.BannerSwitcher.CANCLOSED)
				.setInstlDisplayType(InitConfiguration.InstlDisplayType.POPUPWINDOW_MODE)
				.build();


//Initialization For Video ads
	AdViewVideoManager.getInstance(this).init(initConfiguration,new String[]{SDK_KEY});


```


```
	//Requesting video Ad Function
	//Request video ads after initialization.
	public void requestVideo() {
		
		((Activity) context).runOnUiThread(new Runnable() {
			@Override
			public void run() {
				//To receive Video Ad events from AdViewVideoListener
				//Requesting video ads 
				AdViewVideoManager.getInstance(context).requestAd(context, SDK_KEY,
						new AdViewVideoListener() {

							@Override
							public void onAdClose(String arg0) {
								Log.i(TAG, "onAdClose");
								UnityPlayer.UnitySendMessage(DEFAULTCAMERA,
										"onAdClose", "");

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
						});			}
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


```



**Note:**
You can refer to the code of **AdVideoActivity** in **AdViewTestDemoEN** Project.



## XII. Adding Proguard-rules 

If you have a ProGuard configuration file please add the below lines of code in proguard-rules.pro file

```
	-keep public class com.kyview.** {*;} 
	-keep public class com.kuaiyou.** {*;} 

```
In case you add other adnetworks ( like InMobi, AdMob etc..,) add their proguard rules to proguard-rules.pro file.

For example In case of InMobi add the below lines of code to the proguard-rules.pro.
```
	-keep class com.google.android.gms.ads.identifier.AdvertisingIdClient{
	    public *;
	}

	-keep class com.google.android.gms.ads.identifier.AdvertisingIdClient$Info{
	    public *;
	}

	-keep class com.inmobi.**
	{ *; }

	-dontwarn com.inmobi.**

```


## XIII. Adding custom ad network

AdView has integrated various ad networks (InMobi, AdMob, etc..,) where you are given flexibility to add the ad network of your choice and prioritize accordingly, there are various advantages of integrating more than one ad networks to monetize your app, some them include

--> Good fill rates - we suggest to include on an avrage of 3 ad netwroks for good fill rates
--> More revenue
--> You can prioritize according to the ad platform performance


1. In your publisher dashboard http://adview.com/user/appreport click on the "App Management" tab --> click "Configure" against your app name which you want to add custom ad networks, then click on "Add Platform" button (out of China or within China depending on your region ) --> you will be redirected to the popup as shown below where you can choose ad network of your choice.


![Inmobi 0](https://raw.githubusercontent.com/vinith-cit/Images-for-github/master/Adding%20Inmobi%20in%20DashBoard%20.png)

2.In this example we will be adding InMobi as the custom Ad Netwrok, select InMobi in the popup and click on "Add" button, this will redirect you to the AdView dashboard --> here turn on the switch again InMobi give the **priority(%)** of your choice then click on "not set" in InMobi row you will get  "Configure InMobi" popup with Signup link at the bottom which will redirect you to the below login page, complete the login procedure


![Inmobi 22](https://raw.githubusercontent.com/vinith-cit/Images-for-github/master/inmobi%20configure%20dialg.png)

 ![Inmobi 1](https://raw.githubusercontent.com/vinith-cit/Images-for-github/master/inmobi%201.png)

Please add the SDK of InMobi--> you can follow this procedure 

[Add SDK](https://github.com/vinith-cit/AdViewSDK_Unity_Android_3.4.4#iii-add-sdk)

3. After login you will get the the account ID as shown in the below image, click on Add an App.  

![Inmobi 2](https://raw.githubusercontent.com/vinith-cit/Images-for-github/master/inmobi2.jpg)

4. Please add your application ( the same application you want to add custom Ad platform in AdView) by filling in the details as asked in below image, in case of any proguard rules in the Ad Network integration part just copy and paste them in proguard-rules.pro file in your project.  

![Inmobi 3](https://raw.githubusercontent.com/vinith-cit/Images-for-github/master/inmobi3.jpg)

5. After adding the App  to InMobi then click on the application name, where you will be redirected to the below window, please click on the option marked in the below image to get Placement ID.  

![Inmobi 4](https://raw.githubusercontent.com/vinith-cit/Images-for-github/master/inmobi4.jpg)

6. Please copy the placement ID and Account ID which you need to add it in AdView dashobard as shown in the 2nd image 

![Inmobi 5](https://raw.githubusercontent.com/vinith-cit/Images-for-github/master/inmobi5.jpg)


In the same way you can configure different custom Ad Networks to your app (different Ad networks might demand different ID's to be configured ) 

 

## XIV. Contact us 

Users can login Adview, there are service E-mail, service contact number and enterprise QQ customer service at the bottom of the homepage 

![custom ad platform](https://raw.githubusercontent.com/vinith-cit/Images-for-github/master/VII.png)


