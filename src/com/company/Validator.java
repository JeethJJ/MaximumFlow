package com.company;

import java.util.Scanner;

public class Validator {
    public static int intVal(String question) {
        System.out.print(question);     //prompting the question
        Scanner sc = new Scanner(System.in);
        while (!sc.hasNextInt()) {           //validating int until proper input
            System.out.print("Invalid input.\nPlease enter a valid number\n>");
            sc.next();
        }
        int userInputInt = sc.nextInt();
        sc.nextLine();   //to remove skipping errors (https://www.youtube.com/watch?v=R2ZB-Ye6GEo)
        return userInputInt;
    }
}
