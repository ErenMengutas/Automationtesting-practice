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

public class TC22_OdemeSayfasındakiAdresAyrintilari extends ExtentReport {
    @Test
    public void odemeSayfasındakiAdreskontrolTesti(){
        AutoMationexercisePages autoMationexercisePages=new AutoMationexercisePages();
        SoftAssert softAssert=new SoftAssert();
        Faker faker=new Faker();


        extentTest=extentReports.createTest("Odeme sayfasındaki adres ayrintilari",
                "Kullanıcı Odeme sayfasındaki adres ayrintilarini doğrular");

        extentTest.pass("Kullanici autoMationexercise sitesine gider");
        Driver.getDriver().get(ConfigReader.getProperty("autom"));

        extentTest.pass("Kullanıcı doğru sayfaya gittiğini doğrular");
        String expectedTitle=ConfigReader.getProperty("expectedTitle");
        String actualTitle=Driver.getDriver().getTitle();
        softAssert.assertEquals(actualTitle,expectedTitle,
                    "Title bilgileri farklı");

        extentTest.pass("Sign up butonuna basar");
        autoMationexercisePages.signUpLoginButonu.click();


        extentTest.pass("Yeni kullanici Sign in butonunun görünür olduğunu test eder");
        softAssert.assertTrue(autoMationexercisePages.yeniKullaniciSignupYazisi.isDisplayed(),
                                            "Sign in butonun gözükmüyor");

        extentTest.pass("Kullanici adi ve email girerek sisteme kayıt olur");
        autoMationexercisePages.yeniKullaniciIsimKayitButonu.sendKeys(faker.name().firstName());
        autoMationexercisePages.yeniKullaniciEmailKayitButonu.sendKeys(faker.internet().emailAddress());
        autoMationexercisePages.getYeniKullaniciSignupButonu.click();

        extentTest.pass("Enter Account Infermation yazisinin görünür olduğunu test eder");
        softAssert.assertTrue(autoMationexercisePages.enterAccountInformationYazisi.isDisplayed(),
                                        "Enter Account Infermation yazisi gözükmüyor");

        extentTest.pass("Kayıt formuna gerekli bilgileri doldurarak kayıt olur");
        autoMationexercisePages.signUpforNewsletterbutonu.click();
        autoMationexercisePages.receiveSpecialOfferButonu.click();

        String fakeIsim=faker.name().firstName();
        String fakeSoyisim=faker.name().lastName();
        String fakeAdress=faker.address().firstName();
        //String fakeCountry=faker.address().country();
        //String fakeState=faker.address().state();
        String fakeCity=faker.address().city();
        String fakeZipCode=faker.address().zipCode();
        String fakePhone=faker.phoneNumber().phoneNumber();

        autoMationexercisePages.formName.sendKeys(
                fakeIsim+
                        Keys.TAB+ faker.internet().password()+
                        Keys.TAB+faker.number().numberBetween(1,31)+
                        Keys.TAB+faker.letterify("a")+
                        Keys.TAB+faker.number().numberBetween(1990,2000)+
                        Keys.TAB+Keys.TAB+Keys.TAB+fakeIsim+//isim2
                        Keys.TAB+fakeSoyisim+
                        Keys.TAB+fakeAdress+
                        Keys.TAB+fakeAdress+
                        Keys.TAB+fakeAdress+
                        Keys.TAB+faker.letterify("a")+
                        Keys.TAB+ faker.address().state()+
                        Keys.TAB+fakeCity+
                        Keys.TAB+fakeZipCode+
                        Keys.TAB+fakePhone

        );
        extentTest.addScreenCaptureFromBase64String(ReusableMethods.ekranResmi(Driver.getDriver()));
        ReusableMethods.click(autoMationexercisePages.createAccountButonu);

        extentTest.pass("Hesabınız olusuturuldu yazisinin görünür olduğunu doğrular");
        softAssert.assertTrue(autoMationexercisePages.accountCreatedYazisi.isDisplayed(),
                                            "Hesabınız olusuturuldu yazisi gözükmüyor");

        extentTest.pass("Devam butonuna tıklar");
        autoMationexercisePages.continueYazisi.click();


        extentTest.pass("Sisteme giriş yapıldığını test eder");
        softAssert.assertTrue(autoMationexercisePages.loggedInButonu.isDisplayed(),"Sisteme giriş yapılmadı");

        extentTest.pass("Products butonuna tıklar");
        autoMationexercisePages.anaSayfaProductButonu.click();

        extentTest.pass("Ilk urunun üzerinde ki 'Add Cart' butonunna tıklar");
        ReusableMethods.click(autoMationexercisePages.ilkUrunUzerindekiAddCartButonu);

        extentTest.pass("Cıkan uyarıda View Cart Butonuna tıklar");
        autoMationexercisePages.viewCartElementi.click();

        extentTest.pass("Sepete urun eklendiğini test eder");
        softAssert.assertTrue(autoMationexercisePages.sepettekiIlkurun.isDisplayed(),
                                                "Sepete urun eklenemedi");

        extentTest.pass("Odeme işlemleri için 'Proceed To Checkout' butonuna tıklar");
        autoMationexercisePages.sepettekiOdemeButonu.click();

        extentTest.pass("Adres bilgilerinin sisteme kayıt olurken ki adres bilgileriyle aynı oldugunu doğrular ve ekran görüntüsü alır");
        softAssert.assertEquals(autoMationexercisePages.deliveryAdressIsımBolumu.getText(),". "+fakeIsim+" "+fakeSoyisim
                                                                                        ,"isim bilgisi hatalı");

        softAssert.assertEquals(autoMationexercisePages.deliveryAdressAddresBolumu.getText(),fakeAdress,
                                                                            "adress hatalı");


        softAssert.assertEquals(autoMationexercisePages.deliveryAdressCountryBolumu.getText(),"Australia",
                                                                    "country hatalı");
        softAssert.assertEquals(autoMationexercisePages.deliveryAdressTelefonBolumu.getText(),fakePhone,
                                                                     "telefon hatalı");
        extentTest.addScreenCaptureFromBase64String(ReusableMethods.ekranResmi(Driver.getDriver()));


        extentTest.pass("Account delete butonuna basar");
        autoMationexercisePages.deleteAccountButonu.click();

        extentTest.pass("Account Deleted yazısının göründüğünü test eder,continue butonuna basar ve sayfayı kapatır");
        softAssert.assertTrue(autoMationexercisePages.accountDeleteYazisi.isDisplayed());


        softAssert.assertAll();
    }
}
