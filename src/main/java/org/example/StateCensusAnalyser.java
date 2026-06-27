package org.example;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileReader;
import java.io.Reader;
import java.util.Iterator;

public class StateCensusAnalyser {

    // Method to load CSV data
    public int loadStateCensusData(String csvFilePath) throws CensusAnalyserException {

        // Open the CSV file for reading
        try {
            Reader reader = new FileReader(csvFilePath);

            /*
             * CsvToBeanBuilder converts every row
             * of the CSV into a CSVStateCensus object.
             */
            CsvToBean<CSVStateCensus> csvToBean =
                    new CsvToBeanBuilder<CSVStateCensus>(reader)
                            .withType(CSVStateCensus.class)
                            .withIgnoreLeadingWhiteSpace(true)
                            .build();

            // Create an Iterator to read records one by one
            Iterator<CSVStateCensus> iterator = csvToBean.iterator();

            int count = 0;

            // Read each record until no more data is available
            while (iterator.hasNext()) {

                // Get one record
                CSVStateCensus census = iterator.next();

                /*
                 * Optional:
                 * Print every record to verify the data
                 */
                System.out.println(
                        census.state + " | "
                                + census.population + " | "
                                + census.areaInSqKm + " | "
                                + census.densityPerSqKm);

                // Increase record count
                count++;
            }
            // Close the file
            reader.close();

            // Return total records loaded
            return count;
        }
        catch(Exception e){
                throw new CensusAnalyserException("Incorrect CSV Files");
        }


    }
}