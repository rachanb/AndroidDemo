package com.mytaxi.android_demo.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mytaxi.android_demo.App;
import com.mytaxi.android_demo.R;
import com.mytaxi.android_demo.dependencies.component.AppComponent;
import com.mytaxi.android_demo.utils.network.HttpClient;
import com.mytaxi.android_demo.utils.storage.SharedPrefStorage;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.inject.Inject;

import static com.mytaxi.android_demo.misc.Constants.LOG_TAG;

public class AuthenticationActivity extends AppCompatActivity {

    @Inject
    HttpClient mHttpClient;

    @Inject
    SharedPrefStorage mSharedPrefStorage;

    private EditText mEditTextUsername;
    private EditText mEditTextPassword;

    private static final String RANDOM_USER_SEED = "a1f30d446f820665";

    public static Intent createIntent(Activity activity) {
        return new Intent(activity, AuthenticationActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);
        AppComponent appComponent = App.getApplicationContext(this).getAppComponent();
        appComponent.inject(this);
        mEditTextUsername = findViewById(R.id.edt_username);
        mEditTextPassword = findViewById(R.id.edt_password);
        Button buttonLogin = findViewById(R.id.btn_login);
        buttonLogin.setOnClickListener(new OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View view) {
                attemptLogin();
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void attemptLogin() {
        final String username = mEditTextUsername.getText().toString();
        final String password = mEditTextPassword.getText().toString();
        mHttpClient.fetchUser(RANDOM_USER_SEED, new HttpClient.UserCallback() {
            @Override
            public void run() {
                String sha256 = calculateSHA256(password, mUser.getSalt());
                if (mUser.match(username, sha256)) {
                    mSharedPrefStorage.saveUser(mUser);
                    finish();
                    Log.i(LOG_TAG, "Successful login with user: " + username);
                } else {
                    /*View view = findViewById(android.R.id.content);
                    Snackbar.make(view, R.string.message_login_fail, Snackbar.LENGTH_LONG).show();*/

                    //BY- RACHANA
                    // ADDING THE TOAST WHICH GETS DISPLAYED AT THE CENTER OF THE SCREEN TO UNDERSTAND THAT LOGIN HAS FAILED.
                    toastAuthFail(username, password);

                    Log.i(LOG_TAG, "Failed login with user: " + username);
                }
            }
        });
    }

    //ADDED BY RACHANA
    private void toastAuthFail(String username, String password) {

        final int finalToast ;
        int toastMessage = R.string.message_login_fail;

        if (password != null && "".equals(password.trim()))
            toastMessage = R.string.message_Password_notnull;

        if (username != null && "".equals(username.trim()))
            toastMessage = R.string.message_Username_notnull;

        finalToast = toastMessage;

        runOnUiThread(new Runnable() {
            View view = findViewById(android.R.id.content);
            @Override
            public void run() {
                Toast toast = Toast.makeText(getApplicationContext(),finalToast,Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER,0,0);
                toast.show();
            }
        });

    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private String calculateSHA256(String password, String salt) {
        String passwordWithSalt = password + salt;
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            digest.update(passwordWithSalt.getBytes(StandardCharsets.UTF_8));
            return String.format("%064x", new BigInteger(1, digest.digest()));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return passwordWithSalt;
    }

}
