package com.mytaxi.android_demo.activities;


import static android.support.test.espresso.Espresso.*;
import static android.support.test.espresso.action.ViewActions.*;
import static android.support.test.espresso.matcher.ViewMatchers.*;
import static android.support.test.espresso.assertion.ViewAssertions.*;

import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.matcher.RootMatchers;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.rule.GrantPermissionRule;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import static org.hamcrest.core.AllOf.*;

import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import com.mytaxi.android_demo.R;

@LargeTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Rule
    public GrantPermissionRule mGrantPermissionRule =
            GrantPermissionRule.grant(
                    "android.permission.ACCESS_FINE_LOCATION");

    @Test
    public void test1_verifyLogin() throws InterruptedException{
        login("","");

        onView(withContentDescription(R.string.navigation_drawer_open)).perform(click());
        onView(withId(R.id.nav_username)).check(matches(withText("crazydog335")));
        //onView(withId(R.id.nav_view)).perform(click());
        //Thread.sleep(2000);
    }

    private void login(String username, String password){

        username = "crazydog335";
        password = "venture";

        try{
            ViewActions.closeSoftKeyboard();
            onView(withId(R.id.edt_username))
                    .perform(typeText(username),ViewActions.closeSoftKeyboard());
            onView(withId(R.id.edt_password))
                    .perform(typeText(password),ViewActions.closeSoftKeyboard());
            onView(withId(R.id.btn_login))
                    .perform(click());

            Thread.sleep(1000);
        }
        catch(Exception e){
            Log.e("Login()", "INTO EXCEPTION --->"+e.getMessage());

        }
    }

    @Test
    public void test2_verifySearchDriver(){
        String driverName="Sarah Scott";

        searchDriver(driverName);

        onView(withId(R.id.textViewDriverName)).check(matches(withText(driverName)));


    }

    /*@Test
    public void test3_verifyCallDriver(){
        callDriver();
    }*/

    public void searchDriver(String driverName){
        try{
            String searchText = "sa";
            //String driverName = "Sarah Scott";
            onView(withId(R.id.textSearch)).perform(click());
            Thread.sleep(500);
            onView(withId(R.id.textSearch))
                    .perform(typeText(searchText),ViewActions.closeSoftKeyboard());

            onView(withText(driverName)).inRoot(RootMatchers.isPlatformPopup()).perform(click());
            Thread.sleep(2000);

            onView(withId(R.id.fab)).perform(click());
        }
        catch(Exception e){
            Log.e("searchDriver()", "INTO EXCEPTION --->"+e.getMessage());
        }
    }

    public void callDriver(){
        try{
            onView(withId(R.id.fab)).perform(click());
            Thread.sleep(2000);
        }
        catch(Exception e){
            Log.e("callDriver()", "INTO EXCEPTION --->"+e.getMessage());
        }
    }


}
