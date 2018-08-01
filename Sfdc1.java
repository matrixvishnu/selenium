import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;
//import org.testng.Assert;
//import org.testng.annotations.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.JavascriptExecutor;
import java.util.Set;


public class Sfdc1 {
    public static WebDriver driver = new FirefoxDriver();
    public static JavascriptExecutor js = (JavascriptExecutor) driver;  
//   public static  ChromeOptions options = new ChromeOptions();
//            options.addArguments("--disable-notifications");
//    // declaration and instantiation of objects/variables
//    System.setProperty("webdriver.chrome.driver", "/home/vishnu/chromedriver");
//    public static WebDriver driver = new ChromeDriver(options);
    public static void main(String[] args) {

        login();
	account();
//        doctor();
//        hierarchy();
//        patienthistory();
    }
    public static void login() {
        driver.manage().window().maximize();
        driver.get("https://healthcareapp-dev-ed.my.salesforce.com/home/home.jsp?tsid=02u7F00000069Of");
//        driver.manage().window().maximize();
        driver.findElement(By.id("username")).sendKeys("healthcare@vishnu.com");
        driver.findElement(By.id("password")).sendKeys("matrix24");
        driver.findElement(By.id("Login")).click();
    }
    public static void doctor() {
        driver.get("https://healthcareapp-dev-ed.my.salesforce.com/a01/e?retURL=%2Fa01%2Fo");
//        driver.findElement(By.id("Name")).sendKeys("VISHNU");
	js.executeScript("document.getElementById('Name').value='vv';");

        driver.findElement(By.id("00N7F000003zSzx")).sendKeys("BAGUMPET");
        Select dropdown = new Select(driver.findElement(By.id("00N7F000003zT01")));
        dropdown.selectByValue("Dentist - General");
    }
    public static void hierarchy() {
        driver.get("https://healthcareapp-dev-ed.my.salesforce.com/a06/o");
        driver.findElement(By.xpath("//*[@id=\"hotlist\"]/table/tbody/tr/td[2]/input")).click();
        driver.findElement(By.id("Name")).sendKeys("D1SD1M1");
        WebElement dd1 = driver.findElement(By.id("00N7F00000Qcr91"));
        Select s1 = new Select(dd1);
        s1.selectByValue("D1");
        java.util.List<WebElement> e1 = s1.getOptions();
        for (WebElement e : e1) {
            System.out.println(e.getText());
        }
        Select s2 = new Select(driver.findElement(By.id("00N7F00000QcrAY")));
        java.util.List<WebElement> e2 = s2.getOptions();
        for (WebElement e : e2) {
            System.out.println(e.getText());
        }
    }
    public static void patienthistory(){
//	WebElement element = driver.findElement(By.cssSelector(".wt-PatientHistory"));
//			element.click();
//        driver.findElement(By.id("01r7F0000006hRS_Tab")).click();
        driver.get("https://healthcareapp-dev-ed.my.salesforce.com/a03/o");
	driver.findElement(By.name("new")).click();
        driver.findElement(By.id("CF00N7F000003zSyH_lkwgt")).click();
        String Parent_window = driver.getWindowHandle();
        System.out.println(Parent_window);
	System.out.println(driver.getTitle());
        Set<String> l1  = driver.getWindowHandles();
        String cw = "";
        for(String i : l1){
            if(i.equals(Parent_window)) {
                continue;

            }
            System.out.println(i);
            cw = i;
            }
        System.out.println(cw);
        driver.switchTo().window(cw);
        System.out.println(driver.getWindowHandle());
	driver.manage().window().maximize();
//	String title = driver.getTitle();
	System.out.println(driver.getTitle());
	js.executeScript("document.getElementById('lksrch').value='vv';");
//	driver.findElement(By.id("Account_Tab")).click();
//      driver.close();
        }
	public static void account(){
		String cssLocatorOfTheElement="#tsid-menuItems > a:nth-child(3)";
		StringBuilder stringBuilder = new StringBuilder();
	        stringBuilder.append("var x = (\'"+cssLocatorOfTheElement+"\');");
	        stringBuilder.append("x.click();");
	        js.executeScript(stringBuilder.toString());

//		driver.findElement(By.id("tsid")).click();
	//	driver.findElement(By.id("Account_Tab")).click();
    }
    }
