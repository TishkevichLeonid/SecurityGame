package com.leo.game;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.leo.game.Security;

public class AndroidLauncher extends AndroidApplication {

	public static final String TAG = "AndroidLauncher";
	protected AdView adView;


	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		RelativeLayout layout = new RelativeLayout(this);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);


		View gameView = initializeForView(new Security(), config);
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
}
