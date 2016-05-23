package book.laborhazirecipe;

import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import book.laborhazirecipe.android.MainActivity;

import android.support.test.espresso.contrib.RecyclerViewActions;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class UITest {

    @Rule
    public ActivityRule<MainActivity> mActivityRule = new ActivityRule(MainActivity.class);

    @Test
    public void testMoveToAbout() {
        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());
        onView(withText("About")).perform(click());
        onView(withText("About Us")).check(ViewAssertions.matches(isDisplayed()));
    }
    @Test
    public void testMoveToDetail() {
        onView(withId(R.id.rvRecipes)).perform(RecyclerViewActions.actionOnItemAtPosition(2, click()));
        onView(withText("Bacon")).check(ViewAssertions.matches(isDisplayed()));
    }
}
