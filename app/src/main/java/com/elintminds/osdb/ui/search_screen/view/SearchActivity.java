package com.elintminds.osdb.ui.search_screen.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import com.elintminds.osdb.R;
import com.elintminds.osdb.ui.base.view.BaseActivity;
import com.elintminds.osdb.ui.search_finding_screen.view.SearchFindingsActivity;
import com.elintminds.osdb.ui.search_screen.adapters.SearchAdapter;
import com.elintminds.osdb.ui.search_screen.beans.SearchBean;

import java.util.ArrayList;

public class SearchActivity extends BaseActivity implements SearchScreenView, SearchScreenView.SearchItemClickListener {
    private Toolbar toolbar;
    private EditText searchET;
    private RecyclerView searchRV;
    private SearchAdapter adapter;
    private ArrayList<SearchBean> dataList = new ArrayList<>();
    private String[] searchSampleData = {"Blackhawks", "Aaron Rodgers", "Australian Open"};

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        initializeViews();

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        setUpRecyclerView();
    }

    private void initializeViews()
    {
        toolbar = findViewById(R.id.search_toolbar);
        searchET = findViewById(R.id.searchET);
        searchRV = findViewById(R.id.search_recyclerView);
    }

    private void setUpRecyclerView()
    {
        getSearchData();
        adapter = new SearchAdapter(this, dataList, this);
        searchRV.setAdapter(adapter);
    }

    private void getSearchData()
    {
        SearchBean itemBean;
        itemBean = new SearchBean();
        itemBean.setSearchType(SearchAdapter.HEADING_TYPE);
        itemBean.setSearchName("Recent");
        dataList.add(itemBean);
        for(String searchItem : searchSampleData)
        {
            itemBean = new SearchBean();
            itemBean.setSearchType(SearchAdapter.ITEM_TYPE);
            itemBean.setSearchName(searchItem);
            dataList.add(itemBean);
        }

        itemBean = new SearchBean();
        itemBean.setSearchType(SearchAdapter.HEADING_TYPE);
        itemBean.setSearchName("Suggestions");
        dataList.add(itemBean);
        for(String searchItem : searchSampleData)
        {
            itemBean = new SearchBean();
            itemBean.setSearchType(SearchAdapter.ITEM_TYPE);
            itemBean.setSearchName(searchItem);
            dataList.add(itemBean);
        }
    }

    @Override
    public void onItemClick(int position)
    {
        Intent intent = new Intent(this, SearchFindingsActivity.class);
        intent.putExtra("TITLE", dataList.get(position).getSearchName());
        startActivity(intent);
    }
}
