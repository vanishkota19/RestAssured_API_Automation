package base;

import com.aventstack.extentreports.ExtentTest;

public class BaseExtentTest {

    public static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    public static ExtentTest getTest() {
        return extentTest.get();
    }
}
