package com.redmaneapps;

import java.util.*;

public class Calculations {
    int totalSalaries;
    int fullTimeSalaries;
    int partTimeSalaries;
    int contractSalaries;

    public void CalculateSalaries(List<String> fullTime, List<String> partTime, List<String> contract)
    {
        CalculateFullTimeEmployee(fullTime);
        CalculatePartTimeEmployee(partTime);
        CalculateContractEmployee(contract);
        CalculateTotalSalaries();
    }
    public void CalculateFullTimeEmployee(List<String> fullTime)
    {
        for (String line : fullTime)
        {
            List<String> fullTimeList = Arrays.asList(line.split(","));
                    int rate = Integer.parseInt(fullTimeList.get(1));
                    int hours = Integer.parseInt(fullTimeList.get(2));
                    int salary = hours * rate;
                    if (salary > 50000)
                    {
                        salary = 50000;
                    }
                    setFullTimeSalaries(salary);
        }
    }
    public void CalculatePartTimeEmployee(List<String> partTime)
    {
        for (String line : partTime)
        {
            List<String> partTimeList = Arrays.asList(line.split(","));
                    int rate = Integer.parseInt(partTimeList.get(1));
                    int hours = Integer.parseInt(partTimeList.get(2));
                    int salary = hours * rate;
                    setPartTimeSalaries(salary);
        }
    }
    public void CalculateContractEmployee(List<String> contract)
    {
        for (String line : contract)
        {
            List<String> contractTimeList = Arrays.asList(line.split(","));
                    int rate = Integer.parseInt(contractTimeList.get(1));
                    int hours = Integer.parseInt(contractTimeList.get(2));
                    int salary = 10000 + (hours * rate);
                    setContractSalaries(salary);
        }
    }
    public void CalculateTotalSalaries()
    {
        setTotalSalaries(getFullTimeSalaries(), getPartTimeSalaries(), getContractSalaries());
    }
    private void setTotalSalaries(int fullTime, int partTime, int contract)
    {
        totalSalaries = fullTime + partTime + contract;
    }
    private void setFullTimeSalaries(int salary)
    {
        fullTimeSalaries += salary;
    }
    private void setPartTimeSalaries(int salary)
    {
        partTimeSalaries += salary;
    }
    private void setContractSalaries(int salary)
    {
        contractSalaries += salary;
    }
    public int getTotalSalaries()
    {
        return totalSalaries;
    }
    public int getFullTimeSalaries()
    {
        return fullTimeSalaries;
    }
    public int getPartTimeSalaries()
    {
        return partTimeSalaries;
    }
    public int getContractSalaries()
    {
        return contractSalaries;
    }
}
