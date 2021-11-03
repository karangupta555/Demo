package com.qa;

import com.google.common.collect.ImmutableMap;
import org.openqa.selenium.remote.FileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;


public class FlutterFinder extends BaseTest{
    RemoteWebDriver driver;
    FileDetector fileDetector;

    public FlutterFinder(RemoteWebDriver driver){
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