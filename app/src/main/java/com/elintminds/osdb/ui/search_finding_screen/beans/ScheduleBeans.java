package com.elintminds.osdb.ui.search_finding_screen.beans;

import java.util.ArrayList;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;



public class ScheduleBeans {

    @SerializedName("schedules")
    @Expose
    private ArrayList<Schedule> schedules = null;

    public ArrayList<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(ArrayList<Schedule> schedules) {
        this.schedules = schedules;
    }
    public class Game {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("scheduled_date_time")
        @Expose
        private String scheduledDateTime;
        @SerializedName("venue")
        @Expose
        private String venue;
        @SerializedName("game_type")
        @Expose
        private Integer gameType;
        @SerializedName("game_status")
        @Expose
        private String gameStatus;
        @SerializedName("schedule_id")
        @Expose
        private Integer scheduleId;
        @SerializedName("week_sequence")
        @Expose
        private String weekSequence;
        @SerializedName("week_title")
        @Expose
        private String weekTitle;
        @SerializedName("meta")
        @Expose
        private String meta;
        @SerializedName("sport_id")
        @Expose
        private Integer sportId;
        @SerializedName("uuid")
        @Expose
        private String uuid;
        @SerializedName("is_active")
        @Expose
        private Integer isActive;
        @SerializedName("created_at")
        @Expose
        private String createdAt;
        @SerializedName("updated_at")
        @Expose
        private String updatedAt;
        @SerializedName("participants")
        @Expose
        private ArrayList<Participant> participants = null;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getScheduledDateTime() {
            return scheduledDateTime;
        }

        public void setScheduledDateTime(String scheduledDateTime) {
            this.scheduledDateTime = scheduledDateTime;
        }

        public String getVenue() {
            return venue;
        }

        public void setVenue(String venue) {
            this.venue = venue;
        }

        public Integer getGameType() {
            return gameType;
        }

        public void setGameType(Integer gameType) {
            this.gameType = gameType;
        }

        public String getGameStatus() {
            return gameStatus;
        }

        public void setGameStatus(String gameStatus) {
            this.gameStatus = gameStatus;
        }

        public Integer getScheduleId() {
            return scheduleId;
        }

        public void setScheduleId(Integer scheduleId) {
            this.scheduleId = scheduleId;
        }

        public String getWeekSequence() {
            return weekSequence;
        }

        public void setWeekSequence(String weekSequence) {
            this.weekSequence = weekSequence;
        }

        public String getWeekTitle() {
            return weekTitle;
        }

        public void setWeekTitle(String weekTitle) {
            this.weekTitle = weekTitle;
        }

        public String getMeta() {
            return meta;
        }

        public void setMeta(String meta) {
            this.meta = meta;
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

        public Integer getIsActive() {
            return isActive;
        }

        public void setIsActive(Integer isActive) {
            this.isActive = isActive;
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

        public ArrayList<Participant> getParticipants() {
            return participants;
        }

        public void setParticipants(ArrayList<Participant> participants) {
            this.participants = participants;
        }

    }


    public class Participant {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("game_id")
        @Expose
        private Integer gameId;
        @SerializedName("participant_id")
        @Expose
        private Integer participantId;
        @SerializedName("position")
        @Expose
        private Integer position;
        @SerializedName("qualifier")
        @Expose
        private Integer qualifier;
        @SerializedName("created_at")
        @Expose
        private String createdAt;
        @SerializedName("updated_at")
        @Expose
        private String updatedAt;
        @SerializedName("teams")
        @Expose
        private Teams teams;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getGameId() {
            return gameId;
        }

        public void setGameId(Integer gameId) {
            this.gameId = gameId;
        }

        public Integer getParticipantId() {
            return participantId;
        }

        public void setParticipantId(Integer participantId) {
            this.participantId = participantId;
        }

        public Integer getPosition() {
            return position;
        }

        public void setPosition(Integer position) {
            this.position = position;
        }

        public Integer getQualifier() {
            return qualifier;
        }

        public void setQualifier(Integer qualifier) {
            this.qualifier = qualifier;
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

        public Teams getTeams() {
            return teams;
        }

        public void setTeams(Teams teams) {
            this.teams = teams;
        }

    }

    public class Schedule {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("sport_id")
        @Expose
        private Integer sportId;
        @SerializedName("year")
        @Expose
        private String year;
        @SerializedName("type")
        @Expose
        private String type;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("created_at")
        @Expose
        private String createdAt;
        @SerializedName("updated_at")
        @Expose
        private String updatedAt;
        @SerializedName("games")
        @Expose
        private ArrayList<Game> games = null;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getSportId() {
            return sportId;
        }

        public void setSportId(Integer sportId) {
            this.sportId = sportId;
        }

        public String getYear() {
            return year;
        }

        public void setYear(String year) {
            this.year = year;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
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

        public ArrayList<Game> getGames() {
            return games;
        }

        public void setGames(ArrayList<Game> games) {
            this.games = games;
        }

    }

    public class Teams {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("team_name")
        @Expose
        private String teamName;
        @SerializedName("logo")
        @Expose
        private String logo;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getTeamName() {
            return teamName;
        }

        public void setTeamName(String teamName) {
            this.teamName = teamName;
        }

        public String getLogo() {
            return logo;
        }

        public void setLogo(String logo) {
            this.logo = logo;
        }

    }

}

