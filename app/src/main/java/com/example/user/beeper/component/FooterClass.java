package com.example.user.beeper.component;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.beeper.HomeActivity;
import com.example.user.beeper.R;
import com.example.user.beeper.fragment.fragmentFavoritHome;
import com.example.user.beeper.fragment.fragmentHome;
import com.example.user.beeper.fragment.fragmentHome2;
import com.example.user.beeper.fragment.fragmentNotifikasiHome;
import com.example.user.beeper.fragment.fragmentOrderListHome;
import com.example.user.beeper.fragment.fragmentUrgentCallHome;
import com.example.user.beeper.utils.FragmentTransfer;
import com.example.user.beeper.utils.GlobalUtils;

/**
 * Created by user on 8/8/2016.
 */
public class FooterClass {

    public static void setFooter(AppCompatActivity act, ImageView img1, ImageView img2, ImageView img3, ImageView img4, ImageView img5, TextView txtHeader, ImageView imgHeader3, int id, String position)
    {
        if(position.equals("home")) {
            switch (id) {
                case R.id.imgFooter1: {
                    GlobalUtils.changeDrawableIconFooter(img1, img2, img3, img4, img5, "home");
                    FragmentTransfer.callFragment(act, new fragmentHome2(), R.id.layoutHome, "HOME");
                    txtHeader.setText("HOME");
                    imgHeader3.setVisibility(View.GONE);
                    break;
                }
                case R.id.imgFooter2: {
                    GlobalUtils.changeDrawableIconFooter(img1, img2, img3, img4, img5, "favorit");
                    FragmentTransfer.callFragment(act, new fragmentFavoritHome(), R.id.layoutHome, "FAVORIT");
                    txtHeader.setText("FAVORIT");
                    imgHeader3.setVisibility(View.VISIBLE);
                    break;
                }
                case R.id.imgFooter3: {
                    GlobalUtils.changeDrawableIconFooter(img1, img2, img3, img4, img5, "urgentcall");
                    FragmentTransfer.callFragment(act, new fragmentUrgentCallHome(), R.id.layoutHome, "URGENTCALL");
                    txtHeader.setText("URGENT CALL");
                    imgHeader3.setVisibility(View.GONE);
                    break;
                }
                case R.id.imgFooter4: {
                    GlobalUtils.changeDrawableIconFooter(img1, img2, img3, img4, img5, "notif");
                    FragmentTransfer.callFragment(act, new fragmentNotifikasiHome(), R.id.layoutHome, "NOTIF");
                    txtHeader.setText("NOTIFIKASI");
                    imgHeader3.setVisibility(View.GONE);
                    break;
                }
                case R.id.imgFooter5: {
                    GlobalUtils.changeDrawableIconFooter(img1, img2, img3, img4, img5, "order");
                    FragmentTransfer.callFragment(act, new fragmentOrderListHome(), R.id.layoutHome, "ORDER");
                    txtHeader.setText("ORDER LIST");
                    imgHeader3.setVisibility(View.GONE);
                    break;
                }
                default:
                    break;
            }
        }
        else
        {
            switch (id) {
                case R.id.imgFooter1: {
                    Intent intent = new Intent(act, HomeActivity.class);
                    intent.putExtra("header", "HOME");
                    intent.putExtra("kelas", "home");
                    act.startActivity(intent);
                    act.finish();
                    break;
                }
                case R.id.imgFooter2: {
                    Intent intent = new Intent(act, HomeActivity.class);
                    intent.putExtra("header", "FAVORIT");
                    intent.putExtra("kelas", "favorit");
                    act.startActivity(intent);
                    act.finish();
                    break;
                }
                case R.id.imgFooter3: {
                    Intent intent = new Intent(act, HomeActivity.class);
                    intent.putExtra("header", "URGENT CALL");
                    intent.putExtra("kelas", "urgentcall");
                    act.startActivity(intent);
                    act.finish();
                    break;
                }
                case R.id.imgFooter4: {
                    Intent intent = new Intent(act, HomeActivity.class);
                    intent.putExtra("header", "NOTIFIKASI");
                    intent.putExtra("kelas", "notif");
                    act.startActivity(intent);
                    act.finish();
                    break;
                }
                case R.id.imgFooter5: {
                    Intent intent = new Intent(act, HomeActivity.class);
                    intent.putExtra("header", "ORDER LIST");
                    intent.putExtra("kelas", "order");
                    act.startActivity(intent);
                    act.finish();
                    break;
                }
                default:
                    break;
            }
        }
    }
}
