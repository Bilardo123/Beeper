package com.example.user.beeper.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.user.beeper.R;
import com.example.user.beeper.utils.Constanta;
import com.example.user.beeper.utils.FontChangeCrawler;
import com.example.user.beeper.utils.FragmentTransfer;
import com.github.siyamed.shapeimageview.CircularImageView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by user on 7/19/2016.
 */
public class fragmentProfile extends Fragment {

    //Profile
    @Bind(R.id.imgProfileProfilePage) CircularImageView imgProfile;
    @Bind(R.id.txtNamaBeeperProfilPage) TextView txtNama;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance)
    {
        View view = inflater.inflate(R.layout.fragment_profile_page, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick({R.id.imgProfileProfilePage, R.id.txtEmailBeeperProfilePage, R.id.txtNoHandphoneProfilePage, R.id.txtTglLahirProfilePage,
            R.id.txtAlamatProfilePage, R.id.txtIDPengenalProfilePage})
    public void onClickProfile(View view)
    {
        switch (view.getId())
        {
            case R.id.imgProfileProfilePage : {
                Log.e("Profile", "ImageProfile Not Active"); break;}
            case R.id.txtEmailBeeperProfilePage : {
                FragmentTransfer.callFragment(getActivity(), new fragmentPerubahanEmail(), R.id.layoutSide, "PERUBAHANEMAIL"); break;}
            case R.id.txtNoHandphoneProfilePage : {
                FragmentTransfer.callFragment(getActivity(), new fragmentPerubahanHandphone(), R.id.layoutSide, "PERUBAHANHANDPHONE"); break;}
            case R.id.txtTglLahirProfilePage : {
                Log.e("Profile", "Tgl Lahir Not Active"); break;}
            case R.id.txtAlamatProfilePage : {
                FragmentTransfer.callFragment(getActivity(), new fragmentPerubahanAlamatRumah(), R.id.layoutSide, "PERUBAHANALAMAT"); break;}
            case R.id.txtIDPengenalProfilePage : {
                FragmentTransfer.callFragment(getActivity(), new fragmentPerubahanIDPengenal(), R.id.layoutSide, "PERUBAHANID"); break;}
        }
    }
}
