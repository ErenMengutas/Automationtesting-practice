package tests.US02;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AutoMationexercisePages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExtentReport;
import utilities.ReusableMethods;

public class TC07_ProductsButonu extends ExtentReport {
    @Test
    public void productsButonuDoğrulama(){

        AutoMationexercisePages autoMationexercisePages=new AutoMationexercisePages();
        SoftAssert softAssert=new SoftAssert();



        extentTest=extentReports.createTest("All Product bölümü",
                "Kullanıcı 'All Product' bölümününün ve seçtiği bir ürünün,ürün ayrıntılarını görebilmeli ");

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
        softAssert.assertEquals(actualProductTitle,expectedProductTitle,"All product sayfasında değil");

        extentTest.pass("'All Products' yazısının gözültüğünü doğrular");
        softAssert.assertTrue(autoMationexercisePages.allProductsYaziElementi.isDisplayed(),"All products yazısı gözüknüyor");

        extentTest.pass("Ilk urunun üzerindeki 'View Product' yazısına tıklar");
        ReusableMethods.click(autoMationexercisePages.ilkUrunViewProductButonu);

        extentTest.pass("Açılan sayfada 'Urun ismi','Categori','Fiyat','Stok bilgisi','Marka' bilgilerinin gözüktüğünü doğrular," +
                "                                                                ekran görüntüsü alır ve sayfayı kapatır");
        softAssert.assertTrue(autoMationexercisePages.ilkUrunIsmiButonu.isDisplayed(),"isim butonu gözükmüyor");
        softAssert.assertTrue(autoMationexercisePages.ilkUrunCategoriButonu.isDisplayed(),"Categori bölümü gözükmüyor ");
        softAssert.assertTrue(autoMationexercisePages.ilkUrunFiyatButonu.isDisplayed(),"Fiyat butonu gözükmüyor");
        softAssert.assertTrue(autoMationexercisePages.ilkUrunStokBilgisiButonu.isDisplayed(),"Stok Bilgisi gözükmüyor");
        softAssert.assertTrue(autoMationexercisePages.ilkUrunMarkaButonu.isDisplayed(),"Marka butonu gözükmüyor ");
        extentTest.addScreenCaptureFromBase64String(ReusableMethods.ekranResmi(Driver.getDriver()));


        softAssert.assertAll();
    }
}
