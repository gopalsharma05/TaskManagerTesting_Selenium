package TaskManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TaskMangerTesting {
	WebDriver driver;
	
	@Test
	public void registerNewUser() throws InterruptedException
	{
		System.out.println("start the application");
		System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\new softwares\\new software\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://localhost:8080/login");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Enter Username']")).sendKeys("james12");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Enter Firstname']")).sendKeys("james");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Enter Lastname']")).sendKeys("bond");
		driver.findElement(By.xpath("//input[@placeholder='Enter email']")).sendKeys("james@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("james");
		Select genderDrp= new Select(driver.findElement(By.xpath("//select[@name='gender']")));
		genderDrp.selectByIndex(0);
		
		
		driver.findElement(By.xpath("//button[normalize-space()='Submit']")).click();
		
		Thread.sleep(3000);
		
		
		
		
		
		
	}
	@Test(dependsOnMethods="registerNewUser")
	public void loginToApp() throws InterruptedException
	{
		 
		
		driver.manage().window().maximize();
		String actualTitle=driver.getTitle();
		Assert.assertEquals(actualTitle, "Login page");
		Thread.sleep(7000);
		
		driver.findElement(By.name("email")).sendKeys("gopal@gmail.com");
		driver.findElement(By.name("password")).sendKeys("gopal");
		driver.findElement(By.xpath("//button[normalize-space()='Submit']")).click();
		
		Thread.sleep(7000);
		
		
	}
	
	
	
	@Test(dependsOnMethods="loginToApp")
	public void deleteTask() throws InterruptedException
	{
		driver.findElement(By.xpath("//tbody/tr[2]/td[4]/form[2]/button[1]")).click();  // here tr[2] means that it will delete 
																						// 2 row task. so you can change the row number accordingly 
		Thread.sleep(3000);
		 
		
	}
	
	@Test(dependsOnMethods="deleteTask")
	public void addTask() throws InterruptedException
	{
		driver.findElement(By.xpath("//button[normalize-space()='Add new Task']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Enter Task Name']")).sendKeys("task3");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Enter Task Description']")).sendKeys("task3 description");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='example-date-input']")).sendKeys("26-03-2021");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space()='Add Task']")).click();
		Thread.sleep(2000);
		
		 	
		
	}
	
	
	
	@Test(dependsOnMethods="addTask",alwaysRun=true)
	public void signoff() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.close();
	}
	
	
	
	 

}
