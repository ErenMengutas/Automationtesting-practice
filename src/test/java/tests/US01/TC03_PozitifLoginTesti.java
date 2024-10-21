package tests.US01;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AutoMationexercisePages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExtentReport;
import utilities.ReusableMethods;

public class TC03_PozitifLoginTesti extends ExtentReport {
    @Test
    public void pozitifLoginTesti(){
        AutoMationexercisePages autoMationexercisePages=new AutoMationexercisePages();
        SoftAssert softAssert=new SoftAssert();

        extentTest=extentReports.createTest("Pozitif Login testi",
                                            "Kullanici geçerli e-mail ve password kullarak sisteme giriş yapabilmeli");

        extentTest.pass("Kullanici autoMationexercise sitesine gider");
        Driver.getDriver().get(ConfigReader.getProperty("autom"));

        extentTest.pass("Kullanıcı doğru sayfaya gittiğini doğrular");
        String expectedTitle=ConfigReader.getProperty("expectedTitle");
        String actualTitle=Driver.getDriver().getTitle();
        softAssert.assertEquals(actualTitle,expectedTitle);

        extentTest.pass("Sign up butonuna basar");
        autoMationexercisePages.signUpLoginButonu.click();


        extentTest.pass("'Login To Your Account' yazisinin görünür olduğunu test eder");
        softAssert.assertTrue(autoMationexercisePages.loginToYourAccountYazisi.isDisplayed());

        extentTest.pass("Geçerli kullanici adi, sifre girer ve login butonuna tıklar");
        autoMationexercisePages.mevcutKullaniciEmailButonu.sendKeys(ConfigReader.getProperty("gecerliKullaniciEmail"));
        autoMationexercisePages.mevcutKullaniciPassButonu.sendKeys(ConfigReader.getProperty("gecerliSifre"));
        autoMationexercisePages.mevcutKullaniciLoginButonu.click();

        extentTest.pass("Sisteme giriş yapıldığını test eder, ekran görüntüsü alır");
        softAssert.assertTrue(autoMationexercisePages.loggedInButonu.isDisplayed());
        extentTest.addScreenCaptureFromBase64String(ReusableMethods.ekranResmi(Driver.getDriver()));

        extentTest.pass("Logout butonuna basar ve sayfayı kapatır");
        autoMationexercisePages.logoutButonu.click();



    softAssert.assertAll();

    }
}
