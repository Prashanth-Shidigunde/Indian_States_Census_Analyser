package org.example;


public class CensusAnalyserMain {

    public static void main(String[] args) throws Exception {

        // Welcome message
        System.out.println("Welcome to Indian State Census Analyser");

        // Create analyser object
        StateCensusAnalyser analyser = new StateCensusAnalyser();

        // CSV file location
        String filePath =
                "src/main/resources/censusAnalyser.csv";

        // Load the CSV file
        int totalRecords = analyser.loadStateCensusData(filePath);

        // Print total records
        System.out.println("\nTotal Records Loaded : " + totalRecords);
    }
}
