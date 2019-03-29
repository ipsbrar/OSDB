package com.elintminds.osdb.ui.search_screen.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.elintminds.osdb.R;
import com.elintminds.osdb.ui.base.view.BaseActivity;
import com.elintminds.osdb.ui.detailview.view.DetailActivity;
import com.elintminds.osdb.ui.player_details_screen.view.PlayerDetailsActivity;
import com.elintminds.osdb.ui.search_finding_screen.view.SearchFindingsActivity;
import com.elintminds.osdb.ui.search_screen.adapters.SearchAdapter;
import com.elintminds.osdb.ui.search_screen.adapters.SearchAdapterRemote;
import com.elintminds.osdb.ui.search_screen.beans.SearchAdapterRemoteBean;
import com.elintminds.osdb.ui.search_screen.beans.SearchBean;
import com.elintminds.osdb.ui.search_screen.beans.SearchModal;
import com.elintminds.osdb.ui.search_screen.presenter.SearchScreenPresenterClass;

import java.util.ArrayList;

public class SearchActivity extends BaseActivity implements SearchScreenView, SearchScreenView.SearchItemClickListener {
    private Toolbar toolbar;
    private EditText searchET;
    private RecyclerView searchRV, search_recyclerView_remote;
    private SearchAdapter adapter;
    private ArrayList<SearchBean> dataList = new ArrayList<>();
    private String[] searchSampleData = {"Blackhawks", "Aaron Rodgers", "Australian Open"};
    private SearchScreenPresenterClass searchScreenPresenterClass;
    private SearchAdapterRemote searchAdapterRemote;
    private ArrayList<SearchAdapterRemoteBean> searchAdapterRemoteBeanArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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

    private void initializeViews() {
        toolbar = findViewById(R.id.search_toolbar);
        searchET = findViewById(R.id.searchET);
        searchRV = findViewById(R.id.search_recyclerView);
        search_recyclerView_remote = findViewById(R.id.search_recyclerView_remote);
        searchRV.setVisibility(View.VISIBLE);
        search_recyclerView_remote.setVisibility(View.GONE);
    }

    private void setUpRecyclerView() {
        searchScreenPresenterClass = new SearchScreenPresenterClass(this, this);

        getSearchData();
        adapter = new SearchAdapter(this, dataList, this);
        searchRV.setAdapter(adapter);

        searchAdapterRemote = new SearchAdapterRemote(searchAdapterRemoteBeanArrayList, this, this);
        search_recyclerView_remote.setAdapter(searchAdapterRemote);


        searchET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Log.e("EditTextChanged", s + "  " + start + "  " + count + "  " + after);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.e("EditTextChanged", s + "  " + start + "  " + count + "  ");
                if (s.toString().length() >= 3) {
                    Log.e("EditTextChanged", "Search is working");
                    searchScreenPresenterClass.getSearchData(s.toString(), "0");
                } else {
                    searchRV.setVisibility(View.VISIBLE);
                    search_recyclerView_remote.setVisibility(View.GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.e("EditTextChanged", s.toString());

            }
        });
    }

    private void getSearchData() {
        SearchBean itemBean;
        itemBean = new SearchBean();
        itemBean.setSearchType(SearchAdapter.HEADING_TYPE);
        itemBean.setSearchName("Recent");
        dataList.add(itemBean);
        for (String searchItem : searchSampleData) {
            itemBean = new SearchBean();
            itemBean.setSearchType(SearchAdapter.ITEM_TYPE);
            itemBean.setSearchName(searchItem);
            dataList.add(itemBean);
        }

        itemBean = new SearchBean();
        itemBean.setSearchType(SearchAdapter.HEADING_TYPE);
        itemBean.setSearchName("Suggestions");
        dataList.add(itemBean);
        for (String searchItem : searchSampleData) {
            itemBean = new SearchBean();
            itemBean.setSearchType(SearchAdapter.ITEM_TYPE);
            itemBean.setSearchName(searchItem);
            dataList.add(itemBean);
        }
    }

    @Override
    public void onItemClick(int position, String type) {
        Intent intent = new Intent(this, SearchFindingsActivity.class);
        intent.putExtra("TITLE", dataList.get(position).getSearchName());
        startActivity(intent);
    }

    @Override
    public void onItemClickRemote(SearchAdapterRemoteBean searchAdapterRemoteBean) {
        if (searchAdapterRemoteBean.getType().equalsIgnoreCase("Player")) {
            Intent intent = new Intent(this, PlayerDetailsActivity.class);
            intent.putExtra("AGE", "2019-03-20 18:34:34");
            intent.putExtra("PLAYER_NAME", searchAdapterRemoteBean.getPlayerName());
            intent.putExtra("TEAM_NAME", searchAdapterRemoteBean.getPlayerTeam());
            intent.putExtra("DIVISION_NAME", searchAdapterRemoteBean.getSlugName());
            intent.putExtra("PLAYER_ID", searchAdapterRemoteBean.getPlayerId());
            startActivity(intent);

//            AGE,TEAM_NAME,DIVISION_NAME,PLAYER_ID,PLAYER_NAME
        } else if (searchAdapterRemoteBean.getType().equalsIgnoreCase("News")) {
            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra("imgUrl", searchAdapterRemoteBean.getImgUrl());
            intent.putExtra("title", searchAdapterRemoteBean.getTitle());
            intent.putExtra("bigContent", searchAdapterRemoteBean.getLongContent());
            intent.putExtra("teamName", searchAdapterRemoteBean.getSlugName());
//            intent.putExtra("date", date);
//            intent.putExtra("timeStamp", timeStamp);
            startActivity(intent);
        } else {

        }
    }

    @Override
    public void searchOnClick(ArrayList<SearchAdapterRemoteBean> searchModal) {
        searchAdapterRemote.changeData(searchModal);
        searchRV.setVisibility(View.GONE);
        search_recyclerView_remote.setVisibility(View.VISIBLE);
    }

    @Override
    public void getError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }
}
