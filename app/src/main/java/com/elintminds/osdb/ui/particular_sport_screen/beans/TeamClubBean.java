package com.elintminds.osdb.ui.particular_sport_screen.beans;

import java.util.ArrayList;

public class TeamClubBean
{
    private String teamClubName;

    private ArrayList<TeamInfoBean.Team> teamsList = new ArrayList<>();

    public String getTeamClubName() {
        return teamClubName;
    }

    public void setTeamClubName(String teamClubName) {
        this.teamClubName = teamClubName;
    }

    public ArrayList<TeamInfoBean.Team> getTeamsList() {
        return teamsList;
    }

    public void setTeamsList(ArrayList<TeamInfoBean.Team> teamsList) {
        this.teamsList = teamsList;
    }

    public void setItemInList(TeamInfoBean.Team item){
        teamsList.add(item);
    }

}
