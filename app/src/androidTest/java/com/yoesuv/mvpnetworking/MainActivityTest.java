package com.yoesuv.mvpnetworking;

import android.os.SystemClock;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.Espresso;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.UiDevice;

import com.yoesuv.mvpnetworking.main.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.pressBack;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.action.ViewActions.swipeDown;
import static android.support.test.espresso.action.ViewActions.swipeUp;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayingAtLeast;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 *  Created by yusuf on 4/19/18.
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityTest {

    UiDevice device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());

    @Rule
    public ActivityTestRule<MainActivity> mainActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void startApplication(){
        Espresso.onView(withId(R.id.buttonListPlace)).perform(click());
        // ===== open list place =====
        SystemClock.sleep(2000);
        Espresso.onView(withId(R.id.swipeRefreshListPlace)).perform(TestHelper.withCustomConstraints(swipeDown(), isDisplayingAtLeast(50)));
        SystemClock.sleep(2000);
        Espresso.onView(withId(R.id.recyclerViewListPlace)).perform(swipeUp());
        Espresso.onView(withId(R.id.recyclerViewListPlace)).perform(swipeUp());
        Espresso.onView(withId(R.id.recyclerViewListPlace)).perform(swipeUp());
        Espresso.onView(withId(R.id.recyclerViewListPlace)).perform(swipeUp());
        SystemClock.sleep(1000);
        Espresso.onView(withId(R.id.recyclerViewListPlace)).perform(swipeUp());
        SystemClock.sleep(1000);
        Espresso.onView(withId(R.id.recyclerViewListPlace)).perform(swipeDown());
        SystemClock.sleep(2000);
        device.pressBack();
        SystemClock.sleep(500);
        //===== open list gallery =====
        Espresso.onView(withId(R.id.buttonGallery)).perform(click());
        SystemClock.sleep(2000);
        Espresso.onView(withId(R.id.swipeRefreshGallery)).perform(TestHelper.withCustomConstraints(swipeDown(), isDisplayingAtLeast(50)));
        SystemClock.sleep(2000);
        Espresso.onView(withId(R.id.recyclerViewGallery)).perform(swipeUp());
        Espresso.onView(withId(R.id.recyclerViewGallery)).perform(swipeUp());
        SystemClock.sleep(500);
        Espresso.onView(withId(R.id.recyclerViewGallery)).perform(swipeUp());
        SystemClock.sleep(1000);
        Espresso.onView(withId(R.id.recyclerViewGallery)).perform(swipeDown());
        device.pressBack();
        SystemClock.sleep(500);
    }

}
