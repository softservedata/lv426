package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * The LogIn class implements a functionality which
 * login user into the "Opencart".
 *
 * @author  Beata Kovtan
 * @version 1.0
 * @since   2019-09-03
 */
public class LogIn {
    WebDriver chromeDriver;
    public LogIn(WebDriver driver){
        this.chromeDriver = driver;
    }

    /**
     * The setUserName() function sets user name into proper field
     * @param strUserName
     */
    public void setUserName(String strUserName){
        chromeDriver.findElement(By.id("input-email")).sendKeys(strUserName);
    }

    /**
     * The setPassword() function sets user's password into proper field
     * @param strPassword
     */
    public void setPassword(String strPassword){
        chromeDriver.findElement(By.id("input-password")).sendKeys(strPassword);
    }

    /**
     * Make click on the button to submit credentials and enter into account
     */
    public void clickLogin(){
        chromeDriver.findElement(By.cssSelector("input[type='submit']")).click();
    }

    /**
     * This loginToOpencart() method for gaining access by user into the "Opencart" account
     * @param strUserName
     * @param strPassword
     **/
    public void loginToOpencart(String strUserName,String strPassword){
       this.setUserName(strUserName);
       this.setPassword(strPassword);
    }




}
