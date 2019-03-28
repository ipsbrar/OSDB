package com.elintminds.osdb.ui.dashboard.beans;



import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class HomeBean {

    private String error;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @SerializedName("sportsList")
        @Expose
        private ArrayList<SportsAdapterListBean> sportsList = null;
        @SerializedName("breakingNews")
        @Expose
        private ArrayList<BreakingNews> breakingNews = null;
        @SerializedName("bornToday")
        @Expose
        private ArrayList<BornToday> bornToday = null;
        @SerializedName("featuredPlayer")
        @Expose
        private ArrayList<Object> featuredPlayer = null;
//        @SerializedName("featuredPoll")
//        @Expose
//        private ArrayList<FeaturedPoll> featuredPoll = null;
        @SerializedName("didYouKnow")
        @Expose
        private ArrayList<DidYouKnow> didYouKnow = null;
//        @SerializedName("onThisDay")
//        @Expose
//        private Object onThisDay;

        public ArrayList<SportsAdapterListBean> getSportsList() {
            return sportsList;
        }

        public void setSportsList(ArrayList<SportsAdapterListBean> sportsList) {
            this.sportsList = sportsList;
        }

        public ArrayList<BreakingNews> getBreakingNews() {
            return breakingNews;
        }

        public void setBreakingNews(ArrayList<BreakingNews> breakingNews) {
            this.breakingNews = breakingNews;
        }

        public ArrayList<BornToday> getBornToday() {
            return bornToday;
        }

        public void setBornToday(ArrayList<BornToday> bornToday) {
            this.bornToday = bornToday;
        }

        public ArrayList<Object> getFeaturedPlayer() {
            return featuredPlayer;
        }

        public void setFeaturedPlayer(ArrayList<Object> featuredPlayer) {
            this.featuredPlayer = featuredPlayer;
        }

//        public ArrayList<FeaturedPoll> getFeaturedPoll() {
//            return featuredPoll;
//        }
//
//        public void setFeaturedPoll(ArrayList<FeaturedPoll> featuredPoll) {
//            this.featuredPoll = featuredPoll;
//        }

        public ArrayList<DidYouKnow> getDidYouKnow() {
            return didYouKnow;
        }

        public void setDidYouKnow(ArrayList<DidYouKnow> didYouKnow) {
            this.didYouKnow = didYouKnow;
        }

//        public Object getOnThisDay() {
//            return onThisDay;
//        }
//
//        public void setOnThisDay(Object onThisDay) {
//            this.onThisDay = onThisDay;
//        }


    public class BreakingNews {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("slug")
        @Expose
        private Object slug;
        @SerializedName("content")
        @Expose
        private String content;
        @SerializedName("source")
        @Expose
        private String source;
        @SerializedName("published_at")
        @Expose
        private String publishedAt;
        @SerializedName("created_at")
        @Expose
        private String createdAt;
        @SerializedName("updated_at")
        @Expose
        private String updatedAt;
        @SerializedName("tags")
        @Expose
        private String tags;
        @SerializedName("is_breaking_news")
        @Expose
        private Integer isBreakingNews;
        @SerializedName("is_active")
        @Expose
        private Integer isActive;
        @SerializedName("image_url")
        @Expose
        private Object imageUrl;
        @SerializedName("is_manual")
        @Expose
        private Integer isManual;
        @SerializedName("is_top_headline")
        @Expose
        private Integer isTopHeadline;
        @SerializedName("long_content")
        @Expose
        private String longContent;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Object getSlug() {
            return slug;
        }

        public void setSlug(Object slug) {
            this.slug = slug;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
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

        public String getTags() {
            return tags;
        }

        public void setTags(String tags) {
            this.tags = tags;
        }

        public Integer getIsBreakingNews() {
            return isBreakingNews;
        }

        public void setIsBreakingNews(Integer isBreakingNews) {
            this.isBreakingNews = isBreakingNews;
        }

        public Integer getIsActive() {
            return isActive;
        }

        public void setIsActive(Integer isActive) {
            this.isActive = isActive;
        }

        public Object getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(Object imageUrl) {
            this.imageUrl = imageUrl;
        }

        public Integer getIsManual() {
            return isManual;
        }

        public void setIsManual(Integer isManual) {
            this.isManual = isManual;
        }

        public Integer getIsTopHeadline() {
            return isTopHeadline;
        }

        public void setIsTopHeadline(Integer isTopHeadline) {
            this.isTopHeadline = isTopHeadline;
        }

        public String getLongContent() {
            return longContent;
        }

        public void setLongContent(String longContent) {
            this.longContent = longContent;
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


    public class BornToday {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("full_name")
        @Expose
        private String fullName;
        @SerializedName("date_of_birth")
        @Expose
        private String dateOfBirth;
        @SerializedName("age")
        @Expose
        private Integer age;
        @SerializedName("headshot")
        @Expose
        private List<Headshot> headshot = null;

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

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public List<Headshot> getHeadshot() {
            return headshot;
        }

        public void setHeadshot(List<Headshot> headshot) {
            this.headshot = headshot;
        }

    }

    public class DidYouKnow {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("content")
        @Expose
        private String content;
        @SerializedName("published_date")
        @Expose
        private String publishedDate;
        @SerializedName("created_at")
        @Expose
        private String createdAt;
        @SerializedName("updated_at")
        @Expose
        private String updatedAt;
        @SerializedName("assets")
        @Expose
        private List<Asset> assets = null;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getPublishedDate() {
            return publishedDate;
        }

        public void setPublishedDate(String publishedDate) {
            this.publishedDate = publishedDate;
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

        public List<Asset> getAssets() {
            return assets;
        }

        public void setAssets(List<Asset> assets) {
            this.assets = assets;
        }

    }



    public class Headshot {

        @SerializedName("href")
        @Expose
        private String href;
        @SerializedName("size")
        @Expose
        private String size;

        public String getHref() {
            return href;
        }

        public void setHref(String href) {
            this.href = href;
        }

        public String getSize() {
            return size;
        }

        public void setSize(String size) {
            this.size = size;
        }

    }


    public class Logo {

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
        private Object mimeType;
        @SerializedName("file_type")
        @Expose
        private Integer fileType;
        @SerializedName("entity_id")
        @Expose
        private Integer entityId;

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

        public Object getMimeType() {
            return mimeType;
        }

        public void setMimeType(Object mimeType) {
            this.mimeType = mimeType;
        }

        public Integer getFileType() {
            return fileType;
        }

        public void setFileType(Integer fileType) {
            this.fileType = fileType;
        }

        public Integer getEntityId() {
            return entityId;
        }

        public void setEntityId(Integer entityId) {
            this.entityId = entityId;
        }

    }

    public class Poll {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("text")
        @Expose
        private String text;
        @SerializedName("user_id")
        @Expose
        private Integer userId;
        @SerializedName("is_active")
        @Expose
        private Integer isActive;
        @SerializedName("published_date")
        @Expose
        private String publishedDate;
        @SerializedName("featured")
        @Expose
        private Integer featured;
        @SerializedName("created_at")
        @Expose
        private String createdAt;
        @SerializedName("updated_at")
        @Expose
        private String updatedAt;
        @SerializedName("deleted_at")
        @Expose
        private Object deletedAt;
        @SerializedName("options")
        @Expose
        private List<Option> options = null;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public Integer getUserId() {
            return userId;
        }

        public void setUserId(Integer userId) {
            this.userId = userId;
        }

        public Integer getIsActive() {
            return isActive;
        }

        public void setIsActive(Integer isActive) {
            this.isActive = isActive;
        }

        public String getPublishedDate() {
            return publishedDate;
        }

        public void setPublishedDate(String publishedDate) {
            this.publishedDate = publishedDate;
        }

        public Integer getFeatured() {
            return featured;
        }

        public void setFeatured(Integer featured) {
            this.featured = featured;
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

        public Object getDeletedAt() {
            return deletedAt;
        }

        public void setDeletedAt(Object deletedAt) {
            this.deletedAt = deletedAt;
        }

        public List<Option> getOptions() {
            return options;
        }

        public void setOptions(List<Option> options) {
            this.options = options;
        }

    }
    public class Option {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("poll_id")
        @Expose
        private Integer pollId;
        @SerializedName("text")
        @Expose
        private String text;
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

        public Integer getPollId() {
            return pollId;
        }

        public void setPollId(Integer pollId) {
            this.pollId = pollId;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
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
    public class FeaturedPoll {

        @SerializedName("poll")
        @Expose
        private Poll poll;
        @SerializedName("result")
        @Expose
        private Object result;

        public Poll getPoll() {
            return poll;
        }

        public void setPoll(Poll poll) {
            this.poll = poll;
        }

        public Object getResult() {
            return result;
        }

        public void setResult(Object result) {
            this.result = result;
        }

    }
}
