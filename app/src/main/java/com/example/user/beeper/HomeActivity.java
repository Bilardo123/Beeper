package com.example.user.beeper;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.user.beeper.component.FooterClass;
import com.example.user.beeper.fragment.fragmentFavoritHome;
import com.example.user.beeper.fragment.fragmentHome2;
import com.example.user.beeper.fragment.fragmentNotifikasiHome;
import com.example.user.beeper.fragment.fragmentOrderListHome;
import com.example.user.beeper.fragment.fragmentSide;
import com.example.user.beeper.fragment.fragmentUrgentCallHome;
import com.example.user.beeper.utils.Constanta;
import com.example.user.beeper.utils.FontChangeCrawler;
import com.example.user.beeper.utils.FragmentTransfer;
import com.example.user.beeper.utils.GlobalUtils;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeActivity extends AppCompatActivity {

    //Header Layout
    @Bind(R.id.txtTitleHeader3) TextView txtHeader;
    @Bind(R.id.imgHeaderRight3) ImageView imgHeaderRight3;
    @Bind(R.id.drawer_layout) DrawerLayout mDrawer;
    @Bind(R.id.nav_view) NavigationView mDrawerLayout;

    //Footer
    @Bind(R.id.imgFooter1) ImageView img1;
    @Bind(R.id.imgFooter2) ImageView img2;
    @Bind(R.id.imgFooter3) ImageView img3;
    @Bind(R.id.imgFooter4) ImageView img4;
    @Bind(R.id.imgFooter5) ImageView img5;

    //FAB
    @Bind(R.id.fab) FloatingActionButton fab;

    String kelas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        FontChangeCrawler fontChanger = new FontChangeCrawler(getAssets(), Constanta.Jenis_Font);
        fontChanger.replaceFonts((ViewGroup)this.findViewById(android.R.id.content));

        ButterKnife.bind(this);

        componentView();
    }

    public void componentView()
    {
        FragmentTransfer.callFragment(this, new fragmentSide(), R.id.layout_fragment_side_home, "SIDE");

        if(getIntent().getExtras() != null)
        {
            txtHeader.setText(getIntent().getExtras().getString("header"));
            kelas = getIntent().getExtras().getString("kelas");
            if(kelas != null) {
                if (kelas.equals("home")) {
                    FragmentTransfer.callFragment(this, new fragmentHome2(), R.id.layoutHome, "HOME");
                    GlobalUtils.changeDrawableIconFooter(img1, img2, img3, img4, img5, "home");
                    fab.setVisibility(View.VISIBLE);
                    imgHeaderRight3.setVisibility(View.GONE);
                } else if (kelas.equals("urgentcall")) {
                    FragmentTransfer.callFragment(this, new fragmentUrgentCallHome(), R.id.layoutHome, "URGENTCALL");
                    GlobalUtils.changeDrawableIconFooter(img1, img2, img3, img4, img5, "urgentcall");
                    fab.setVisibility(View.GONE);
                    imgHeaderRight3.setVisibility(View.GONE);
                } else if (kelas.equals("notif")) {
                    FragmentTransfer.callFragment(this, new fragmentNotifikasiHome(), R.id.layoutHome, "NOTIF");
                    GlobalUtils.changeDrawableIconFooter(img1, img2, img3, img4, img5, "notif");
                    fab.setVisibility(View.GONE);
                    imgHeaderRight3.setVisibility(View.GONE);
                } else if (kelas.equals("order")) {
                    FragmentTransfer.callFragment(this, new fragmentOrderListHome(), R.id.layoutHome, "ORDER");
                    GlobalUtils.changeDrawableIconFooter(img1, img2, img3, img4, img5, "order");
                    fab.setVisibility(View.GONE);
                } else if (kelas.equals("favorit")) {
                    imgHeaderRight3.setVisibility(View.GONE);
                    FragmentTransfer.callFragment(this, new fragmentFavoritHome(), R.id.layoutHome, "FAVORIT");
                    GlobalUtils.changeDrawableIconFooter(img1, img2, img3, img4, img5, "favorit");
                    fab.setVisibility(View.GONE);
                    imgHeaderRight3.setVisibility(View.VISIBLE);
                }
            }
            else
            {
                FragmentTransfer.callFragment(this, new fragmentHome2(), R.id.layoutHome, "HOME");
                GlobalUtils.changeDrawableIconFooter(img1, img2, img3, img4, img5, "home");
                fab.setVisibility(View.VISIBLE);
                imgHeaderRight3.setVisibility(View.GONE);
            }
        }
        else
        {
            FragmentTransfer.callFragment(this, new fragmentHome2(), R.id.layoutHome, "HOME");
            GlobalUtils.changeDrawableIconFooter(img1, img2, img3, img4, img5, "home");
            imgHeaderRight3.setVisibility(View.GONE);
            fab.setVisibility(View.VISIBLE);
        }

    }

    //Footer Action
    @OnClick({R.id.imgFooter1, R.id.imgFooter2, R.id.imgFooter3, R.id.imgFooter4, R.id.imgFooter5})
    public void onClickFooter(View view)
    {
        FooterClass.setFooter(this, img1, img2, img3, img4, img5, txtHeader, imgHeaderRight3, view.getId(), "home");

        if(view.getId() == R.id.imgFooter1)
            fab.setVisibility(View.VISIBLE);
        else
            fab.setVisibility(View.GONE);
    }

    //FAB Action
    @OnClick(R.id.fab)
    public void onClickFAB()
    {
        Intent intent = new Intent(this, SearchActivity.class);
        startActivity(intent);
    }

    @OnClick({R.id.imgHamburgerHeader3, R.id.imgHeaderRight3})
    public void headerLayout(View view)
    {
        switch (view.getId())
        {
            case R.id.imgHamburgerHeader3 : mDrawer.openDrawer(mDrawerLayout); break;
            case R.id.imgHeaderRight3 : {
                Intent intent = new Intent(this, SearchActivity.class);
                startActivity(intent);
                break;
            }
        }

    }
}
