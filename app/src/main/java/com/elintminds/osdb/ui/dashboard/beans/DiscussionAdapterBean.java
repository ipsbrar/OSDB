package com.elintminds.osdb.ui.dashboard.beans;

import java.io.Serializable;
import java.util.ArrayList;

public class DiscussionAdapterBean implements Serializable {

    private ArrayList<Threads> threads;

    private String totalCount;

    public ArrayList<Threads> getThreads ()
    {
        return threads;
    }

    public void setThreads (ArrayList<Threads> threads)
    {
        this.threads = threads;
    }

    public String getTotalCount ()
    {
        return totalCount;
    }

    public void setTotalCount (String totalCount)
    {
        this.totalCount = totalCount;
    }
    
    public class Created_by implements Serializable
    {
        private Assets[] assets;

        private String name;

        private String id;

        public Assets[] getAssets ()
        {
            return assets;
        }

        public void setAssets (Assets[] assets)
        {
            this.assets = assets;
        }

        public String getName ()
        {
            return name;
        }

        public void setName (String name)
        {
            this.name = name;
        }

        public String getId ()
        {
            return id;
        }

        public void setId (String id)
        {
            this.id = id;
        }

    }
    public class Assets implements Serializable
    {
        private String entity_type;

        private String file_name;

        private String display_name;

        private String entity_id;

        public String getEntity_type ()
        {
            return entity_type;
        }

        public void setEntity_type (String entity_type)
        {
            this.entity_type = entity_type;
        }

        public String getFile_name ()
        {
            return file_name;
        }

        public void setFile_name (String file_name)
        {
            this.file_name = file_name;
        }

        public String getDisplay_name ()
    {
        return display_name;
    }

        public void setDisplay_name (String display_name)
        {
            this.display_name = display_name;
        }

        public String getEntity_id ()
        {
            return entity_id;
        }

        public void setEntity_id (String entity_id)
        {
            this.entity_id = entity_id;
        }
        
    }
    public class Threads implements Serializable
    {
        private String delete_reason;

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

        public String getDelete_reason ()
    {
        return delete_reason;
    }

        public void setDelete_reason (String delete_reason)
        {
            this.delete_reason = delete_reason;
        }

        public String getUpdated_at ()
        {
            return updated_at;
        }

        public void setUpdated_at (String updated_at)
        {
            this.updated_at = updated_at;
        }

        public String getComments_count ()
        {
            return comments_count;
        }

        public void setComments_count (String comments_count)
        {
            this.comments_count = comments_count;
        }

        public String getReports_count ()
        {
            return reports_count;
        }

        public void setReports_count (String reports_count)
        {
            this.reports_count = reports_count;
        }

        public String getDescription ()
        {
            return description;
        }

        public void setDescription (String description)
        {
            this.description = description;
        }

        public String getDeleted_by ()
    {
        return deleted_by;
    }

        public void setDeleted_by (String deleted_by)
        {
            this.deleted_by = deleted_by;
        }

        public String getCreated_at ()
        {
            return created_at;
        }

        public void setCreated_at (String created_at)
        {
            this.created_at = created_at;
        }

        public String getId ()
        {
            return id;
        }

        public void setId (String id)
        {
            this.id = id;
        }

        public String getTitle ()
        {
            return title;
        }

        public void setTitle (String title)
        {
            this.title = title;
        }

        public Created_by getCreated_by ()
        {
            return created_by;
        }

        public void setCreated_by (Created_by created_by)
        {
            this.created_by = created_by;
        }

        public String getDeleted_at ()
    {
        return deleted_at;
    }

        public void setDeleted_at (String deleted_at)
        {
            this.deleted_at = deleted_at;
        }

    }

}
