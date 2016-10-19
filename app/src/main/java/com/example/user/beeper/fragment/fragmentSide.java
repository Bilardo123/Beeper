package com.example.user.beeper.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.user.beeper.R;
import com.example.user.beeper.SideActivity;
import com.example.user.beeper.utils.ButtonRippleUtils;
import com.example.user.beeper.utils.Constanta;
import com.example.user.beeper.utils.FontChangeCrawler;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by user on 8/4/2016.
 */
public class fragmentSide extends Fragment {

    @Bind(R.id.txtCalendarSide) TextView txtJadwalSide;
    @Bind(R.id.txtInboxSide) TextView txtInboxSide;
    @Bind(R.id.txtUndangTemanSide) TextView txtUndangTemanSide;
    @Bind(R.id.txtPengaturanSide) TextView txtPengaturan;
    @Bind(R.id.txtNewsSide) TextView txtNewSide;
    @Bind(R.id.txtHelpSide) TextView txtHelpSide;
    @Bind(R.id.txtFeedBackSide) TextView txtFeedBack;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance)
    {
        View view = inflater.inflate(R.layout.fragment_side, container, false);
        ButterKnife.bind(this, view);

        ButtonRippleUtils.setRippleEffect(txtJadwalSide, getContext());
        ButtonRippleUtils.setRippleEffect(txtInboxSide, getContext());
        ButtonRippleUtils.setRippleEffect(txtUndangTemanSide, getContext());
        ButtonRippleUtils.setRippleEffect(txtPengaturan, getContext());
        ButtonRippleUtils.setRippleEffect(txtNewSide, getContext());
        ButtonRippleUtils.setRippleEffect(txtHelpSide, getContext());
        ButtonRippleUtils.setRippleEffect(txtFeedBack, getContext());
        return view;
    }

    @OnClick({R.id.imgProfileSide, R.id.txtSaldoSide, R.id.txtCalendarSide, R.id.txtPengaturanSide, R.id.txtUndangTemanSide, R.id.txtFeedBackSide, R.id.txtNewsSide,
            R.id.txtHelpSide, R.id.txtInboxSide})
    public void leftSideClick(View view)
    {
        switch (view.getId())
        {
            case R.id.imgProfileSide : {
                Intent intent = new Intent(getActivity(), SideActivity.class);
                intent.putExtra("header", "DATA DIRI");
                startActivity(intent);
                break;
            }
            case R.id.txtSaldoSide : {
                Intent intent = new Intent(getActivity(), SideActivity.class);
                intent.putExtra("header", "TOP KREDIT");
                startActivity(intent);
                break;
            }
            case R.id.txtCalendarSide : {
                Intent intent = new Intent(getActivity(), SideActivity.class);
                intent.putExtra("header", "JADWAL");
                startActivity(intent);
                break;
            }
            case R.id.txtPengaturanSide : {
                Intent intent = new Intent(getActivity(), SideActivity.class);
                intent.putExtra("header", "PENGATURAN");
                startActivity(intent);
                break;
            }
            case R.id.txtFeedBackSide : {
                Intent intent = new Intent(getActivity(), SideActivity.class);
                intent.putExtra("header", "KRITIK DAN SARAN");
                startActivity(intent);
                break;
            }
            case R.id.txtNewsSide : {
                break;
            }
            case R.id.txtHelpSide : {
                break;
            }
            case R.id.txtInboxSide : {
                Intent intent = new Intent(getActivity(), SideActivity.class);
                intent.putExtra("header", "INBOX");
                startActivity(intent);
                break;
            }
            case R.id.txtUndangTemanSide : {
                Intent intent = new Intent(getActivity(), SideActivity.class);
                intent.putExtra("header", "UNDANG TEMAN");
                startActivity(intent);
                break;
            }
        }
    }

}
