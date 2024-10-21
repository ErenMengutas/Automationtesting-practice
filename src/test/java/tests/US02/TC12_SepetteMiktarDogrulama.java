package tests.US02;

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

public class TC12_SepetteMiktarDogrulama extends ExtentReport{
     @Test
    public void sepetteMiktarDogrulamaTesti(){

         AutoMationexercisePages autoMationexercisePages=new AutoMationexercisePages();
         SoftAssert softAssert=new SoftAssert();
         Faker faker=new Faker();


         extentTest=extentReports.createTest("Sepete eklenen ürünleri doğrulama",
                 "Kullanıcı sepete eklediği ürünlerin miktarlarının doğru olduğunu test eder");

         extentTest.pass("Kullanici autoMationexercise sitesine gider");
         Driver.getDriver().get(ConfigReader.getProperty("autom"));

         extentTest.pass("Kullanıcı doğru sayfaya gittiğini doğrular");
         String expectedTitle=ConfigReader.getProperty("expectedTitle");
         String actualTitle=Driver.getDriver().getTitle();
         softAssert.assertEquals(actualTitle,expectedTitle,"Title bilgileri farklı");

         int randomNum=faker.number().numberBetween(1,25);
          for (int i = 0; i <1 ; i++)
          {
              WebElement secilenUrun=Driver.getDriver().findElement(By.xpath("//*[@href=\"/product_details/"+randomNum+"\"]"));
              ReusableMethods.click(secilenUrun);
          }

          extentTest.pass("Urun sayfasında olduğunu doğrular");
          String expectedUrunUrl="https://www.automationexercise.com/product_details/"+randomNum;
          String actualUrunUrl=Driver.getDriver().getCurrentUrl();

          softAssert.assertEquals(actualUrunUrl,expectedUrunUrl,"Url bilgileri farklı");


         extentTest.pass("Seçilen ürünün miktarını 4 olarak ayarlar");
         autoMationexercisePages.urunMiktarYazısı.clear();
         autoMationexercisePages.urunMiktarYazısı.sendKeys("4");

         extentTest.pass("Seçilen ürünü sepete ekler");
         autoMationexercisePages.urunSayfasindakiSepeteEkleButonu.click();


         extentTest.pass("Çıkan uyarıda sepeti görüntüleye tıklar");
         autoMationexercisePages.viewCartElementi.click();

         extentTest.pass("Sepetteki ürün miktarının seçilen urun miktarı ile aynı oldugunu doğrular" +
                 "                                       ekran görüntüsü alır ve sayfayı kapatır");
         String actualSepettekiMiktarYazisi=autoMationexercisePages.sepettekiUrunMiktarYazisi.getText();
         String expectedSepettekiMiktarYazisi="4";

         softAssert.assertEquals(actualSepettekiMiktarYazisi,expectedSepettekiMiktarYazisi,"Miktar aynı değil");
         extentTest.addScreenCaptureFromBase64String(ReusableMethods.ekranResmi(Driver.getDriver()));





         softAssert.assertAll();

     }
}
