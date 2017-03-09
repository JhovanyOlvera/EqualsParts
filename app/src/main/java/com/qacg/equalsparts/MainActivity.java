package com.qacg.equalsparts;

import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.hardware.fingerprint.FingerprintManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.dx.dxloadingbutton.lib.LoadingButton;
import com.qacg.equalsparts.models.User;
import com.qacg.equalsparts.services.AuthenticationServices;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    //<editor-fold des=" * * * * *  U I    R E F E R E N C E S  * * * * * ">
    @BindView(R.id.et_user)
    EditText etUser;
    @BindView(R.id.tv_user)
    TextView tvUser;
    @BindView(R.id.tv_password)
    TextView tvPassword;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.btn_logIn)
    LoadingButton btnLogIn;

    private Random rnd;
    private int color;

    private User user;

    //</editor-fold>


    //<editor-fold des=" * * * * *  S E R V I C E S  A N D  C A L L B A C K S  * * * * * ">
    private AuthenticationServices authenticationServices;
    //</editor-fold>

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initServices();
        initElements();

        // setEventClick();
    }


    //<editor-fold des=" * * * * *  I N I T   S E R V I C E S  * * * * * ">
    private void initServices() {
        authenticationServices = new AuthenticationServices();
    }
    //</editor-fold>

    //<editor-fold des=" * * * * *  I N I T   E L E M E N T S  * * * * * ">
    private void initElements() {
       /* btn_LogIn = (LoadingButton) findViewById(R.id.loading_btn);
        btn_LogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              /*  switch (v.getId()){
                    case R.id.button1:

                        break;
                }*/

        //    }
        //});*/

    }
    //</editor-fold>


    //<editor-fold des=" * * * * *  O N   C L I C K  E L E M E N T S  * * * * * ">
    private void setEventClick() {


    }

    @OnClick({R.id.tv_user, R.id.tv_password, R.id.btn_logIn})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_user:
                rnd = new Random();
                color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
                tvUser.setTextColor(color);
                btnLogIn.cancelLoading();
                break;
            case R.id.tv_password:
                rnd = new Random();
                color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
                tvPassword.setTextColor(color);
                break;
            case R.id.btn_logIn:

                AuthenticarUser runner = new AuthenticarUser();
                runner.execute();
                break;
        }
    }


    //</editor-fold>

    //<editor-fold des=" * * * * *  M E N U   E L E M E N T S  * * * * * ">

    // btn_LogIn.startLoading();
    //btn_LogIn.loadingSuccessful();
    //btn_LogIn.loadingFailed();
    //btn_LogIn.cancelLoading();
    //btn_LogIn.reset();
    //</editor-fold>


    private void validateFields() {

        if (!TextUtils.isEmpty(etUser.getText().toString()) && !TextUtils.isEmpty(etPassword.getText().toString())) {
            btnLogIn.loadingSuccessful();
        } else {
            btnLogIn.loadingFailed();
        }


    }

    //<editor-fold des=" * * * * *  E V E N T     V I E W  * * * * * ">
    void showAuthenticarLoad() {
        btnLogIn.startLoading();
    }

    //</editor-fold>

    //<editor-fold des=" * * * * *  L I F E C Y C L E  * * * * * ">

    //</editor-fold>

    // <editor-fold des=" * * * * *  A S Y N C T A S K   * * * * * ">
    public class AuthenticarUser extends AsyncTask<String, Void, String> {


        @Override
        protected void onPreExecute() {
            showAuthenticarLoad();
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... params) {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {

            validateFields();
            super.onPostExecute(s);
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }
    }

    //</editor-fold>
}
