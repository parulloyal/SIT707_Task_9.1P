package web.service;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import web.MyServer;

public class TestMathQuestionService {

	private static Thread applicationThread;
	private static WebDriver driver;

	private static void sleep(long sec) {
		try {
			Thread.sleep(sec * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@BeforeClass
	public static void setUp() {
		// Starting the application
		applicationThread = new Thread(() -> {
			MyServer.main(new String[] {});
		});
		applicationThread.start();

		System.setProperty("webdriver.chrome.driver", "/Users/panchamloyal/Documents/chromedriver");
		driver = new ChromeDriver();
	}

	@AfterClass
	public static void shutDown() {
		if (driver != null) {
			driver.quit();
		}

		// Stop your application after all tests have been executed
		if (applicationThread != null) {
			applicationThread.interrupt();
			try {
				applicationThread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Test
	public void testInputsAndResultQ1Validation() {

		// Navigate to q1 page
		driver.navigate().to("http://localhost:8080/q1");

		// Values in the text box
		WebElement firstNumInput = driver.findElement(By.id("number1"));
		WebElement secondNumInput = driver.findElement(By.id("number2"));
		WebElement resultInput = driver.findElement(By.id("result"));
		WebElement submitButton = driver.findElement(By.cssSelector("[type=submit]"));

		firstNumInput.sendKeys("20");
		secondNumInput.sendKeys("25");
		resultInput.sendKeys("45");
		// sleep(10);
		submitButton.click();

		Assert.assertEquals("http://localhost:8080/q2", driver.getCurrentUrl());
	}

	@Test
	public void testValidInputsAndResultValidationQ1() {

		// Navigate to q1 page
		driver.navigate().to("http://localhost:8080/q1");

		// Values in the text box
		WebElement firstNumInput = driver.findElement(By.id("number1"));
		WebElement secondNumInput = driver.findElement(By.id("number2"));
		WebElement resultInput = driver.findElement(By.id("result"));
		WebElement submitButton = driver.findElement(By.cssSelector("[type=submit]"));

		firstNumInput.sendKeys("20");
		secondNumInput.sendKeys("25");
		resultInput.sendKeys("45");
		// sleep(10);
		submitButton.click();

		Assert.assertEquals("http://localhost:8080/q2", driver.getCurrentUrl());
	}

	@Test
	public void testValidInputsAndResultValidationQ2() {

		// Navigate to q1 page
		driver.navigate().to("http://localhost:8080/q2");

		// Values in text boxes
		WebElement firstNumInput = driver.findElement(By.id("number1"));
		WebElement secondNumInput = driver.findElement(By.id("number2"));
		WebElement resultInput = driver.findElement(By.id("result"));
		WebElement submitButton = driver.findElement(By.cssSelector("[type=submit]"));

		firstNumInput.sendKeys("20");
		secondNumInput.sendKeys("25");
		resultInput.sendKeys("35");
		// sleep(10);
		submitButton.click();

		Assert.assertEquals("http://localhost:8080/q2", driver.getCurrentUrl());
	}

	@Test
	public void testValidInputsAndResultValidationQ3() {

		// Navigate to q1 page
		driver.navigate().to("http://localhost:8080/q3");

		// Values in text boxes

		WebElement firstNumInput = driver.findElement(By.id("number1"));
		WebElement secondNumInput = driver.findElement(By.id("number2"));
		WebElement resultInput = driver.findElement(By.id("result"));
		WebElement submitButton = driver.findElement(By.cssSelector("[type=submit]"));

		firstNumInput.sendKeys("2");
		secondNumInput.sendKeys("25");
		resultInput.sendKeys("50");
		// sleep(10);
		submitButton.click();

		Assert.assertEquals("http://localhost:8080/login", driver.getCurrentUrl());
		// Wait for the message
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement messageElement = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[contains(text(),  'STEM Game Completed! Thank you!')]")));
		// sleep(2);

		Assert.assertEquals("STEM Game Completed! Thank you!", messageElement.getText());

	}

	@Test
	public void testValidNumbersandInCorrectResultQ1() {

		// Navigate to q1 page
		driver.navigate().to("http://localhost:8080/q1");

		// Values in the text boxes
		WebElement firstNumInput = driver.findElement(By.id("number1"));
		WebElement secondNumInput = driver.findElement(By.id("number2"));
		WebElement resultInput = driver.findElement(By.id("result"));
		WebElement submitButton = driver.findElement(By.cssSelector("[type=submit]"));

		firstNumInput.sendKeys("20");
		secondNumInput.sendKeys("25");
		resultInput.sendKeys("55");
		// sleep(10);
		submitButton.click();

		// Error Message

		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement messageElement = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Incorrect answer, try again.')]")));
		// sleep(2);

		Assert.assertEquals("Incorrect answer, try again.", messageElement.getText());


	}

	@Test
	public void testInValidNumberAndInValidResultQ1() {

		// Navigate to q1 page
		driver.navigate().to("http://localhost:8080/q1");

		// Values in the text boxes
		WebElement firstNumInput = driver.findElement(By.id("number1"));
		WebElement secondNumInput = driver.findElement(By.id("number2"));
		WebElement resultInput = driver.findElement(By.id("result"));
		WebElement submitButton = driver.findElement(By.cssSelector("[type=submit]"));

		firstNumInput.sendKeys("two");
		secondNumInput.sendKeys("five");
		resultInput.sendKeys("eight");
		// sleep(10);
		submitButton.click();
		// Error Message
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement messageElement = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Incorrect Inputs, try again.')]")));
		// sleep(2);
		Assert.assertEquals("Incorrect Inputs, try again.", messageElement.getText());

		// sleep(2);
	}

	@Test
	public void testInCorrectNumberQ1() {

		// Navigate to q1 page
		driver.navigate().to("http://localhost:8080/q1");

		// Values in the text boxes
		WebElement firstNumInput = driver.findElement(By.id("number1"));
		WebElement secondNumInput = driver.findElement(By.id("number2"));
		WebElement resultInput = driver.findElement(By.id("result"));
		WebElement submitButton = driver.findElement(By.cssSelector("[type=submit]"));

		firstNumInput.sendKeys("thirty");
		secondNumInput.sendKeys("25");
		resultInput.sendKeys("35");
		// sleep(2);

		submitButton.click();
		// sleep(2);

		// Error Message
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement messageElement = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Incorrect Inputs, try again.')]")));
		// sleep(2);
		Assert.assertEquals("Incorrect Inputs, try again.", messageElement.getText());

		// sleep(2);
	}

	@Test
	public void testInCorrectNumber2Q1() {

		// Navigate to q1 page
		driver.navigate().to("http://localhost:8080/q1");

		// Values in the text box
		WebElement firstNumInput = driver.findElement(By.id("number1"));
		WebElement secondNumInput = driver.findElement(By.id("number2"));
		WebElement resultInput = driver.findElement(By.id("result"));
		WebElement submitButton = driver.findElement(By.cssSelector("[type=submit]"));

		firstNumInput.sendKeys("20");
		secondNumInput.sendKeys("three");
		resultInput.sendKeys("35");
		// sleep(2);

		submitButton.click();

		// Error Message
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement messageElement = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Incorrect Inputs, try again.')]")));
		// sleep(2);
		Assert.assertEquals("Incorrect Inputs, try again.", messageElement.getText());

		// sleep(2);
	}

	@Test
	public void testIncorrectResultQ1() {

		// Navigate to q1 page
		driver.navigate().to("http://localhost:8080/q1");

		// Values in the text box
		WebElement firstNumInput = driver.findElement(By.id("number1"));
		WebElement secondNumInput = driver.findElement(By.id("number2"));
		WebElement resultInput = driver.findElement(By.id("result"));
		WebElement submitButton = driver.findElement(By.cssSelector("[type=submit]"));

		firstNumInput.sendKeys("20");
		secondNumInput.sendKeys("25");
		resultInput.sendKeys("ten");
		// sleep(2);

		submitButton.click();

		// Error Message
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement messageElement = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Incorrect Inputs, try again.')]")));
		// sleep(2);

		Assert.assertEquals("Incorrect Inputs, try again.", messageElement.getText());

		// sleep(2);

	}

	@Test
	public void testInCorrectNumber12Q1() {

		// Navigate to q1 page
		driver.navigate().to("http://localhost:8080/q1");

		// Values in the text box
		WebElement firstNumInput = driver.findElement(By.id("number1"));
		WebElement secondNumInput = driver.findElement(By.id("number2"));
		WebElement resultInput = driver.findElement(By.id("result"));
		WebElement submitButton = driver.findElement(By.cssSelector("[type=submit]"));

		firstNumInput.sendKeys("one");
		secondNumInput.sendKeys("two");
		resultInput.sendKeys("35");
		// sleep(2);

		submitButton.click();

		// Error Message
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement messageElement = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Incorrect Inputs, try again.')]")));
		// sleep(2);

		Assert.assertEquals("Incorrect Inputs, try again.", messageElement.getText());

		// sleep(2);

	}

	@Test
	public void testInCorrectandIResultNumber1Q1() {

		// Navigate to q1 page
		driver.navigate().to("http://localhost:8080/q1");

		// Values in text boxes
		WebElement firstNumbInput = driver.findElement(By.id("number1"));
		WebElement secondNumInput = driver.findElement(By.id("number2"));
		WebElement resultInput = driver.findElement(By.id("result"));
		WebElement submitButton = driver.findElement(By.cssSelector("[type=submit]"));

		firstNumbInput.sendKeys("seven");
		secondNumInput.sendKeys("25");
		resultInput.sendKeys("five");
		// sleep(2);

		submitButton.click();

		// Error Message
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement messageElement = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Incorrect Inputs, try again.')]")));
		// sleep(2);

		Assert.assertEquals("Incorrect Inputs, try again.", messageElement.getText());

		// sleep(2);

	}

	@Test
	public void testInCorrectNumber2andResultQ1() {

		// Navigate to q1 page
		driver.navigate().to("http://localhost:8080/q1");

		// Values in text boxes
		WebElement firstNumInput = driver.findElement(By.id("number1"));
		WebElement secondNumInput = driver.findElement(By.id("number2"));
		WebElement resultInput = driver.findElement(By.id("result"));
		WebElement submitButton = driver.findElement(By.cssSelector("[type=submit]"));

		firstNumInput.sendKeys("60");
		secondNumInput.sendKeys("Seventy");
		resultInput.sendKeys("four");
		// sleep(2);

		submitButton.click();

		//// Error Message
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement messageElement = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Incorrect Inputs, try again.')]")));
		// sleep(2);
		Assert.assertEquals("Incorrect Inputs, try again.", messageElement.getText());

		// sleep(2);
	}

	@Test
	public void testValidNumbersandInValidResultQ2() {

		// Navigate to q1 page
		driver.navigate().to("http://localhost:8080/q2");

		// Values in the text box
		WebElement firstNumInput = driver.findElement(By.id("number1"));
		WebElement secondNumInput = driver.findElement(By.id("number2"));
		WebElement resultInput = driver.findElement(By.id("result"));
		WebElement submitButton = driver.findElement(By.cssSelector("[type=submit]"));

		firstNumInput.sendKeys("20");
		secondNumInput.sendKeys("25");
		resultInput.sendKeys("Seventy");
		sleep(2);

		submitButton.click();

		// Error Message
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement messageElement = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Incorrect Inputs, try again.')]")));
		sleep(5);

		Assert.assertEquals("Incorrect Inputs, try again.", messageElement.getText());

		sleep(5);

	}

	@Test
	public void testInValidNumber12andResultQ2() {
		// Navigate to q1 page
		driver.navigate().to("http://localhost:8080/q2");

		// Values in text boxes
		WebElement firstNumInput = driver.findElement(By.id("number1"));
		WebElement secondNumInput = driver.findElement(By.id("number2"));
		WebElement resultInput = driver.findElement(By.id("result"));
		WebElement submitButton = driver.findElement(By.cssSelector("[type=submit]"));

		firstNumInput.sendKeys("six");
		secondNumInput.sendKeys("eight");
		resultInput.sendKeys("ten");
		// sleep(2);

		submitButton.click();

		// Error Message
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement messageElement = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Incorrect Inputs, try again.')]")));
		// sleep(2);
		Assert.assertEquals("Incorrect Inputs, try again.", messageElement.getText());

		// sleep(2);
	}

	@Test
	public void testInCorrectNumber1Q2() {

		// Navigate to q1 page
		driver.navigate().to("http://localhost:8080/q2");

		// Values in the text box
		WebElement firstNumInput = driver.findElement(By.id("number1"));
		WebElement secondNumInput = driver.findElement(By.id("number2"));
		WebElement resultInput = driver.findElement(By.id("result"));
		WebElement submitButton = driver.findElement(By.cssSelector("[type=submit]"));

		firstNumInput.sendKeys("Eleven");
		secondNumInput.sendKeys("25");
		resultInput.sendKeys("35");
		// sleep(2);

		submitButton.click();

		// Error Message
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement messageElement = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Incorrect Inputs, try again.')]")));
		// sleep(2);

		Assert.assertEquals("Incorrect Inputs, try again.", messageElement.getText());
	}

	@Test
	public void testInCorrectNumber2Q2() {

		// Navigate to q1 page
		driver.navigate().to("http://localhost:8080/q2");

		// Values in the text box
		WebElement firstNumInput = driver.findElement(By.id("number1"));
		WebElement secondNumInput = driver.findElement(By.id("number2"));
		WebElement resultInput = driver.findElement(By.id("result"));
		WebElement submitButton = driver.findElement(By.cssSelector("[type=submit]"));

		firstNumInput.sendKeys("20");
		secondNumInput.sendKeys("three");
		resultInput.sendKeys("35");
		// sleep(2);

		submitButton.click();

		// Error Message
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement messageElement = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Incorrect Inputs, try again.')]")));
		// sleep(2);

		Assert.assertEquals("Incorrect Inputs, try again.", messageElement.getText());
	}

	@Test
	public void testInCorrectResultQ2() {

		// Navigate to q1 page
		driver.navigate().to("http://localhost:8080/q2");

		// Values in text boxes
		WebElement firstNumInput = driver.findElement(By.id("number1"));
		WebElement secondNumInput = driver.findElement(By.id("number2"));
		WebElement resultInput = driver.findElement(By.id("result"));
		WebElement submitButton = driver.findElement(By.cssSelector("[type=submit]"));

		firstNumInput.sendKeys("20");
		secondNumInput.sendKeys("25");
		resultInput.sendKeys("Seventy");
		// sleep(2);

		submitButton.click();

		// Error Message
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement messageElement = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Incorrect Inputs, try again.')]")));
		// sleep(2);

		Assert.assertEquals("Incorrect Inputs, try again.", messageElement.getText());

	}

	@Test
	public void testInCorrectNumber1And2Q2() {

		// Navigate to q1 page
		driver.navigate().to("http://localhost:8080/q2");

		// Values in the text box
		WebElement firstNumInput = driver.findElement(By.id("number1"));
		WebElement secondNumInput = driver.findElement(By.id("number2"));
		WebElement resultInput = driver.findElement(By.id("result"));
		WebElement submitButton = driver.findElement(By.cssSelector("[type=submit]"));

		firstNumInput.sendKeys("Three");
		secondNumInput.sendKeys("Five");
		resultInput.sendKeys("35");
		// sleep(2);

		submitButton.click();

		// Error Message
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement messageElement = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Incorrect Inputs, try again.')]")));
		// sleep(2);

		Assert.assertEquals("Incorrect Inputs, try again.", messageElement.getText());

		// sleep(2);

	}

	@Test
	public void testInCorrectNumberAndResulttForQ2() {
		// Navigate to q1 page
		driver.navigate().to("http://localhost:8080/q2");

		// Values in the text box
		WebElement firstNumInput = driver.findElement(By.id("number1"));
		WebElement secondNumInput = driver.findElement(By.id("number2"));
		WebElement resultInput = driver.findElement(By.id("result"));
		WebElement submitButton = driver.findElement(By.cssSelector("[type=submit]"));

		firstNumInput.sendKeys("Eight");
		secondNumInput.sendKeys("9");
		resultInput.sendKeys("7");
		// sleep(2);

		submitButton.click();

		// Error Message
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement messageElement = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Incorrect Inputs, try again.')]")));
		// sleep(2);

		Assert.assertEquals("Incorrect Inputs, try again.", messageElement.getText());

	}

	@Test
	public void testInCorrectNumber2AnddResultQ2() {

		// Navigate to q1 page
		driver.navigate().to("http://localhost:8080/q2");

		// Values in text boxes
		WebElement firstNumInput = driver.findElement(By.id("number1"));
		WebElement secondNumInput = driver.findElement(By.id("number2"));
		WebElement resultInput = driver.findElement(By.id("result"));
		WebElement submitButton = driver.findElement(By.cssSelector("[type=submit]"));

		firstNumInput.sendKeys("60");
		secondNumInput.sendKeys("Seventy");
		resultInput.sendKeys("One");
		// sleep(2);

		submitButton.click();

		// Error Message
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement messageElement = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Incorrect Inputs, try again.')]")));
		// sleep(2);
		Assert.assertEquals("Incorrect Inputs, try again.", messageElement.getText());
	}

	@Test
	public void testCorrectNumbersAndIncorrectResultQ3() {

		// Navigate to q1 page
		driver.navigate().to("http://localhost:8080/q3");

		// Values in text boxes
		WebElement firstNumInput = driver.findElement(By.id("number1"));
		WebElement secondNumInput = driver.findElement(By.id("number2"));
		WebElement resultInput = driver.findElement(By.id("result"));
		WebElement submitButton = driver.findElement(By.cssSelector("[type=submit]"));

		firstNumInput.sendKeys("20");
		secondNumInput.sendKeys("25");
		resultInput.sendKeys("90");
	sleep(5);

		submitButton.click();

		// Error Message
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement messageElement = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Incorrect answer, try again.')]")));
sleep(5);
		Assert.assertEquals("Incorrect answer, try again.", messageElement.getText());

	}

	@Test
	public void testInCorrectNumber1And2andResultQ3() {
		// Navigate to q1 page
		driver.navigate().to("http://localhost:8080/q3");

		// Values in text boxes
		WebElement firstNumInput = driver.findElement(By.id("number1"));
		WebElement secondNumInput = driver.findElement(By.id("number2"));
		WebElement resultInput = driver.findElement(By.id("result"));
		WebElement submitButton = driver.findElement(By.cssSelector("[type=submit]"));

		firstNumInput.sendKeys("four");
		secondNumInput.sendKeys("eight");
		resultInput.sendKeys("ninty");
		// sleep(2);

		submitButton.click();

		// Error Message
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement messageElement = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Incorrect Inputs, try again.')]")));
		// sleep(2);

		Assert.assertEquals("Incorrect Inputs, try again.", messageElement.getText());

	}

	@Test
	public void testInCorrectNumber1Q3() {

		// Navigate to q1 page
		driver.navigate().to("http://localhost:8080/q3");

		// Values in the text box
		WebElement firstNumInput = driver.findElement(By.id("number1"));
		WebElement secondNumInput = driver.findElement(By.id("number2"));
		WebElement resultInput = driver.findElement(By.id("result"));
		WebElement submitButton = driver.findElement(By.cssSelector("[type=submit]"));

		firstNumInput.sendKeys("Nine");
		secondNumInput.sendKeys("25");
		resultInput.sendKeys("35");
		// sleep(2);

		submitButton.click();

		// Error Message
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement messageElement = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Incorrect Inputs, try again.')]")));
		// sleep(2);
		Assert.assertEquals("Incorrect Inputs, try again.", messageElement.getText());
	}

	@Test
	public void testInCorrectNumber2Q3() {

		// Navigate to q1 page
		driver.navigate().to("http://localhost:8080/q3");

		// Values in text boxes
		WebElement firstNumInput = driver.findElement(By.id("number1"));
		WebElement secondNumInput = driver.findElement(By.id("number2"));
		WebElement resultInput = driver.findElement(By.id("result"));
		WebElement submitButton = driver.findElement(By.cssSelector("[type=submit]"));

		firstNumInput.sendKeys("20");
		secondNumInput.sendKeys("Eight");
		resultInput.sendKeys("35");
		// sleep(2);
		submitButton.click();

		// Error Message
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement messageElement = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Incorrect Inputs, try again.')]")));
		// sleep(2);
		Assert.assertEquals("Incorrect Inputs, try again.", messageElement.getText());
	}

	@Test
	public void testInCorrectResultQ3() {
		// Navigate to q1 page
		driver.navigate().to("http://localhost:8080/q3");

		// Values in the text box
		WebElement firstNumInput = driver.findElement(By.id("number1"));
		WebElement secondNumInput = driver.findElement(By.id("number2"));
		WebElement resultInput = driver.findElement(By.id("result"));
		WebElement submitButton = driver.findElement(By.cssSelector("[type=submit]"));

		firstNumInput.sendKeys("20");
		secondNumInput.sendKeys("25");
		resultInput.sendKeys("Thirty");
		// sleep(2);

		submitButton.click();

		// Error Message
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement messageElement = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Incorrect Inputs, try again.')]")));
		// sleep(2);

		Assert.assertEquals("Incorrect Inputs, try again.", messageElement.getText());
	}

	@Test
	public void testInCorrectNumber1And2Q3() {
		// Navigate to q1 page
		driver.navigate().to("http://localhost:8080/q3");

		// Values in the text box
		WebElement firstNumInput = driver.findElement(By.id("number1"));
		WebElement secondNumInput = driver.findElement(By.id("number2"));
		WebElement resultInput = driver.findElement(By.id("result"));
		WebElement submitButton = driver.findElement(By.cssSelector("[type=submit]"));

		firstNumInput.sendKeys("three");
		secondNumInput.sendKeys("five");
		resultInput.sendKeys("35");
		// sleep(2);

		submitButton.click();

		// Error Message
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement messageElement = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Incorrect Inputs, try again.')]")));
		// sleep(2);

		Assert.assertEquals("Incorrect Inputs, try again.", messageElement.getText());

	}

	@Test
	public void testInCorrectNumber1ANdInCorrectResultQ3() {
		// Navigate to q1 page
		driver.navigate().to("http://localhost:8080/q3");

		// Values in the text box
		WebElement firstNumInput = driver.findElement(By.id("number1"));
		WebElement secondNumInput = driver.findElement(By.id("number2"));
		WebElement resultInput = driver.findElement(By.id("result"));
		WebElement submitButton = driver.findElement(By.cssSelector("[type=submit]"));

		firstNumInput.sendKeys("Three");
		secondNumInput.sendKeys("6");
		resultInput.sendKeys("seven");
		// sleep(2);

		submitButton.click();

		// Error Message
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement messageElement = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Incorrect Inputs, try again.')]")));
		// sleep(2);

		Assert.assertEquals("Incorrect Inputs, try again.", messageElement.getText());

	}

	@Test
	public void testInValidNumber2andInvalidResulttForQ3() {

		// Navigate to q1 page
		driver.navigate().to("http://localhost:8080/q3");

		// Values in text boxes
		WebElement firstNumInput = driver.findElement(By.id("number1"));
		WebElement secondNumInput = driver.findElement(By.id("number2"));
		WebElement resultInput = driver.findElement(By.id("result"));
		WebElement submitButton = driver.findElement(By.cssSelector("[type=submit]"));

		firstNumInput.sendKeys("80");
		secondNumInput.sendKeys("Thirty");
		resultInput.sendKeys("two");
		sleep(5);

		submitButton.click();

		// Error Message
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement messageElement = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Incorrect Inputs, try again.')]")));
		sleep(5);

		Assert.assertEquals("Incorrect Inputs, try again.", messageElement.getText());

	}

}
