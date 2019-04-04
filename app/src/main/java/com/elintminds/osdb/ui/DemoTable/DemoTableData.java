package com.elintminds.osdb.ui.DemoTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DemoTableData {

    public static  int ROW_SIZE = 20;
    public static  int COLUMN_SIZE = 20;

    private List<String> getSimpleRowHeaderList() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < ROW_SIZE; i++) {
            list.add("row " + i);
        }
        return list;
    }

    private List<String> getRandomColumnHeaderList() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < COLUMN_SIZE; i++) {
            String title = "column " + i;
            list.add(title);
        }

        return list;
    }

    private List<List<String>> getRandomCellList() {
        List<List<String>> list = new ArrayList<>();
        for (int i = 0; i < ROW_SIZE; i++) {
            List<String> cellList = new ArrayList<>();
            list.add(cellList);
                for (int j = 0; j < COLUMN_SIZE; j++) {
                    String text = "cell " + j + " " + i;
                    cellList.add(text);
                }
        }

        return list;
    }

    public List<List<String>> getCellList() {
        return getRandomCellList();
    }

    public List<String> getRowHeaderList() {
        return getSimpleRowHeaderList();
    }

    public List<String> getColumnHeaderList() {
        return getRandomColumnHeaderList();
    }
}
