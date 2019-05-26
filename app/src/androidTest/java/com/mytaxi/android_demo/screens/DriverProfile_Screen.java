package com.mytaxi.android_demo.screens;

import android.support.test.espresso.ViewInteraction;
import android.util.Log;

import com.mytaxi.android_demo.R;
import com.mytaxi.android_demo.screens.base.ElementActor;

public class DriverProfile_Screen extends ElementActor {


    private int getFabBtn() {
        return R.id.fab;
    }

    private int getDriverNameLabel(){ return R.id.textViewDriverName; }

    public ViewInteraction getDriverName(){
        return findElementWithId(getDriverNameLabel());
    }

    public void callDriver () {
        try {
            clickOnElement(findElementWithId(getFabBtn()));
        } catch (Exception ex) {
            Log.e("Error:", "Authentication_Screen.login");
        }

    }

}
