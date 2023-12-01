package com.ayoub.deliveryapp.model;

import android.content.Context;
import android.webkit.JavascriptInterface;

import com.ayoub.deliveryapp.view.activities.DiscoverActivity;

public class WebAppInterface {

    private DiscoverActivity discoverActivity;
    private AddressHolder mAddressHolder;

    public WebAppInterface(DiscoverActivity discoverActivity, AddressHolder addressHolder) {
        this.discoverActivity = discoverActivity;
        this.mAddressHolder = addressHolder;
    }

    @JavascriptInterface
    public double getLatitude() {
        return mAddressHolder.getLatitude();
    }

    @JavascriptInterface
    public double getLongitude() {
        return mAddressHolder.getLongitude();
    }

    @JavascriptInterface
    public void onMarkerClick(String discoveryName) {
        // Call the onMarkerClick method in DiscoverActivity
        if (discoverActivity != null) {
            discoverActivity.onMarkerClick(discoveryName);
        }
    }
}
