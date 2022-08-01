package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.gherkin.model.*;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.awt.*;
import java.io.File;

public class QuickTest {

    private static ExtentReports report;
    private static ExtentSparkReporter sparkReporter;
    private static ExtentTest test;

//    public static void main(String[] args) {
//
//
//        String reportPath = System.getProperty("user.dir") + "/target/report.html";
//        report = new ExtentReports();
//
//        sparkReporter = new ExtentSparkReporter(reportPath);
//
//        try {
//
//        sparkReporter.loadXMLConfig(new File("src/spark-config.xml"));
//        }catch (Exception ecx){
//            ecx.printStackTrace();
//        }
//
//        report.attachReporter(sparkReporter);
//        test = report.createTest("haha");
//        ExtentTest scenario = report.createTest(Scenario.class, "Jeff returns a faulty microwave");
//        scenario.createNode(Given.class, "Jeff has bought a microwave for $100").pass("pass");
//        scenario.createNode(And.class, "he has a receipt").pass("pass");
//        scenario.createNode(When.class, "he returns the microwave").pass("pass");
//        scenario.createNode(Then.class, "Jeff should be refunded $100").fail("fail");
//
//        test.createNode("Name shu name ghu").createNode("hahaha").pass("for no reason");
//        test.pass("Pass ha ha ha");
//        test.fail("Failed wu wu wu");
//        test.info("info info");
//        test.skip("skip skip");
//        test.log(Status.PASS, "This is a logging event for MyFirstTest, and it passed!");
//        test.log(Status.FAIL, "<a href=\"https://www.olg.ca/en/home.html\">SHERLCK-2888</a>");
//
////        test.pass()
////        test.fail()
//
//
//
//
//        report.flush();
//
//        try {
//
//         Desktop.getDesktop().browse(new File("target/report.html").toURI());
//        }catch (Exception ex){
//            ex.printStackTrace();
//        }
//    }

    public static void main(String[] args) {
         String CODE1 = "{\n    \"theme\": \"standard\",\n    \"encoding\": \"utf-8\n}";
         String CODE2 = "{\n    \"protocol\": \"HTTPS\",\n    \"timelineEnabled\": false\n}";


        ExtentReports extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark/Spark.html");
        
        extent.attachReporter(spark);

        extent.createTest("ScreenCapture")
                .addScreenCaptureFromPath("extent.png")
                .pass(MediaEntityBuilder.createScreenCaptureFromPath("extent.png").build());

        extent.createTest("LogLevels")
                .info("info")
                .pass("pass")
                .warning("warn")
                .skip("skip")
                .fail("fail");

        extent.createTest("CodeBlock").generateLog(
                Status.PASS,
                MarkupHelper.createCodeBlock(CODE1, CODE2));

        extent.createTest("ParentWithChild")
                .createNode("Child")
                .pass(MarkupHelper.createLabel("This test is created as a toggle as part of a child test of 'ParentWithChild'", ExtentColor.GREEN));

        extent.createTest("Tags")
                .assignCategory("MyTag")
                .pass("The test 'Tags' was assigned by the tag <span class='badge badge-primary'>MyTag</span>");

        extent.createTest("Authors")
                .assignAuthor("TheAuthor")
                .pass("This test 'Authors' was assigned by a special kind of author tag.");

        extent.createTest("Devices")
                .assignDevice("TheDevice")
                .pass("This test 'Devices' was assigned by a special kind of devices tag. <i class='fa fa-frown-o'></i>");

        extent.createTest("Exception! <i class='fa fa-frown-o'></i>").createNode("Test <i class='fa fa-frown-o'></i>")
                .fail(new RuntimeException("A runtime exception occurred!"));

        extent.flush();

    }
}
