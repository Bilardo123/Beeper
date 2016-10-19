package com.example.user.beeper;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.beeper.component.FooterClass;
import com.example.user.beeper.fragment.fragmentInboxPengaturan;
import com.example.user.beeper.fragment.fragmentKritikSaran;
import com.example.user.beeper.fragment.fragmentMyService;
import com.example.user.beeper.fragment.fragmentPengaturan;
import com.example.user.beeper.fragment.fragmentProfile;
import com.example.user.beeper.fragment.fragmentScheduleHome;
import com.example.user.beeper.fragment.fragmentSide;
import com.example.user.beeper.fragment.fragmentTopKredit;
import com.example.user.beeper.fragment.fragmentUndangTeman;
import com.example.user.beeper.utils.Constanta;
import com.example.user.beeper.utils.FontChangeCrawler;
import com.example.user.beeper.utils.FragmentTransfer;
import com.example.user.beeper.utils.GlobalUtils;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SideActivity extends AppCompatActivity {

    //Header Layout
    @Bind(R.id.txtTitleHeader3) TextView txtHeader;
    @Bind(R.id.imgHeaderRight3) ImageView imgHeaderRight;
    @Bind(R.id.sidedrawer_layout) DrawerLayout mDrawer;
    @Bind(R.id.sidepage_nav_view) NavigationView mDrawerLayout;
    @Bind(R.id.imgHamburgerHeader3) ImageView imgHeader;

    //Footer
    @Bind(R.id.imgFooter1)
    ImageView img1;
    @Bind(R.id.imgFooter2) ImageView img2;
    @Bind(R.id.imgFooter3) ImageView img3;
    @Bind(R.id.imgFooter4) ImageView img4;
    @Bind(R.id.imgFooter5) ImageView img5;

    String header;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_side);
        FontChangeCrawler fontChanger = new FontChangeCrawler(getAssets(), Constanta.Jenis_Font);
        fontChanger.replaceFonts((ViewGroup)this.findViewById(android.R.id.content));
        ButterKnife.bind(this);

        setComponenView();
    }

    public void setComponenView(){

        imgHeader.setImageDrawable(getResources().getDrawable(R.drawable.icon_back));

        if(getIntent().getExtras() != null)
        {
            header = getIntent().getExtras().getString("header");
            txtHeader.setText(header);
            if(header.equals("DATA DIRI"))
                FragmentTransfer.callFragment(this, new fragmentProfile(), R.id.layoutSide, "PROFILE");
            else if(header.equals("INBOX"))
                FragmentTransfer.callFragment(this, new fragmentInboxPengaturan(), R.id.layoutSide, "INBOXPENGATURAN");
            else if(header.equals("PENGATURAN"))
                FragmentTransfer.callFragment(this, new fragmentPengaturan(), R.id.layoutSide, "PENGATURAN");
            else if(header.equals("KRITIK DAN SARAN"))
                FragmentTransfer.callFragment(this, new fragmentKritikSaran(), R.id.layoutSide, "KRITIKSARAN");
            else if(header.equals("UNDANG TEMAN"))
                FragmentTransfer.callFragment(this, new fragmentUndangTeman(), R.id.layoutSide, "UNDANGTEMAN");
            else if(header.equals("TOP KREDIT"))
                FragmentTransfer.callFragment(this, new fragmentTopKredit(), R.id.layoutSide, "TOPUPKREDIT");
            else if(header.equals("JADWAL")) {
                Bundle bundle = new Bundle();
                bundle.putString("schedule", "schedule");
                fragmentScheduleHome fragSchedule = new fragmentScheduleHome();
                fragSchedule.setArguments(bundle);
                FragmentTransfer.callFragment(this, fragSchedule, R.id.layoutSide, "SCHEDULE");
            }
        }
        imgHeaderRight.setVisibility(View.GONE);

        FragmentTransfer.callFragment(this, new fragmentSide(), R.id.layout_fragment_side_Side, "SIDE");
        GlobalUtils.changeDrawableIconFooter(img1, img2, img3, img4, img5, "home");

    }

    @OnClick(R.id.imgHamburgerHeader3)
    public void headerLayout(View view)
    {
        finish();
    }

    //Footer Action
    @OnClick({R.id.imgFooter1, R.id.imgFooter2, R.id.imgFooter3, R.id.imgFooter4, R.id.imgFooter5})
    public void onClickFooter(View view)
    {
        FooterClass.setFooter(this, img1, img2, img3, img4, img5, txtHeader, imgHeaderRight, view.getId(), "side");
    }
}
