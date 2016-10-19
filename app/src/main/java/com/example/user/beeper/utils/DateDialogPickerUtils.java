package com.example.user.beeper.utils;

import android.app.DatePickerDialog;
import android.content.Context;
import android.util.Log;
import android.widget.Button;
import android.widget.DatePicker;
import com.example.user.beeper.R;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * Created by user on 7/15/2016.
 */
public class DateDialogPickerUtils {

    Calendar calendar;
    private SimpleDateFormat dateFormatter;
    private String tgl;
    Context ctx;

    public DateDialogPickerUtils(Context ctx)
    {
        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        calendar = Calendar.getInstance();
        tgl = "";
        this.ctx = ctx;
    }

    public DatePickerDialog DatePickerDialogPopUp(final Button btn)
    {
        DatePickerDialog datePicker = new DatePickerDialog(ctx, new DatePickerDialog.OnDateSetListener()
        {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day)
            {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, month, day);
                btn.setText(dateFormatter.format(newDate.getTime()));
                btn.setTextColor(ctx.getResources().getColor(R.color.colorPrimaryBlack));
                Log.e("Tanggal", dateFormatter.format(newDate.getTime()));
            }
        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));

        return datePicker;
    }

    public String getTgl() {
        return tgl;
    }

    public void setTgl(String tgl) {
        this.tgl = tgl;
    }
}
