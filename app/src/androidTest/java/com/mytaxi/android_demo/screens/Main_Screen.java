package com.mytaxi.android_demo.screens;

import android.util.Log;

import com.mytaxi.android_demo.R;

public class Main_Screen extends NavigationBar_Screen {

    public int getTxtSearch() {
        return R.id.textSearch;
    }

    public String searchDriver(String initials, String driverName) {

        try {
            clickOnElement(findElementWithId(getTxtSearch()));
            waitOnPage();
            typeTextIntoElement(findElementWithId(getTxtSearch()),initials);

            clickOnElement(findInRoot (findElementWithText(driverName) ));
            waitOnPage();

        } catch (Exception ex) {
            Log.e("Error:", "Main_Bar_Screen.searchDriver failed");
        }
        return null;
    }


}
