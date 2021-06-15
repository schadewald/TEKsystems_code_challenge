package com.redmaneapps;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ParseFile {

    List<String> fullTimeEmployeeRecords = new ArrayList<>();
    List<String> partTimeEmployeeRecords = new ArrayList<>();
    List<String> contractEmployeeRecords = new ArrayList<>();

    public void Parse(String fileName) throws FileNotFoundException
    {
        Scanner scanner = new Scanner(new File("src/com/redmaneapps/" + fileName));
        scanner.useDelimiter(",");

        while (scanner.hasNext())
        {
            String line = scanner.nextLine();
            if (line.contains("FULL"))
            {
                setFullTimeEmployeeRecords(line);
            }
            else if (line.contains("PART"))
            {
                setPartTimeEmployeeRecords(line);
            }
            else if (line.contains("CONTRACT"))
            {
                setContractEmployeeRecords(line);
            }
        }
        scanner.close();
    }
    private void setFullTimeEmployeeRecords(String line)
    {
        fullTimeEmployeeRecords.add(line);
    }
    private void setPartTimeEmployeeRecords(String line)
    {
        partTimeEmployeeRecords.add(line);
    }
    private void setContractEmployeeRecords(String line)
    {
        contractEmployeeRecords.add(line);
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
}
