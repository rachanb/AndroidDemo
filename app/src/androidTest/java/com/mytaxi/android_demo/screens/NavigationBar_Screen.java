package com.mytaxi.android_demo.screens;

import android.support.test.espresso.ViewInteraction;
import android.util.Log;

import com.mytaxi.android_demo.R;
import com.mytaxi.android_demo.screens.base.ElementActor;

public class NavigationBar_Screen extends ElementActor {

    private int getNavigationDrawerOpen() {
        return R.string.navigation_drawer_open;
    }

    private int getNavigationDrawerClose() {
        return R.string.navigation_drawer_close;
    }

    private int getUsername() {
        return R.id.nav_username;
    }

    private int getLogout(){ return R.id.nav_logout;}

    public boolean openNavigationBar(){
        boolean isNavigationSuccessful = false;
        try{
            clickOnElement(findElementWithId(getNavigationDrawerOpen()));
            isNavigationSuccessful = true;
        }
        catch(Exception e){
            Log.e("@openNavigationBar()", "Unable to open Navigation Bar");
            isNavigationSuccessful = false;
        }
        return isNavigationSuccessful;
    }

    public boolean closeNavigationBar(){
        boolean isNavigationBarClosed = false;
        try{
            clickOnElement(findElementWithId(getNavigationDrawerClose()));
            isNavigationBarClosed = true;
        }
        catch(Exception e){
            Log.e("@closeNavigationBar()", "Unable to close Navigation Bar");
            isNavigationBarClosed = false;
        }
        return isNavigationBarClosed;
    }

    public ViewInteraction getLoggedInUser(){
        return findElementWithId(getUsername());
    }

    public boolean logout(){
        boolean isLogoutDone = false;
        try{
            clickOnElement(findElementWithId(getLogout()));
            isLogoutDone = true;
        }
        catch (Exception e){
            Log.e("@logout()", "Unable to click on logout");
            isLogoutDone = false;
        }
        return isLogoutDone;
    }

}
