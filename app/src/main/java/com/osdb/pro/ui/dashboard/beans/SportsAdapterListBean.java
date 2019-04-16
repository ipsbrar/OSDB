package com.osdb.pro.ui.dashboard.beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class SportsAdapterListBean implements Serializable
{
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
    @SerializedName("logo")
    @Expose
    private Logo logo;

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

    public Logo getLogo() {
        return logo;
    }

    public void setLogo(Logo logo) {
        this.logo = logo;
    }

    public class Logo implements Serializable{

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

}

