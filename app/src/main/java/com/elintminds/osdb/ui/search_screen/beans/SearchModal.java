package com.elintminds.osdb.ui.search_screen.beans;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class SearchModal {
    @SerializedName("data")
    private data mData;

    public data getMData() {
        return mData;
    }

    public void setMData(data mData) {
        this.mData = mData;
    }

    public class data {
        @SerializedName("teams")
        private ArrayList<Teams> teamArrayList;
        @SerializedName("players")
        private ArrayList<Player> playerArrayList;
        @SerializedName("news")
        private ArrayList<News> newsArrayList;

        public ArrayList<Teams> getTeamArrayList() {
            return teamArrayList;
        }

        public void setTeamArrayList(ArrayList<Teams> teamArrayList) {
            this.teamArrayList = teamArrayList;
        }

        public ArrayList<Player> getPlayerArrayList() {
            return playerArrayList;
        }

        public void setPlayerArrayList(ArrayList<Player> playerArrayList) {
            this.playerArrayList = playerArrayList;
        }

        public ArrayList<News> getNewsArrayList() {
            return newsArrayList;
        }

        public void setNewsArrayList(ArrayList<News> newsArrayList) {
            this.newsArrayList = newsArrayList;
        }
    }

    public class Team {
        @SerializedName("team_name")
        private String teamName;
        @SerializedName("team_id")
        private int teamId;
        @SerializedName("sport")
        private Sports sports;


        public String getTeamName() {
            return teamName;
        }

        public void setTeamName(String teamName) {
            this.teamName = teamName;
        }

        public int getTeamId() {
            return teamId;
        }

        public void setTeamId(int teamId) {
            this.teamId = teamId;
        }

        public Sports getSports() {
            return sports;
        }

        public void setSports(Sports sports) {
            this.sports = sports;
        }
    }

    public class Player {
        @SerializedName("id")
        private int playerId;
        @SerializedName("full_name")
        private String fullName;
        @SerializedName("team")
        private ArrayList<Team> teamArray;
        @SerializedName("headshots")
        private String proPic;

        public ArrayList<Team> getTeamArray() {
            return teamArray;
        }

        public void setTeamArray(ArrayList<Team> teamArray) {
            this.teamArray = teamArray;
        }

        public int getPlayerId() {
            return playerId;
        }

        public void setPlayerId(int playerId) {
            this.playerId = playerId;
        }

        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        public String getProPic() {
            return proPic;
        }

        public void setProPic(String proPic) {
            this.proPic = proPic;
        }
    }

    public class News {
        @SerializedName("id")
        private int newsId;
        @SerializedName("title")
        private String newsTitle;
        @SerializedName("slug")
        private String slugName;
        @SerializedName("content")
        private String shortContent;
        @SerializedName("created_at")
        private String createdAt;
        private String tags;
        @SerializedName("image_url")
        private String imageUrl;
        @SerializedName("is_breaking_news")
        private int isBreakingNews;
        @SerializedName("long_content")
        private String longContent;

        public int getNewsId() {
            return newsId;
        }

        public void setNewsId(int newsId) {
            this.newsId = newsId;
        }

        public String getNewsTitle() {
            return newsTitle;
        }

        public void setNewsTitle(String newsTitle) {
            this.newsTitle = newsTitle;
        }

        public String getSlugName() {
            return slugName;
        }

        public void setSlugName(String slugName) {
            this.slugName = slugName;
        }

        public String getShortContent() {
            return shortContent;
        }

        public void setShortContent(String shortContent) {
            this.shortContent = shortContent;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getTags() {
            return tags;
        }

        public void setTags(String tags) {
            this.tags = tags;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public int getIsBreakingNews() {
            return isBreakingNews;
        }

        public void setIsBreakingNews(int isBreakingNews) {
            this.isBreakingNews = isBreakingNews;
        }

        public String getLongContent() {
            return longContent;
        }

        public void setLongContent(String longContent) {
            this.longContent = longContent;
        }
    }

    public class Sports {
        @SerializedName("name")
        private String slugName;

        public String getSlugName() {
            return slugName;
        }

        public void setSlugName(String slugName) {
            this.slugName = slugName;
        }
    }

    public class Teams {
        @SerializedName("team_name")
        private String teamName;
        @SerializedName("id")
        private int teamId;
        private String logo;
        @SerializedName("sport")
        private Sports sports;

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

        public int getTeamId() {
            return teamId;
        }

        public void setTeamId(int teamId) {
            this.teamId = teamId;
        }

        public Sports getSports() {
            return sports;
        }

        public void setSports(Sports sports) {
            this.sports = sports;
        }
    }
}
