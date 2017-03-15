package com.leo.game;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.google.android.gms.games.Games;
import com.google.example.games.basegameutils.GameHelper;
import com.leo.game.Security;

public class AndroidLauncher extends AndroidApplication implements GameHelper.GameHelperListener, ActionResolver {

	private GameHelper gameHelper;
	private Security game;

	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
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

	}
}
