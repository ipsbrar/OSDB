package com.osdb.pro.ui.particular_sport_screen.beans;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class TeamInfoBean {

    @SerializedName("teams")
    @Expose
    private ArrayList<Team> teams = null;

    public ArrayList<Team> getTeams() {
        return teams;
    }

    public void setTeams(ArrayList<Team> teams) {
        this.teams = teams;
    }

    public class Division {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("uuid")
        @Expose
        private String uuid;
        @SerializedName("alias")
        @Expose
        private String alias;
        @SerializedName("conference_name")
        @Expose
        private String conferenceName;
        @SerializedName("conference_uuid")
        @Expose
        private String conferenceUuid;
        @SerializedName("conference_alias")
        @Expose
        private String conferenceAlias;
        @SerializedName("created_at")
        @Expose
        private Object createdAt;
        @SerializedName("updated_at")
        @Expose
        private Object updatedAt;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUuid() {
            return uuid;
        }

        public void setUuid(String uuid) {
            this.uuid = uuid;
        }

        public String getAlias() {
            return alias;
        }

        public void setAlias(String alias) {
            this.alias = alias;
        }

        public String getConferenceName() {
            return conferenceName;
        }

        public void setConferenceName(String conferenceName) {
            this.conferenceName = conferenceName;
        }

        public String getConferenceUuid() {
            return conferenceUuid;
        }

        public void setConferenceUuid(String conferenceUuid) {
            this.conferenceUuid = conferenceUuid;
        }

        public String getConferenceAlias() {
            return conferenceAlias;
        }

        public void setConferenceAlias(String conferenceAlias) {
            this.conferenceAlias = conferenceAlias;
        }

        public Object getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(Object createdAt) {
            this.createdAt = createdAt;
        }

        public Object getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(Object updatedAt) {
            this.updatedAt = updatedAt;
        }

    }

    public class Sport {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("slug")
        @Expose
        private String slug;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("description")
        @Expose
        private String description;
        @SerializedName("is_active")
        @Expose
        private Integer isActive;
        @SerializedName("created_at")
        @Expose
        private Object createdAt;
        @SerializedName("updated_at")
        @Expose
        private Object updatedAt;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getSlug() {
            return slug;
        }

        public void setSlug(String slug) {
            this.slug = slug;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Integer getIsActive() {
            return isActive;
        }

        public void setIsActive(Integer isActive) {
            this.isActive = isActive;
        }

        public Object getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(Object createdAt) {
            this.createdAt = createdAt;
        }

        public Object getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(Object updatedAt) {
            this.updatedAt = updatedAt;
        }

    }

    public class Team {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("division_id")
        @Expose
        private Integer divisionId;
        @SerializedName("slug")
        @Expose
        private String slug;
        @SerializedName("sport_id")
        @Expose
        private Integer sportId;
        @SerializedName("uuid")
        @Expose
        private String uuid;
        @SerializedName("logo")
        @Expose
        private String logo;
        @SerializedName("team_name")
        @Expose
        private String teamName;
        @SerializedName("division")
        @Expose
        private Division division;
        @SerializedName("sport")
        @Expose
        private Sport sport;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getDivisionId() {
            return divisionId;
        }

        public void setDivisionId(Integer divisionId) {
            this.divisionId = divisionId;
        }

        public String getSlug() {
            return slug;
        }

        public void setSlug(String slug) {
            this.slug = slug;
        }

        public Integer getSportId() {
            return sportId;
        }

        public void setSportId(Integer sportId) {
            this.sportId = sportId;
        }

        public String getUuid() {
            return uuid;
        }

        public void setUuid(String uuid) {
            this.uuid = uuid;
        }

        public String getLogo() {
            return logo;
        }

        public void setLogo(String logo) {
            this.logo = logo;
        }

        public String getTeamName() {
            return teamName;
        }

        public void setTeamName(String teamName) {
            this.teamName = teamName;
        }

        public Division getDivision() {
            return division;
        }

        public void setDivision(Division division) {
            this.division = division;
        }

        public Sport getSport() {
            return sport;
        }

        public void setSport(Sport sport) {
            this.sport = sport;
        }

    }

}
