package org.example;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Objects;
import java.util.Random;

import static org.apache.commons.math3.util.Precision.round;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main1 {
    public static void main1(String[] args) {
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
//        driver.get("https://fs2.formsite.com/meherpavan/form2/index.html?1537702596407");

//        //Select
//        var select = new Select(driver.findElement(By.id("RESULT_RadioButton-9")));
//        select.selectByVisibleText("Afternoon");
//
//        //Radio Button
//        WebElement radio1 = driver.findElement(By.xpath("//*[@id=\"RESULT_RadioButton-7_0\"]"));
//        WebElement radio2 = driver.findElement(By.xpath("//*[@id=\"RESULT_RadioButton-7_1\"]"));
//        //Radio Button1 is selected
//        try
//        {
//            WebElement searchButton = driver.findElement(By.id("RESULT_RadioButton-7_0"));
//            JavascriptExecutor js = (JavascriptExecutor)driver;
//            js.executeScript("arguments[0].click()", searchButton);
//            //radio1.click();
//            System.out.println("Radio Button Option 1 Selected");
//        }
//        catch(Exception e)
//        {
//            System.out.println("Radio ButtonException : " + e.getMessage());
//        }
//
//        //Radio Button1 is de-selected and Radio Button2 is selected
////        radio2.click();
////        System.out.println("Radio Button Option 2 Selected");
//
//        //CheckBox Click
//        WebElement checkButton = driver.findElement(By.id("RESULT_CheckBox-8_0"));
//        JavascriptExecutor js = (JavascriptExecutor)driver;
//        js.executeScript("arguments[0].click()", checkButton);
//        //driver.findElement(By.id("RESULT_CheckBox-8_0")).click();
//
//        //FileUpload
//        WebElement fileButton = driver.findElement(By.id("RESULT_FileUpload-10"));
//        fileButton.sendKeys("C:\\Users\\salen\\Downloads\\Test.html");

        driver.get("file:///C:/Users/salen/IdeaProjects/FirstMaven/src/main/java/org/example/Calculator.html");

        //create a workbook
        Workbook workbook = new XSSFWorkbook();

        //create a sheet in the workbook(you can give it a name)
        Sheet sheet = workbook.createSheet("excel-sheet");

                //create a row in the sheet
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
        //add cells in the sheet
        cell = row.createCell(0);

        //set a value to the cell
        cell.setCellValue(operand1 + "");
        cell = row.createCell(1);
        cell.setCellValue(operand2 + "");
        cell = row.createCell(2);
        cell.setCellValue(operator);
        cell = row.createCell(3);

        if(operator.equals("Division")) {
            actualResult = round(actualResult, 7);
        }

        cell.setCellValue(actualResult);

        driver.findElement(By.className("all-clear")).click();
        driver.findElement(By.id("btn"+operand1)).click();
        switch (operatorIndex) {
            case 0 -> {
                driver.findElement(By.id("add")).click();
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

//        if(operator.equals("Division")) {
//            expectedResult = round(expectedResult, 7);
//        }

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

        //save the Excel file
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