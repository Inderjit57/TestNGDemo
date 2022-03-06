import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class testNGDemo {

	// What is the hierachy of test anotation

	// It runs the test case alphabetcally if no priority is given
	// dependsUponMethod - depends on the other method for excution

	@BeforeClass
	public void beforeExecutingClass() {
		System.out.println("Before class execution");
	}

	@BeforeMethod
	public void openBrowser() {
		System.out.println("Opening Browser");
	}

	@Test(priority = 1, dependsOnMethods = "printHelloLame")
	public void printHelloJames() {
		System.out.println("Hello world Jame");
	}

	@Test(priority = 2)
	public void printHelloSam() {
		System.out.println("Hello world Sam");
		//Assert.fail();	//to fail a method intentionally
	}

	@Test(priority = 3, dependsOnMethods = "printHelloSam")
	public void printHelloLame() {
		System.out.println("Hello world Lame");
	}

	@AfterMethod
	public void closeBrowser() {
		System.out.println("Close broswer");
	}

	@AfterClass
	public void afterExecutingClass() {
		System.out.println("after class execution");
	}
}
