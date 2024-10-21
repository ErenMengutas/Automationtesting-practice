package tests.US05;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AutoMationexercisePages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExtentReport;
import utilities.ReusableMethods;

public class TC20_UrunlereYorumEkleme extends ExtentReport {
    @Test
    public void urunlereYorumEklemeTesti(){
        AutoMationexercisePages autoMationexercisePages=new AutoMationexercisePages();
        SoftAssert softAssert=new SoftAssert();
        Faker faker=new Faker();


        extentTest=extentReports.createTest("Urunlere yorum ekleme",
                "Kullanıcı urunlere yorum eklenebildiğini test eder");

        extentTest.pass("Kullanici autoMationexercise sitesine gider");
        Driver.getDriver().get(ConfigReader.getProperty("autom"));

        extentTest.pass("Kullanıcı doğru sayfaya gittiğini doğrular");
        String expectedTitle=ConfigReader.getProperty("expectedTitle");
        String actualTitle=Driver.getDriver().getTitle();
        softAssert.assertEquals(actualTitle,expectedTitle,
                                        "Title bilgileri doğru değil");

        extentTest.pass("Products butonuna tıklar");
        autoMationexercisePages.anaSayfaProductButonu.click();

        extentTest.pass("'All Products' sayfasında olduğunu doğrular");
        String expectedProductTitle="Automation Exercise - All Products";
        String actualProductTitle=Driver.getDriver().getTitle();
        softAssert.assertEquals(actualProductTitle,expectedProductTitle,
                                    "All Products title bilgileri doğru değil");

        extentTest.pass("'All Products' yazısının gözültüğünü doğrular");
        softAssert.assertTrue(autoMationexercisePages.allProductsYaziElementi.isDisplayed(),
                                                "All products yazısı gözükmüyor");

        extentTest.pass("Ilk urunun üzerinde ki 'View Product' yazısına tıklar");
        ReusableMethods.click( autoMationexercisePages.ilkUrunViewProductButonu);

        extentTest.pass("Açılan sayfaya 'WRITE YOUR REVIEW' yazısının görünür olduğunu doğrular");
        softAssert.assertTrue(autoMationexercisePages.writeYourReviewYaziElementi.isDisplayed(),
                                                    "WRITE YOUR REVIEW yazısı gözükmüyor");

        extentTest.pass("Sayfa ki yorum bırak bölümüne isim,email ve yorum bırakarak 'Submit' butonuna tıklar");
        autoMationexercisePages.yorumBolumuIsimSekmesi.sendKeys(faker.name().fullName()+
                                                                            Keys.TAB+faker.internet().emailAddress()+
                                                                            Keys.TAB+faker.cat().name());
        ReusableMethods.click(autoMationexercisePages.yorumBolumuSubmitButonu);

        extentTest.pass("'Thank you for your review.' yazısının gözüktügünü doğrular, ekran görüntüsü alır ve sayfayı kapatır");
        softAssert.assertTrue(autoMationexercisePages.thankYouReviewYazıElementi.isDisplayed(),
                                        "Thank you for your review yazısı gözükmüyor");
        extentTest.addScreenCaptureFromBase64String(ReusableMethods.ekranResmi(Driver.getDriver()));


         softAssert.assertAll();
    }
}
