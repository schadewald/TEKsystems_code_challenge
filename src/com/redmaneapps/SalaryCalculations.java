package com.redmaneapps;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SalaryCalculations {
    private static String userFileName;

    public static void main(String[] args) throws Exception
    {
        FileExtensionCheck checker = new FileExtensionCheck();
        ParseFile parser = new ParseFile();
        List<String> fullTimeEmployeeRecords;
        List<String> partTimeEmployeeRecords;
        List<String> contractEmployeeRecords;
        int totalSalary = 0;
        int roleSalary = 0;

        try
        {
            Scanner userInput = new Scanner(System.in);
            System.out.println("Please enter filename: ");
            userFileName = checker.ExtensionCheck(userInput.nextLine());
            System.out.println("Opening " + userFileName);

            parser.Parse(userFileName);

            fullTimeEmployeeRecords = parser.getFullTimeEmployees();
            partTimeEmployeeRecords = parser.getPartTimeEmployees();
            contractEmployeeRecords = parser.getContractEmployees();

//            Scanner scanner = new Scanner(new File("src/com/redmaneapps/" + userFileName));
//            scanner.useDelimiter(",");
//
//
//
//            while (scanner.hasNext())
//            {
//                String line = scanner.nextLine();
//                if (line.contains("FULL"))
//                {
//                    fullTimeEmployeeRecords.add(line);
//                    List<String> fullTimeList = Arrays.asList(line.split(","));
//                    int rate = Integer.parseInt(fullTimeList.get(1));
//                    int hours = Integer.parseInt(fullTimeList.get(2));
//                    int salary = hours * rate;
//                    if (salary > 50000)
//                    {
//                        salary = 50000;
//                    }
//                    totalSalary += salary;
//                }
//                else if (line.contains("PART"))
//                {
//                    partTimeEmployeeRecords.add(line);
//                    List<String> partTimeList = Arrays.asList(line.split(","));
//                    int rate = Integer.parseInt(partTimeList.get(1));
//                    int hours = Integer.parseInt(partTimeList.get(2));
//                    int salary = hours * rate;
//                    totalSalary += salary;
//                }
//                else if (line.contains("CONTRACT"))
//                {
//                    contractEmployeeRecords.add(line);
//                    List<String> contractTimeList = Arrays.asList(line.split(","));
//                    int rate = Integer.parseInt(contractTimeList.get(1));
//                    int hours = Integer.parseInt(contractTimeList.get(2));
//                    int salary = 10000 + (hours * rate);
//                    totalSalary += salary;
//                }
//            }

            System.out.println("Please enter Total or Role");
            String userCalculation = userInput.nextLine();

            if (userCalculation.equalsIgnoreCase("Total"))
            {
                System.out.println("Total Salary = $" + totalSalary + ".00");
            }
            else if (userCalculation.equalsIgnoreCase("Role"))
            {
                System.out.println("Please enter Role to be calculated (FULL, PART, CONTRACT)");
                String userRoll = userInput.nextLine();

                if (userRoll.equalsIgnoreCase("FULL"))
                {
                    for (String employee : fullTimeEmployeeRecords)
                    {
                        List<String> fullTimeList = Arrays.asList(employee.split(","));
                        int rate = Integer.parseInt(fullTimeList.get(1));
                        int hours = Integer.parseInt(fullTimeList.get(2));
                        int salary = hours * rate;
                        if (salary > 50000)
                        {
                            salary = 50000;
                        }
                        roleSalary += salary;
                        System.out.println("Total Salary for Full Time Workers : $ " + roleSalary + ".00");
                    }
                }
                else if (userRoll.equalsIgnoreCase("Part"))
                {
                    for (String employee : partTimeEmployeeRecords)
                    {
                        List<String> partTimeList = Arrays.asList(employee.split(","));
                        int rate = Integer.parseInt(partTimeList.get(1));
                        int hours = Integer.parseInt(partTimeList.get(2));
                        int salary = hours * rate;
                        roleSalary += salary;
                        System.out.println("Total Salary for Part Time Workers : $ " + roleSalary + ".00");
                    }
                }
                else if (userRoll.equalsIgnoreCase("CONTRACT"))
                {
                    for (String employee : contractEmployeeRecords)
                    {
                        List<String> contractTimeList = Arrays.asList(employee.split(","));
                        int rate = Integer.parseInt(contractTimeList.get(1));
                        int hours = Integer.parseInt(contractTimeList.get(2));
                        int salary = 10000 + (hours * rate);
                        roleSalary += salary;
                    }
                    System.out.println("Total Salary for Contract Workers : $ " + roleSalary + ".00");
                }
            }

//            scanner.close();
        }
        catch (Exception exception)
        {
            System.out.println("Unable to locate file: " + userFileName);
        }
        finally
        {
            System.out.println("\n" + "Exiting Program.");
        }
    }
}
