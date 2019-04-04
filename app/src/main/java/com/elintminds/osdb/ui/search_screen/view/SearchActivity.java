package com.elintminds.osdb.ui.search_screen.view;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
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
import com.elintminds.osdb.ui.team_details_screen.view.TeamDetailsActivity;

import java.util.ArrayList;

public class SearchActivity extends BaseActivity implements SearchScreenView, SearchScreenView.SearchItemClickListener {
    private Toolbar toolbar;
    private EditText searchET;
    private RecyclerView /*searchRV,*/ search_recyclerView_remote;
    /*private SearchAdapter adapter;*/
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
//        searchRV = findViewById(R.id.search_recyclerView);
        search_recyclerView_remote = findViewById(R.id.search_recyclerView_remote);

    }

    private void setUpRecyclerView() {
        searchScreenPresenterClass = new SearchScreenPresenterClass(this, this);



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
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.e("EditTextChanged", s.toString());

            }
        });
    }


    @Override
    public void onItemClick(int position, String type) {
        Intent intent = new Intent(this, SearchFindingsActivity.class);
        intent.putExtra("TITLE", dataList.get(position).getSearchName());
        startActivity(intent);
    }

    @Override
    public void onItemClickRemote(SearchAdapterRemoteBean searchAdapterRemoteBean) {
        hideSoftKeyboard(SearchActivity.this);
        if (searchAdapterRemoteBean.getType().equalsIgnoreCase("Player")) {
            Intent intent = new Intent(this, PlayerDetailsActivity.class);
            intent.putExtra("AGE", "2019-03-20 18:34:34");
            intent.putExtra("PLAYER_NAME", searchAdapterRemoteBean.getPlayerName());
            intent.putExtra("TEAM_NAME", searchAdapterRemoteBean.getPlayerTeam());
            intent.putExtra("DIVISION_NAME", searchAdapterRemoteBean.getSlugName());
            intent.putExtra("PLAYER_ID", String.valueOf(searchAdapterRemoteBean.getPlayerId()));
            intent.putExtra("PROFILE_PIC", searchAdapterRemoteBean.getImgUrl());
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
            Intent intent = new Intent(this, TeamDetailsActivity.class);
            intent.putExtra("TEAM_NAME", searchAdapterRemoteBean.getPlayerTeam());
            intent.putExtra("DIVISION_NAME", searchAdapterRemoteBean.getSlugName());
            intent.putExtra("TEAM_ID", String.valueOf(searchAdapterRemoteBean.getTeamId()));
            intent.putExtra("PROFILE_PIC", searchAdapterRemoteBean.getImgUrl());
            startActivity(intent);
        }
    }

    @Override
    public void searchOnClick(ArrayList<SearchAdapterRemoteBean> searchModal) {
        searchAdapterRemote.changeData(searchModal);
    }

    @Override
    public void getError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (this != null)
        hideSoftKeyboard(SearchActivity.this);

    }

    public static void hideSoftKeyboard(Activity activity) {
        InputMethodManager inputMethodManager =
                (InputMethodManager) activity.getSystemService(
                        Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(
                activity.getCurrentFocus().getWindowToken(), 0);
    }
}
