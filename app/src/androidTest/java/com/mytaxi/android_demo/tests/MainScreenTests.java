package com.mytaxi.android_demo.tests;

import android.content.Context;

import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.intent.Intents;
import android.util.Log;

import com.mytaxi.android_demo.screens.DriverProfile_Screen;
import com.mytaxi.android_demo.screens.Main_Screen;

import org.junit.Test;

import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasAction;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasPackage;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.espresso.intent.matcher.IntentMatchers.toPackage;
import static android.support.test.espresso.intent.Intents.intended;

public class MainScreenTests extends BaseTest{

    Main_Screen mainPage;
    DriverProfile_Screen driverProfilePage;

    @Test
    public void Test2_verifySearchDriver() throws InterruptedException{
        mainPage = new Main_Screen();
        mainPage.searchDriver("sa","Sarah Scott");
        driverProfilePage = new DriverProfile_Screen();
        driverProfilePage.getDriverName().check(matches(withText("Sarah Scott")));

        Context context = InstrumentationRegistry.getContext();

        Log.e("Test2_verifySearchDriver()", "--- INTENDING TO DIALER PACKAGE ---" );
        Intents.init();
        //CALL DRIVER
        Log.e("Test2_verifySearchDriver()", "--- CLICKING ON DIAL ICON ---" );
        driverProfilePage.callDriver();

        //intended(hasPackage("com.google.android.dialer"));
        intended(toPackage("com.google.android.dialer"));

        Intents.release();

    }

    @Test
    public void callDriver()
    {

    }


}
