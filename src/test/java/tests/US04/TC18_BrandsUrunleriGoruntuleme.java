package tests.US04;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AutoMationexercisePages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExtentReport;
import utilities.ReusableMethods;

public class TC18_BrandsUrunleriGoruntuleme extends ExtentReport {
    @Test
    public void BrandsUrunleriGoruntulemeVeSepeteEkleme(){

        AutoMationexercisePages autoMationexercisePages=new AutoMationexercisePages();
        SoftAssert softAssert=new SoftAssert();


        extentTest=extentReports.createTest("Brand urunlerinin goruntuleme",
                "Kullanıcı Brands sekmesindeki ürünleri görüntülendiğini test eder");

        extentTest.pass("Kullanici autoMationexercise sitesine gider");
        Driver.getDriver().get(ConfigReader.getProperty("autom"));

        extentTest.pass("Products butonuna tıklar");
        autoMationexercisePages.anaSayfaProductButonu.click();


        extentTest.pass("Brands yazısının gözüktüğünü doğrular");
        //actions.sendKeys(Keys.PAGE_DOWN).perform();
        softAssert.assertTrue(autoMationexercisePages.brandsYaziElementi.isDisplayed(),
                                                    "Yazı elementi gözükmüyor");

        extentTest.pass("Polo' sekmesine tıklar");
        ReusableMethods.click(autoMationexercisePages.brandsPoloSekmesi);

        extentTest.pass("Polo' sekmesinde olduğunu doğrular tıklar");
        softAssert.assertTrue(autoMationexercisePages.brandsPoloProductsYaziElementi.isDisplayed(),
                                                            "Polo yazı elementi gözükmüyor");

        extentTest.pass("Biba' sekmesine tıklar");
        ReusableMethods.click(autoMationexercisePages.brandsBibaSekmesi);


        extentTest.pass("Biba' sekmesinede olduğunu doğrular tıklar ve sayfayı kapatır");
        softAssert.assertTrue(autoMationexercisePages.brandsBibaProductsYaziElementi.isDisplayed(),
                                                                        "Biba yazı elementi gözükmüyor");

        softAssert.assertAll();

    }

}
