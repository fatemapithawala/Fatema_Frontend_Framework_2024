package Resources.fatGlobalResources;

import Resources.fatStaticResources.FAT_GLOBAL_STATIC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageResource {

    public LoginPageResource(){

        PageFactory.initElements(FAT_GLOBAL_STATIC.driver,this);

    }

    @FindBy(xpath = "//input[@placeholder='Username']")
            WebElement  xpathOfUserNameTextBox1;


    @FindBy(xpath = "//input[@placeholder='Password']")
           WebElement xpathOfPasswordTextBox2;

  //  String  xpathOfUserNameTextBox="//input[@placeholder='Username']";
   // String  xpathOfPasswordTextBox="//input[@placeholder='Password']";

    public void userNameAndPassword( String username1, String password2){
       // d.findElement(By.xpath(xpathOfUserNameTextBox)).sendKeys(user);
      //  d.findElement(By.xpath(xpathOfPasswordTextBox)).sendKeys(password);

        xpathOfUserNameTextBox1.sendKeys(username1);
        xpathOfPasswordTextBox2.sendKeys(password2);

    }









}
