package com.osdb.app.ui.search_screen.view;

import com.osdb.app.ui.base.view.BaseView;
import com.osdb.app.ui.search_screen.beans.SearchAdapterRemoteBean;

import java.util.ArrayList;

public interface SearchScreenView extends BaseView
{
    interface SearchItemClickListener
    {
        void onItemClick(int position ,String type);
        void onItemClickRemote(SearchAdapterRemoteBean searchAdapterRemoteBean);
    }

    void searchOnClick(ArrayList<SearchAdapterRemoteBean> searchModal);
    void getError(String error);
}
