package com.krymlov.tests;

import app.temperature.TemperatureConverter;
import org.testng.Assert;
import org.testng.annotations.*;

public class TemperatureConversionTests {

    private TemperatureConverter temperatureConverter = new TemperatureConverter();

    @BeforeClass
    public void init(){
        temperatureConverter = new TemperatureConverter();
    }

    @BeforeMethod
    public void beforeEach(){
    }

    @DataProvider (name = "temperature-provider")
    public Object[][] dpMethod(){
        return new Object[][] {{5d}, {25d}, {30d}, {100d}, {24d}, {70d}};
    }

    @Test(groups = {"temperature"}, dataProvider = "temperature-provider")
    public void convertCtoF(Double amount){
        Assert.assertEquals(temperatureConverter.CtoF(amount), (amount * 9/5) + 32);
    }

    @Test(groups = {"temperature"},dataProvider = "temperature-provider")
    public void convertCtoK(Double amount){
        Assert.assertEquals(temperatureConverter.CtoK(amount), amount + 273.15);
    }

    @Test(groups = {"temperature"}, dataProvider = "temperature-provider")
    public void convertKtoC(Double amount){
        Assert.assertEquals(temperatureConverter.KtoC(amount), amount - 273.15);
    }

    @Test(groups = {"temperature"}, dataProvider = "temperature-provider")
    public void convertKtoF(Double amount){
        Assert.assertEquals(temperatureConverter.KtoF(amount), (amount - 273.15) * 9/5 + 32);
    }

    @Test(groups = {"temperature"}, dataProvider = "temperature-provider")
    public void convertFtoC(Double amount){
        Assert.assertEquals(temperatureConverter.FtoC(amount), (amount - 32) * 5/9);
    }

    @Test(groups = {"temperature"}, dataProvider = "temperature-provider")
    public void convertFtoK(Double amount){
        Assert.assertEquals(temperatureConverter.FtoK(amount), (amount - 32) * 5/9 + 273.15);
    }

    @AfterMethod
    public void afterEach(){}

    @AfterClass
    public void afterClass(){
        System.out.println("All tests ran!");
    }

}
