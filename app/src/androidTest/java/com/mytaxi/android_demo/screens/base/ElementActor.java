package com.mytaxi.android_demo.screens.base;

import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.matcher.RootMatchers;
import android.util.Log;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class ElementActor {

    protected ViewInteraction findElementWithId(int elementId) {
        return onView(withId(elementId));
    }

    protected ViewInteraction findElementWithText(String text) {
        return onView(withText(text));
    }

    protected ViewInteraction findElementWithContentDescription(String withDescription) {
        return onView(withContentDescription(withDescription));
    }

    protected ViewInteraction findInRoot(ViewInteraction element) {
        return element.inRoot(RootMatchers.isPlatformPopup());
    }

    public ViewInteraction typeTextIntoElement(ViewInteraction element, String text)  throws Exception {

        try {
            element = element.perform(ViewActions.typeText(text), ViewActions.closeSoftKeyboard());

        }catch (Exception ex) {
            Log.e("Error:" , "PageActions.typeTextIntoElement failed") ;
            element = null ;
            throw  ex;
        }
        return element;
    }

    public ViewInteraction clickOnElement(ViewInteraction element)  throws Exception {

        try {
            element =  element.perform(ViewActions.click());

        } catch( Exception ex) {
            Log.e("Error:", "PageActions.clickOnElement failed");
            element = null ;
            throw ex;
        }
        return element;
    }

    public  void waitOnPage() {
        try {
            Thread.sleep(1000);
        }catch(Exception ex) {
            Log.e("Error:" , "ElementActor.waitOnPage failed");
        }
    }




}
