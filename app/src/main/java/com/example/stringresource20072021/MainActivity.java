package com.example.stringresource20072021;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    TextInputEditText mEdtEmail, mEdtPassword;
    Button mBtnSignIn;
    TextView mTvInfo;
    ImageView mImgVN, mImgEN;
    SharedPreferences mSharedPreferences;
    SharedPreferences.Editor mEditor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mSharedPreferences = getSharedPreferences("Appcache",MODE_PRIVATE);
        String language = mSharedPreferences.getString("language","");

        if (language.length() >0){
            setLanguage(language);
        }

        setContentView(R.layout.activity_main);

        mEdtEmail = findViewById(R.id.textInputEditTextMail);
        mEdtPassword = findViewById(R.id.textInputEditTextPassword);
        mBtnSignIn = findViewById(R.id.buttonSignIn);
        mTvInfo = findViewById(R.id.textViewInfo);
        mImgVN = findViewById(R.id.imageLanguageVn);
        mImgEN = findViewById(R.id.imageLanguageEn);

        mBtnSignIn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                String email = mEdtEmail.getText().toString();
                String password = mEdtPassword.getText().toString();

                if (email.equals("android123@gmail.com") && password.equals("12345678")) {
                    String strEmail = getResources().getString(R.string.text_hint_email);
                    String strPassword = getResources().getString(R.string.text_hint_password);
                    String strLink = getResources().getString(R.string.text_demo_html);

                    mTvInfo.setText(strEmail + " : " + email + "\n" + strPassword + " : " + password + "\n");
                    mTvInfo.append(Html.fromHtml(strLink));
                }
            }
        });

        mImgEN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mEditor = mSharedPreferences.edit();
                mEditor.putString("language","en");
                mEditor.apply();
                Intent intent1 = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent1);
                finish();
            }
        });

        mImgVN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mEditor = mSharedPreferences.edit();
                mEditor.putString("language","vi");
                mEditor.apply();
                Intent intent1 = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent1);
                finish();

            }
        });
    }

    private void setLanguage(String languageCode) {
        Locale locale = new Locale(languageCode);
        Locale.setDefault(locale);
        Resources resources = getResources();
        Configuration config = resources.getConfiguration();
        config.setLocale(locale);
        resources.updateConfiguration(config, resources.getDisplayMetrics());
    }


}