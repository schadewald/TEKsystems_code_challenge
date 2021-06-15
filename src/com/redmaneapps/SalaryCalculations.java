package com.redmaneapps;

import java.util.List;
import java.util.Scanner;

public class SalaryCalculations {
    private static String userFileName;

    public static void main(String[] args) throws Exception
    {
        FileExtensionCheck checker = new FileExtensionCheck();
        ParseFile parser = new ParseFile();
        Calculations calculator = new Calculations();
        List<String> fullTimeEmployeeRecords;
        List<String> partTimeEmployeeRecords;
        List<String> contractEmployeeRecords;

        try {
            Scanner userInput = new Scanner(System.in);
            System.out.println("Please enter filename: ");
            userFileName = checker.ExtensionCheck(userInput.nextLine());
            parser.Parse(userFileName);
            fullTimeEmployeeRecords = parser.getFullTimeEmployees();
            partTimeEmployeeRecords = parser.getPartTimeEmployees();
            contractEmployeeRecords = parser.getContractEmployees();
            calculator.CalculateSalaries(fullTimeEmployeeRecords, partTimeEmployeeRecords, contractEmployeeRecords);
            System.out.println("Please enter Total or Role or Q to exit.");
            String userCalculation = userInput.nextLine();
            while (!userCalculation.equalsIgnoreCase("Q"))
            {
                if (userCalculation.equalsIgnoreCase("Total")) {
                    System.out.println("Total Salary = $" + calculator.getTotalSalaries() + ".00");
                } else if (userCalculation.equalsIgnoreCase("Role")) {
                    System.out.println("Please enter Role to be calculated (FULL, PART, CONTRACT)");
                    String userRoll = userInput.nextLine();

                    if (userRoll.equalsIgnoreCase("FULL")) {
                        System.out.println("Total Salary for Full Time Workers : $ " + calculator.getFullTimeSalaries() + ".00");
                    } else if (userRoll.equalsIgnoreCase("Part")) {
                        System.out.println("Total Salary for Part Time Workers : $ " + calculator.getPartTimeSalaries() + ".00");
                    } else if (userRoll.equalsIgnoreCase("CONTRACT")) {
                        System.out.println("Total Salary for Contract Workers : $ " + calculator.getContractSalaries() + ".00");
                    } else {
                        System.out.println("Invalid input.");
                    }
                }
                System.out.println("\nPlease enter Total or Role or Q to exit.");
                userCalculation = userInput.nextLine();
            }
        }
        catch (Exception exception)
        {
            System.out.println("Unable to locate file: " + userFileName);
            main(args);
        }
        finally
        {
            System.out.println("\n" + "Exiting Program.");
        }
    }
}
