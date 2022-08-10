package recipes;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasSibling;
import static androidx.test.espresso.matcher.ViewMatchers.isChecked;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.appium.android.apis.R;
import io.appium.android.apis.accessibility.TaskListActivity;

@RunWith(AndroidJUnit4.class)
public class FindElementUsingHasSiblingE2ETest {
    @Rule
    public ActivityScenarioRule<TaskListActivity> activityScenarioRule =
            new ActivityScenarioRule<>(TaskListActivity.class);

    @Test
    public void testCanFindElementUsingSiblingMatcher() {
        String taskText = "Conquer World";
        // Find checkbox with id tasklist_finished that has sibling label with text Conquer World
        onView(allOf(withId(R.id.tasklist_finished), hasSibling(withText(taskText))))
                // Click on the checkbox
                .perform(click())
                // Verify the checkbox was ticked
                .check(matches(isChecked()));
    }
}
