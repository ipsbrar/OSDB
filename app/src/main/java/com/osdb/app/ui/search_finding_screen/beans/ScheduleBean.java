package com.osdb.app.ui.search_finding_screen.beans;

import android.os.Parcel;
import android.os.Parcelable;

public class ScheduleBean implements Parcelable
{
    private String matchTime;
    private String teamOneName;
    private String teamTwoName;
    private String matchAddres;
    private String teamOneLogo;
    private String teamTwoLogo;

    public ScheduleBean(){

    }

    protected ScheduleBean(Parcel in) {
        matchTime = in.readString();
        teamOneName = in.readString();
        teamTwoName = in.readString();
        matchAddres = in.readString();
        teamOneLogo = in.readString();
        teamTwoLogo = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(matchTime);
        dest.writeString(teamOneName);
        dest.writeString(teamTwoName);
        dest.writeString(matchAddres);
        dest.writeString(teamOneLogo);
        dest.writeString(teamTwoLogo);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ScheduleBean> CREATOR = new Creator<ScheduleBean>() {
        @Override
        public ScheduleBean createFromParcel(Parcel in) {
            return new ScheduleBean(in);
        }

        @Override
        public ScheduleBean[] newArray(int size) {
            return new ScheduleBean[size];
        }
    };

    public String getMatchTime() {
        return matchTime;
    }

    public void setMatchTime(String matchTime) {
        this.matchTime = matchTime;
    }

    public String getTeamOneName() {
        return teamOneName;
    }

    public void setTeamOneName(String teamOneName) {
        this.teamOneName = teamOneName;
    }

    public String getTeamTwoName() {
        return teamTwoName;
    }

    public void setTeamTwoName(String teamTwoName) {
        this.teamTwoName = teamTwoName;
    }

    public String getMatchAddres() {
        return matchAddres;
    }

    public void setMatchAddres(String matchAddres) {
        this.matchAddres = matchAddres;
    }

    public String getTeamOneLogo() {
        return teamOneLogo;
    }

    public void setTeamOneLogo(String teamOneLogo) {
        this.teamOneLogo = teamOneLogo;
    }

    public String getTeamTwoLogo() {
        return teamTwoLogo;
    }

    public void setTeamTwoLogo(String teamTwoLogo) {
        this.teamTwoLogo = teamTwoLogo;
    }
}
