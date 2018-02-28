package erail1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ticketavailability 
{
	WebDriver driver;
	String count;
	String s3;
	
  @BeforeTest
  public void availability()
  {
	  driver =new FirefoxDriver();
	  String URL = "https://erail.in/";
	  driver.get(URL);
	  String j = driver.getTitle();
	  System.out.println("Page Title is = " +j);
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	 // .//*[@id='divCalender']//table//tbody//tr[1]//table//child::tr//td[contains(@onclick, 'DoDateSelect')][5]
  }
  
  @Test
  public void availability1() throws InterruptedException
  {
	  //From Station
	  driver.findElement(By.xpath(".//*[@id='txtStationFrom']")).clear();
	  WebElement ele = driver.findElement(By.xpath(".//*[@id='txtStationFrom']"));
	  Actions a=new Actions(driver);
	   a.moveToElement(ele)
	   .sendKeys("vskp")
	  .sendKeys(Keys.ENTER)
	  .build().perform();
	 
	   //To Station
	   driver.findElement(By.xpath(".//*[@id='txtStationTo']")).clear();
		  WebElement ele1 = driver.findElement(By.xpath(".//*[@id='txtStationTo']"));
		  Thread.sleep(2000);
		  Actions a1=new Actions(driver);
		   a.moveToElement(ele1)
		   .sendKeys("bza")
		  .sendKeys(Keys.ENTER)
		  .build().perform();
			
		//Date selection  
		driver.findElement(By.xpath(".//*[@id='tdDateFromTo']/input[2]")).click();
		Thread.sleep(3000);
		
		
		 List<WebElement> e2 = driver.findElements(By.xpath(".//*[@id='divCalender']//table//tbody//tr[1]//td//table//child::tr//td[contains(@style, ';color:red;')][1]"));
		
		 List<String> allelements = new ArrayList<>();

		    for(int i=0; i<e2.size(); i++)
		    {

		        //loading text of each element in to array all_elements_text
		    allelements.add(e2.get(i).getText());
		     s3 = e2.get(i).getText();
		        //to print directly
		        System.out.println(s3);
		    }	
		 
		    Scanner in = new Scanner(System.in);
			   int b;
			   b=in.nextInt();
			   System.out.println("Enter date "+b);	   
			   Thread.sleep(1000);
			   
			   while(.equals())
			   {
				  driver.findElement(By.xpath(".//*[@id='divCalender']/center/table/tbody/tr[1]/td[5]/table/tbody/tr[9]/td[7]")).click();
			   }
		 
		 /*Iterator<WebElement> itr = e2.iterator();
			while(itr.hasNext()) 
			{
			    count = itr.next().getText();
			   System.out.println(count);
			} 
			
			//String ss = e2.getText();
			 //System.out.println(ss);
			Thread.sleep(1000);*/
		
		
		   
		
		//String reservation;
		//reservation = JOptionPane.showInputDialog("Enter only sunday");
		//JOptionPane.showMessageDialog( null, reservation  ); 
		/*JOptionPane optionPane = new JOptionPane("Please select only Sunday day from Jan to May",JOptionPane.WARNING_MESSAGE);
		JDialog dialog = optionPane.createDialog("Warning!");
		dialog.setAlwaysOnTop(true); // to show top of all other application
		dialog.setVisible(true); // to visible the dialog*/
 
  }
  
  @AfterTest
  public void availability2()
  {
	 // driver.quit();
  }
  
}
