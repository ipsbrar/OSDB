package com.elintminds.osdb.ui.particular_sport_screen.beans;

import java.util.ArrayList;

public class TeamClubBean
{
    private String teamClubName;
    private ArrayList<TeamsBean> teamsList;

    public String getTeamClubName() {
        return teamClubName;
    }

    public void setTeamClubName(String teamClubName) {
        this.teamClubName = teamClubName;
    }

    public ArrayList<TeamsBean> getTeamsList() {
        return teamsList;
    }

    public void setTeamsList(ArrayList<TeamsBean> teamsList) {
        this.teamsList = teamsList;
    }
}
