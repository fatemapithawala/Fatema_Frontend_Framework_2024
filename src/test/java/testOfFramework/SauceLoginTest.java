package testOfFramework;

import base.Base;
import fatResources.fatGlobalResources.LoginPageResource;
import fatResources.fatStaticResources.FAT_GLOBAL_STATIC;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class SauceLoginTest extends Base {

    LoginPageResource lp;

    //LoginPageResource login = new LoginPageResource();

   @BeforeMethod(alwaysRun = true)
    public void setup() throws IOException, InterruptedException {

     launchBrowser();

       // FileInputStream file = new FileInputStream("src/main/java/fatConfig/fatConfig.properties");
       // FAT_GLOBAL_STATIC.prop= new Properties();
        //FAT_GLOBAL_STATIC.prop.load(file);

       //launchBrowser();

   }
   @Test
    public void  credentials() throws InterruptedException, IOException {
      LoginPageResource login = new LoginPageResource();
      String user1= FAT_GLOBAL_STATIC.prop.getProperty("username");
      String pass1= FAT_GLOBAL_STATIC.prop.getProperty("password");

      login.userNameAndPassword(user1,pass1);


      // FAT_GLOBAL_STATIC.driver.manage().window().maximize();
       // FAT_GLOBAL_STATIC.driver.get(FAT_GLOBAL_STATIC.prop.getProperty("applicationURL"));
      // login.userNameAndPassword("performance_glitch_user","secret_sauce");



   }


}
