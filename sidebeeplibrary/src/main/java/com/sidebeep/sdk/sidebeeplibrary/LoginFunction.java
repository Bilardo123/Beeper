package com.sidebeep.sdk.sidebeeplibrary;

import android.content.SharedPreferences;

import com.sidebeep.sdk.sidebeeplibrary.service.LoginObservable;
import com.sidebeep.sdk.sidebeeplibrary.service.LoginSubscribe;

import okhttp3.Response;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by user on 10/10/2016.
 */
public class LoginFunction {

    private LoginSubscribe loginSubs;
    private LoginObservable loginObs;


    public LoginFunction()
    {
        loginObs = new LoginObservable();
        loginSubs = new LoginSubscribe();
    }

    public void loginToAPI(String username, String password, SharedPreferences.Editor sharedManager)
    {
        //connect ke API
        Observable<Response> login = loginObs.loginObservable(username, password);
        login.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(loginSubs.loginSubscribe(sharedManager));
    }

    public void refreshTokenToAPI(String refresh_token, SharedPreferences.Editor sharedManager)
    {
        //connect ke API
        Observable<Response> refreshToken = loginObs.refreshTokenObservable(refresh_token);
        refreshToken.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(loginSubs.refreshTokenSubscribe(sharedManager));
    }
}
