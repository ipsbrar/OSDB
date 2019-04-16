package com.osdb.pro.ui.team_details_screen.beans;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class TeamPlayersBean
{

    @SerializedName("players")
    @Expose
    private ArrayList<Player> players = null;

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }


    public class Asset {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("file_name")
        @Expose
        private String fileName;
        @SerializedName("display_name")
        @Expose
        private String displayName;
        @SerializedName("description")
        @Expose
        private String description;
        @SerializedName("mime_type")
        @Expose
        private String mimeType;
        @SerializedName("file_type")
        @Expose
        private Integer fileType;
        @SerializedName("entity_type")
        @Expose
        private String entityType;
        @SerializedName("entity_id")
        @Expose
        private Integer entityId;
        @SerializedName("uuid")
        @Expose
        private Object uuid;
        @SerializedName("created_at")
        @Expose
        private String createdAt;
        @SerializedName("updated_at")
        @Expose
        private String updatedAt;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getFileName() {
            return fileName;
        }

        public void setFileName(String fileName) {
            this.fileName = fileName;
        }

        public String getDisplayName() {
            return displayName;
        }

        public void setDisplayName(String displayName) {
            this.displayName = displayName;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getMimeType() {
            return mimeType;
        }

        public void setMimeType(String mimeType) {
            this.mimeType = mimeType;
        }

        public Integer getFileType() {
            return fileType;
        }

        public void setFileType(Integer fileType) {
            this.fileType = fileType;
        }

        public String getEntityType() {
            return entityType;
        }

        public void setEntityType(String entityType) {
            this.entityType = entityType;
        }

        public Integer getEntityId() {
            return entityId;
        }

        public void setEntityId(Integer entityId) {
            this.entityId = entityId;
        }

        public Object getUuid() {
            return uuid;
        }

        public void setUuid(Object uuid) {
            this.uuid = uuid;
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

    }

    public class Pivot {

        @SerializedName("team_id")
        @Expose
        private Integer teamId;
        @SerializedName("player_id")
        @Expose
        private Integer playerId;

        public Integer getTeamId() {
            return teamId;
        }

        public void setTeamId(Integer teamId) {
            this.teamId = teamId;
        }

        public Integer getPlayerId() {
            return playerId;
        }

        public void setPlayerId(Integer playerId) {
            this.playerId = playerId;
        }

    }

    public class Player {

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
        @SerializedName("position")
        @Expose
        private String position;
        @SerializedName("headshots")
        @Expose
        private String headshots;
        @SerializedName("pivot")
        @Expose
        private Pivot pivot;
        @SerializedName("assets")
        @Expose
        private ArrayList<Asset> assets = null;

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

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public String getHeadshots() {
            return headshots;
        }

        public void setHeadshots(String headshots) {
            this.headshots = headshots;
        }

        public Pivot getPivot() {
            return pivot;
        }

        public void setPivot(Pivot pivot) {
            this.pivot = pivot;
        }

        public ArrayList<Asset> getAssets() {
            return assets;
        }

        public void setAssets(ArrayList<Asset> assets) {
            this.assets = assets;
        }

    }
}
