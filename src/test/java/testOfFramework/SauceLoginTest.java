package testOfFramework;

import Utilities.fatExcelDataUtility.ExcelDataUtility;
import base.Base;
import Resources.GlobalResources.LoginPageResource;
import Resources.StaticResources.GLOBAL_STATIC;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class SauceLoginTest extends Base {

    LoginPageResource lp;
    String validUserName;
    String valdPassword;

    LoginPageResource login;

   @BeforeMethod(alwaysRun = true)
    public void setup() throws IOException, InterruptedException {
       login = launchBrowser();

       // FileInputStream file = new FileInputStream("src/main/java/Config/Config.properties");
       // FAT_GLOBAL_STATIC.prop= new Properties();
        //FAT_GLOBAL_STATIC.prop.load(file);

       //launchBrowser();

   }
   @Test(priority = 1)
    public void  getcredentialsFromPropertiesFile() throws InterruptedException, IOException {

      String user1= GLOBAL_STATIC.prop.getProperty("username");
      String pass1= GLOBAL_STATIC.prop.getProperty("password");

      login.userNameAndPassword(user1,pass1);
      
      // FAT_GLOBAL_STATIC.driver.manage().window().maximize();
       // FAT_GLOBAL_STATIC.driver.get(FAT_GLOBAL_STATIC.prop.getProperty("applicationURL"));
      // login.userNameAndPassword("performance_glitch_user","secret_sauce");
   }

   @Test(priority = 2)
    public void getCredentialsFromExcel(){
       ExcelDataUtility testData = new ExcelDataUtility("src/main/java/testData/SauceTestData.xlsx");
      validUserName= testData.getCellData("SauceCredentials",2,1);
      valdPassword=testData.getCellData("SauceCredentials",2,2);
      login.userNameAndPassword(validUserName,valdPassword);

   }

    @AfterMethod(alwaysRun = true)
    public void teardown(){
        GLOBAL_STATIC.driver.close();
    }

}



