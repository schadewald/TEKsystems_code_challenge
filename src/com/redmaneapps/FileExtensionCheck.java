package com.redmaneapps;

public class FileExtensionCheck {

    public String ExtensionCheck(String userFileName)
    {
        boolean isCSV = CSVCheck(userFileName);

        if (isCSV)
        {
            return userFileName;
        }
        else
        {
            return userFileName.concat(".csv");
        }
    }
    private boolean CSVCheck(String file)
    {
        return file.matches(".*\\.csv.*");
    }
}
