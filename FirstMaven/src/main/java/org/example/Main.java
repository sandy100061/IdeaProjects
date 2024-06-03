package org.example;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.io.Console;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Objects;
import java.util.Random;

import static org.apache.commons.math3.util.Precision.round;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\salen\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
//        WebDriver driver = new ChromeDriver();

//        driver.get("https://facebook.com");
//
//        driver.findElement(By.id("email")).sendKeys("my email s address");
//        driver.findElement(By.id("pass")).sendKeys("password");
//        var test = driver.findElement(By.id("jazoest")).getText();
//        System.out.println(test);
//        driver.get("https://stackoverflow.com/questions/17530104/selenium-webdriver-submit-vs-click");
//
//        driver.findElement(By.id("display-name")).sendKeys("email123");
//        driver.findElement(By.id("m-address")).sendKeys("email123@gmail.com");
//        driver.findElement(By.id("wmd-input")).sendKeys("submitting this text through using selenium chrome driver using java");
//        driver.findElement(By.id("submit-button")).submit();
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\salen\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("file:///C:/Users/salen/IdeaProjects/FirstMaven/src/main/java/org/example/Calculator.html");

        //creating a workbook
        Workbook workbook = new XSSFWorkbook();

        //creating a sheet in the workbook(you can give it a name)
        Sheet sheet = workbook.createSheet("excel-sheet");

        //creating a header row in the sheet
        Row row = sheet.createRow(0);
        Cell cell = row.createCell(0);
        cell.setCellValue("Operand1 ");
        cell = row.createCell(1);
        cell.setCellValue("Operand2 ");
        cell = row.createCell(2);
        cell.setCellValue("Operator ");
        cell = row.createCell(3);
        cell.setCellValue("Expected Result");
        cell = row.createCell(4);
        cell.setCellValue("Actual Result");
        cell = row.createCell(5);
        cell.setCellValue("Test Result");

        Random rand = new Random();

        //Creating 1000 TestCases
        for (int rowIndex = 1; rowIndex <= 1000; rowIndex++) {
            int operand1 = rand.nextInt(10);
            int operand2 = rand.nextInt(10);
            String operator = "";
            double actualResult = 0;
            int operatorIndex = rand.nextInt(4);
            actualResult = switch (operatorIndex) {
                case 0 -> {
                    operator = "Addition";
                    yield Double.parseDouble(operand1 + "") + Double.parseDouble(operand2 + "");
                }
                case 1 -> {
                    operator = "Subtraction";
                    yield Double.parseDouble(operand1 + "") - Double.parseDouble(operand2 + "");
                }
                case 2 -> {
                    operator = "Multiplication";
                    yield Double.parseDouble(operand1 + "") * Double.parseDouble(operand2 + "");
                }
                case 3 -> {
                    operator = "Division";
                    yield Double.parseDouble(operand1 + "") / Double.parseDouble(operand2 + "");
                }
                default -> actualResult;
            };

            row = sheet.createRow(rowIndex);
            //adding cells in the sheet
            cell = row.createCell(0);

            //setting a value to the cell
            cell.setCellValue(operand1 + "");
            cell = row.createCell(1);
            cell.setCellValue(operand2 + "");
            cell = row.createCell(2);
            cell.setCellValue(operator);
            cell = row.createCell(3);

            //Below round to scale 7 is done to match the Javascript Division result which also scales to 7 decimal points
            if(operator.equals("Division")) {
                actualResult = round(actualResult, 7);
            }

            cell.setCellValue(actualResult);

            //Using xpath from Chrome Browser
            //driver.findElement(By.className("all-clear")).click();
            driver.findElement(By.xpath("/html/body/div[1]/div/button[16]")).click();

            driver.findElement(By.id("btn"+operand1)).click();

            switch (operatorIndex) {
                case 0 -> {
                    //Using User Defined xpath
                    //driver.findElement(By.id("add")).click();
                    driver.findElement(By.xpath("//button[@id=\"add\"]")).click();
                    break;
                }
                case 1 -> {
                    driver.findElement(By.id("sub")).click();
                    break;
                }
                case 2 -> {
                    driver.findElement(By.id("mul")).click();
                    break;
                }
                case 3 -> {
                    driver.findElement(By.id("div")).click();
                    break;
                }
            }

            driver.findElement(By.id("btn"+operand2)).click();

            driver.findElement(By.className("equal-sign")).click();

            var screenVal = driver.findElement(By.id("screen")).getAttribute("value");
            var expectedResult = Double.parseDouble(screenVal);

            cell = row.createCell(4);
            cell.setCellValue(expectedResult);
            cell = row.createCell(5);

            if (Objects.equals(Double.toString(actualResult), Double.toString(expectedResult))) {
                cell.setCellValue("Pass");
            }
            else {
                cell.setCellValue("Failure");
            }
        }

        //saving the Excel file
        try {
            var file = new File("excel.xlsx");
            if(file.exists()) {
                file.delete();
            }
            FileOutputStream out = new FileOutputStream(
                    file, false);
            workbook.write(out);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}