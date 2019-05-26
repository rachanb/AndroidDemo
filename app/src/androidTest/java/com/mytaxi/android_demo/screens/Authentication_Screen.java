package com.mytaxi.android_demo.screens;

import android.util.Log;

import com.mytaxi.android_demo.R;
import com.mytaxi.android_demo.model.User;
import com.mytaxi.android_demo.screens.base.ElementActor;

public class Authentication_Screen extends ElementActor {

    private int getUserId() {
        return R.id.edt_username;
    }

    private int getPassword() {
        return R.id.edt_password;
    }

    private int getLoginBtn() {
        return R.id.btn_login;
    }

    private  int getErrorMsg(){ return R.string.message_login_fail; }


    public boolean login (User user) {
        boolean isLogin = false ;
        try {
            typeTextIntoElement( findElementWithId( getUserId() ), user.getUserId() );
            typeTextIntoElement( findElementWithId( getPassword() ), user.getPassword() );
            clickOnElement(findElementWithId(getLoginBtn()));
            waitOnPage();
            isLogin = true ;
        } catch (Exception ex) {
            Log.e("Error:", "Authentication_Screen.login");
        }

        return isLogin;
    }
}
