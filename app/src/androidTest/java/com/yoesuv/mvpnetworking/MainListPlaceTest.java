package com.yoesuv.mvpnetworking;

import android.support.test.espresso.Espresso;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.yoesuv.mvpnetworking.menu.listplace.views.MainListPlaceActivity;

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
public class MainListPlaceTest {

    @Rule
    public ActivityTestRule<MainListPlaceActivity> mainListPlaceRule = new ActivityTestRule<>(MainListPlaceActivity.class);

    @Test
    public void swipeRefreshGallery(){
        Espresso.onView(withId(R.id.swipeRefreshListPlace)).perform(TestHelper.withCustomConstraints(swipeDown(), isDisplayingAtLeast(50)));
    }

}
