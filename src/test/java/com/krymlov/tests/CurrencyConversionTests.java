package com.krymlov.tests;

import app.currency.Currency;
import app.currency.CurrencyConverter;
import org.testng.Assert;
import org.testng.annotations.*;


public class CurrencyConversionTests {

    @DataProvider (name = "currency-provider")
    public Object[][] currencyDP(){
        return new Object[][] {{"UAH", "USD" , 50d, 1.35d}, {"UAH", "EUR", 1200d, 29.16}, {"USD","EUR",200d, 180d}};
    }

    @DataProvider (name = "currency-exception-provider")
    public Object[][] currencyExcDP(){
        return new Object[][] {{"aa", "s", 100d, 200d}, {"b", "b", 2000d, 1d}};
    }
    private CurrencyConverter currencyConverter = new CurrencyConverter();

    @BeforeClass
    public void init(){
        currencyConverter = new CurrencyConverter();
        Assert.assertNotNull(currencyConverter);
    }

    @BeforeMethod
    public void beforeMethod(){
        Assert.assertNull(currencyConverter.getFrom());
        Assert.assertNull(currencyConverter.getTo());
    }

    @Test(groups = {"currency"},dataProvider = "currency-provider")
    public void convertCurrency(String from, String to, Double amount, Double result) throws Exception {
            currencyConverter.setFrom(checker(from));
            currencyConverter.setTo(checker(to));
            Assert.assertEquals(result, currencyConverter.convert(amount));
    }

    @Test(groups = {"currency"},dataProvider = "currency-exception-provider", expectedExceptions = Exception.class)
    public void badConvertCurrency(String from, String to, Double amount, Double result) throws Exception {
        currencyConverter.setFrom(checker(from));
        currencyConverter.setTo(checker(to));
        Assert.assertEquals(result, currencyConverter.convert(amount));
    }

    @AfterMethod
    public void afterMethod(){
        currencyConverter.setTo(null);
        currencyConverter.setFrom(null);
    }

    @AfterClass
    public void afterClass(){
        System.out.println("All tests ran!");
    }

    private Currency checker(String currency) throws Exception {
        return switch (currency) {
            case "USD" -> Currency.USD;
            case "UAH" -> Currency.UAH;
            case "EUR" -> Currency.EUR;
            case "AUD" -> Currency.AUD;
            case "BGN" -> Currency.BGN;
            case "DKK" -> Currency.DKK;
            default -> throw new Exception("Wrong currency Data!");
        };
    }

}
