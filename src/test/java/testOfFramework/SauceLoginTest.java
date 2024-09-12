package testOfFramework;

import Utilities.fatExcelDataUtility.ExcelDataUtility;
import base.Base;
import Resources.fatGlobalResources.LoginPageResource;
import Resources.fatStaticResources.FAT_GLOBAL_STATIC;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class SauceLoginTest extends Base {

    LoginPageResource lp;
    String validUserName;
    String valdPassword;

    //LoginPageResource login = new LoginPageResource();

   @BeforeMethod(alwaysRun = true)
    public void setup() throws IOException, InterruptedException {
      // LoginPageResource login = new LoginPageResource();
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

   @Test
    public void getCredentialsFromExcel(){
       LoginPageResource login2 = new LoginPageResource();
       ExcelDataUtility testData = new ExcelDataUtility("src/main/java/testData/SauceTestData.xlsx");
      validUserName= testData.getCellData("SauceCredentials",2,1);
      valdPassword=testData.getCellData("SauceCredentials",2,2);
      login2.userNameAndPassword(validUserName,valdPassword);







   }


}
