package com.example.stringresource20072021;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    TextInputEditText mEdtEmail,mEdtPassword;
    Button mBtnSignIn;
    TextView mTvInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEdtEmail = findViewById(R.id.textInputEditTextMail);
        mEdtPassword = findViewById(R.id.textInputEditTextPassword);
        mBtnSignIn = findViewById(R.id.buttonSignIn);
        mTvInfo = findViewById(R.id.textViewInfo);

        mBtnSignIn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                String email = mEdtEmail.getText().toString();
                String password = mEdtPassword.getText().toString();

                if (email.equals("android123@gmail.com") && password.equals("12345678")){
                    String strEmail = getResources().getString(R.string.text_hint_email);
                    String strPassword = getResources().getString(R.string.text_hint_password);
                    String strLink = getResources().getString(R.string.text_demo_html);

                    mTvInfo.setText(strEmail + " : " + email + "\n" + strPassword + " : " + password + "\n");
                    mTvInfo.append(Html.fromHtml(strLink));

                }

            }
        });
    }
}