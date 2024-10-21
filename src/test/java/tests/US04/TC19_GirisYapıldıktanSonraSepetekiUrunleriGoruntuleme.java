package tests.US04;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AutoMationexercisePages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExtentReport;
import utilities.ReusableMethods;

import java.time.Duration;

public class TC19_GirisYapıldıktanSonraSepetekiUrunleriGoruntuleme extends ExtentReport {
    @Test
    public void girisYapildiktanSonraSepeteUrunEklenmesi(){

        AutoMationexercisePages autoMationexercisePages=new AutoMationexercisePages();
        SoftAssert softAssert=new SoftAssert();
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));


        extentTest=extentReports.createTest("Sisteme giriş yapıp sepete ürün ekleme",
                "Kullanıcı sisteme giriş yapıp sepete ürün eklendiğini test eder");

        extentTest.pass("Kullanici autoMationexercise sitesine gider");
        Driver.getDriver().get(ConfigReader.getProperty("autom"));

        extentTest.pass("Products butonuna tıklar");
        autoMationexercisePages.anaSayfaProductButonu.click();

        extentTest.pass("'All Products' sayfasında olduğunu doğrular");
        String expectedProductTitle="Automation Exercise - All Products";
        String actualProductTitle=Driver.getDriver().getTitle();
        softAssert.assertEquals(actualProductTitle,expectedProductTitle,
                                "All product title bilgileri aynı değil");

        extentTest.pass("'All Products' yazısının gözültüğünü doğrular");
        softAssert.assertTrue(autoMationexercisePages.allProductsYaziElementi.isDisplayed(),
                                            "All product  yazı elementi gözükmüyor");

        extentTest.pass("Arama kutununa 'Polo' yazar aama butonuna tıklar");
        autoMationexercisePages.productsSayfayiAramaButonu.sendKeys("Polo");
        autoMationexercisePages.aramaKutusuAramaButonu.click();

        extentTest.pass("Arama sonucunda urun bulunabildiğini test eder");
        softAssert.assertTrue(autoMationexercisePages.bulunanUrunlerList.size()>0,"girilen sayi hatalı");

        extentTest.pass("Bulunan ilk ürünü sepete ekler");
        ReusableMethods.click(autoMationexercisePages.poloTshirtAddCartButonu);

        extentTest.pass("Cıkan uyarıda View Cart Butonuna tıklar");
        autoMationexercisePages.viewCartElementi.click();

        extentTest.pass("Sepete urun eklendiğini test eder");
        softAssert.assertTrue(autoMationexercisePages.sepettekiurunlerList.size()>0
                                             ,"Sepete urun eklenemedi");

        extentTest.pass("Login butonuna basar");
        autoMationexercisePages.signUpLoginButonu.click();


        extentTest.pass("'Login To Your Account' yazisinin görünür olduğunu test eder");
        softAssert.assertTrue(autoMationexercisePages.loginToYourAccountYazisi.isDisplayed());

        extentTest.pass("Geçerli kullanici adi, sifre girer ve login butonuna tıklar ve ekran görüntüsü alır");
        autoMationexercisePages.mevcutKullaniciEmailButonu.sendKeys(ConfigReader.getProperty("gecerliKullaniciEmail"));
        autoMationexercisePages.mevcutKullaniciPassButonu.sendKeys(ConfigReader.getProperty("gecerliSifre"));
        autoMationexercisePages.mevcutKullaniciLoginButonu.click();
        extentTest.addScreenCaptureFromBase64String(ReusableMethods.ekranResmi(Driver.getDriver()));

        extentTest.pass("Sepet butonuna tıklar ve sepette urun bulunduğunu test eder ve ekran görüntüsü alır");
        autoMationexercisePages.anaSayfaCartButonu.click();
        softAssert.assertTrue(autoMationexercisePages.sepettekiurunlerList.size()>0
                ,"Sepete urun bulunamadi");
        extentTest.addScreenCaptureFromBase64String(ReusableMethods.ekranResmi(Driver.getDriver()));


        extentTest.pass("Sepetteki ürünleri iptal eder");
        for (WebElement each:autoMationexercisePages.sepettekiUrunuIptalEtmeButonu)
        {
            if (each.isDisplayed())
            {
                each.click();
            }
        }
        extentTest.pass("Sepetin bos oldugunu test eder, ekran görüntüsü alır ve sayfayı kapatır");
        wait.until(ExpectedConditions.visibilityOf(autoMationexercisePages.sepeteBosYaziElementi));
        softAssert.assertTrue(autoMationexercisePages.sepeteBosYaziElementi.isDisplayed(),"Sepet bos değil");




        softAssert.assertAll();
    }
}
