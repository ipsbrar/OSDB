package com.osdb.app.ui.team_details_screen.beans;

import java.util.ArrayList;
import java.util.List;

public class StatsMainBean {
    private String headerText;
    private ArrayList<List<StatsHorizontalBean>> statsHorizontalBeans;
    private ArrayList<StatsVerticalBean> statsVerticalBeans;


    public String getHeaderText() {
        return headerText;
    }

    public void setHeaderText(String headerText) {
        this.headerText = headerText;
    }

    public ArrayList<List<StatsHorizontalBean>> getStatsHorizontalBeans() {
        return statsHorizontalBeans;
    }

    public void setStatsHorizontalBeans(ArrayList<List<StatsHorizontalBean>> statsHorizontalBeans) {
        this.statsHorizontalBeans = statsHorizontalBeans;
    }

    public ArrayList<StatsVerticalBean> getStatsVerticalBeans() {
        return statsVerticalBeans;
    }

    public void setStatsVerticalBeans(ArrayList<StatsVerticalBean> statsVerticalBeans) {
        this.statsVerticalBeans = statsVerticalBeans;
    }

}
