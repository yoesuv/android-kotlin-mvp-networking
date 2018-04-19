package com.yoesuv.mvpnetworking;

import android.support.test.espresso.Espresso;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.yoesuv.mvpnetworking.main.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 *  Created by yusuf on 4/19/18.
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mainActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void clickMenuListPlace(){
        Espresso.onView(withId(R.id.buttonListPlace)).perform(click());
    }

    @Test
    public void clickMenuGallery(){
        Espresso.onView(withId(R.id.buttonGallery)).perform(click());
    }

}
