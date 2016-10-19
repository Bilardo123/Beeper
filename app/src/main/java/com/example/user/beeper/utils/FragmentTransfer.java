package com.example.user.beeper.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by user on 8/5/2016.
 */
public class FragmentTransfer {

    public static void callFragment(AppCompatActivity act, Fragment fragment, int id, String tag)
    {
        clearOldFragment(act, tag);
        FragmentTransaction ft = act.getSupportFragmentManager().beginTransaction();
        ft.replace(id, fragment, tag);
        ft.commit();
    }

    public static void callFragment(FragmentActivity act, Fragment fragment, int id, String tag)
    {
        clearOldFragment(act, tag);
        FragmentTransaction ft = act.getSupportFragmentManager().beginTransaction();
        ft.replace(id, fragment, tag);
        ft.commit();
    }

    public static void clearOldFragment(FragmentActivity act, String tag)
    {
        Fragment fragment = act.getSupportFragmentManager().findFragmentByTag(tag);
        if(fragment != null) {
            act.getSupportFragmentManager().beginTransaction().remove(fragment).commit();
            Log.e("Fragment", "tidak null");
        }
        else
            Log.e("Fragment", "null2");
    }
}
