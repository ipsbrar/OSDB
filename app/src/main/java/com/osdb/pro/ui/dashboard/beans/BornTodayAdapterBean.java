package com.osdb.pro.ui.dashboard.beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BornTodayAdapterBean
{

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("full_name")
    @Expose
    private String fullName;
    @SerializedName("date_of_birth")
    @Expose
    private String dateOfBirth;
    @SerializedName("height")
    @Expose
    private String height;
    @SerializedName("weight")
    @Expose
    private String weight;
    @SerializedName("college_university")
    @Expose
    private String collegeUniversity;
    @SerializedName("about")
    @Expose
    private Object about;
    @SerializedName("birth_place")
    @Expose
    private String birthPlace;
    @SerializedName("state")
    @Expose
    private Object state;
    @SerializedName("salary")
    @Expose
    private Object salary;
    @SerializedName("fan_email")
    @Expose
    private Object fanEmail;
    @SerializedName("meta")
    @Expose
    private String meta;
    @SerializedName("uuid")
    @Expose
    private String uuid;
    @SerializedName("biography")
    @Expose
    private Object biography;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("hometown")
    @Expose
    private Object hometown;
    @SerializedName("business_ventures")
    @Expose
    private Object businessVentures;
    @SerializedName("endorsement_deals")
    @Expose
    private Object endorsementDeals;
    @SerializedName("get_team_player")
    @Expose
    private Object getTeamPlayer;
    @SerializedName("assets")
    @Expose
    private List<Object> assets = null;
    @SerializedName("team")
    @Expose
    private List<Object> team = null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getCollegeUniversity() {
        return collegeUniversity;
    }

    public void setCollegeUniversity(String collegeUniversity) {
        this.collegeUniversity = collegeUniversity;
    }

    public Object getAbout() {
        return about;
    }

    public void setAbout(Object about) {
        this.about = about;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public Object getState() {
        return state;
    }

    public void setState(Object state) {
        this.state = state;
    }

    public Object getSalary() {
        return salary;
    }

    public void setSalary(Object salary) {
        this.salary = salary;
    }

    public Object getFanEmail() {
        return fanEmail;
    }

    public void setFanEmail(Object fanEmail) {
        this.fanEmail = fanEmail;
    }

    public String getMeta() {
        return meta;
    }

    public void setMeta(String meta) {
        this.meta = meta;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Object getBiography() {
        return biography;
    }

    public void setBiography(Object biography) {
        this.biography = biography;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Object getHometown() {
        return hometown;
    }

    public void setHometown(Object hometown) {
        this.hometown = hometown;
    }

    public Object getBusinessVentures() {
        return businessVentures;
    }

    public void setBusinessVentures(Object businessVentures) {
        this.businessVentures = businessVentures;
    }

    public Object getEndorsementDeals() {
        return endorsementDeals;
    }

    public void setEndorsementDeals(Object endorsementDeals) {
        this.endorsementDeals = endorsementDeals;
    }

    public Object getGetTeamPlayer() {
        return getTeamPlayer;
    }

    public void setGetTeamPlayer(Object getTeamPlayer) {
        this.getTeamPlayer = getTeamPlayer;
    }

    public List<Object> getAssets() {
        return assets;
    }

    public void setAssets(List<Object> assets) {
        this.assets = assets;
    }

    public List<Object> getTeam() {
        return team;
    }

    public void setTeam(List<Object> team) {
        this.team = team;
    }


}
