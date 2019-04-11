package com.osdb.android.ui.dashboard.Interfaces;

public interface DiscussionOnClick {
    void discussionOnClick(String id,String name,String comment ,String time,String filepath,String commentNumber);
    void discussionReportOnClick(int pos, String id);
}
