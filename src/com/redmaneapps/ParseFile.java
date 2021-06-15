package com.redmaneapps;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ParseFile {

    List<String> fullTimeEmployeeRecords = new ArrayList<>();
    List<String> partTimeEmployeeRecords = new ArrayList<>();
    List<String> contractEmployeeRecords = new ArrayList<>();
//    int totalSalary = 0;

    public void Parse(String fileName) throws FileNotFoundException
    {
        Scanner scanner = new Scanner(new File("src/com/redmaneapps/" + fileName));
        scanner.useDelimiter(",");

        while (scanner.hasNext())
        {
            String line = scanner.nextLine();
            if (line.contains("FULL"))
            {
                fullTimeEmployeeRecords.add(line);
            }
            else if (line.contains("PART"))
            {
                partTimeEmployeeRecords.add(line);
            }
            else if (line.contains("CONTRACT"))
            {
                contractEmployeeRecords.add(line);
            }
        }
        scanner.close();
    }
    public List<String> getFullTimeEmployees()
    {
        return fullTimeEmployeeRecords;
    }
    public List<String> getPartTimeEmployees()
    {
        return partTimeEmployeeRecords;
    }
    public List<String> getContractEmployees()
    {
        return contractEmployeeRecords;
    }

//    public void CalculateFullTimeEmployee()
//    {
//        for (String line : fullTimeEmployeeRecords)
//        {
//
//        }
//    }
//    public void CalculatePartTimeEmployee()
//    {
//        for (String line : partTimeEmployeeRecords)
//        {
//
//        }
//    }
//    public void CalculateContractEmployee()
//    {
//        for (String line : contractEmployeeRecords)
//        {
//
//        }
//    }

}
