package tests.US01;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AutoMationexercisePages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExtentReport;
import utilities.ReusableMethods;

public class TC02_Negatif_loginTesti extends ExtentReport {
    @Test
    public void negaatifLogintesti(){

        AutoMationexercisePages autoMationexercisePages=new AutoMationexercisePages();
        SoftAssert softAssert=new SoftAssert();
        Faker faker=new Faker();

        extentTest=extentReports.createTest("Negatif login testi",
                                                "Kullanici yanlış e-mail ve şifre ile sisteme giriş yapamamalı");


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

        extentTest.pass("Geçersiz Kullanici adi ve sifre girer");
        autoMationexercisePages.mevcutKullaniciEmailButonu.sendKeys(faker.internet().emailAddress());
        autoMationexercisePages.mevcutKullaniciPassButonu.sendKeys(faker.internet().password());

        extentTest.pass("Login butonuna Basar");
        autoMationexercisePages.mevcutKullaniciLoginButonu.click();

        extentTest.pass("Kullanici adi ve şifre yanlış yazısının çıktığını doğrular ekran görüntüsü alır ve sayfayı kapatır");
        softAssert.assertTrue(autoMationexercisePages.yanlişEmailPassYazisi.isDisplayed());
        extentTest.addScreenCaptureFromBase64String(ReusableMethods.ekranResmi(Driver.getDriver()));

       softAssert.assertAll();
    }

}
