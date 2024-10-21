package tests.US05;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AutoMationexercisePages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExtentReport;
import utilities.ReusableMethods;

public class TC25_OkDugmesiOlmadanKaydirma extends ExtentReport {
    @Test
    public void okDugmesiOlmadanKaydirma(){
        AutoMationexercisePages autoMationexercisePages = new AutoMationexercisePages();
        SoftAssert softAssert = new SoftAssert();
        Actions actions = new Actions(Driver.getDriver());


        extentTest = extentReports.createTest("Ok düğmesi olmadan sayfayı yukarı kaydırma",
                "Kullanıcı sağ alt taraftaki ok tuşunu kullanmadan sayfanun yukarı kaydırılabildiğini test eder.");

        extentTest.pass("Kullanici autoMationexercise sitesine gider");
        Driver.getDriver().get(ConfigReader.getProperty("autom"));

        extentTest.pass("Kullanıcı doğru sayfaya gittiğini doğrular");
        String expectedTitle = ConfigReader.getProperty("expectedTitle");
        String actualTitle = Driver.getDriver().getTitle();
        softAssert.assertEquals(actualTitle, expectedTitle,"Title bilgileri farklı");

        extentTest.pass("Ana sayfadaki email butonu gözükene kadar sayfayı aşağıya kaydırır ve ekran görüntüs alır");
        actions.moveToElement(autoMationexercisePages.anaSayfaEmailButonu).perform();
        softAssert.assertTrue(autoMationexercisePages.anaSayfaEmailButonu.isDisplayed(),
                                            "Ana sayfafaki email buyonu gözükmüyor");
        extentTest.addScreenCaptureFromBase64String(ReusableMethods.ekranResmi(Driver.getDriver()));


        extentTest.pass("'Full-Fledged practice website for Automation Engineers' yazısının görünür olduğuna kadar sayfayı yukarı kaydırır");
        actions.moveToElement(autoMationexercisePages.fullFledgedpracticeYaziElementi).perform();


        extentTest.pass("'Full-Fledged practice website for Automation Engineers' yazısının görünür olduğunu doğrular, " +
                "                                                               ekran görüntüsü alır ve sayfayı kapatır");
        softAssert.assertTrue(autoMationexercisePages.fullFledgedpracticeYaziElementi.isDisplayed(),
                                                "Full-Fledged practice yazını gözükmüyor");
        extentTest.addScreenCaptureFromBase64String(ReusableMethods.ekranResmi(Driver.getDriver()));



        softAssert.assertAll();
    }
}
