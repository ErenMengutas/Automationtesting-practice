package tests.US02;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AutoMationexercisePages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExtentReport;
import utilities.ReusableMethods;

public class TC10_AlisverisSayfasiSubscriptionButonu extends ExtentReport {
    @Test
    public void alisverisSayfasiSubscriptionButonuTesti(){
        AutoMationexercisePages autoMationexercisePages=new AutoMationexercisePages();
        SoftAssert softAssert=new SoftAssert();



        extentTest=extentReports.createTest("Alışveris sepetindeki subscription butonu",
                "Kullanıcı Alışveris sepetindeki subscription butonunun çalıştığını test eder.");

        extentTest.pass("Kullanici autoMationexercise sitesine gider");
        Driver.getDriver().get(ConfigReader.getProperty("autom"));

        extentTest.pass("Kullanıcı doğru sayfaya gittiğini doğrular");
        String expectedTitle=ConfigReader.getProperty("expectedTitle");
        String actualTitle=Driver.getDriver().getTitle();
        softAssert.assertEquals(actualTitle,expectedTitle,"Title bilgileri farklı");

        extentTest.pass("Anasayfa ki alışveris butonuna tıklar");
        autoMationexercisePages.anaSayfaCartButonu.click();

        extentTest.pass("Subscription butonuna geçerli email girer ve enter tuşuna basar");
        autoMationexercisePages.anaSayfaEmailButonu.sendKeys(ConfigReader.getProperty("gecerliKullaniciEmail")+ Keys.ENTER);

        extentTest.pass("You have been successfully subscribed!' yazısının çıktığını doğrular ekran görüntüsü alır ve sayfayı kapatır");
        softAssert.assertTrue(autoMationexercisePages.youHaveBeenYouSuccessfullyYaziElementi.isDisplayed(),
                                    "You have been successfully subscribed!' yazısı gözükmüyor");
        extentTest.addScreenCaptureFromBase64String(ReusableMethods.ekranResmi(Driver.getDriver()));



        softAssert.assertAll();
    }
}
