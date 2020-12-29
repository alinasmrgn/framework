package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends AbstractPageWithStaticUrl{

    @FindBy(xpath = "//button [@aria-label='Открыть поиск'  and @class='search-btn header-hover__search-btn js__search-open']")
    private WebElement openSearchButton;

    @FindBy(xpath = "//div[@class='search-block header-hover__search-block']//input[@type='text']")
    private WebElement searchInput;

    @FindBy(xpath = "//div[@class='search-block header-hover__search-block']//button [@type='submit' and @aria-label='Найти']")
    private WebElement searchButton;

    public  MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public MainPage openPage() {
        driver.get("https://aimclo.ru");
        return this;
    }

    public MainPage openSearch()
    {
        openSearchButton.click();
        return this;
    }
    public MainPage searchForTerms(String term)
    {
        searchInput.sendKeys(term);
        return this;
    }

    public SearchResultsPage searchForTermsResults(){
        searchButton.click();
        return new SearchResultsPage(driver);
    }
}
