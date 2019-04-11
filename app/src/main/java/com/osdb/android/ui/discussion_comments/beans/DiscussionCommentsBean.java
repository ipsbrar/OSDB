package com.osdb.android.ui.discussion_comments.beans;

import java.util.ArrayList;

public class DiscussionCommentsBean {

    private String delete_reason;

    private ArrayList<Comments> comments;

    private String updated_at;

    private String comments_count;

    private String reports_count;

    private String description;

    private String deleted_by;

    private String created_at;

    private String id;

    private String title;

    private Created_by created_by;

    private String deleted_at;

    public String getDelete_reason() {
        return delete_reason;
    }

    public void setDelete_reason(String delete_reason) {
        this.delete_reason = delete_reason;
    }

    public ArrayList<Comments> getComments() {
        return comments;
    }

    public void setComments(ArrayList<Comments> comments) {
        this.comments = comments;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getComments_count() {
        return comments_count;
    }

    public void setComments_count(String comments_count) {
        this.comments_count = comments_count;
    }

    public String getReports_count() {
        return reports_count;
    }

    public void setReports_count(String reports_count) {
        this.reports_count = reports_count;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDeleted_by() {
        return deleted_by;
    }

    public void setDeleted_by(String deleted_by) {
        this.deleted_by = deleted_by;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Created_by getCreated_by() {
        return created_by;
    }

    public void setCreated_by(Created_by created_by) {
        this.created_by = created_by;
    }

    public String getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(String deleted_at) {
        this.deleted_at = deleted_at;
    }


    public class Created_by {
        private ArrayList<Assets> assets;

        private String name;

        private String id;

        public ArrayList<Assets> getAssets() {
            return assets;
        }

        public void setAssets(ArrayList<Assets> assets) {
            this.assets = assets;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }

    public class Assets {
        private String entity_type;

        private String file_name;

        private String display_name;

        private String entity_id;

        public String getEntity_type() {
            return entity_type;
        }

        public void setEntity_type(String entity_type) {
            this.entity_type = entity_type;
        }

        public String getFile_name() {
            return file_name;
        }

        public void setFile_name(String file_name) {
            this.file_name = file_name;
        }

        public String getDisplay_name() {
            return display_name;
        }

        public void setDisplay_name(String display_name) {
            this.display_name = display_name;
        }

        public String getEntity_id() {
            return entity_id;
        }

        public void setEntity_id(String entity_id) {
            this.entity_id = entity_id;
        }

    }

    public class Comments {
        private String delete_reason;

        private String thread_id;

        private String updated_at;

        private String reports_count;

        private String deleted_by;

        private String created_at;

        private String comment;

        private String id;

        private Created_by created_by;

        private String deleted_at;

        private String parent_comment_id;

        public String getDelete_reason() {
            return delete_reason;
        }

        public void setDelete_reason(String delete_reason) {
            this.delete_reason = delete_reason;
        }

        public String getThread_id() {
            return thread_id;
        }

        public void setThread_id(String thread_id) {
            this.thread_id = thread_id;
        }

        public String getUpdated_at() {
            return updated_at;
        }

        public void setUpdated_at(String updated_at) {
            this.updated_at = updated_at;
        }

        public String getReports_count() {
            return reports_count;
        }

        public void setReports_count(String reports_count) {
            this.reports_count = reports_count;
        }

        public String getDeleted_by() {
            return deleted_by;
        }

        public void setDeleted_by(String deleted_by) {
            this.deleted_by = deleted_by;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public String getComment() {
            return comment;
        }

        public void setComment(String comment) {
            this.comment = comment;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Created_by getCreated_by() {
            return created_by;
        }

        public void setCreated_by(Created_by created_by) {
            this.created_by = created_by;
        }

        public String getDeleted_at() {
            return deleted_at;
        }

        public void setDeleted_at(String deleted_at) {
            this.deleted_at = deleted_at;
        }

        public String getParent_comment_id() {
            return parent_comment_id;
        }

        public void setParent_comment_id(String parent_comment_id) {
            this.parent_comment_id = parent_comment_id;
        }

    }
}
