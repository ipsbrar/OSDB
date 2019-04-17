package com.osdb.app.ui.team_details_screen.beans;


import java.io.Serializable;

public class StatsBeanVertical implements Serializable {

    private String mainHeader;
    private String header;
    private TableList tableList;

    public String getMainHeader() {
        return mainHeader;
    }

    public void setMainHeader(String mainHeader) {
        this.mainHeader = mainHeader;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public TableList getTableList() {
        return tableList;
    }

    public void setTableList(TableList tableList) {
        this.tableList = tableList;
    }

}
