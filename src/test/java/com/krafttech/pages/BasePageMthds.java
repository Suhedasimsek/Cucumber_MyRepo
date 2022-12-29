package com.krafttech.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.Random;

public class BasePageMthds {
    public WebDriver driver;
    public WebDriverWait wait;
    Actions action;
    public JavascriptExecutor jsdriver;

    public BasePageMthds(WebDriver driver) {
        this.driver = driver;
        //wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        action = new Actions(driver);

    }

    /**
     * @param key
     * @return
     */
    public WebElement findElement(By key) {
        WebElement element = presenceElement(key);
        scrollToElement(element);
        return element;
    }


    /**
     * @param key
     * @return
     */
    public List<WebElement> findElements(By key) {
        List<WebElement> elements = presenceElements(key);
        scrollToElement(elements.get(0));
        return elements;
    }

    /**
     * @param key
     */


    public void click(By key) {

        wait.until(ExpectedConditions.elementToBeClickable(key)).click();
    }

    /**
     * @param key
     * @param text
     */


    public void sendKey(By key, String text) {

        wait.until(ExpectedConditions.elementToBeClickable(key)).sendKeys(text);
    }


    /**
     * @param key
     * @return
     */
    public String getText(By key) {

        return findElement(key).getText();
    }

    /**
     * @param key
     * @param text
     * @return
     */
    public boolean checkElementText(By key, String text) {

        ,return wait.until(ExpectedConditions.textToBe(key, text));
    }

    /**
     * @param key
     */
    public void checkElementVisible(By key) {

        wait.until(ExpectedConditions.visibilityOf(findElement(key)));
    }

    /**
     * @param key
     */

    /**
     * @param seconds
     */

    public void waitBySeconds(int seconds) {

        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param key
     */

    public void selectRandomProduct(By key) {
        List<WebElement> products = findElements(key);
        Random random = new Random();
        int number = 0;
        number = random.nextInt(products.size());
        try {
            products.get(number).click();
        } catch (Exception e) {
            jsdriver.executeScript("arguments[0].click();", products.get(number));
        }
    }

    /**
     * @param key
     * @param element
     */

    public void selectElementFromDropdown(By key, String element) {
        WebElement product = findElement(key);
        Select slc = new Select(product);
        slc.selectByVisibleText(element);
    }

    public void checkElementPresence(By key) {

        wait.until(ExpectedConditions.presenceOfElementLocated(key));
    }

    /**
     * @param text
     * @return
     */
    public boolean checkTitle(String text) {

        return wait.until(ExpectedConditions.titleIs(text));
    }

    /**
     * @param url
     * @param text
     * @return
     */
    public void checkUrl(String url, String text) {

        Assert.assertEquals(url, text);
    }

    /**
     * @param key
     * @param attr
     * @return
     */
    public String getAttribute(By key, String attr) {
        return findElement(key).getAttribute(attr);
    }

    /**
     * @param key
     * @param attr
     * @param text
     */
    public void checkAttribute(By key, String attr, String text) {
        Assert.assertEquals(getAttribute(key, attr), text);
    }

    /**
     * @param key
     * @param text
     */
    public void clickElementWithText(By key, String text) {
        boolean find = false;
        List<WebElement> elements = findElements(key);
        for (WebElement element : elements) {
            if (element.getText().contains(text)) {
                element.click();
                find = true;
                break;
            }
        }
        Assert.assertEquals(true, find);
    }

    /**
     * @param key
     * @param text
     */
    public void checkElementWithText(By key, String text) {
        boolean find = false;
        List<WebElement> elements = findElements(key);
        for (WebElement element : elements) {
            if (element.getText().contains(text)) {
                find = true;
                break;
            }
        }
        Assert.assertEquals(true, find);
    }

    /**
     * @param expectedList
     * @param actualList
     */

    public void checkStringList(List<String> expectedList, List<String> actualList) {
        Assert.assertEquals(expectedList, actualList);
    }

    /**
     * @param key
     */
    public void checkBoolean(Boolean key) {
        Assert.assertTrue(key);
    }


    /**
     * @param key
     * @param text
     * @param text2
     */
    public void sendKeyElementWithText(By key, String text, String text2) {
        boolean find = false;
        List<WebElement> elements = findElements(key);
        for (WebElement element : elements) {
            if (element.getText().equals(text)) {
                element.sendKeys(text2);
                find = true;
                break;
            }
        }
        Assert.assertEquals(true, find);
    }

    /**
     * @param key
     * @return
     */
    public WebElement presenceElement(By key) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(key));
    }

    /**
     * @param key
     * @return
     */
    public List<WebElement> presenceElements(By key) {
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(key));
    }

    /**
     * @param element
     */
    public void scrollToElement(WebElement element) {
        String scrollElementIntoMiddle = "var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);" + "var elementTop = arguments[0].getBoundingClientRect().top;" + "window.scrollBy(0, elementTop-(viewPortHeight/2));";
        ((JavascriptExecutor) driver).executeScript(scrollElementIntoMiddle, element);
    }

    public void scrollToUp() {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1000)");
    }


    /**
     * @param filename
     */
    public boolean check_file_exist(String filename) {
        boolean result = false;
        String home = System.getProperty("user.home");
        String file_with_location = home + "\\Downloads\\" + filename;
        File file = new File(file_with_location);
        if (file.exists()) result = true;

        return result;
    }
    /* public Parent() {
        driver = Driver.get();
        wait = new WebDriverWait(driver, 10);
    }

    public void clickFunction(WebElement element)
    {
        waitUntilClickable(element);// eleman clikable olana kadar bekle
        scrollToElement(element); // eleman kadar scroll yap
        element.click();// click yap
    }

    public void sendKeysFunction(WebElement element, String value)
    {
        waitUntilVisible(element);// elelman görünüt olana kadar bekle
        //scrollToElement(element);// elemana kadar scroll yap
        //element.clear();// eleman clear yap
        element.sendKeys(value);// value yi gönder
    }
     public void findElementAndClickFunction(String ElementName) {

        switch (ElementName) {

            case "menuButton":
                myElement = menuButton;
                break;

            case "oscarsButton":
                myElement = oscarsButton;
                break;

            case "yearButton":
                myElement = yearButton;
                break;

            case "theCircusMovie":
                myElement = theCircusMovie;
                break;

            case "imdbLogo":
                myElement = imdbLogo;
                break;

            case "firstMovieResult":
                myElement = firstMovieResult;
                break;

            case "seeTheGallery":
                myElement = seeTheGallery;
                break;

            case "theJazzSingerMovie":
                myElement = theJazzSingerMovie;
                break;

            case "resultJazzSinger":
                myElement = resultJazzSinger;
                break;

            case "photosButton":
                myElement = photosButton;
                break;

        }
        clickFunction(myElement);
    }


    public void findElementAndSendKeysFunction(String ElementName, String value) {

        switch (ElementName) {
            case "txtBox":
                myElement = txtBox;
                break;
        }

        sendKeysFunction(myElement, value);
    }

    public void waitUntilClickable(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitUntilVisible(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }
     public static void verifyEquals(String actual, String expected){

        if (actual.equals(expected)){
            System.out.println("PASS");
            System.out.println("actual = " + actual);
            System.out.println("expected = " + expected);
        }else {
            System.out.println("FAIL");
            System.out.println("actual = " + actual);
            System.out.println("expected = " + expected);
        }


    public void scrollToElement(WebElement element)
    {
        JavascriptExecutor js= (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public void waiting(int ms)
    {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
}
