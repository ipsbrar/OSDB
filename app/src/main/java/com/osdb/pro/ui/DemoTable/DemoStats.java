package com.osdb.pro.ui.DemoTable;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.osdb.pro.R;
import com.osdb.pro.ui.base.view.BaseActivity;
import com.osdb.pro.ui.team_details_screen.beans.StatsBeanVertical;
import com.osdb.pro.ui.team_details_screen.presenter.StatsPresenterClass;
import com.osdb.pro.ui.team_details_screen.view.StatsView;
import com.evrencoskun.tableview.TableView;

import java.util.ArrayList;
import java.util.List;

public class DemoStats extends BaseActivity implements StatsView {
    //    private TableView content_container;
    private List<RowHeader> mRowHeaderList = new ArrayList<>();
    private List<ColumnHeader> mColumnHeaderList = new ArrayList<>();
    private List<List<Cell>> mCellList = new ArrayList<>();

    private StatsPresenterClass statsPresenterClass;
    private LinearLayout ll_table_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);
        setUpView();
    }

    private void setUpView() {

//        TableViewModel tableViewModel = new TableViewModel(this);
//        mCellList = tableViewModel.getCellList();
//        mColumnHeaderList = tableViewModel.getColumnHeaderList();
//        mRowHeaderList = tableViewModel.getRowHeaderList();
        ll_table_main = findViewById(R.id.ll_table_main);
        statsPresenterClass = new StatsPresenterClass(this, this);
//        content_container = findViewById(R.id.content_container);
// Create our custom TableView Adapter
//        adapter = new MyTableViewAdapter(this);

        // Set this adapter to the our TableView
//        content_container.setAdapter(adapter);

        // Let's set datas of the TableView on the Adapter
//        adapter.setAllItems(mColumnHeaderList, mRowHeaderList, mCellList);
//        content_container.setTableViewListener(new MyTableViewListener());
        statsPresenterClass.fetchTeamStatsData("1");
    }

//    @Override
//    public void success(ArrayList<StatsBeans> statsData) {
//
//    }

    @Override
    public void success(List<ColumnHeader> columnHeaderList, List<RowHeader> rowHeaderList, List<List<Cell>> cellList) {
//        adapter.setAllItems(columnHeaderList, rowHeaderList, cellList);
    }

    @Override
    public void success(ArrayList<StatsBeanVertical> verticalArrayList) {
        if (verticalArrayList.size() > 0) {
            for (int i = 0; i < verticalArrayList.size(); i++) {
                View pollOptionView = LayoutInflater.from(this).inflate(R.layout.table_layout, null);
                ll_table_main.addView(pollOptionView);
                TextView txt_main_header = pollOptionView.findViewById(R.id.txt_main_header);
                TextView txt_header = pollOptionView.findViewById(R.id.txt_header);
                TableView content_container = pollOptionView.findViewById(R.id.content_container);
                txt_main_header.setText(verticalArrayList.get(i).getMainHeader());
                txt_header.setText(verticalArrayList.get(i).getHeader());

                 MyTableViewAdapter adapter = new MyTableViewAdapter(this);
                content_container.setAdapter(adapter);
                adapter.setAllItems(verticalArrayList.get(i).getTableList().getColumnHeaderList()
                        , verticalArrayList.get(i).getTableList().getRowHeaderList()
                        , verticalArrayList.get(i).getTableList().getCellList());
            }
        }
    }

    @Override
    public void error(String error) {

    }
}
