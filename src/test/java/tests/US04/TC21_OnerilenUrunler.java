package tests.US04;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AutoMationexercisePages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExtentReport;
import utilities.ReusableMethods;

public class TC21_OnerilenUrunler extends ExtentReport{
    @Test
    public void OnerilenUrunleriSepeteEkleme() {

        AutoMationexercisePages autoMationexercisePages=new AutoMationexercisePages();
        SoftAssert softAssert=new SoftAssert();
        Faker faker=new Faker();

        extentTest=extentReports.createTest("Onerilen eşyalar",
                "Kullanıcı Onerilen eşyalar yazı elementinin gözüktüğünü doğrular ve bazı ürünleri sepete ekler");

        extentTest.pass("Kullanici autoMationexercise sitesine gider");
        Driver.getDriver().get(ConfigReader.getProperty("autom"));

        extentTest.pass("Kullanıcı doğru sayfaya gittiğini doğrular");
        String expectedTitle=ConfigReader.getProperty("expectedTitle");
        String actualTitle=Driver.getDriver().getTitle();
        softAssert.assertEquals(actualTitle,expectedTitle,"Title bilgileri farklı");

        extentTest.pass("Önerilen eşyalar yazı elemtinin gözüktüğünü doğrular");
        softAssert.assertTrue(autoMationexercisePages.onerilenEsyalarYaziElementi.isDisplayed());


        int randomNum=faker.number().numberBetween(1,6);
        extentTest.pass("Önerilen eşyalardan rastgele birini sepete ekler ve ekran görüntüsü alır");
        WebElement rastgeleSecilenUrun=Driver.getDriver().findElement(By.xpath("(//a[@data-product-id="+randomNum+"])[3]"));
        ReusableMethods.click(rastgeleSecilenUrun);
        extentTest.addScreenCaptureFromBase64String(ReusableMethods.ekranResmi(Driver.getDriver()));

        extentTest.pass("Cıkan uyarıda View Cart Butonuna tıklar");
        autoMationexercisePages.viewCartElementi.click();

        extentTest.pass("Sepete urun eklendiğini test eder, ekran görüntüsü alır ve sayfayı kapatır");
        softAssert.assertTrue(autoMationexercisePages.sepettekiurunlerList.size()>0
                ,"Sepete urun eklenemedi");
        extentTest.addScreenCaptureFromBase64String(ReusableMethods.ekranResmi(Driver.getDriver()));





        softAssert.assertAll();
    }
}
