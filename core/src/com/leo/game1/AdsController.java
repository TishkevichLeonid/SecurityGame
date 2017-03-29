package com.leo.game1;

/**
 * Created by leonidtiskevic on 23.03.17.
 */

public interface AdsController {
    public void showBannerAd();
    public void hideBannerAd();
    public void showInterstitialAd (Runnable then);
    public boolean isInternet();
}
