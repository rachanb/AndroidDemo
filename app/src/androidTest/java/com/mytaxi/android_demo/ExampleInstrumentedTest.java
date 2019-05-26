package com.mytaxi.android_demo;



import android.support.test.espresso.ViewAction;
import android.support.test.espresso.action.ViewActions;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.rule.GrantPermissionRule;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import com.mytaxi.android_demo.activities.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.allOf;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;


@LargeTest
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Rule
    public GrantPermissionRule mGrantPermissionRule =
            GrantPermissionRule.grant(
                    "android.permission.ACCESS_FINE_LOCATION");

    @Test
    public void verifyLogin() throws InterruptedException{
        login("","");

        onView(withContentDescription(R.string.navigation_drawer_open)).perform(click());
        onView(withId(R.id.nav_username)).check(matches(withText("crazydog335")));
        onView(withId(R.id.nav_view)).perform(click());
        Thread.sleep(3000);
    }

    private void login(String username, String password){

        username = "crazydog335";
        password = "venture";

        try{
            ViewActions.closeSoftKeyboard();
            onView(withId(R.id.edt_username)).perform(typeText(username));
            onView(withId(R.id.edt_password)).perform(typeText(password));
            onView(withId(R.id.btn_login)).perform(click());

            Thread.sleep(500);
        }
        catch(Exception e){
            Log.e("Login()", "INTO EXCEPTION --->"+e.getMessage());

        }
    }

    @Test
    public void verifySearchDriver(){
        searchDriver("sa");
    }

    public void searchDriver(String driver){
        try{
            //onView(withText("Sarah Scott")).inRoot(RootMatchers.isPlatformPopup()).perform(click());
            String searchText = "sa";
            onView(withId(R.id.textSearch)).perform(click());
            Thread.sleep(1000);
            onView(withId(R.id.textSearch)).perform(typeText(searchText));

            /*onView(allOf(withId(R.id.textSearch), isDisplayed()))
                    .perform(typeText("sa"),closeSoftKeyboard());
            onView(withText("Sarah Scott"))
                    .inRoot(withDecorView(not(is(mActivity.getWindow().getDecorView()))))
                    .perform(click());
            onView(withId(R.id.fab))
                    .perform(click())*/
            Thread.sleep(3000);
        }
        catch(Exception e){
            Log.e("searchDriver()", "INTO EXCEPTION --->"+e.getMessage());
        }
    }


}

