package task_two;

import org.testng.ITestListener;
import org.testng.annotations.Listeners;

import java.lang.reflect.Method;

@Listeners
public class AnnotationTestListener implements ITestListener {

    @Override
    public void onTestStart(org.testng.ITestResult result) {
        System.out.println("onTestStart");
        Method testMethod = result.getMethod().getConstructorOrMethod().getMethod();
        if (testMethod.isAnnotationPresent(TestMethodInfo.class)) {
            TestMethodInfo annotation = testMethod.getAnnotation(TestMethodInfo.class);
            Priority priority = annotation.priority();
            String author = annotation.author();
            String lastModified = annotation.lastModified();
            System.out.println("Test Priority: " + priority);
            System.out.println("Test Author: " + author);
            System.out.println("Test Last Modified: " + lastModified);
        }
    }
    @Override
    public void onTestSuccess(org.testng.ITestResult result) {
        System.out.println("onTestSuccess");
    }
    @Override
    public void onTestFailure(org.testng.ITestResult result) {
        System.out.println("onTestFailure");
    }



}
