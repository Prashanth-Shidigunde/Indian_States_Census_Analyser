package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StateCensusAnalyserTest {

    @Test
    void givenStateCensusCSVFile_WhenCorrect_ShouldReturnCorrectRecordCount() throws Exception {

        // Arrange
        StateCensusAnalyser analyser = new StateCensusAnalyser();

        String filePath = "src/main/resources/censusAnalyser.csv";

        // Act
        int actualRecordCount = analyser.loadStateCensusData(filePath);

        // Assert
        // Replace 29 with the actual number of data rows in your CSV
        assertEquals(36, actualRecordCount);
    }


    @Test
    void givenWrongCSVFile_WhenLoaded_ShouldThrowCustomException() {

        StateCensusAnalyser analyser = new StateCensusAnalyser();

        assertThrows(
                CensusAnalyserException.class,
                () -> analyser.loadStateCensusData(
                        "src/main/resources/WrongFile.csv")
        );
    }
    @Test
    void givenStateCensusFile_WhenTypeIsIncorrect_ShouldThrowCustomException() {

        StateCensusAnalyser analyser = new StateCensusAnalyser();

        CensusAnalyserException exception =
                assertThrows(
                        CensusAnalyserException.class,
                        () -> analyser.loadStateCensusData(
                                "src/main/resources/censusAnalyser.txt"));

        assertEquals(
                CensusAnalyserException.ExceptionType.INVALID_FILE_TYPE,
                exception.type);
    }
    @Test
    void givenStateCensusCSV_WhenDelimiterIncorrect_ShouldThrowCustomException() {

        StateCensusAnalyser analyser = new StateCensusAnalyser();

        CensusAnalyserException exception =
                assertThrows(
                        CensusAnalyserException.class,
                        () -> analyser.loadStateCensusData(
                                "src/main/resources/censusWrongDelimiter.csv"));

        assertEquals(
                CensusAnalyserException.ExceptionType.INVALID_DELIMITER,
                exception.type);
    }
    @Test
    void givenStateCensusCSV_WhenHeaderIncorrect_ShouldThrowCustomException() {

        StateCensusAnalyser analyser = new StateCensusAnalyser();

        CensusAnalyserException exception =
                assertThrows(
                        CensusAnalyserException.class,
                        () -> analyser.loadStateCensusData(
                                "src/main/resources/censusWrongDelimiter.csv"));

        assertEquals(
                CensusAnalyserException.ExceptionType.INVALID_HEADER,
                exception.type);
    }


}