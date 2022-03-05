package com.example.chatapp;
import androidx.test.espresso.action.ViewActions;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;

@RunWith(AndroidJUnit4.class)
public class LoginActivityTest {
    @Rule
    public ActivityTestRule<LoginActivity> mActivityRule = new ActivityTestRule<>(LoginActivity.class);
    @Test
    public void successLogin(){
        onView(withId(R.id.email)).perform(typeText("freddy1@gmail.com"), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.password)).perform(typeText("123456"), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.btn_login)).perform(click());
        //onView(withId(R.id.username)).check(matches(withText("Freddy")));
    }
    @Test
    public void failedLogin(){
        onView(withId(R.id.email)).perform(typeText("freddyvalverdeg@gmail.com"), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.password)).perform(typeText("654321"), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.btn_login)).perform(click());
        onView(withText(R.string.toast_error)).inRoot(withDecorView(not(is(
                mActivityRule.getActivity().getWindow().getDecorView())))).check(matches(isDisplayed()));
    }

}
