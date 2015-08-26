package com.jskhaleel.albumviewer.login;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.jskhaleel.albumviewer.R;
import com.jskhaleel.albumviewer.base.BaseCompatActivity;
import com.jskhaleel.albumviewer.home.HomeActivity;
import com.jskhaleel.albumviewer.ui.UiUtils;
import com.jskhaleel.albumviewer.utils.AlertUtils;
import com.jskhaleel.albumviewer.utils.DeviceUtils;
import com.jskhaleel.albumviewer.utils.TextUtils;

public class LoginActivity extends BaseCompatActivity {

    private TextInputLayout edtUserName, edtPincode;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        setContentView(R.layout.activity_login);

        init();
        setupDefaults();
        setupEvents();
    }

    private void init() {
        edtUserName = (TextInputLayout) findViewById(R.id.edt_user_name);
        edtPincode = (TextInputLayout) findViewById(R.id.edt_pincode);
        btnLogin = (Button) findViewById(R.id.btn_login);
    }

    private void setupDefaults() {
        if(!TextUtils.isNullOrEmpty(getApp().getUserPreference().getUserName())) {
            EditText email = new EditText(LoginActivity.this);
            email.setText(getApp().getUserPreference().getUserName());
            edtUserName.addView(email);
        }
    }

    private void setupEvents() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callToLogin();
            }
        });
    }

    private void callToLogin() {
        DeviceUtils.hideSoftKeyboard(LoginActivity.this);
        final String userName = edtUserName.getEditText().getText().toString();
        String pinCode = edtPincode.getEditText().getText().toString();

        if(TextUtils.isNullOrEmpty(userName)) {
            AlertUtils.showAlert(LoginActivity.this, getResources().getString(R.string.alert_username));
            return;
        }

        if(TextUtils.isNullOrEmpty(pinCode)) {
            AlertUtils.showAlert(LoginActivity.this, getResources().getString(R.string.alert_pincode));
            return;
        }

        final Dialog dialog = UiUtils.getSpinnerDialog(LoginActivity.this, getResources().getString(R.string.loading));
        dialog.show();


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                getApp().getUserPreference().setUserName(userName);
                getApp().getUserPreference().setUserLogged(true);
                if(dialog.isShowing()) {
                    dialog.dismiss();
                }
                setResult(RESULT_OK);
                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        }, 3000);

    }
}
