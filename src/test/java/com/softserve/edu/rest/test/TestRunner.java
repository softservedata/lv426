package com.softserve.edu.rest.test;

import io.qameta.allure.Attachment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public abstract class TestRunner {
    private final static Logger logger = LoggerFactory.getLogger(TestRunner.class.getName());

    @BeforeTest
    public void beforeTestSetUp(ITestContext testResult){
        logger.info("Test has started"+ testResult.getName());
    }

    @AfterTest
    public void afterTestSetUp(ITestContext testResult){
        logger.info("Test has started"+ testResult.getName());
        saveTextAttach(testResult.getName(), "D:\\framework\\rest\\lv426\\myproject-debug.log");
    }

    @Attachment("Image attachment")
    public byte[] addImgAttachment() throws IOException {
        File img = new File(getClass().getClassLoader().getResource("totally-open-source-kitten.jpeg").getFile());
        return Files.readAllBytes(img.toPath());
    }

    @Attachment(value = "{0}", type = "text/plain")
    public byte[] saveTextAttach(String attachName, String attachPath) {
        byte[] result = null;
        try {
            result = Files.readAllBytes(Paths.get(attachPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
