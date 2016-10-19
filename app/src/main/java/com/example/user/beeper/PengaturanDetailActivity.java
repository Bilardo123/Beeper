package com.example.user.beeper;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.beeper.component.FooterClass;
import com.example.user.beeper.utils.Constanta;
import com.example.user.beeper.utils.FontChangeCrawler;
import com.example.user.beeper.utils.FragmentTransfer;
import com.example.user.beeper.utils.GlobalUtils;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PengaturanDetailActivity extends AppCompatActivity {

    //Header Layout
    @Bind(R.id.txtTitleHeader2) TextView txtHeader;
    @Bind(R.id.txtTitle2Header2) TextView txtHeaderRight;

    //Footer
    @Bind(R.id.imgFooter1) ImageView img1;
    @Bind(R.id.imgFooter2) ImageView img2;
    @Bind(R.id.imgFooter3) ImageView img3;
    @Bind(R.id.imgFooter4) ImageView img4;
    @Bind(R.id.imgFooter5) ImageView img5;

    String kelas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengaturan_detail);
        FontChangeCrawler fontChanger = new FontChangeCrawler(getAssets(), Constanta.Jenis_Font);
        fontChanger.replaceFonts((ViewGroup)this.findViewById(android.R.id.content));
        ButterKnife.bind(this);

        setComponenView();
    }

    public void setComponenView(){

        if(getIntent().getExtras() != null)
        {
            txtHeader.setText(getIntent().getExtras().getString("header"));
            kelas = getIntent().getExtras().getString("class");
            /*if(kelas.equals("KATA SANDI"))
                FragmentTransfer.callFragment(this, new fragmentKataSandi(), R.id.layoutPengaturandetail);
            else if(kelas.equals("AKUN BANK"))
                FragmentTransfer.callFragment(this, new fragmentAkunBank(), R.id.layoutPengaturandetail);
            else if(kelas.equals("PENGATURAN EMAIL"))
                FragmentTransfer.callFragment(this, new fragmentPerubahanEmail(), R.id.layoutPengaturandetail);
            else if(kelas.equals("NOMOR HANDPHONE"))
                FragmentTransfer.callFragment(this, new fragmentPerubahanHandphone(), R.id.layoutPengaturandetail);*/

            if(kelas.equals("AKUN BANK"))
                txtHeaderRight.setText("EDIT");
            else
                txtHeaderRight.setText("");
        }

        GlobalUtils.changeDrawableIconFooter(img1, img2, img3, img4, img5, "home");

    }

    @OnClick(R.id.imgHamburgerHeader2)
    public void onClickHamburger()
    {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
        finish();
    }

    //Footer Action
    @OnClick({R.id.imgFooter1, R.id.imgFooter2, R.id.imgFooter3, R.id.imgFooter4, R.id.imgFooter5})
    public void onClickFooter(View view)
    {
        FooterClass.setFooter(this, img1, img2, img3, img4, img5, txtHeader, null, view.getId(), "pengaturan");
    }

    @OnClick(R.id.txtTitle2Header2)
    public void editLayout()
    {
        /*if(txtHeaderRight.getText().equals("EDIT")) {
            FragmentTransfer.callFragment(this, new fragmentEditAkunBank(), R.id.layoutPengaturandetail);
            txtHeaderRight.setText("SAVE");
        }
        else
        {
            FragmentTransfer.callFragment(this, new fragmentAkunBank(), R.id.layoutPengaturandetail);
            txtHeaderRight.setText("EDIT");
        }*/
    }

}
