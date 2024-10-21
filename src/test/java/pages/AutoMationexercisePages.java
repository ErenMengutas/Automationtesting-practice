package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.nio.file.Watchable;
import java.util.List;
import java.util.logging.XMLFormatter;

public class AutoMationexercisePages {
    public AutoMationexercisePages(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[@href=\"/login\"]")
    public WebElement signUpLoginButonu;

    @FindBy(xpath = "//h2[text()='New User Signup!']")
    public WebElement yeniKullaniciSignupYazisi;

    @FindBy(xpath = "//input[@data-qa='signup-name']")
    public WebElement yeniKullaniciIsimKayitButonu;

    @FindBy(xpath = "//input[@data-qa='signup-email']")
    public WebElement yeniKullaniciEmailKayitButonu;

    @FindBy(xpath = "//button[@data-qa='signup-button']")
    public WebElement getYeniKullaniciSignupButonu;

    @FindBy(xpath = "//*[text()='Enter Account Information']")
    public WebElement enterAccountInformationYazisi;

    @FindBy(xpath = "//input[@id='name']")
    public WebElement formName;

    @FindBy(xpath = "//input[@name='newsletter']")
    public WebElement signUpforNewsletterbutonu;

    @FindBy(xpath = "(//input[@type='checkbox'])[2]")
    public WebElement receiveSpecialOfferButonu;

    @FindBy(xpath = "//*[@data-qa='account-created']")
    public WebElement accountCreatedYazisi;

    @FindBy(xpath = "//*[@data-qa='continue-button']")
    public WebElement continueYazisi;

    @FindBy(xpath = "//a[@data-qa=\"continue-button\"]")
    public WebElement odemeSonrasıContinueYazisi;

    @FindBy(xpath = "//*[@Class='fa fa-user']")
    public WebElement loggedInButonu;

    @FindBy(xpath = "//*[@href='/delete_account']")
    public WebElement deleteAccountButonu;

    @FindBy(xpath = "//*[@data-qa='account-deleted']")
    public WebElement accountDeleteYazisi;

    @FindBy(xpath = "//h2[text()='Login to your account']")
    public WebElement loginToYourAccountYazisi;

    @FindBy(xpath = "(//input[@type='email'])[1]")
    public WebElement mevcutKullaniciEmailButonu;

    @FindBy(xpath = "//input[@type='password']")
    public WebElement mevcutKullaniciPassButonu;

    @FindBy(xpath = "//*[@data-qa='login-button']")
    public WebElement mevcutKullaniciLoginButonu;

    @FindBy(xpath = "//*[text()='Your email or password is incorrect!']")
    public WebElement yanlişEmailPassYazisi;

    @FindBy(xpath = "//a[@href=\"/logout\"]")
    public WebElement logoutButonu;

    @FindBy(xpath = "//p[text()='Email Address already exist!']")
    public WebElement emailAddressalreadyexistUyariYazisi;

    @FindBy(xpath = "//a[@href=\"/contact_us\"]")
    public WebElement contactUsButonu;

    @FindBy(xpath = "//h2[text()='Get In Touch']")
    public WebElement getInTounchYaziElementi;

    @FindBy(xpath = "//input[@name='name']")
    public WebElement contactUsNameButonu;

    @FindBy(xpath = "(//input[@class='form-control'])[4]")
    public WebElement uploadFile;

    @FindBy(xpath = "//input[@data-qa='submit-button']")
    public WebElement musteriIletisimSubmitButonu;

    @FindBy(xpath = "//div[@class='status alert alert-success']")
    public WebElement succesYaziElementi;

    @FindBy(xpath = "(//*[text()=' Home'])[2]")
    public WebElement musteriFormundanSonraCıkanHomeButonu;

    @FindBy(xpath = "//a[@href=\"/test_cases\"]")
    public WebElement anaSayfaTestCasesButonu;

    @FindBy(xpath = "//a[@href=\"/products\"]")
    public WebElement anaSayfaProductButonu;

    @FindBy(xpath = "//h2[text()='All Products']")
    public WebElement allProductsYaziElementi;

    @FindBy(xpath = "//*[@href=\"/product_details/1\"]")
    public WebElement ilkUrunViewProductButonu;

    @FindBy(xpath = "//*[text()='Category: Women > Tops']")
    public WebElement ilkUrunCategoriButonu;

    @FindBy(xpath = "//*[text()='Rs. 500']")
    public WebElement ilkUrunFiyatButonu;

    @FindBy(xpath = "//*[text()='Quantity:']")
    public WebElement ilkUrunStokBilgisiButonu;

    @FindBy(xpath = "//*[text()='Blue Top']")
    public WebElement ilkUrunIsmiButonu;

    @FindBy(xpath = "//*[text()='Brand:']")
    public WebElement ilkUrunMarkaButonu;

    @FindBy(xpath = "//input[@id='search_product' ]")
    public WebElement productsSayfayiAramaButonu;

    @FindBy(xpath = "//button[@id='submit_search' ]")
    public WebElement aramaKutusuAramaButonu;

    @FindBy(xpath = "//div[@class='productinfo text-center']")
    public List<WebElement> bulunanUrunlerList;

    @FindBy(xpath = "//input[@id='susbscribe_email']")
    public WebElement anaSayfaEmailButonu;

    @FindBy(xpath = "//h2[text()='Subscription']")
    public WebElement anaSayfaSubscriptionYazisi;

    @FindBy(xpath = "//div[@class='alert-success alert']")
    public WebElement youHaveBeenYouSuccessfullyYaziElementi;

    @FindBy(xpath = "(//a[@href=\"/view_cart\"])[1]")
    public WebElement anaSayfaCartButonu;

    @FindBy(xpath = "(//*[@class='btn btn-default add-to-cart'])[1]")
    public WebElement ilkUrunUzerindekiAddCartButonu;

    @FindBy(xpath = "//*[@class='btn btn-success close-modal btn-block']")
    public WebElement continueShoppingYazisi;

    @FindBy(xpath = "(//*[@class='btn btn-default add-to-cart'])[3]")
    public WebElement ikinciUrunUzerindekiAddCartButonu;

    @FindBy(xpath = "(//*[@href=\"/view_cart\"])[2]")
    public WebElement viewCartElementi;

    @FindBy(xpath = "//a[@href=\"/product_details/1\"]")
    public WebElement sepettekiIlkurun;

    @FindBy(xpath = "//a[@href=\"/product_details/2\"]")
    public WebElement sepettekiIkinciurun;

    @FindBy(xpath = "//div[@class='product-image-wrapper']")
    public List<WebElement> anaSayfaUrunElementleriList;

    @FindBy(xpath = "//input[@name='quantity']")
    public WebElement urunMiktarYazısı;

    @FindBy(xpath = "//button[@class='btn btn-default cart']")
    public WebElement urunSayfasindakiSepeteEkleButonu;

    @FindBy(xpath = "//button[@class='disabled']")
    public WebElement sepettekiUrunMiktarYazisi;

    @FindBy(xpath = "//*[@class='btn btn-default check_out']")
    public WebElement sepettekiOdemeButonu;

    @FindBy(xpath = "(//*[@href=\"/login\"])[2]")
    public WebElement sepettekiRegisterLoginButonu;

    @FindBy(xpath = "(//h3[@class='page-subheading'])[1]")
    public WebElement delievryAdressYazisi;

    @FindBy(xpath = "(//h3[@class='page-subheading'])[2]")
    public WebElement billingAdressYazisi;

    @FindBy(xpath = "//*[@class='form-control']")
    public WebElement sepettekiAciklamalarBolumu;

    @FindBy(xpath = "//*[@class='btn btn-default check_out']")
    public WebElement placeOrderButonu;

    @FindBy(xpath = "//input[@class='form-control']")
    public WebElement krediKartiIsimBolumu;

    @FindBy(xpath = "(//div[@class='alert-success alert'])[1]")
    public WebElement yourOrderHasBeenYaziElementi;

    @FindBy(xpath = "(//div[@class='alert-success alert'])[2]")
    public WebElement odemeSonrasiOrderYazisi;


    @FindBy(xpath = "//*[@class='fa fa-times']")
    public List<WebElement> sepettekiUrunuIptalEtmeButonu;

    @FindBy(xpath = "(//p[@class='text-center'])[3]")
    public WebElement sepeteBosYaziElementi;

    @FindBy(xpath = "//h2[text()='Category']")
    public WebElement anaSayfaKategoriYaziElementi;

    @FindBy(xpath = "(//a[@data-toggle='collapse'])[1]")
    public WebElement anaSayfaKategoriWomenYaziElementi;

    @FindBy(xpath = "(//a[@data-toggle='collapse'])[2]")
    public WebElement anaSayfaKategoriMenYaziElementi;

    @FindBy(xpath = "(//a[@data-toggle='collapse'])[3]")
    public WebElement anaSayfaKategoriKidsYaziElementi;

    @FindBy(xpath = "//*[@href=\"/category_products/1\"]")
    public WebElement anaSayfaWomenSekmesiDressButonu;

    @FindBy(xpath = " //h2[@class='title text-center']")
    public WebElement womenDressProductsYaziElementi;


    @FindBy(xpath = "//*[@href=\"/category_products/6\"]")
    public WebElement anaSayfaMenSekmesiJeansButonu;

    @FindBy(xpath = " //h2[@class='title text-center']")
    public WebElement menJeansProductsYaziElementi;

    @FindBy(xpath = "//h2[text()=\"Brands\"]")
    public WebElement brandsYaziElementi;

    @FindBy(xpath = "//*[text()=\"Order Placed!\"]")
    public WebElement orderPlacedYaziElementi;

    @FindBy(xpath = "//a[@href=\"/brand_products/Polo\"]")
    public WebElement brandsPoloSekmesi;

    @FindBy(xpath = "//a[@href=\"/brand_products/Biba\"]")
    public WebElement brandsBibaSekmesi;

    @FindBy(xpath = " //h2[@class='title text-center']")
    public WebElement brandsPoloProductsYaziElementi;

    @FindBy(xpath = " //h2[@class='title text-center']")
    public WebElement brandsBibaProductsYaziElementi;

    @FindBy(xpath = "//a[text()='Write Your Review']")
    public WebElement writeYourReviewYaziElementi;

    @FindBy(xpath = "//input[@id='name']")
    public WebElement yorumBolumuIsimSekmesi;

    @FindBy(xpath = "(//button[@type='submit'])[1]")
    public WebElement yorumBolumuSubmitButonu;

    @FindBy(xpath = "//span[text()='Thank you for your review.']")
    public WebElement thankYouReviewYazıElementi;


    @FindBy(xpath = "(//li[@class='address_firstname address_lastname'])[1]")
    public WebElement deliveryAdressIsımBolumu;

    @FindBy(xpath = "(//li[@class='address_address1 address_address2'])[1]")
    public WebElement deliveryAdressAddresBolumu;

    @FindBy(xpath = "address_city address_state_name address_postcode")
    public WebElement deliveryAdressPostaKoduBolumu;

    @FindBy(xpath = "(//li[@class='address_country_name'])[1]")
    public WebElement deliveryAdressCountryBolumu;

    @FindBy(xpath = "(//li[@class='address_phone'])[1]")
    public WebElement deliveryAdressTelefonBolumu;


    @FindBy(xpath = "//a[@class='btn btn-default check_out']")
    public WebElement faturaIndirmeButonu;

    @FindBy(xpath = "//*[@id='scrollUp']")
    public WebElement yukariKaydirmaButonu;

    @FindBy(xpath = "//h2[text()='Full-Fledged practice website for Automation Engineers']")
    public WebElement  fullFledgedpracticeYaziElementi;

    @FindBy(xpath = "//h2[@Class='title text-center']")
    public WebElement testCaseYaziElementi;

     @FindBy(xpath = "(//a[@data-product-id=\"30\"])[1]")
    public WebElement poloTshirtAddCartButonu;

     @FindBy(xpath = "//td[@class='cart_product']")
    public List<WebElement> sepettekiurunlerList;

     @FindBy(xpath = "//h2[text()='recommended items']")
    public WebElement onerilenEsyalarYaziElementi;

     @FindBy(xpath = "//*[text()='Your account has been permanently deleted!']")
    public WebElement accountDeteletedYazisi;

    @FindBy(xpath = " //button[@data-qa='create-account']")
    public WebElement createAccountButonu;

}
