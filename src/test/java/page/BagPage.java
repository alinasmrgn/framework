package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class BagPage extends AbstractPageWithStaticUrl {

    @FindBy(xpath = "//div[@class='close']")
    private WebElement deleteFromBagPageButton;

    @FindBy(xpath = "//div[@class='header__cart-counter']")
    private WebElement numberOfBagProduct;

    public BagPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @Override
    public BagPage openPage() {
        driver.get("https://aimclo.ru/basket/");
        return this;
    }

    public int getSizeBagProductPanel(){
        return driver.findElements(By.xpath("//div[@class='cart-tovar']")).size();
    }
    public int getNumberOfBagProduct(){
        return Integer.parseInt(numberOfBagProduct.getText());
    }

    public BagPage deleteFromBagPage() {
        deleteFromBagPageButton.click();
        return this;
    }

}
