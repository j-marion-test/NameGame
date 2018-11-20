package com.willowtreeapps;

import org.apache.commons.collections.map.ListOrderedMap;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Array;
import java.util.ListIterator;

/**
 * Created on 5/23/17.
 */
public class HomePage extends BasePage {


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void validateTitleIsPresent() {
        WebElement title = driver.findElement(By.cssSelector("h1"));
        Assert.assertTrue(title != null);

        System.out.print("The title is present.");
    }


    public void validateClickingFirstPhotoIncreasesTriesCounter() {
        //Wait for page to load
        sleep(6000);

        int count = Integer.parseInt(driver.findElement(By.className("attempts")).getText());

        driver.findElement(By.className("photo")).click();

        sleep(6000);

        int countAfter = Integer.parseInt(driver.findElement(By.className("attempts")).getText());

        Assert.assertTrue(countAfter > count);

        System.out.print("The number of tries was " + countAfter + " which is more than the beginning count of " + count + ".");

    }

    public void validateClickingCorrectPhotoIncreasesCorrectCounter() {
        sleep(6000);

        int count = Integer.parseInt(driver.findElement(By.className("correct")).getText());

        String data_id = driver.findElement(By.id("name")).getAttribute("data-n");

        driver.findElement(By.xpath("//div[@data-n='"+data_id+"']")).click();

        sleep(6000);

        int countAfter = Integer.parseInt(driver.findElement(By.className("correct")).getText());

        Assert.assertTrue(countAfter > count);

        System.out.print("The number of correct selections was " + countAfter + " which is more than the beginning count of " + count + ".");
    }

    public void validateClickingCorrectPhotosIncreasesStreakCounter() {
        sleep(6000);

        int count = Integer.parseInt(driver.findElement(By.className("streak")).getText());

        String data_id = driver.findElement(By.id("name")).getAttribute("data-n");

        driver.findElement(By.xpath("//div[@data-n='"+data_id+"']")).click();

        sleep(6000);

        String data_id2 = driver.findElement(By.id("name")).getAttribute("data-n");

        driver.findElement(By.xpath("//div[@data-n='"+data_id2+"']")).click();

        sleep(6000);

        int countAfter = Integer.parseInt(driver.findElement(By.className("streak")).getText());

        Assert.assertTrue(countAfter > count);

        System.out.print("Correctly selected " + countAfter + " choices in a row.");
    }

    public void validateClickingThroughTenTimesTrackingCounter () {
        sleep(6000);

        int count = Integer.parseInt(driver.findElement(By.className("correct")).getText());
        int count2 = Integer.parseInt(driver.findElement(By.className("attempts")).getText());

        for(int i= 1;i<3;i++) {
                driver.findElement(By.xpath("//div[@data-n='0']")).click();
                sleep(6000);
                driver.findElement(By.xpath("//div[@data-n='1']")).click();
                sleep(6000);
                driver.findElement(By.xpath("//div[@data-n='2']")).click();
                sleep(6000);
                driver.findElement(By.xpath("//div[@data-n='3']")).click();
                sleep(6000);
                driver.findElement(By.xpath("//div[@data-n='4']")).click();
                sleep(6000);
        }

        int countAfter = Integer.parseInt(driver.findElement(By.className("correct")).getText());
        int countAfter2 = Integer.parseInt(driver.findElement(By.className("attempts")).getText());

        Assert.assertTrue(countAfter > count);
        Assert.assertTrue(countAfter2 > count2);

        System.out.print("Correctly has selected " + countAfter + " answers with " + countAfter2 + " attempts.");
    }

    public void validateNamesAndPhotosChangeAfterCorrectAnswer () {
        sleep(6000);

        String names = driver.findElement(By.className("name")).getText();
        String photos = driver.findElement(By.className("photo")).getText();


        String data_id = driver.findElement(By.id("name")).getAttribute("data-n");

        driver.findElement(By.xpath("//div[@data-n='"+data_id+"']")).click();

        sleep(6000);

        String namesAfter = driver.findElement(By.className("name")).getText();
        String photosAfter = driver.findElement(By.className("photo")).getText();

        Assert.assertNotSame(namesAfter, names);
        Assert.assertNotSame(photosAfter, photos);

        System.out.print("Name and photos successfully changed.");
    }

}
