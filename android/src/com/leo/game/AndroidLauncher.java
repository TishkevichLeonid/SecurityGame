package com.leo.game;

import android.content.Intent;
import android.os.Bundle;
<<<<<<< HEAD
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
import com.leo.game.Screens.GameOverScreen;
import com.leo.game.Screens.GameScreen;
import com.leo.game.Security;

public class AndroidLauncher extends AndroidApplication implements AdsController {

	public static final String TAG = "AndroidLauncher";
	protected AdView adView;
<<<<<<< HEAD
	public static InterstitialAd mInterstitialAd;
	public  Security game;
=======

=======
import android.view.WindowManager;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.google.android.gms.games.Games;
import com.google.example.games.basegameutils.GameHelper;
import com.leo.game.Security;

public class AndroidLauncher extends AndroidApplication implements GameHelper.GameHelperListener, ActionResolver {

	private GameHelper gameHelper;
	private Security game;
>>>>>>> fc997a95aa37f3e3f7573e2408aabcb256f69223
>>>>>>> 9c860a3a7de951dc92df73ade7577a0f37ee7b86

	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
<<<<<<< HEAD
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

		View gameView = initializeForView(new Security(this), config);
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
=======
		config.useAccelerometer = false;
		config.useCompass = false;
		initialize(new Security(), config);

		gameHelper = new GameHelper(this, GameHelper.CLIENT_ALL);
		gameHelper.setConnectOnStart(false);
		gameHelper.enableDebugLog(true);

		getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

		game = new Security();

		AndroidApplicationConfiguration config1 = new AndroidApplicationConfiguration();
		initialize(game, config);

		gameHelper.setup(this);

	}

	@Override
	protected void onStart() {
		super.onStart();
		gameHelper.onStart(this);
	}

	@Override
	protected void onStop() {
		super.onStop();
		gameHelper.onStop();
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		// здесь gameHelper принимает решение о подключении, переподключении или
		// отключении от игровых сервисов, в зависимости от кода результата
		// Activity
		gameHelper.onActivityResult(requestCode, resultCode, data);

	}

	@Override
	public void onSignInFailed() {

	}

	@Override
	public void onSignInSucceeded() {

	}

	@Override
	public boolean getSignedInGPGS() {
		return gameHelper.isSignedIn();
	}

	@Override
	public void loginGPGS() {

		try {
			runOnUiThread(new Runnable() {

				@Override
				public void run() {
					// инициировать вход пользователя. Может быть вызван диалог
					// входа. Выполняется в UI-потоке
					gameHelper.beginUserInitiatedSignIn();

				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void submitScoreGPGS(int score) {
		// отправить игровые очки в конкретную таблицу рекордов с ID
		Games.Leaderboards.submitScore(gameHelper.getApiClient(), "CgkIjJSdz7sQEAIQAQ", score);

	}

	@Override
	public void unlockAchievementGPGS(String achievementId) {

	}

	@Override
	public void getLeaderboardGPGS() {

		// вызвать Activity для всех зарегистрированных таблиц рекордов. Так же
		// можно вызывать Activity под конкретную таблицу
		startActivityForResult(
				Games.Leaderboards.getAllLeaderboardsIntent(gameHelper
						.getApiClient()), 100);

	}

	@Override
	public void getAchievementsGPGS() {

>>>>>>> fc997a95aa37f3e3f7573e2408aabcb256f69223
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
}
