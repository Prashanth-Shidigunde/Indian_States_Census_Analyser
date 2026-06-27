package org.example;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileReader;
import java.io.Reader;
import java.util.Iterator;

public class StateCensusAnalyser {

    public int loadStateCensusData(String csvFilePath)
            throws CensusAnalyserException {

        try {

            // Check file type
            if (!csvFilePath.endsWith(".csv")) {
                throw new CensusAnalyserException(
                        "Invalid File Type",
                        CensusAnalyserException.ExceptionType.INVALID_FILE_TYPE);
            }

            Reader reader = new FileReader(csvFilePath);

            CsvToBean<CSVStateCensus> csvToBean =
                    new CsvToBeanBuilder<CSVStateCensus>(reader)
                            .withType(CSVStateCensus.class)
                            .withIgnoreLeadingWhiteSpace(true)
                            .build();

            Iterator<CSVStateCensus> iterator = csvToBean.iterator();

            int count = 0;

            while (iterator.hasNext()) {
                CSVStateCensus census = iterator.next();

                /*
                 * If the delimiter is incorrect,
                 * OpenCSV cannot map the columns correctly.
                 * The fields become null or default values.
                 */
                if (census.state == null) {
                    throw new CensusAnalyserException(
                            "Invalid Delimiter",
                            CensusAnalyserException.ExceptionType.INVALID_DELIMITER);
                }

                count++;
            }

            reader.close();

            return count;

        } catch (CensusAnalyserException e) {
            throw e;

        } catch (Exception e) {
            throw new CensusAnalyserException(
                    "State Census File Problem",
                    CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM);
        }
    }
}