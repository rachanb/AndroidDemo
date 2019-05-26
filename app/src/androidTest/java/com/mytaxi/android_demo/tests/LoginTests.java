package com.mytaxi.android_demo.tests;

import static android.support.test.espresso.matcher.ViewMatchers.*;
import static android.support.test.espresso.assertion.ViewAssertions.*;

import com.mytaxi.android_demo.model.User;
import com.mytaxi.android_demo.screens.Authentication_Screen;
import com.mytaxi.android_demo.screens.DriverProfile_Screen;
import com.mytaxi.android_demo.screens.Main_Screen;


import org.junit.Test;

public class LoginTests extends BaseTest{

    Main_Screen mainPage;
    DriverProfile_Screen driverProfilePage;

    @Test
    public void Test1_verifyAuthenticationForValidUser(){
        Authentication_Screen authenticationPage = new Authentication_Screen();
        User user = new User();
        if(authenticationPage.login(user)){
           mainPage = new Main_Screen();
           mainPage.getLoggedInUser().check(matches(withText(user.getUserId())));

        }
    }

   /* @Test
    public void Test1_verifyAuthenticationForInvalidUser(){
        Authentication_Screen authenticationPage = new Authentication_Screen();
        User user = new User();
        if(authenticationPage.login(user)){
            mainPage = new Main_Screen();
            mainPage.getLoggedInUser().check(matches(withText(user.getUserId())));

        }
    }*/



}
