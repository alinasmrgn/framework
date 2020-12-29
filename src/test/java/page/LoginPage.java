package page;

import model.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractPageWithStaticUrl{

    @FindBy(xpath = " //*[@id='js__auth_form'] //input[@name='LOGIN']")
    private WebElement inputLogin;

    @FindBy(xpath = "//*[@id='js__auth_form'] //input[@name='PASSWORD']")
    private WebElement inputPassword;

    @FindBy(xpath = " //*[@id='js__auth_form'] //button[text()='ВОЙТИ']")
    private WebElement buttonSubmit;

    @FindBy(xpath = "//a[@href='#login-modal']")
    private WebElement accountPageButton;

    public LoginPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver,this);
    }

    @Override
    public LoginPage openPage()
    {
        driver.navigate().to("https://aimclo.ru/personal/");
        return this;
    }

    public LoginPage inputUserLogin(String login){
        inputLogin.sendKeys(login);
        return this;
    }

    public LoginPage inputUserPassword(String password){
        inputPassword.sendKeys(password);
        return this;
    }

    public LoginPage clickSubmitButton(){
        buttonSubmit.click();
        return this;
    }

    public AccountPage clickGoToAccountPageButton(){
        accountPageButton.click();
        return new AccountPage(driver);
    }
}
