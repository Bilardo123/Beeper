package com.example.user.beeper.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.user.beeper.R;
import com.example.user.beeper.utils.Constanta;
import com.example.user.beeper.utils.FontChangeCrawler;
import com.example.user.beeper.utils.FragmentTransfer;
import com.example.user.beeper.utils.GlobalUtils;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by user on 9/5/2016.
 */
public class fragmentAddKartuKreditPengaturan extends Fragment {

    //@Bind(R.id.webViewTest) WebView webTest;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance)
    {
        View view = inflater.inflate(R.layout.fragment_add_kartukredit_pengaturan, container, false);
        GlobalUtils.setupUI(view, getActivity());
        ButterKnife.bind(this, view);

        //setComponent();

        return view;
    }

    /*public void setComponent()
    {
        webTest.getSettings().setJavaScriptEnabled(true);
        webTest.loadUrl("http://www.google.com");
        webTest.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(webTest, url);
                if(url.contains("sidebeep"))
                {
                    getActivity().finish();
                }
            }

            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
            }
        });
    }*/

    @OnClick(R.id.btnSimpanAddKartuKreditPengaturan)
    public void onClick()
    {
        FragmentTransfer.callFragment(getActivity(), new fragmentInformasiKartuKreditPengaturan(), R.id.layoutSide, "KARTUKREDITPENGATURAN");
    }

}
