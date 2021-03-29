package view;

import calculationMethods.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import writingResults.FileOutput;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MyView {
    Map<String, String> menu;
    Map<String, Printable> methodMenu;
    double num1;
    double num2;

    private static Scanner op = new Scanner(System.in);

    private static final Logger logger = LogManager.getLogger(MyView.class);

    public MyView() {

        menu = new LinkedHashMap<>();
        menu.put("+", " + - calculationMethods.Addition");
        menu.put("-", " - - calculationMethods.Subtraction");
        menu.put("*", " * - calculationMethods.Multiplication");
        menu.put("/", " / - calculationMethods.Division");
        menu.put("^", " ^ - calculationMethods.Power");
        menu.put("log", " log - Logarifm");

        methodMenu = new LinkedHashMap<>();
        methodMenu.put("+", this::pressButton1);
        methodMenu.put("-", this::pressButton2);
        methodMenu.put("*", this::pressButton3);
        methodMenu.put("/", this::pressButton4);
        methodMenu.put("^", this::pressButton5);
        methodMenu.put("log", this::pressButton6);

        Scanner input = new Scanner(System.in);

        // for values inputting and validation [-20; 20]
        do {
            System.out.println("Please input your first number:");
            num1 = input.nextDouble();
            if (num1 > 20 || num1 < -20) {
                logger.info("First value out of the borders: " + num1);// let`s log not valid values into log file in the logs folder
                System.out.println("Number must be in the [-20; 20]");
            }

        } while (num1 > 20 || num1 < -20);

        do {
            System.out.println("Please input your second number:");
            num2 = input.nextDouble();
            if (num2 > 20 || num2 < -20) {
                logger.info("Second value out of the borders: " + num2);
                System.out.println("Number must be in the [-20; 20]");
            }

        } while (num2 > 20 || num2 < -20);

    }

    // the map only for showing a menu of options for the user
    private void outputMenu() {
        System.out.println("\nChoose operation:");
        for (String str : menu.values()) {
            System.out.println(str);
        }
    }

    private void pressButton1() throws IOException {
        System.out.println("Your Result is : " + Addition.addition(num1, num2));

// Call method for  writing last calculated results into txt file
        String s = "Your Result is : " + Addition.addition(num1, num2) + "\n" + "Calculation time is  ";
        FileOutput.fileOutput(s);

    }

    private void pressButton2() throws IOException {
        System.out.println("Your Result is : " + Subtraction.subtraction(num1, num2));

        String s = "Your Result is : " + Subtraction.subtraction(num1, num2) + "\n" + "Calculation time is  ";
        FileOutput.fileOutput(s);
    }

    private void pressButton3() throws IOException {
        System.out.println("Your Result is : " + Multiplication.multiplication(num1, num2));

        String s = "Your Result is : " + Multiplication.multiplication(num1, num2) + "\n" + "Calculation time is  ";
        FileOutput.fileOutput(s);
    }

    private void pressButton4() throws IOException {
        if (num2 == 0) {
            System.out.println("Your Input is Invalid");
        } else {
            System.out.println("Your Result is : " + Division.division(num1, num2));
        }

        String s = "Your Result is : " + Division.division(num1, num2) + "\n" + "Calculation time is  ";
        FileOutput.fileOutput(s);
    }

    private void pressButton5() throws IOException {
        System.out.println("Your Result is : " + Power.power(num1, num2));
        String s = "Your Result is : " + Power.power(num1, num2) + "\n" + "Calculation time is  ";
        FileOutput.fileOutput(s);
    }

    private void pressButton6() throws IOException {
        System.out.println("Your Result is : " + Log.log(num1, num2));
        String s = "Your Result is : " + Log.log(num1, num2) + "\n" + "Calculation time is  ";
        FileOutput.fileOutput(s);
    }

    public void show() {
        String keyMenu;
        outputMenu();
        System.out.println("Select your operation:");
        keyMenu = op.nextLine();

        try {
            methodMenu.get(keyMenu).print();
        } catch (Exception e) {

        }
    }
}


