package com.leo.game1;

/**
 * Created by leonidtiskevic on 23.03.17.
 */
public class DummyAdsController implements AdsController {
    @Override
    public void showBannerAd() {

    }

    @Override
    public void hideBannerAd() {

    }

    @Override
    public void showInterstitialAd(Runnable then) {

    }

    @Override
    public boolean isInternet() {
        return false;
    }
}
