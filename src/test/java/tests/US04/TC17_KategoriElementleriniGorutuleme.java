package tests.US04;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AutoMationexercisePages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExtentReport;
import utilities.ReusableMethods;

import java.time.Duration;

public class TC17_KategoriElementleriniGorutuleme extends ExtentReport {
    @Test
    public void kategoriElementleriniGorutuleme(){
        AutoMationexercisePages autoMationexercisePages=new AutoMationexercisePages();
        SoftAssert softAssert=new SoftAssert();
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));

        extentTest=extentReports.createTest("Kategori elemanları",
                "Kullanici kategori elemanlarının gözüktüğünü test eder");

        extentTest.pass("Kullanici autoMationexercise sitesine gider");
        Driver.getDriver().get(ConfigReader.getProperty("autom"));


        extentTest.pass("Kategori yazısının görünür olduğunu doğrular ve ekran görüntüsü alır");
        softAssert.assertTrue(autoMationexercisePages.anaSayfaKategoriYaziElementi.isDisplayed(),
                                                "Kategori yazısı gözükmüyor");
        extentTest.addScreenCaptureFromBase64String(ReusableMethods.ekranResmi(Driver.getDriver()));

        extentTest.pass("'Women' sekmesine tıklar");
        autoMationexercisePages.anaSayfaKategoriWomenYaziElementi.click();

        extentTest.pass("'Women' sekmesinin altindaki 'dress' sekmesine tıklar ");
        autoMationexercisePages.anaSayfaWomenSekmesiDressButonu.click();

        extentTest.pass("Açılan sayfada 'Women - Dress Products' yazısının gözüktüğünü doğrular ekran görüntüsü alır");
        autoMationexercisePages.womenDressProductsYaziElementi.isDisplayed();
        softAssert.assertTrue(autoMationexercisePages.womenDressProductsYaziElementi.isDisplayed(),
                                                            "Women - Dress Products yazısı gözükmüyor");
        extentTest.addScreenCaptureFromBase64String(ReusableMethods.ekranResmi(Driver.getDriver()));

        extentTest.pass("Kategori bölümünden 'Men' sekmesine tiklar");
        autoMationexercisePages.anaSayfaKategoriMenYaziElementi.click();

        extentTest.pass("'Men' sekmesinin altindaki 'Jeans' sekmesine tıklar ");
        autoMationexercisePages.anaSayfaMenSekmesiJeansButonu.click();

        extentTest.pass("Açılan sayfada 'Men - Jeans Products' yazısının gözüktüğünü doğrular, ekran görüntüsü ve sayfayı kapatır");
        softAssert.assertTrue(autoMationexercisePages.menJeansProductsYaziElementi.isDisplayed(),
                                                        "Men - Jeans Products yazısı gözükmüyor");
        extentTest.addScreenCaptureFromBase64String(ReusableMethods.ekranResmi(Driver.getDriver()));

        softAssert.assertAll();

    }
}
