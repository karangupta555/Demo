package com.qa;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.FileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;


public class FlutterFinder extends BaseTest{
    AppiumDriver driver;
    FileDetector fileDetector;

    public FlutterFinder(AppiumDriver driver){
        this.driver=driver;
        this.fileDetector = null;
    }

    public FlutterElement byValueKey(String key){
        FlutterElement flutterElement = new FlutterElement(ImmutableMap
                .of("finderType","ByValueKey",
                        "keyValueType","String",
                        "keyValueString",key));
        flutterElement.setParent(driver);
        flutterElement.setFileDetector(fileDetector);
        return flutterElement;
    }
}