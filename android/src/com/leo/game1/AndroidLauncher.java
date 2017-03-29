package com.leo.game1;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

public class AndroidLauncher extends AndroidApplication implements AdsController {

	public static final String TAG = "AndroidLauncher";
	protected AdView adView;

	public static InterstitialAd mInterstitialAd;
	public com.leo.game1.Security game;


	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();

		RelativeLayout layout = new RelativeLayout(this);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);

		mInterstitialAd = new InterstitialAd(this);
		mInterstitialAd.setAdUnitId("ca-app-pub-3872601962088528/6930576694");
		AdRequest adRequest = new AdRequest.Builder()
				.addTestDevice("A2E59626C95D3AAE8B35B7C76FFCDC43")
				.build();
		mInterstitialAd.loadAd(adRequest);

		/* mInterstitialAd.setAdListener(new AdListener() {
			@Override
			public void onAdClosed() {
				requestNewInterstitial();
				game.setScreen(new GameOverScreen(game));
			}
		});
		requestNewInterstitial(); */

		View gameView = initializeForView(new com.leo.game1.Security(this), config);
		layout.addView(gameView);

		adView = new AdView(this);
		adView.setAdUnitId("ca-app-pub-3872601962088528/6939726696");
		adView.setAdSize(AdSize.SMART_BANNER);

		AdRequest.Builder builder = new AdRequest.Builder();
		builder.addTestDevice("A2E59626C95D3AAE8B35B7C76FFCDC43");
		adView.loadAd(builder.build());

		RelativeLayout.LayoutParams adParams = new RelativeLayout.LayoutParams(
				RelativeLayout.LayoutParams.WRAP_CONTENT,
				RelativeLayout.LayoutParams.WRAP_CONTENT
		);
		adParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
		adParams.addRule(RelativeLayout.CENTER_HORIZONTAL);

		layout.addView(adView, adParams);

		setContentView(layout);


		//config.useAccelerometer = false;
		//config.useCompass = false;
		//initialize(new Security(), config);

	}


	@Override
	public void showBannerAd() {

	}

	@Override
	public void hideBannerAd() {

	}

	@Override
	public void showInterstitialAd(final Runnable then) {
		runOnUiThread(new Runnable() {
			@Override
			public void run() {
				if (then != null) {
					mInterstitialAd.setAdListener(new AdListener() {
						@Override
						public void onAdClosed() {
							Gdx.app.postRunnable(then);
							AdRequest.Builder builder = new AdRequest.Builder();
							AdRequest ad = builder.build();
							mInterstitialAd.loadAd(ad);
						}
					});
				}
				mInterstitialAd.show();
			}
		});
	}

	@Override
	public boolean isInternet() {
		ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo ni = cm.getActiveNetworkInfo();

		return (ni != null && ni.isConnectedOrConnecting());
	}
}
