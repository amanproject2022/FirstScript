package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginpage {
	WebDriver driver;
By txt_username_login=By.id("name");
By txt_password_login=By.id("password");
By btn_login=By.id("login");



public loginpage(WebDriver driver) {
	this.driver = driver;
	
}

public void loginwithvalidcredentials(String username, String password) {
	
	driver.findElement(txt_username_login).sendKeys(username);
	driver.findElement(txt_password_login).sendKeys(password);

}

public void clicklogin()
{
	driver.findElement(btn_login).click();
	
}
}
