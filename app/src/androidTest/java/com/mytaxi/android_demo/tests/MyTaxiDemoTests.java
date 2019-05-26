package com.mytaxi.android_demo.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        LoginTests.class, //test case 1
        MainScreenTests.class     //test case 2
})
public class MyTaxiDemoTests {
}
