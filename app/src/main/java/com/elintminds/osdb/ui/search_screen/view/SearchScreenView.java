package com.elintminds.osdb.ui.search_screen.view;

import com.elintminds.osdb.ui.base.view.BaseView;
import com.elintminds.osdb.ui.search_screen.beans.SearchAdapterRemoteBean;
import com.elintminds.osdb.ui.search_screen.beans.SearchModal;

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
