package tests.US02;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AutoMationexercisePages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExtentReport;
import utilities.ReusableMethods;

public class TC11_SepeteUrunEkleme extends ExtentReport {
    @Test
    public void sepeteUrunEklemeTesti(){

        AutoMationexercisePages autoMationexercisePages=new AutoMationexercisePages();
        SoftAssert softAssert=new SoftAssert();
        extentTest=extentReports.createTest("Sepete ürün ekleme",
                "Kullanici sepete ürün eklenebilidiğini test eder");

        extentTest.pass("Kullanici autoMationexercise sitesine gider");
        Driver.getDriver().get(ConfigReader.getProperty("autom"));

        extentTest.pass("Kullanıcı doğru sayfaya gittiğini doğrular");
        String expectedTitle=ConfigReader.getProperty("expectedTitle");
        String actualTitle=Driver.getDriver().getTitle();
        softAssert.assertEquals(actualTitle,expectedTitle,"Title bilgileri farklı");

        extentTest.pass("Products butonuna tıklar");
        autoMationexercisePages.anaSayfaProductButonu.click();

        extentTest.pass("Ilk urunun üzerinde ki 'Add Cart' butonunna tıklar");
        ReusableMethods.click(autoMationexercisePages.ilkUrunUzerindekiAddCartButonu);


        extentTest.pass("'Continue Shopping' yazisina tıklar");
        ReusableMethods.bekle(1);
        ReusableMethods.click(autoMationexercisePages.continueShoppingYazisi);


        extentTest.pass("ikici urunun üzerinde ki 'Add Cart' butonunna tıklar");
        ReusableMethods.click(autoMationexercisePages.ikinciUrunUzerindekiAddCartButonu);

       extentTest.pass("Cıkan uyarıda View Cart Butonuna tıklar");
       autoMationexercisePages.viewCartElementi.click();

       extentTest.pass("Sepete urun eklendiğini test eder ekran görüntüsü alır  ve sayfayı kapatır");
       softAssert.assertTrue(autoMationexercisePages.sepettekiIlkurun.isDisplayed(),"Sepete eklenen ürünler gözükmüyor");
       softAssert.assertTrue(autoMationexercisePages.sepettekiIkinciurun.isDisplayed(),"Sepete eklenen ürünler gözükmüyor");
       extentTest.addScreenCaptureFromBase64String(ReusableMethods.ekranResmi(Driver.getDriver()));

       softAssert.assertAll();

    }
}
