package base;

import Resources.fatGlobalResources.LoginPageResource;
import Resources.fatStaticResources.FAT_GLOBAL_STATIC;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Base {

    public void launchBrowser() throws IOException {
        loadProperties();

      //will decide at runtime frm CMD mvn test command which browser to open.Whatever value provide at the time of runtime in
        //cmd it will open that browser to the key name "browserName"
        //here the data (browser) will travel frm intellije to CMD with the connection of getProperty and its key

        String br = System.getProperty("browserName");

        if (br==null){
            //will take the value frm the properties files to the key name "browser"
            //here data (browser) will travel from properties file so we have created object for the class properties
            br= FAT_GLOBAL_STATIC.prop.getProperty("browser");
            openSpecificBrowser(br);
        }

        else
            openSpecificBrowser(br);
        FAT_GLOBAL_STATIC.driver.manage().window().maximize();
        FAT_GLOBAL_STATIC.driver.get(FAT_GLOBAL_STATIC.prop.getProperty("applicationURL"));
       // FAT_GLOBAL_STATIC.driver.get(FAT_GLOBAL_STATIC.prop.getProperty("username"));
        //FAT_GLOBAL_STATIC.driver.get(FAT_GLOBAL_STATIC.prop.getProperty("password"));



    }


    public void loadProperties() throws IOException {
        FileInputStream file = new FileInputStream("src/main/java/fatConfig/fatConfig.properties");
        FAT_GLOBAL_STATIC.prop = new Properties();
        FAT_GLOBAL_STATIC.prop.load(file);
    }

    public void openSpecificBrowser(String browser) {
        if (browser.equals("Chrome") || browser.equals("chrome")) {
            FAT_GLOBAL_STATIC.driver = new ChromeDriver();
        }
        if (browser.equals("Edge") || browser.equals("edge")) {
            FAT_GLOBAL_STATIC.driver = new EdgeDriver();
        }
        if (browser.equals("FireFox") || browser.equals("Firefox")) {
            FAT_GLOBAL_STATIC.driver = new FirefoxDriver();
        }

    }
}



