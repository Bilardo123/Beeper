package com.example.user.beeper.utils;

import android.content.Context;
import android.view.View;
import com.balysv.materialripple.MaterialRippleLayout;
import com.example.user.beeper.R;

/**
 * Created by user on 8/26/2016.
 */
public class ButtonRippleUtils {

    public static void setRippleEffect(View view, Context ctx){

        MaterialRippleLayout.on(view)
                .rippleColor(ctx.getResources().getColor(R.color.textColor3))
                .rippleAlpha(0.2f)
                .rippleHover(true)
                .create();

    }
}
