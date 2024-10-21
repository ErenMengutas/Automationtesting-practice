package tests.US03;

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

public class TC16_SepeteEklenenUrunleriSepettenSilme extends ExtentReport {
    @Test
    public void SepeteEklenenUrunleriSepettenSilmeTesti(){

        AutoMationexercisePages autoMationexercisePages=new AutoMationexercisePages();
        SoftAssert softAssert=new SoftAssert();
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));

        extentTest=extentReports.createTest("Sepeeteki ürünleri silme",
                "Sepette eklemiş ürünleri sepetten silme testi");

        extentTest.pass("Kullanici autoMationexercise sitesine gider");
        Driver.getDriver().get(ConfigReader.getProperty("autom"));

        extentTest.pass("Kullanıcı doğru sayfaya gittiğini doğrular");
        String expectedTitle=ConfigReader.getProperty("expectedTitle");
        String actualTitle=Driver.getDriver().getTitle();
        softAssert.assertEquals(actualTitle,expectedTitle,"Title bilgileri farklı");

        extentTest.pass("Ilk urunun üzerinde ki 'Add Cart' butonunna tıklar");
        ReusableMethods.click(autoMationexercisePages.ilkUrunUzerindekiAddCartButonu);

        extentTest.pass("Cıkan uyarıda View Cart Butonuna tıklar");
        autoMationexercisePages.viewCartElementi.click();

        extentTest.pass("Sepete urun eklendiğini test eder ve ekran görüntüsü alır");
        softAssert.assertTrue(autoMationexercisePages.sepettekiIlkurun.isDisplayed(),"Sepete urun eklenemedi");
        extentTest.addScreenCaptureFromBase64String(ReusableMethods.ekranResmi(Driver.getDriver()));


        extentTest.pass("Sepete eklenmis olan urunleri iptal eder");



        for (WebElement each:autoMationexercisePages.sepettekiUrunuIptalEtmeButonu)
        {
            if (each.isDisplayed())
            {
                each.click();
            }
        }

        extentTest.pass("Sepetin bos oldugunu test eder ekran görüntüsü alır ve Sayfayı kapatır");
        wait.until(ExpectedConditions.visibilityOf(autoMationexercisePages.sepeteBosYaziElementi));
        softAssert.assertTrue(autoMationexercisePages.sepeteBosYaziElementi.isDisplayed(),"Sepet bos değil");
        extentTest.addScreenCaptureFromBase64String(ReusableMethods.ekranResmi(Driver.getDriver()));



        softAssert.assertAll();
    }
}
