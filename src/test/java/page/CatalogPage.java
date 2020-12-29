package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CatalogPage extends AbstractPageWithParameterizedUrl {

    @FindBy(xpath = "//li[text()='Фильтры ']//span[@class='show']")
    private WebElement moreColorButton;

    public CatalogPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @Override
    public CatalogPage openPage(String partUrl) {
        driver.get("https://aimclo.ru/shop/"+partUrl);
        return this;
    }

    public CatalogPage clickToChooseFilterColor(String color) {
        driver.findElement(By.xpath("//li[text()='Фильтры ']//span[@class='show']" +
                "label//p[contains(text(),'"+color+"')]")).click();

        return this;
    }

    public CatalogPage clickMoreFilterColor(){
        moreColorButton.click();
        return this;
    }

    public List<String> getAllProductColor() {
        List<String> list =new ArrayList<>();
        driver.findElements(By.xpath("//div[@class='catalogue-products']//div[@class='one-product mt-30']/a"))
                .stream().forEach(s->list.add(s.getAttribute("data-impression-data-variant")));
        return list;
    }

    public CatalogPage clickToChooseCategoryProduct(String category) {
        driver.findElement(By.xpath("//div[@class='navigation-catalogue is_stuck']" +
                "li//a[contains(text(),'"+category+"')]")).click();
        return this;
    }
    public List<String> getAllProductCategory() {
        List<String> list =new ArrayList<>();
        driver.findElements(By.xpath("//div[@class='catalogue-products']//div[@class='one-product mt-30']/a"))
                .stream().forEach(s->list.add(s.getAttribute("data-impression-data-category")));
        return list;
    }

}
