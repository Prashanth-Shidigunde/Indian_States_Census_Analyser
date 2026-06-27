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

            // Check whether the file is a CSV
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
                iterator.next();
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