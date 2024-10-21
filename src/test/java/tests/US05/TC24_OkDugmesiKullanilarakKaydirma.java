package tests.US05;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AutoMationexercisePages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExtentReport;
import utilities.ReusableMethods;

public class TC24_OkDugmesiKullanilarakKaydirma extends ExtentReport {
    @Test
    public void okDugmesiKullanilarakSayfayiKaydirma() {

        AutoMationexercisePages autoMationexercisePages = new AutoMationexercisePages();
        SoftAssert softAssert = new SoftAssert();
        Actions actions = new Actions(Driver.getDriver());


        extentTest = extentReports.createTest("Sağ alt taraftaki ok tuşunu kullanarak sayfayı kaydırma",
                "Kullanıcı ok tuşunu kullanarak sayfayının üst kısma kaydırılabildiğini test eder.");

        extentTest.pass("Kullanici autoMationexercise sitesine gider");
        Driver.getDriver().get(ConfigReader.getProperty("autom"));

        extentTest.pass("Kullanıcı doğru sayfaya gittiğini doğrular");
        String expectedTitle = ConfigReader.getProperty("expectedTitle");
        String actualTitle = Driver.getDriver().getTitle();
        softAssert.assertEquals(actualTitle, expectedTitle,
                            "Title bilgileri farklı");

        extentTest.pass("Ana sayfadaki email butonu gözükene kadar sayfayı aşağıya kaydırır ve ekran görüntüsü alır");
        actions.moveToElement(autoMationexercisePages.anaSayfaEmailButonu).perform();
        extentTest.addScreenCaptureFromBase64String(ReusableMethods.ekranResmi(Driver.getDriver()));



        //While döngüsü ile yapılması planlandı ancak sayfanın en altına bulunan email adres cubuğu,en alta inmeden de
        // sistem tarafından algılandıgı için, pageDown komutu otomatik olarak durduruluyor bu yüzden
        // sayfanın en alt kısmına inmek için moveToElement komutu kullanıldı.

        /*
        boolean anaSayfaEmailButonu = true;

                while (anaSayfaEmailButonu) {
                    actions.sendKeys(Keys.PAGE_DOWN).perform();

                    if (autoMationexercisePages.anaSayfaEmailButonu.isDisplayed()) {
                        anaSayfaEmailButonu = false;
                    }}
         */



        softAssert.assertTrue(autoMationexercisePages.anaSayfaEmailButonu.isDisplayed(),"Email butonu gözükmüyor");


        extentTest.pass("Sağ alt köşedeki yukarı kaydırma butonuna tıklar");
        actions.moveToElement(autoMationexercisePages.yukariKaydirmaButonu).perform();
        ReusableMethods.click(autoMationexercisePages.yukariKaydirmaButonu);
        ReusableMethods.bekle(1);

        extentTest.pass("'Full-Fledged practice website for Automation Engineers' yazısının görünür olduğunu doğrular, " +
                "                                                                   ekran görüntüsü alır ve sayfayı kapatır");
        softAssert.assertTrue(autoMationexercisePages.fullFledgedpracticeYaziElementi.isDisplayed(),
                                    "Full-Fledged practice yazısı gözükmüyor");
        extentTest.addScreenCaptureFromBase64String(ReusableMethods.ekranResmi(Driver.getDriver()));


        softAssert.assertAll();
    }

}
