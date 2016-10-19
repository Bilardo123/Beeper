package com.example.user.beeper.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.Button;
import com.example.user.beeper.R;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 7/15/2016.
 */
public class PopUpDialog {

    Context ctx;

    public PopUpDialog(Context ctx)
    {
        this.ctx = ctx;
    }

    public void regionListDialog(final Button btn)
    {
        List<String> region = new ArrayList<String>();
        region.add("Jakarta");
        region.add("Medan");
        region.add("Pontianak");
        region.add("Padang");
        region.add("Manado");
        region.add("Bandung");

        final CharSequence[] regions = region.toArray(new String[region.size()]);
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(ctx);
        dialogBuilder.setTitle("Region");
        dialogBuilder.setItems(regions, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {
                btn.setText(regions[item].toString());  //Selected item in listview
                btn.setTextColor(ctx.getResources().getColor(R.color.colorPrimaryBlack));
            }
        });
        //Create alert dialog object via builder
        AlertDialog alertDialogObject = dialogBuilder.create();
        //Show the dialog
        alertDialogObject.show();
    }
}
