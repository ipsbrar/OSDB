package com.elintminds.osdb.ui.dashboard.beans;

import java.util.ArrayList;

public class PollAdapterBean {
    private String title;
    private String options;
    private Boolean isVisible = false;


    public Boolean getVisible() {
        return isVisible;
    }

    public void setVisible(Boolean visible) {
        isVisible = visible;
    }

    private ArrayList<PollOption> pollOptions;
    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }


    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
    }



    public ArrayList<PollOption> getPollOptions() {
        return pollOptions;
    }

    public void setPollOptions(ArrayList<PollOption> pollOptions) {
        this.pollOptions = pollOptions;
    }
}
