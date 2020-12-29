package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPage extends AbstractPageWithStaticUrl {

    @FindBy(xpath = "//*[@class='one-product-info' ]/p")
    private WebElement SearchResult;

    public  SearchResultsPage (WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public SearchResultsPage openPage() {
        driver.get("https://aimclo.ru/shop/");
        return this;
    }


    public String getSearchResults() { return SearchResult.getText(); }
}
