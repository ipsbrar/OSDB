package com.osdb.app.ui.player_details_screen.beans;

import java.io.Serializable;
import java.util.ArrayList;

public class PlayerDetailInfoBean implements Serializable {


    private String playerHeight, playerWeight, playerCollege, placeOfBirth, playerPosition;
    private String playerFanMailAddress, playerSportsAgent, playerTelevision, currentContract, businessVentures;
    private String endorsementDeals, communityWork, careerHighlight, jersey, draft;

    private ArrayList<CharityCommunityBeans> charityArrayList;
    private ArrayList<CharityCommunityBeans> communityArrayList;

    public ArrayList<CharityCommunityBeans> getCommunityArrayList() {
        return communityArrayList;
    }

    public void setCommunityArrayList(ArrayList<CharityCommunityBeans> communityArrayList) {
        this.communityArrayList = communityArrayList;
    }

    public ArrayList<CharityCommunityBeans> getCharityArrayList() {
        return charityArrayList;
    }

    public void setCharityArrayList(ArrayList<CharityCommunityBeans> charityArrayList) {
        this.charityArrayList = charityArrayList;
    }

    public String getJersey() {
        return jersey;
    }

    public void setJersey(String jersey) {
        this.jersey = jersey;
    }

    public String getDraft() {
        return draft;
    }

    public void setDraft(String draft) {
        this.draft = draft;
    }

    public String getPlayerHeight() {
        return playerHeight;
    }

    public void setPlayerHeight(String playerHeight) {
        this.playerHeight = playerHeight;
    }

    public String getPlayerWeight() {
        return playerWeight;
    }

    public void setPlayerWeight(String playerWeight) {
        this.playerWeight = playerWeight;
    }

    public String getPlayerCollege() {
        return playerCollege;
    }

    public void setPlayerCollege(String playerCollege) {
        this.playerCollege = playerCollege;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public String getPlayerPosition() {
        return playerPosition;
    }

    public void setPlayerPosition(String playerPosition) {
        this.playerPosition = playerPosition;
    }

    public String getPlayerFanMailAddress() {
        return playerFanMailAddress;
    }

    public void setPlayerFanMailAddress(String playerFanMailAddress) {
        this.playerFanMailAddress = playerFanMailAddress;
    }

    public String getPlayerSportsAgent() {
        return playerSportsAgent;
    }

    public void setPlayerSportsAgent(String playerSportsAgent) {
        this.playerSportsAgent = playerSportsAgent;
    }

    public String getPlayerTelevision() {
        return playerTelevision;
    }

    public void setPlayerTelevision(String playerTelevision) {
        this.playerTelevision = playerTelevision;
    }

    public String getCurrentContract() {
        return currentContract;
    }

    public void setCurrentContract(String currentContract) {
        this.currentContract = currentContract;
    }

    public String getBusinessVentures() {
        return businessVentures;
    }

    public void setBusinessVentures(String businessVentures) {
        this.businessVentures = businessVentures;
    }

    public String getEndorsementDeals() {
        return endorsementDeals;
    }

    public void setEndorsementDeals(String endorsementDeals) {
        this.endorsementDeals = endorsementDeals;
    }

    public String getCommunityWork() {
        return communityWork;
    }

    public void setCommunityWork(String communityWork) {
        this.communityWork = communityWork;
    }

    public String getCareerHighlight() {
        return careerHighlight;
    }

    public void setCareerHighlight(String careerHighlight) {
        this.careerHighlight = careerHighlight;
    }
}
