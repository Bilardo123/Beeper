package com.example.user.beeper;

import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.beeper.component.FooterClass;
import com.example.user.beeper.fragment.fragmentFavoritHome;
import com.example.user.beeper.fragment.fragmentKategori;
import com.example.user.beeper.fragment.fragmentSearch;
import com.example.user.beeper.utils.Constanta;
import com.example.user.beeper.utils.FontChangeCrawler;
import com.example.user.beeper.utils.FragmentTransfer;
import com.example.user.beeper.utils.GlobalUtils;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SearchActivity extends AppCompatActivity {

    //Header
    @Bind(R.id.imgRightHeader4) ImageView imgHeaderRight;
    @Bind(R.id.txtTitleHeader4) TextView txtHeader;

    //Footer
    @Bind(R.id.imgFooter1) ImageView img1;
    @Bind(R.id.imgFooter2) ImageView img2;
    @Bind(R.id.imgFooter3) ImageView img3;
    @Bind(R.id.imgFooter4) ImageView img4;
    @Bind(R.id.imgFooter5) ImageView img5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        FontChangeCrawler fontChanger = new FontChangeCrawler(getAssets(), Constanta.Jenis_Font);
        fontChanger.replaceFonts((ViewGroup)this.findViewById(android.R.id.content));
        ButterKnife.bind(this);
        setComponentView();
    }

    public void setComponentView()
    {
        FragmentTransfer.callFragment(this, new fragmentSearch(), R.id.layoutSearch, "SEARCH");
        GlobalUtils.changeDrawableIconFooter(img1, img2, img3, img4, img5, "favorit");
    }

    @OnClick({R.id.imgHeader4, R.id.imgRightHeader4})
    public void onClick(View view){
        switch (view.getId())
        {
            case R.id.imgHeader4 : finish(); break;
            case R.id.imgRightHeader4 : {
                FragmentTransfer.callFragment(this, new fragmentKategori(), R.id.layoutSearch, "KATEGORI");
                imgHeaderRight.setVisibility(View.GONE);
                break;
            }
        }
    }

    //Footer Action
    @OnClick({R.id.imgFooter1, R.id.imgFooter2, R.id.imgFooter3, R.id.imgFooter4, R.id.imgFooter5})
    public void onClickFooter(View view)
    {
        FooterClass.setFooter(this, img1, img2, img3, img4, img5, txtHeader, null, view.getId(), "Search");
    }
}
