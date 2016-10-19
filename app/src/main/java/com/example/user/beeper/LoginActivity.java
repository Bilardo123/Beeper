package com.example.user.beeper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.user.beeper.utils.Constanta;
import com.example.user.beeper.utils.FontChangeCrawler;
import com.example.user.beeper.utils.SharedPreferencesManager;
import com.sidebeep.sdk.sidebeeplibrary.LoginFunction;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @Bind(R.id.edittxtUsername) EditText txtUsername;
    @Bind(R.id.edittxtPassword) EditText txtPassword;
    @Bind(R.id.btnLogIn) Button btnLogin;
    SharedPreferencesManager sharedPreferencesManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        FontChangeCrawler fontChanger = new FontChangeCrawler(getAssets(), Constanta.Jenis_Font);
        fontChanger.replaceFonts((ViewGroup)this.findViewById(android.R.id.content));
        sharedPreferencesManager = new SharedPreferencesManager(this);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.btnLogIn)
    public void onClick()
    {
        try {
            //Ada kondisi untuk kalau pertama kali masuk dengan sudah pernah masuk
            LoginFunction loginFunction = new LoginFunction();
            loginFunction.loginToAPI(txtUsername.getText().toString(), txtPassword.getText().toString(), sharedPreferencesManager.getEditor());
            Log.d("Beeper Login", sharedPreferencesManager.getStringFromCache("json"));
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
            finish();
        }
        catch (Exception e)
        {
            Log.e("error", e.toString());
        }
    }

}
