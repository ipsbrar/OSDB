package com.elintminds.osdb.ui.dashboard.beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


import java.util.ArrayList;

public class NewsAdapterBean {

        @SerializedName("data")
        @Expose
        private ArrayList<Datum> data = null;
        @SerializedName("breakingNews")
        @Expose
        private ArrayList<BreakingNews> breakingNews = null;
        @SerializedName("totalCount")
        @Expose
        private Integer totalCount;

        public ArrayList<Datum> getData() {
            return data;
        }

        public void setData(ArrayList<Datum> data) {
            this.data = data;
        }

        public ArrayList<BreakingNews> getBreakingNews() {
            return breakingNews;
        }

        public void setBreakingNews(ArrayList<BreakingNews> breakingNews) {
            this.breakingNews = breakingNews;
        }

        public Integer getTotalCount() {
            return totalCount;
        }

        public void setTotalCount(Integer totalCount) {
            this.totalCount = totalCount;
        }

    public class Datum {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("slug")
        @Expose
        private String slug;
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
        @SerializedName("asset")
        @Expose
        private Asset asset;
        @SerializedName("sports")
        @Expose
        private ArrayList<Sport> sports = null;

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

        public String getSlug() {
            return slug;
        }

        public void setSlug(String slug) {
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

        public Asset getAsset() {
            return asset;
        }

        public void setAsset(Asset asset) {
            this.asset = asset;
        }

        public ArrayList<Sport> getSports() {
            return sports;
        }

        public void setSports(ArrayList<Sport> sports) {
            this.sports = sports;
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
        private Object mimeType;
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
    public class BreakingNews {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("slug")
        @Expose
        private String slug;
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

        public String getSlug() {
            return slug;
        }

        public void setSlug(String slug) {
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

    public class Sport {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("news_id")
        @Expose
        private Integer newsId;
        @SerializedName("sport_id")
        @Expose
        private Integer sportId;
        @SerializedName("tags")
        @Expose
        private Object tags;
        @SerializedName("created_at")
        @Expose
        private String createdAt;
        @SerializedName("updated_at")
        @Expose
        private String updatedAt;
        @SerializedName("sport")
        @Expose
        private Sport_ sport;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getNewsId() {
            return newsId;
        }

        public void setNewsId(Integer newsId) {
            this.newsId = newsId;
        }

        public Integer getSportId() {
            return sportId;
        }

        public void setSportId(Integer sportId) {
            this.sportId = sportId;
        }

        public Object getTags() {
            return tags;
        }

        public void setTags(Object tags) {
            this.tags = tags;
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

        public Sport_ getSport() {
            return sport;
        }

        public void setSport(Sport_ sport) {
            this.sport = sport;
        }

    }

    public class Sport_ {

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
}
