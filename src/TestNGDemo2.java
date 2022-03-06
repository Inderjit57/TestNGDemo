import java.util.ArrayList;
import java.util.Scanner;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGDemo2 {
	
	int num1 = 14;
	int num2 = 70;
	static public int num3 = 14;

	@BeforeClass
	public void beforeClass() {
		System.out.println("Before Class execution");
	}

	@BeforeMethod
	public void printNames() {
		ArrayList<String> list = new ArrayList<String>();
		list.add("Toronto");
		list.add("Brampton");
		list.add("Mississuaga");
		list.add("Ottawa");
		list.add("Niagara");
		list.add("Vaughan");
		for (int i=0;i<list.size();i++) {
			System.out.println(list);
			break;
		}
	}

	@Test(priority = 1)
	public void addTwoNum() {
		System.out.println("sum of num1 and num2: " + (num1 + num2));
		Assert.fail();
	}

	@Test(priority = 2)
	public void printStatment() {
		System.out.println("print when addTwoNum executed");
	}
	@Test(priority = 3, dependsOnMethods = "addTwoNum")
	public void subTwoNum() {
		System.out.println("sum of num1 and num2: " + (num1 - num2));
	}

	@AfterMethod
	public static void printStaticInt() {
		System.out.println("Printing after method static num: " + num3);
	}

	@AfterClass
	public void afterClass() {
		System.out.println("GoodBye");

	}
}
