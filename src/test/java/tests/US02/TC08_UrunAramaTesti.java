package tests.US02;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AutoMationexercisePages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExtentReport;
import utilities.ReusableMethods;

public class TC08_UrunAramaTesti extends ExtentReport {
    @Test
    public void urunAramaTesti(){


        AutoMationexercisePages autoMationexercisePages=new AutoMationexercisePages();
        SoftAssert softAssert=new SoftAssert();

        extentTest=extentReports.createTest("Urun arama testi",
                "Kullanıcı istenilen ürünü aratabilmeli ve arama sonucunda ürün bulabilmeli");

        extentTest.pass("Kullanici autoMationexercise sitesine gider");
        Driver.getDriver().get(ConfigReader.getProperty("autom"));

        extentTest.pass("Kullanıcı doğru sayfaya gittiğini doğrular");
        String expectedTitle=ConfigReader.getProperty("expectedTitle");
        String actualTitle=Driver.getDriver().getTitle();
        softAssert.assertEquals(actualTitle,expectedTitle,"Title bilgileri farklı");
        extentTest.pass("Products butonuna tıklar");
        autoMationexercisePages.anaSayfaProductButonu.click();

        extentTest.pass("'All Products' sayfasında olduğunu doğrular");
        String expectedProductTitle="Automation Exercise - All Products";
        String actualProductTitle=Driver.getDriver().getTitle();
        softAssert.assertEquals(actualProductTitle,expectedProductTitle,"All products sayfasına gidilemedi");

        extentTest.pass("Arama kutununa istenilen urunu yazar ve arama butonuna tıklar");
        autoMationexercisePages.productsSayfayiAramaButonu.sendKeys(ConfigReader.getProperty("istenilenUrun"));
        autoMationexercisePages.aramaKutusuAramaButonu.click();

        extentTest.pass("Arama sonucunda urun bulunabildiğini test eder ekran görüntüsü alır ve sayfayı kapatır");
        softAssert.assertTrue(autoMationexercisePages.bulunanUrunlerList.size()>0,"girilen sayi hatalı");
        extentTest.addScreenCaptureFromBase64String(ReusableMethods.ekranResmi(Driver.getDriver()));

        softAssert.assertAll();

    }
}
