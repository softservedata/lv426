package com.softserve.edu.rest.tools;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Listener implements ITestListener {
    private static ByteArrayOutputStream context;
    final Logger logger = LoggerFactory.getLogger(this.getClass());
    public static PrintStream contextPrint;

    public void onTestStart(ITestResult result) {
        context = new ByteArrayOutputStream();
        contextPrint = new PrintStream(context, true);

    }

    public void onTestSuccess(ITestResult result) {
        logger.debug(context.toString());
        attach(result.getName());

    }

    public void onTestFailure(ITestResult result) {
        logger.error(result.getName() + "Failed", result.getThrowable());
        attach(result.getName());

    }

    @Attachment(value = "My attach", type = "text/plain")
    private void attach(String fileName) {
        Path content = Paths.get("./logs/TestLogs.log");
        try {
            InputStream is = Files.newInputStream(content);
            Allure.addAttachment("Logs for " + fileName, is);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

