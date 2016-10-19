package com.sidebeep.sdk.sidebeeplibrary.service;

import com.sidebeep.sdk.sidebeeplibrary.utils.constanta;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import rx.Observable;
import rx.Subscriber;


/**
 * Created by user on 10/10/2016.
 */
public class LoginObservable {

    public Observable<Response> loginObservable(final String user, final String pass)
    {
        Observable<Response> loginObs = Observable.create(new Observable.OnSubscribe<Response>() {
            OkHttpClient client = new OkHttpClient();

            @Override
            public void call(Subscriber<? super Response> subscriber) {

                try
                {
                    RequestBody formBody = new FormBody.Builder()
                            .add("grant_type", "password")
                            .add("client_id", constanta.CLIENT_ID)
                            .add("client_secret", constanta.CLIENT_SECRET)
                            .add("username", user)
                            .add("password", pass)
                            .build();
                    Request request = new Request.Builder()
                            .url(constanta.LOGIN_API)
                            .post(formBody)
                            .build();

                    Response response = client.newCall(request).execute();
                    subscriber.onNext(response);
                    subscriber.onCompleted();
                    if (!response.isSuccessful()) subscriber.onError(new Exception("error"));
                }
                catch (Exception e)
                {
                    subscriber.onError(e);
                }
            }

        });

        return loginObs;
    }

    public Observable<Response> refreshTokenObservable(final String refreshToken)
    {
        Observable<Response> refreshTokenObs = Observable.create(new Observable.OnSubscribe<Response>() {
            OkHttpClient client = new OkHttpClient();

            @Override
            public void call(Subscriber<? super Response> subscriber) {

                try
                {
                    RequestBody formBody = new FormBody.Builder()
                            .add("grant_type", "refresh_token")
                            .add("client_id", constanta.CLIENT_ID)
                            .add("client_secret", constanta.CLIENT_SECRET)
                            .add("refresh_token", refreshToken)
                            .build();
                    Request request = new Request.Builder()
                            .url(constanta.REFRESH_TOKEN)
                            .post(formBody)
                            .build();

                    Response response = client.newCall(request).execute();
                    subscriber.onNext(response);
                    subscriber.onCompleted();
                    if (!response.isSuccessful()) subscriber.onError(new Exception("error"));
                }
                catch (Exception e)
                {
                    subscriber.onError(e);
                }
            }

        });

        return refreshTokenObs;
    }

}
