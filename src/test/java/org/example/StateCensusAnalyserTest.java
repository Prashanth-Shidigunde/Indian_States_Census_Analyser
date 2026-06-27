package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}