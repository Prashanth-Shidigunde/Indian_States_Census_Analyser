package org.example;

import com.opencsv.bean.CsvBindByName;

public class CSVStates {

    @CsvBindByName(column = "SrNo")
    public int srNo;

    @CsvBindByName(column = "State Name")
    public String stateName;

    @CsvBindByName(column = "TIN")
    public int tin;

    @CsvBindByName(column = "StateCode")
    public String stateCode;
}