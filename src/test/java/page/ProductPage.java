package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends AbstractPageWithParameterizedUrl {

    @FindBy(xpath = "//div[@class='_buttons colors owl-carousel product-information__colors-slider']")
    private WebElement similarProductList;

    @FindBy(xpath = "//div[@class='product-information__code']")
    private WebElement articleSpan;

    @FindBy(xpath = "//div[@class='product-information__title']")
    private WebElement colorSpan;

    @FindBy(xpath = "//a[@href='/basket/']")
    private WebElement goToBagPageButton;

    @FindBy(xpath = "//div[@class='add-basket__footer']")
    private WebElement goToLookBagPageButton;

    @FindBy(xpath = "//*[@value='ДОБАВИТЬ В КОРЗИНУ']")
    private WebElement addProductToBagPageButton;

    public ProductPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @Override
    public ProductPage openPage(String urlPart) {
        driver.get("https://aimclo.ru/shop/"+urlPart);
        return this;
    }

    public ProductPage addProductToBag()
    {
        addProductToBagPageButton.click();
        return this;
    }

    public ProductPage goToBagPage()
    {
        goToBagPageButton.click();
        return this;
    }

    public BagPage goToLookBagPage(){
        goToLookBagPageButton.click();
        return new BagPage(driver);
    }

    public ProductPage chooseSimilarProduct(int order){
        similarProductList.findElements(By.xpath("container-check product-information__container-check")).get(order-1).click();
        return this;
    }

    public String getArticleProduct() {
        return articleSpan.getText();
    }

    public String getColorProduct() {
        return colorSpan.getText();
    }

    public boolean isBagProduct(){
        waitWebElementLocatedBy(By.xpath("//div[@class='header__cart-counter']"));
        return driver.findElements(By.xpath(" //div[@class='header__cart-counter']")).size()>0;
    }

}
