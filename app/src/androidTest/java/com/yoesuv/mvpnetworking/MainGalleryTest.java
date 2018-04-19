package com.yoesuv.mvpnetworking;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;

import com.yoesuv.mvpnetworking.menu.gallery.views.MainGalleryActivity;

import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.action.ViewActions.swipeDown;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayingAtLeast;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 *  Created by yusuf on 4/19/18.
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainGalleryTest {

    @Rule
    public ActivityTestRule<MainGalleryActivity> mainActivityRule = new ActivityTestRule<>(MainGalleryActivity.class);

    @Test
    public void swipeRefreshGallery(){
        Espresso.onView(withId(R.id.swipeRefreshGallery)).perform(TestHelper.withCustomConstraints(swipeDown(), isDisplayingAtLeast(50)));
    }
}
