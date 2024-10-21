package tests.US02;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AutoMationexercisePages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExtentReport;
import utilities.ReusableMethods;

public class TC09_AnaSayfaSubscriptionButonu extends ExtentReport {
    @Test
    public void anaSayfaSubscriptionButonu(){


        AutoMationexercisePages autoMationexercisePages=new AutoMationexercisePages();
        SoftAssert softAssert=new SoftAssert();
        Actions actions=new Actions(Driver.getDriver());


        extentTest=extentReports.createTest("Ana sayfa Subscription butonu doğrulama",
                "Kullanıcı Ana sayfadaki Subscription butonunun kullanılabilir olduğunu test eder");

        extentTest.pass("Kullanici autoMationexercise sitesine gider");
        Driver.getDriver().get(ConfigReader.getProperty("autom"));

        extentTest.pass("Kullanıcı doğru sayfaya gittiğini doğrular");
        String expectedTitle=ConfigReader.getProperty("expectedTitle");
        String actualTitle=Driver.getDriver().getTitle();
        softAssert.assertEquals(actualTitle,expectedTitle,"Title bilgileri farklı");

        extentTest.pass("Ana sayfadaki email butonu gözükene kadar sayfayı aşağıya kaydırır");
        actions.moveToElement(autoMationexercisePages.anaSayfaEmailButonu).perform();
        softAssert.assertTrue(autoMationexercisePages.anaSayfaEmailButonu.isDisplayed(),"Ana sayfa email butonu gözükmüyor");


        extentTest.pass("Ana sayfadaki email butona gecerli email girerek enter tuşuna basar");
        autoMationexercisePages.anaSayfaEmailButonu.sendKeys(ConfigReader.getProperty("gecerliKullaniciEmail")+ Keys.ENTER);

        extentTest.pass("You have been successfully subscribed!' yazısının çıktığını doğrular ekran görüntüsü alır ve sayfayı kapatır");
        softAssert.assertTrue(autoMationexercisePages.youHaveBeenYouSuccessfullyYaziElementi.isDisplayed(),
                                    "You have been successfully subscribed! yazısı gözükmüyor");
        extentTest.addScreenCaptureFromBase64String(ReusableMethods.ekranResmi(Driver.getDriver()));



        softAssert.assertAll();

    }
}
