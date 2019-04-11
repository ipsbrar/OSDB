package com.osdb.android.ui.search_screen.beans;

public class SearchBean
{
    private String searchName;
    private int searchType;

    public SearchBean() {
    }

    public String getSearchName() {
        return searchName;
    }

    public void setSearchName(String searchName) {
        this.searchName = searchName;
    }

    public int getSearchType() {
        return searchType;
    }

    public void setSearchType(int searchType) {
        this.searchType = searchType;
    }
}
