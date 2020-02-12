package com.example.kent.sciencetestapp.project;

import com.example.kent.sciencetestapp.nbmd.NBMData;

import org.apache.poi.ss.usermodel.Workbook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Project
{
    private String name;
    // Used for storing metadata in json format as Non-Binary MetaData
    private NBMData nbmData = new NBMData();
    private Map<String, Workbook> workbooks = new HashMap<>();

    //TODO: Add more properties here!
}
