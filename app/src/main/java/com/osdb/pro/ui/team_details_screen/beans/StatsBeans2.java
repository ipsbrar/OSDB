package com.osdb.pro.ui.team_details_screen.beans;

import java.util.ArrayList;
import java.util.List;

public class StatsBeans2 {
    private String headerText;
    private ArrayList<List<String>> listArrayList;
    private String mainHeaderText;

    public String getMainHeaderText() {
        return mainHeaderText;
    }

    public void setMainHeaderText(String mainHeaderText) {
        this.mainHeaderText = mainHeaderText;
    }


    public String getHeaderText() {
        return headerText;
    }

    public void setHeaderText(String headerText) {
        this.headerText = headerText;
    }

    public ArrayList<List<String>> getListArrayList() {
        return listArrayList;
    }

    public void setListArrayList(ArrayList<List<String>> listArrayList) {
        this.listArrayList = listArrayList;
    }
}
