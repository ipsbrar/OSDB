
package com.osdb.app.ui.player_details_screen.beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;


public class PlayersDetailBean {

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
    @SerializedName("is_claimed")
    @Expose
    private Boolean isClaimed;
    @SerializedName("videos")
    @Expose
    private ArrayList<Object> videos = null;
    @SerializedName("gallery")
    @Expose
    private ArrayList<Object> gallery = null;
    @SerializedName("stats")
    @Expose
    private Stats stats;
    @SerializedName("team")
    @Expose
    private ArrayList<Team> team = null;
    @SerializedName("assets")
    @Expose
    private ArrayList<Object> assets = null;
    @SerializedName("attorneys")
    @Expose
    private ArrayList<Object> attorneys = null;
    @SerializedName("records")
    @Expose
    private ArrayList<Object> records = null;
    @SerializedName("big_purchases")
    @Expose
    private ArrayList<Object> bigPurchases = null;
    @SerializedName("career_highlights")
    @Expose
    private ArrayList<Object> careerHighlights = null;
    @SerializedName("social_network")
    @Expose
    private ArrayList<Object> socialNetwork = null;
    @SerializedName("claim")
    @Expose
    private ArrayList<Object> claim = null;
    @SerializedName("banner_image")
    @Expose
    private ArrayList<Object> bannerImage = null;
    @SerializedName("bio_image")
    @Expose
    private ArrayList<Object> bioImage = null;
    @SerializedName("charity_donations")
    @Expose
    private ArrayList<Object> charityDonations = null;
    @SerializedName("community_works")
    @Expose
    private ArrayList<Object> communityWorks = null;
    @SerializedName("public_affiliations")
    @Expose
    private ArrayList<Object> publicAffiliations = null;
    @SerializedName("awards")
    @Expose
    private ArrayList<Object> awards = null;
    @SerializedName("family_info")
    @Expose
    private ArrayList<Object> familyInfo = null;
    @SerializedName("agencies")
    @Expose
    private ArrayList<Object> agencies = null;
    @SerializedName("current_contracts")
    @Expose
    private ArrayList<Object> currentContracts = null;
    @SerializedName("get_team_player")
    @Expose
    private GetTeamPlayer getTeamPlayer;

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

    public Boolean getIsClaimed() {
        return isClaimed;
    }

    public void setIsClaimed(Boolean isClaimed) {
        this.isClaimed = isClaimed;
    }

    public ArrayList<Object> getVideos() {
        return videos;
    }

    public void setVideos(ArrayList<Object> videos) {
        this.videos = videos;
    }

    public ArrayList<Object> getGallery() {
        return gallery;
    }

    public void setGallery(ArrayList<Object> gallery) {
        this.gallery = gallery;
    }

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }

    public ArrayList<Team> getTeam() {
        return team;
    }

    public void setTeam(ArrayList<Team> team) {
        this.team = team;
    }

    public ArrayList<Object> getAssets() {
        return assets;
    }

    public void setAssets(ArrayList<Object> assets) {
        this.assets = assets;
    }

    public ArrayList<Object> getAttorneys() {
        return attorneys;
    }

    public void setAttorneys(ArrayList<Object> attorneys) {
        this.attorneys = attorneys;
    }

    public ArrayList<Object> getRecords() {
        return records;
    }

    public void setRecords(ArrayList<Object> records) {
        this.records = records;
    }

    public ArrayList<Object> getBigPurchases() {
        return bigPurchases;
    }

    public void setBigPurchases(ArrayList<Object> bigPurchases) {
        this.bigPurchases = bigPurchases;
    }

    public ArrayList<Object> getCareerHighlights() {
        return careerHighlights;
    }

    public void setCareerHighlights(ArrayList<Object> careerHighlights) {
        this.careerHighlights = careerHighlights;
    }

    public ArrayList<Object> getSocialNetwork() {
        return socialNetwork;
    }

    public void setSocialNetwork(ArrayList<Object> socialNetwork) {
        this.socialNetwork = socialNetwork;
    }

    public ArrayList<Object> getClaim() {
        return claim;
    }

    public void setClaim(ArrayList<Object> claim) {
        this.claim = claim;
    }

    public ArrayList<Object> getBannerImage() {
        return bannerImage;
    }

    public void setBannerImage(ArrayList<Object> bannerImage) {
        this.bannerImage = bannerImage;
    }

    public ArrayList<Object> getBioImage() {
        return bioImage;
    }

    public void setBioImage(ArrayList<Object> bioImage) {
        this.bioImage = bioImage;
    }

    public ArrayList<Object> getCharityDonations() {
        return charityDonations;
    }

    public void setCharityDonations(ArrayList<Object> charityDonations) {
        this.charityDonations = charityDonations;
    }

    public ArrayList<Object> getCommunityWorks() {
        return communityWorks;
    }

    public void setCommunityWorks(ArrayList<Object> communityWorks) {
        this.communityWorks = communityWorks;
    }

    public ArrayList<Object> getPublicAffiliations() {
        return publicAffiliations;
    }

    public void setPublicAffiliations(ArrayList<Object> publicAffiliations) {
        this.publicAffiliations = publicAffiliations;
    }

    public ArrayList<Object> getAwards() {
        return awards;
    }

    public void setAwards(ArrayList<Object> awards) {
        this.awards = awards;
    }

    public ArrayList<Object> getFamilyInfo() {
        return familyInfo;
    }

    public void setFamilyInfo(ArrayList<Object> familyInfo) {
        this.familyInfo = familyInfo;
    }

    public ArrayList<Object> getAgencies() {
        return agencies;
    }

    public void setAgencies(ArrayList<Object> agencies) {
        this.agencies = agencies;
    }

    public ArrayList<Object> getCurrentContracts() {
        return currentContracts;
    }

    public void setCurrentContracts(ArrayList<Object> currentContracts) {
        this.currentContracts = currentContracts;
    }

    public GetTeamPlayer getGetTeamPlayer() {
        return getTeamPlayer;
    }

    public void setGetTeamPlayer(GetTeamPlayer getTeamPlayer) {
        this.getTeamPlayer = getTeamPlayer;
    }

    public class Stats {

        @SerializedName("REG")
        @Expose
        private REG rEG;

        public REG getREG() {
            return rEG;
        }

        public void setREG(REG rEG) {
            this.rEG = rEG;
        }

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
        private Object description;
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

        public Object getDescription() {
            return description;
        }

        public void setDescription(Object description) {
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

    public class Average {

//        @SerializedName("2017")
//        @Expose
//        private _2017_ _2017;
//        @SerializedName("2018")
//        @Expose
//        private _2018_ _2018;
//
//        public _2017_ get2017() {
//            return _2017;
//        }
//
//        public void set2017(_2017_ _2017) {
//            this._2017 = _2017;
//        }
//
//        public _2018_ get2018() {
//            return _2018;
//        }
//
//        public void set2018(_2018_ _2018) {
//            this._2018 = _2018;
//        }

    }


    public class GetTeamPlayer {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("player_id")
        @Expose
        private Integer playerId;
        @SerializedName("team_id")
        @Expose
        private Integer teamId;
        @SerializedName("sport_id")
        @Expose
        private Integer sportId;
        @SerializedName("year_from")
        @Expose
        private String yearFrom;
        @SerializedName("year_to")
        @Expose
        private Object yearTo;
        @SerializedName("created_at")
        @Expose
        private Object createdAt;
        @SerializedName("updated_at")
        @Expose
        private Object updatedAt;
        @SerializedName("sport")
        @Expose
        private Sport sport;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getPlayerId() {
            return playerId;
        }

        public void setPlayerId(Integer playerId) {
            this.playerId = playerId;
        }

        public Integer getTeamId() {
            return teamId;
        }

        public void setTeamId(Integer teamId) {
            this.teamId = teamId;
        }

        public Integer getSportId() {
            return sportId;
        }

        public void setSportId(Integer sportId) {
            this.sportId = sportId;
        }

        public String getYearFrom() {
            return yearFrom;
        }

        public void setYearFrom(String yearFrom) {
            this.yearFrom = yearFrom;
        }

        public Object getYearTo() {
            return yearTo;
        }

        public void setYearTo(Object yearTo) {
            this.yearTo = yearTo;
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

        public Sport getSport() {
            return sport;
        }

        public void setSport(Sport sport) {
            this.sport = sport;
        }

    }


    public class Pivot {

        @SerializedName("player_id")
        @Expose
        private Integer playerId;
        @SerializedName("team_id")
        @Expose
        private Integer teamId;

        public Integer getPlayerId() {
            return playerId;
        }

        public void setPlayerId(Integer playerId) {
            this.playerId = playerId;
        }

        public Integer getTeamId() {
            return teamId;
        }

        public void setTeamId(Integer teamId) {
            this.teamId = teamId;
        }

    }

    public class REG {

        @SerializedName("total")
        @Expose
        private Total total;
        @SerializedName("average")
        @Expose
        private Average average;

        public Total getTotal() {
            return total;
        }

        public void setTotal(Total total) {
            this.total = total;
        }

        public Average getAverage() {
            return average;
        }

        public void setAverage(Average average) {
            this.average = average;
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
        @SerializedName("slug")
        @Expose
        private String slug;
        @SerializedName("team_name")
        @Expose
        private String teamName;
        @SerializedName("sport_id")
        @Expose
        private Integer sportId;
        @SerializedName("coaches")
        @Expose
        private String coaches;
        @SerializedName("division_id")
        @Expose
        private Integer divisionId;
        @SerializedName("venue")
        @Expose
        private String venue;
        @SerializedName("meta")
        @Expose
        private String meta;
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

        public String getSlug() {
            return slug;
        }

        public void setSlug(String slug) {
            this.slug = slug;
        }

        public String getTeamName() {
            return teamName;
        }

        public void setTeamName(String teamName) {
            this.teamName = teamName;
        }

        public Integer getSportId() {
            return sportId;
        }

        public void setSportId(Integer sportId) {
            this.sportId = sportId;
        }

        public String getCoaches() {
            return coaches;
        }

        public void setCoaches(String coaches) {
            this.coaches = coaches;
        }

        public Integer getDivisionId() {
            return divisionId;
        }

        public void setDivisionId(Integer divisionId) {
            this.divisionId = divisionId;
        }

        public String getVenue() {
            return venue;
        }

        public void setVenue(String venue) {
            this.venue = venue;
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


    public class Total {

//        @SerializedName("2017")
//        @Expose
//        private com.elintminds.osdb.ui.player_details_screen.beans._2017 _2017;
//        @SerializedName("2018")
//        @Expose
//        private com.elintminds.osdb.ui.player_details_screen.beans._2018 _2018;
//
//        public com.elintminds.osdb.ui.player_details_screen.beans._2017 get2017() {
//            return _2017;
//        }
//
//        public void set2017(com.elintminds.osdb.ui.player_details_screen.beans._2017 _2017) {
//            this._2017 = _2017;
//        }
//
//        public com.elintminds.osdb.ui.player_details_screen.beans._2018 get2018() {
//            return _2018;
//        }
//
//        public void set2018(com.elintminds.osdb.ui.player_details_screen.beans._2018 _2018) {
//            this._2018 = _2018;
//        }

    }

    public class totleClass {

        @SerializedName("plus")
        @Expose
        private Integer plus;
        @SerializedName("minus")
        @Expose
        private Integer minus;
        @SerializedName("blocks")
        @Expose
        private Integer blocks;
        @SerializedName("points")
        @Expose
        private Integer points;
        @SerializedName("steals")
        @Expose
        private Integer steals;
        @SerializedName("assists")
        @Expose
        private Integer assists;
        @SerializedName("minutes")
        @Expose
        private Integer minutes;
        @SerializedName("foulouts")
        @Expose
        private Integer foulouts;
        @SerializedName("rebounds")
        @Expose
        private Integer rebounds;
        @SerializedName("ejections")
        @Expose
        private Integer ejections;
        @SerializedName("turnovers")
        @Expose
        private Integer turnovers;
        @SerializedName("efficiency")
        @Expose
        private Integer efficiency;
        @SerializedName("tech_fouls")
        @Expose
        private Integer techFouls;
        @SerializedName("blocked_att")
        @Expose
        private Integer blockedAtt;
        @SerializedName("fouls_drawn")
        @Expose
        private Integer foulsDrawn;
        @SerializedName("games_played")
        @Expose
        private Integer gamesPlayed;
        @SerializedName("games_started")
        @Expose
        private Integer gamesStarted;
        @SerializedName("double_doubles")
        @Expose
        private Integer doubleDoubles;
        @SerializedName("fast_break_att")
        @Expose
        private Integer fastBreakAtt;
        @SerializedName("fast_break_pct")
        @Expose
        private Double fastBreakPct;
        @SerializedName("fast_break_pts")
        @Expose
        private Integer fastBreakPts;
        @SerializedName("flagrant_fouls")
        @Expose
        private Integer flagrantFouls;
        @SerializedName("personal_fouls")
        @Expose
        private Integer personalFouls;
        @SerializedName("triple_doubles")
        @Expose
        private Integer tripleDoubles;
        @SerializedName("two_points_att")
        @Expose
        private Integer twoPointsAtt;
        @SerializedName("two_points_pct")
        @Expose
        private Double twoPointsPct;
        @SerializedName("coach_ejections")
        @Expose
        private Integer coachEjections;
        @SerializedName("fast_break_made")
        @Expose
        private Integer fastBreakMade;
        @SerializedName("field_goals_att")
        @Expose
        private Integer fieldGoalsAtt;
        @SerializedName("field_goals_pct")
        @Expose
        private Double fieldGoalsPct;
        @SerializedName("free_throws_att")
        @Expose
        private Integer freeThrowsAtt;
        @SerializedName("free_throws_pct")
        @Expose
        private Double freeThrowsPct;
        @SerializedName("offensive_fouls")
        @Expose
        private Integer offensiveFouls;
        @SerializedName("points_in_paint")
        @Expose
        private Integer pointsInPaint;
        @SerializedName("two_points_made")
        @Expose
        private Integer twoPointsMade;
        @SerializedName("coach_tech_fouls")
        @Expose
        private Integer coachTechFouls;
        @SerializedName("effective_fg_pct")
        @Expose
        private Double effectiveFgPct;
        @SerializedName("field_goals_made")
        @Expose
        private Integer fieldGoalsMade;
        @SerializedName("free_throws_made")
        @Expose
        private Integer freeThrowsMade;
        @SerializedName("three_points_att")
        @Expose
        private Integer threePointsAtt;
        @SerializedName("three_points_pct")
        @Expose
        private Double threePointsPct;
        @SerializedName("second_chance_att")
        @Expose
        private Integer secondChanceAtt;
        @SerializedName("second_chance_pct")
        @Expose
        private Integer secondChancePct;
        @SerializedName("second_chance_pts")
        @Expose
        private Integer secondChancePts;
        @SerializedName("three_points_made")
        @Expose
        private Integer threePointsMade;
        @SerializedName("true_shooting_att")
        @Expose
        private Double trueShootingAtt;
        @SerializedName("true_shooting_pct")
        @Expose
        private Double trueShootingPct;
        @SerializedName("defensive_rebounds")
        @Expose
        private Integer defensiveRebounds;
        @SerializedName("offensive_rebounds")
        @Expose
        private Integer offensiveRebounds;
        @SerializedName("second_chance_made")
        @Expose
        private Integer secondChanceMade;
        @SerializedName("points_in_paint_att")
        @Expose
        private Integer pointsInPaintAtt;
        @SerializedName("points_in_paint_pct")
        @Expose
        private Double pointsInPaintPct;
        @SerializedName("points_in_paint_made")
        @Expose
        private Integer pointsInPaintMade;
        @SerializedName("points_off_turnovers")
        @Expose
        private Integer pointsOffTurnovers;
        @SerializedName("assists_turnover_ratio")
        @Expose
        private Integer assistsTurnoverRatio;

        public Integer getPlus() {
            return plus;
        }

        public void setPlus(Integer plus) {
            this.plus = plus;
        }

        public Integer getMinus() {
            return minus;
        }

        public void setMinus(Integer minus) {
            this.minus = minus;
        }

        public Integer getBlocks() {
            return blocks;
        }

        public void setBlocks(Integer blocks) {
            this.blocks = blocks;
        }

        public Integer getPoints() {
            return points;
        }

        public void setPoints(Integer points) {
            this.points = points;
        }

        public Integer getSteals() {
            return steals;
        }

        public void setSteals(Integer steals) {
            this.steals = steals;
        }

        public Integer getAssists() {
            return assists;
        }

        public void setAssists(Integer assists) {
            this.assists = assists;
        }

        public Integer getMinutes() {
            return minutes;
        }

        public void setMinutes(Integer minutes) {
            this.minutes = minutes;
        }

        public Integer getFoulouts() {
            return foulouts;
        }

        public void setFoulouts(Integer foulouts) {
            this.foulouts = foulouts;
        }

        public Integer getRebounds() {
            return rebounds;
        }

        public void setRebounds(Integer rebounds) {
            this.rebounds = rebounds;
        }

        public Integer getEjections() {
            return ejections;
        }

        public void setEjections(Integer ejections) {
            this.ejections = ejections;
        }

        public Integer getTurnovers() {
            return turnovers;
        }

        public void setTurnovers(Integer turnovers) {
            this.turnovers = turnovers;
        }

        public Integer getEfficiency() {
            return efficiency;
        }

        public void setEfficiency(Integer efficiency) {
            this.efficiency = efficiency;
        }

        public Integer getTechFouls() {
            return techFouls;
        }

        public void setTechFouls(Integer techFouls) {
            this.techFouls = techFouls;
        }

        public Integer getBlockedAtt() {
            return blockedAtt;
        }

        public void setBlockedAtt(Integer blockedAtt) {
            this.blockedAtt = blockedAtt;
        }

        public Integer getFoulsDrawn() {
            return foulsDrawn;
        }

        public void setFoulsDrawn(Integer foulsDrawn) {
            this.foulsDrawn = foulsDrawn;
        }

        public Integer getGamesPlayed() {
            return gamesPlayed;
        }

        public void setGamesPlayed(Integer gamesPlayed) {
            this.gamesPlayed = gamesPlayed;
        }

        public Integer getGamesStarted() {
            return gamesStarted;
        }

        public void setGamesStarted(Integer gamesStarted) {
            this.gamesStarted = gamesStarted;
        }

        public Integer getDoubleDoubles() {
            return doubleDoubles;
        }

        public void setDoubleDoubles(Integer doubleDoubles) {
            this.doubleDoubles = doubleDoubles;
        }

        public Integer getFastBreakAtt() {
            return fastBreakAtt;
        }

        public void setFastBreakAtt(Integer fastBreakAtt) {
            this.fastBreakAtt = fastBreakAtt;
        }

        public Double getFastBreakPct() {
            return fastBreakPct;
        }

        public void setFastBreakPct(Double fastBreakPct) {
            this.fastBreakPct = fastBreakPct;
        }

        public Integer getFastBreakPts() {
            return fastBreakPts;
        }

        public void setFastBreakPts(Integer fastBreakPts) {
            this.fastBreakPts = fastBreakPts;
        }

        public Integer getFlagrantFouls() {
            return flagrantFouls;
        }

        public void setFlagrantFouls(Integer flagrantFouls) {
            this.flagrantFouls = flagrantFouls;
        }

        public Integer getPersonalFouls() {
            return personalFouls;
        }

        public void setPersonalFouls(Integer personalFouls) {
            this.personalFouls = personalFouls;
        }

        public Integer getTripleDoubles() {
            return tripleDoubles;
        }

        public void setTripleDoubles(Integer tripleDoubles) {
            this.tripleDoubles = tripleDoubles;
        }

        public Integer getTwoPointsAtt() {
            return twoPointsAtt;
        }

        public void setTwoPointsAtt(Integer twoPointsAtt) {
            this.twoPointsAtt = twoPointsAtt;
        }

        public Double getTwoPointsPct() {
            return twoPointsPct;
        }

        public void setTwoPointsPct(Double twoPointsPct) {
            this.twoPointsPct = twoPointsPct;
        }

        public Integer getCoachEjections() {
            return coachEjections;
        }

        public void setCoachEjections(Integer coachEjections) {
            this.coachEjections = coachEjections;
        }

        public Integer getFastBreakMade() {
            return fastBreakMade;
        }

        public void setFastBreakMade(Integer fastBreakMade) {
            this.fastBreakMade = fastBreakMade;
        }

        public Integer getFieldGoalsAtt() {
            return fieldGoalsAtt;
        }

        public void setFieldGoalsAtt(Integer fieldGoalsAtt) {
            this.fieldGoalsAtt = fieldGoalsAtt;
        }

        public Double getFieldGoalsPct() {
            return fieldGoalsPct;
        }

        public void setFieldGoalsPct(Double fieldGoalsPct) {
            this.fieldGoalsPct = fieldGoalsPct;
        }

        public Integer getFreeThrowsAtt() {
            return freeThrowsAtt;
        }

        public void setFreeThrowsAtt(Integer freeThrowsAtt) {
            this.freeThrowsAtt = freeThrowsAtt;
        }

        public Double getFreeThrowsPct() {
            return freeThrowsPct;
        }

        public void setFreeThrowsPct(Double freeThrowsPct) {
            this.freeThrowsPct = freeThrowsPct;
        }

        public Integer getOffensiveFouls() {
            return offensiveFouls;
        }

        public void setOffensiveFouls(Integer offensiveFouls) {
            this.offensiveFouls = offensiveFouls;
        }

        public Integer getPointsInPaint() {
            return pointsInPaint;
        }

        public void setPointsInPaint(Integer pointsInPaint) {
            this.pointsInPaint = pointsInPaint;
        }

        public Integer getTwoPointsMade() {
            return twoPointsMade;
        }

        public void setTwoPointsMade(Integer twoPointsMade) {
            this.twoPointsMade = twoPointsMade;
        }

        public Integer getCoachTechFouls() {
            return coachTechFouls;
        }

        public void setCoachTechFouls(Integer coachTechFouls) {
            this.coachTechFouls = coachTechFouls;
        }

        public Double getEffectiveFgPct() {
            return effectiveFgPct;
        }

        public void setEffectiveFgPct(Double effectiveFgPct) {
            this.effectiveFgPct = effectiveFgPct;
        }

        public Integer getFieldGoalsMade() {
            return fieldGoalsMade;
        }

        public void setFieldGoalsMade(Integer fieldGoalsMade) {
            this.fieldGoalsMade = fieldGoalsMade;
        }

        public Integer getFreeThrowsMade() {
            return freeThrowsMade;
        }

        public void setFreeThrowsMade(Integer freeThrowsMade) {
            this.freeThrowsMade = freeThrowsMade;
        }

        public Integer getThreePointsAtt() {
            return threePointsAtt;
        }

        public void setThreePointsAtt(Integer threePointsAtt) {
            this.threePointsAtt = threePointsAtt;
        }

        public Double getThreePointsPct() {
            return threePointsPct;
        }

        public void setThreePointsPct(Double threePointsPct) {
            this.threePointsPct = threePointsPct;
        }

        public Integer getSecondChanceAtt() {
            return secondChanceAtt;
        }

        public void setSecondChanceAtt(Integer secondChanceAtt) {
            this.secondChanceAtt = secondChanceAtt;
        }

        public Integer getSecondChancePct() {
            return secondChancePct;
        }

        public void setSecondChancePct(Integer secondChancePct) {
            this.secondChancePct = secondChancePct;
        }

        public Integer getSecondChancePts() {
            return secondChancePts;
        }

        public void setSecondChancePts(Integer secondChancePts) {
            this.secondChancePts = secondChancePts;
        }

        public Integer getThreePointsMade() {
            return threePointsMade;
        }

        public void setThreePointsMade(Integer threePointsMade) {
            this.threePointsMade = threePointsMade;
        }

        public Double getTrueShootingAtt() {
            return trueShootingAtt;
        }

        public void setTrueShootingAtt(Double trueShootingAtt) {
            this.trueShootingAtt = trueShootingAtt;
        }

        public Double getTrueShootingPct() {
            return trueShootingPct;
        }

        public void setTrueShootingPct(Double trueShootingPct) {
            this.trueShootingPct = trueShootingPct;
        }

        public Integer getDefensiveRebounds() {
            return defensiveRebounds;
        }

        public void setDefensiveRebounds(Integer defensiveRebounds) {
            this.defensiveRebounds = defensiveRebounds;
        }

        public Integer getOffensiveRebounds() {
            return offensiveRebounds;
        }

        public void setOffensiveRebounds(Integer offensiveRebounds) {
            this.offensiveRebounds = offensiveRebounds;
        }

        public Integer getSecondChanceMade() {
            return secondChanceMade;
        }

        public void setSecondChanceMade(Integer secondChanceMade) {
            this.secondChanceMade = secondChanceMade;
        }

        public Integer getPointsInPaintAtt() {
            return pointsInPaintAtt;
        }

        public void setPointsInPaintAtt(Integer pointsInPaintAtt) {
            this.pointsInPaintAtt = pointsInPaintAtt;
        }

        public Double getPointsInPaintPct() {
            return pointsInPaintPct;
        }

        public void setPointsInPaintPct(Double pointsInPaintPct) {
            this.pointsInPaintPct = pointsInPaintPct;
        }

        public Integer getPointsInPaintMade() {
            return pointsInPaintMade;
        }

        public void setPointsInPaintMade(Integer pointsInPaintMade) {
            this.pointsInPaintMade = pointsInPaintMade;
        }

        public Integer getPointsOffTurnovers() {
            return pointsOffTurnovers;
        }

        public void setPointsOffTurnovers(Integer pointsOffTurnovers) {
            this.pointsOffTurnovers = pointsOffTurnovers;
        }

        public Integer getAssistsTurnoverRatio() {
            return assistsTurnoverRatio;
        }

        public void setAssistsTurnoverRatio(Integer assistsTurnoverRatio) {
            this.assistsTurnoverRatio = assistsTurnoverRatio;
        }

    }

    public class avarageClass {

        @SerializedName("blocks")
        @Expose
        private Double blocks;
        @SerializedName("points")
        @Expose
        private Double points;
        @SerializedName("steals")
        @Expose
        private Double steals;
        @SerializedName("assists")
        @Expose
        private Double assists;
        @SerializedName("minutes")
        @Expose
        private Double minutes;
        @SerializedName("rebounds")
        @Expose
        private Double rebounds;
        @SerializedName("turnovers")
        @Expose
        private Double turnovers;
        @SerializedName("efficiency")
        @Expose
        private Double efficiency;
        @SerializedName("blocked_att")
        @Expose
        private Integer blockedAtt;
        @SerializedName("fouls_drawn")
        @Expose
        private Double foulsDrawn;
        @SerializedName("def_rebounds")
        @Expose
        private Double defRebounds;
        @SerializedName("off_rebounds")
        @Expose
        private Double offRebounds;
        @SerializedName("fast_break_att")
        @Expose
        private Double fastBreakAtt;
        @SerializedName("fast_break_pts")
        @Expose
        private Double fastBreakPts;
        @SerializedName("flagrant_fouls")
        @Expose
        private Integer flagrantFouls;
        @SerializedName("personal_fouls")
        @Expose
        private Double personalFouls;
        @SerializedName("two_points_att")
        @Expose
        private Double twoPointsAtt;
        @SerializedName("fast_break_made")
        @Expose
        private Double fastBreakMade;
        @SerializedName("field_goals_att")
        @Expose
        private Double fieldGoalsAtt;
        @SerializedName("free_throws_att")
        @Expose
        private Double freeThrowsAtt;
        @SerializedName("offensive_fouls")
        @Expose
        private Double offensiveFouls;
        @SerializedName("points_in_paint")
        @Expose
        private Double pointsInPaint;
        @SerializedName("two_points_made")
        @Expose
        private Double twoPointsMade;
        @SerializedName("field_goals_made")
        @Expose
        private Double fieldGoalsMade;
        @SerializedName("free_throws_made")
        @Expose
        private Double freeThrowsMade;
        @SerializedName("three_points_att")
        @Expose
        private Double threePointsAtt;
        @SerializedName("second_chance_att")
        @Expose
        private Integer secondChanceAtt;
        @SerializedName("second_chance_pts")
        @Expose
        private Double secondChancePts;
        @SerializedName("three_points_made")
        @Expose
        private Double threePointsMade;
        @SerializedName("true_shooting_att")
        @Expose
        private Double trueShootingAtt;
        @SerializedName("second_chance_made")
        @Expose
        private Integer secondChanceMade;
        @SerializedName("points_in_paint_att")
        @Expose
        private Double pointsInPaintAtt;
        @SerializedName("points_in_paint_made")
        @Expose
        private Double pointsInPaintMade;
        @SerializedName("points_off_turnovers")
        @Expose
        private Double pointsOffTurnovers;

        public Double getBlocks() {
            return blocks;
        }

        public void setBlocks(Double blocks) {
            this.blocks = blocks;
        }

        public Double getPoints() {
            return points;
        }

        public void setPoints(Double points) {
            this.points = points;
        }

        public Double getSteals() {
            return steals;
        }

        public void setSteals(Double steals) {
            this.steals = steals;
        }

        public Double getAssists() {
            return assists;
        }

        public void setAssists(Double assists) {
            this.assists = assists;
        }

        public Double getMinutes() {
            return minutes;
        }

        public void setMinutes(Double minutes) {
            this.minutes = minutes;
        }

        public Double getRebounds() {
            return rebounds;
        }

        public void setRebounds(Double rebounds) {
            this.rebounds = rebounds;
        }

        public Double getTurnovers() {
            return turnovers;
        }

        public void setTurnovers(Double turnovers) {
            this.turnovers = turnovers;
        }

        public Double getEfficiency() {
            return efficiency;
        }

        public void setEfficiency(Double efficiency) {
            this.efficiency = efficiency;
        }

        public Integer getBlockedAtt() {
            return blockedAtt;
        }

        public void setBlockedAtt(Integer blockedAtt) {
            this.blockedAtt = blockedAtt;
        }

        public Double getFoulsDrawn() {
            return foulsDrawn;
        }

        public void setFoulsDrawn(Double foulsDrawn) {
            this.foulsDrawn = foulsDrawn;
        }

        public Double getDefRebounds() {
            return defRebounds;
        }

        public void setDefRebounds(Double defRebounds) {
            this.defRebounds = defRebounds;
        }

        public Double getOffRebounds() {
            return offRebounds;
        }

        public void setOffRebounds(Double offRebounds) {
            this.offRebounds = offRebounds;
        }

        public Double getFastBreakAtt() {
            return fastBreakAtt;
        }

        public void setFastBreakAtt(Double fastBreakAtt) {
            this.fastBreakAtt = fastBreakAtt;
        }

        public Double getFastBreakPts() {
            return fastBreakPts;
        }

        public void setFastBreakPts(Double fastBreakPts) {
            this.fastBreakPts = fastBreakPts;
        }

        public Integer getFlagrantFouls() {
            return flagrantFouls;
        }

        public void setFlagrantFouls(Integer flagrantFouls) {
            this.flagrantFouls = flagrantFouls;
        }

        public Double getPersonalFouls() {
            return personalFouls;
        }

        public void setPersonalFouls(Double personalFouls) {
            this.personalFouls = personalFouls;
        }

        public Double getTwoPointsAtt() {
            return twoPointsAtt;
        }

        public void setTwoPointsAtt(Double twoPointsAtt) {
            this.twoPointsAtt = twoPointsAtt;
        }

        public Double getFastBreakMade() {
            return fastBreakMade;
        }

        public void setFastBreakMade(Double fastBreakMade) {
            this.fastBreakMade = fastBreakMade;
        }

        public Double getFieldGoalsAtt() {
            return fieldGoalsAtt;
        }

        public void setFieldGoalsAtt(Double fieldGoalsAtt) {
            this.fieldGoalsAtt = fieldGoalsAtt;
        }

        public Double getFreeThrowsAtt() {
            return freeThrowsAtt;
        }

        public void setFreeThrowsAtt(Double freeThrowsAtt) {
            this.freeThrowsAtt = freeThrowsAtt;
        }

        public Double getOffensiveFouls() {
            return offensiveFouls;
        }

        public void setOffensiveFouls(Double offensiveFouls) {
            this.offensiveFouls = offensiveFouls;
        }

        public Double getPointsInPaint() {
            return pointsInPaint;
        }

        public void setPointsInPaint(Double pointsInPaint) {
            this.pointsInPaint = pointsInPaint;
        }

        public Double getTwoPointsMade() {
            return twoPointsMade;
        }

        public void setTwoPointsMade(Double twoPointsMade) {
            this.twoPointsMade = twoPointsMade;
        }

        public Double getFieldGoalsMade() {
            return fieldGoalsMade;
        }

        public void setFieldGoalsMade(Double fieldGoalsMade) {
            this.fieldGoalsMade = fieldGoalsMade;
        }

        public Double getFreeThrowsMade() {
            return freeThrowsMade;
        }

        public void setFreeThrowsMade(Double freeThrowsMade) {
            this.freeThrowsMade = freeThrowsMade;
        }

        public Double getThreePointsAtt() {
            return threePointsAtt;
        }

        public void setThreePointsAtt(Double threePointsAtt) {
            this.threePointsAtt = threePointsAtt;
        }

        public Integer getSecondChanceAtt() {
            return secondChanceAtt;
        }

        public void setSecondChanceAtt(Integer secondChanceAtt) {
            this.secondChanceAtt = secondChanceAtt;
        }

        public Double getSecondChancePts() {
            return secondChancePts;
        }

        public void setSecondChancePts(Double secondChancePts) {
            this.secondChancePts = secondChancePts;
        }

        public Double getThreePointsMade() {
            return threePointsMade;
        }

        public void setThreePointsMade(Double threePointsMade) {
            this.threePointsMade = threePointsMade;
        }

        public Double getTrueShootingAtt() {
            return trueShootingAtt;
        }

        public void setTrueShootingAtt(Double trueShootingAtt) {
            this.trueShootingAtt = trueShootingAtt;
        }

        public Integer getSecondChanceMade() {
            return secondChanceMade;
        }

        public void setSecondChanceMade(Integer secondChanceMade) {
            this.secondChanceMade = secondChanceMade;
        }

        public Double getPointsInPaintAtt() {
            return pointsInPaintAtt;
        }

        public void setPointsInPaintAtt(Double pointsInPaintAtt) {
            this.pointsInPaintAtt = pointsInPaintAtt;
        }

        public Double getPointsInPaintMade() {
            return pointsInPaintMade;
        }

        public void setPointsInPaintMade(Double pointsInPaintMade) {
            this.pointsInPaintMade = pointsInPaintMade;
        }

        public Double getPointsOffTurnovers() {
            return pointsOffTurnovers;
        }

        public void setPointsOffTurnovers(Double pointsOffTurnovers) {
            this.pointsOffTurnovers = pointsOffTurnovers;
        }

    }


}









