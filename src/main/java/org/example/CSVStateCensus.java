package org.example;

import com.opencsv.bean.CsvBindByName;

// This class represents one row of the CSV file
public class CSVStateCensus {

    // Maps the "State" column
    @CsvBindByName(column = "State")
    public String state;

    // Maps the "Population" column
    @CsvBindByName(column = "Population")
    public long population;

    // Maps the "AreaInSqKm" column
    @CsvBindByName(column = "AreaInSqKm")
    public long areaInSqKm;

    // Maps the "DensityPerSqKm" column
    @CsvBindByName(column = "DensityPerSqKm")
    public long densityPerSqKm;
}