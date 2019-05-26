package com.mytaxi.android_demo.activities;


import android.support.test.espresso.ViewInteraction;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.rule.GrantPermissionRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import com.mytaxi.android_demo.R;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest4 {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Rule
    public GrantPermissionRule mGrantPermissionRule =
            GrantPermissionRule.grant(
                    "android.permission.ACCESS_FINE_LOCATION");

    @Test
    public void mainActivityTest4() {
        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.edt_username),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.support.design.widget.TextInputLayout")),
                                        0),
                                0),
                        isDisplayed()));
        appCompatEditText.perform(click());

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.edt_username),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.support.design.widget.TextInputLayout")),
                                        0),
                                0),
                        isDisplayed()));
        appCompatEditText2.perform(replaceText("crazydog335"), closeSoftKeyboard());

        ViewInteraction appCompatEditText3 = onView(
                allOf(withId(R.id.edt_password),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.support.design.widget.TextInputLayout")),
                                        0),
                                0),
                        isDisplayed()));
        appCompatEditText3.perform(replaceText("venture"), closeSoftKeyboard());

        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.btn_login), withText("Login"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));
        appCompatButton.perform(click());

        ViewInteraction appCompatAutoCompleteTextView = onView(
                allOf(withId(R.id.textSearch),childAtPosition(allOf(withId(R.id.searchContainer),childAtPosition(withClassName(is("android.support.design.widget.CoordinatorLayout")),
                                                1)),
                                0),
                        isDisplayed()));
        appCompatAutoCompleteTextView.perform(click());

        ViewInteraction appCompatAutoCompleteTextView2 = onView(
                allOf(withId(R.id.textSearch),
                        childAtPosition(
                                allOf(withId(R.id.searchContainer),
                                        childAtPosition(
                                                withClassName(is("android.support.design.widget.CoordinatorLayout")),
                                                1)),
                                0),
                        isDisplayed()));
        appCompatAutoCompleteTextView2.perform(replaceText("sa"), closeSoftKeyboard());

        ViewInteraction frameLayout = onView(
                allOf(withId(R.id.searchContainer),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.drawer_layout),
                                        0),
                                2),
                        isDisplayed()));
        frameLayout.check(matches(isDisplayed()));

        ViewInteraction editText = onView(
                allOf(withId(R.id.textSearch), withText("sa"),
                        childAtPosition(
                                allOf(withId(R.id.searchContainer),
                                        childAtPosition(
                                                IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class),
                                                2)),
                                0),
                        isDisplayed()));
        editText.check(matches(withText("sa")));

        ViewInteraction viewGroup = onView(
                allOf(withId(R.id.toolbar),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class),
                                        1),
                                0),
                        isDisplayed()));
        viewGroup.check(matches(isDisplayed()));

        ViewInteraction viewGroup2 = onView(
                allOf(withId(R.id.toolbar),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class),
                                        1),
                                0),
                        isDisplayed()));
        viewGroup2.check(matches(isDisplayed()));
    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
