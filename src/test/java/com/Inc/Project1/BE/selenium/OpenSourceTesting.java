package com.Inc.Project1.BE.selenium;

import java.time.Duration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@TestMethodOrder(OrderAnnotation.class)
@Sql(scripts = { "classpath:shop-schema.sql",
		"classpath:shop-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
public class OpenSourceTesting {

	private RemoteWebDriver driver;

	@LocalServerPort
	private int port;

	@BeforeEach
	void init() {
		this.driver = new ChromeDriver();
		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		new WebDriverWait(driver, Duration.ofSeconds(3));
	}

	@Test
	@Order(1)
	void testLogin() {
		this.driver.get("http://localhost:" + this.port);

		WebElement usernameField = this.driver
				.findElement(By.cssSelector("#root > header > div > form > input[type=text]:nth-child(1)"));
		usernameField.sendKeys("Andrew");

		WebElement passwordField = this.driver
				.findElement(By.cssSelector("#root > header > div > form > input[type=password]:nth-child(4)"));
		passwordField.sendKeys("TestPasSword12");

		WebElement signInButton = this.driver.findElement(By.cssSelector("#root > header > div > form > button"));
		signInButton.click();
	}

	@Test
	@Order(2)
	void testDarkMode() {
		this.driver.get("http://localhost:" + this.port);

		WebElement usernameField = this.driver
				.findElement(By.cssSelector("#root > header > div > form > input[type=text]:nth-child(1)"));
		usernameField.sendKeys("Andrew");

		WebElement passwordField = this.driver
				.findElement(By.cssSelector("#root > header > div > form > input[type=password]:nth-child(4)"));
		passwordField.sendKeys("TestPasSword12");

		WebElement signInButton = this.driver.findElement(By.cssSelector("#root > header > div > form > button"));
		signInButton.click();

		WebElement darkModeButton = this.driver.findElement(By.cssSelector("#navbarSupportedContent > button"));
		darkModeButton.click();

		WebElement welcomeText = this.driver.findElement(By.cssSelector("#root > header > div:nth-child(2) > h1"));

		// Get the color value of welcomeText
		String colorValue = welcomeText.getCssValue("color");

		// Assert that the color has changed to white
		Assertions.assertEquals("rgba(255, 255, 255, 1)", colorValue,
				"Color of welcome text should be white in dark mode.");

	}

	@Test
	@Order(3)
	void testLogOut() {
		this.driver.get("http://localhost:" + this.port);

		WebElement usernameField = this.driver
				.findElement(By.cssSelector("#root > header > div > form > input[type=text]:nth-child(1)"));
		usernameField.sendKeys("Andrew");

		WebElement passwordField = this.driver
				.findElement(By.cssSelector("#root > header > div > form > input[type=password]:nth-child(4)"));
		passwordField.sendKeys("TestPasSword12");

		WebElement signInButton = this.driver.findElement(By.cssSelector("#root > header > div > form > button"));
		signInButton.click();

		WebElement userDropdown = this.driver
				.findElement(By.cssSelector("#navbarSupportedContent > ul > li.nav-item.dropdown > a"));
		userDropdown.click();

		WebElement logoutButton = this.driver.findElement(
				By.cssSelector("#navbarSupportedContent > ul > li.nav-item.dropdown > div > a:nth-child(2)"));
		logoutButton.click();

		WebElement usernameField2 = this.driver
				.findElement(By.cssSelector("#root > header > div > form > input[type=text]:nth-child(1)"));
		Assertions.assertEquals("", usernameField2.getText());

	}

//	@Test
//	@Order(4)
//	void testCreateBasket() throws InterruptedException {
//		this.driver.get("http://localhost:" + this.port);
//
//		WebElement usernameField = this.driver
//				.findElement(By.cssSelector("#root > header > div > form > input[type=text]:nth-child(1)"));
//		usernameField.sendKeys("Andrew");
//
//		WebElement passwordField = this.driver
//				.findElement(By.cssSelector("#root > header > div > form > input[type=password]:nth-child(4)"));
//		passwordField.sendKeys("TestPasSword12");
//
//		WebElement signInButton = this.driver.findElement(By.cssSelector("#root > header > div > form > button"));
//		signInButton.click();
//
//		WebElement createItemPage = this.driver
//				.findElement(By.cssSelector("#navbarSupportedContent > ul > li:nth-child(2) > a"));
//		Thread.sleep(800);
//		createItemPage.click();
//
//	}

}
