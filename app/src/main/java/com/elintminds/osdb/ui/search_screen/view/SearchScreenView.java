package com.elintminds.osdb.ui.search_screen.view;

import com.elintminds.osdb.ui.base.view.BaseView;

public interface SearchScreenView extends BaseView
{
    interface SearchItemClickListener
    {
        void onItemClick(int position);
    }
}
