package test.cn.myapplication;

import android.content.Context;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObject;
import androidx.test.uiautomator.UiObjectNotFoundException;
import androidx.test.uiautomator.UiSelector;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import static org.junit.Assert.assertEquals;


/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {


    /*@Rule  //测试Rule
    public MyRule rule = new MyRule();*/

    @Rule //作为ActivityTestRule的替代
    public ActivityScenarioRule activityScenarioRule = new ActivityScenarioRule(LoginActivity.class);


    @Before
    public void setUp() {

    }


    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = getInstrumentation().getTargetContext();
        assertEquals("test.cn.myapplication", appContext.getPackageName());

        System.out.println("测试进行中......");

    }


    @Test(timeout = 100)  //超时检测
    public void testMethod() {
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    String s;
    @Test(expected = NullPointerException.class) //忽略异常
    public void testException() {
        s.length();
    }


    @Test   //测试Espresso
    public void testEspresso() {
        for (int i = 0; i < 30; i++) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            onView(ViewMatchers.withId(R.id.button)).perform(click());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }


    @Test
    public void testUIAutomator_Calculator() throws UiObjectNotFoundException {
        //getUiDevice().pressHome(); //deprecated
        UiDevice.getInstance(getInstrumentation()).pressHome();
        UiObject Calculator = new UiObject(new UiSelector().description("计算器"));
        //UiObject Calculator = new UiObject(new UiSelector().description("Calculator"));

        Calculator.clickAndWaitForNewWindow();
        //UiObject seven = new UiObject(new UiSelector().resourceId(
        // "com.android.calculator2:id/digit7"));
        UiObject seven = new UiObject(new UiSelector().resourceId(
                "com.ape.calculator2:id/digit7"));
        seven.click();

        //UiObject plus = new UiObject(new UiSelector().resourceId(
        // "com.android.calculator2:id/plus"));
        UiObject plus = new UiObject(new UiSelector().resourceId(
                "com.ape.calculator2:id/plus"));
        plus.click();
        //UiObject one = new UiObject(new UiSelector().resourceId(
        // "com.android.calculator2:id/digit1"));
        UiObject one = new UiObject(new UiSelector().resourceId(
                "com.ape.calculator2:id/digit1"));
        one.click();
        //UiObject result = new UiObject(new UiSelector().resourceId(
        // "com.android.calculator2:id/equal"));
        UiObject result = new UiObject(new UiSelector().resourceId(
                "com.ape.calculator2:id/equal"));
        result.click();

        //getUiDevice().pressBack(); //deprecated
        UiDevice.getInstance(getInstrumentation()).pressBack();
    }


    /*@Test
    public void testAppium(){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "");//这句不是必须的
        capabilities.setCapability("deviceName","Android Emulator");
        capabilities.setCapability("platformVersion", "4.4");
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("appPackage", "com.android.calculator2");
        capabilities.setCapability("appActivity", ".Calculator");
        try {
            AppiumDriver driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }*/
}
