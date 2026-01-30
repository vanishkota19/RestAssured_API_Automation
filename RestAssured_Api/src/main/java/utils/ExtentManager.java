package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getExtent() {

        if (extent == null) {

            ExtentSparkReporter reporter =
                    new ExtentSparkReporter("test-output/ExtentReport.html");

            reporter.config().setReportName("API Automation Report");
            reporter.config().setDocumentTitle("Rest Assured Framework");

            extent = new ExtentReports();
            extent.attachReporter(reporter);

            extent.setSystemInfo("Framework", "Rest Assured");
            extent.setSystemInfo("Environment", System.getProperty("env", "qa"));
        }
        return extent;
    }
}
