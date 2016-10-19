package com.sidebeep.sdk.sidebeeplibrary.service;

import android.content.SharedPreferences;
import android.util.Log;

import okhttp3.Response;
import rx.Subscriber;

/**
 * Created by user on 10/10/2016.
 */
public class LoginSubscribe {

    public Subscriber<Response> loginSubscribe(final SharedPreferences.Editor sharedManager)
    {
        Subscriber<Response> loginSub = new Subscriber<Response>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Log.e("LoginSubscribe error", e.toString());
            }

            @Override
            public void onNext(Response response) {

                //do function here
                //saved to shared preference
                try {
                    sharedManager.putString("json", response.body().string());
                    sharedManager.commit();
                    response.body().close();
                }
                catch (Exception e)
                {
                    Log.e("LoginSubscribe", e.toString());
                }
            }
        };

        return loginSub;
    }

    public Subscriber<Response> refreshTokenSubscribe(final SharedPreferences.Editor sharedManager)
    {
        Subscriber<Response> refreshTokenSub = new Subscriber<Response>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Log.e("LoginSubscribe error", e.toString());
            }

            @Override
            public void onNext(Response response) {

                //do function here
                //saved to shared preference
                try {
                    sharedManager.putString("json2", response.body().string());
                    sharedManager.commit();
                    response.body().close();
                }
                catch (Exception e)
                {
                    Log.e("LoginSubscribe", e.toString());
                }

            }
        };

        return refreshTokenSub;
    }

}
