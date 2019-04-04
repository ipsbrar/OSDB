package com.elintminds.osdb.ui.DemoTable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.elintminds.osdb.R;
import com.evrencoskun.tableview.TableView;
import com.evrencoskun.tableview.adapter.AbstractTableAdapter;

public class DemoTableViewAndroid extends AppCompatActivity {
    private AbstractTableAdapter mTableViewAdapter;
    private TableView mTableView;
    private DemoTableData demoTableData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_table_view_android);

        initViews();
    }

    private void initViews() {
        // Create TableView View model class  to group view models of TableView
        demoTableData = new DemoTableData();

        // Create TableView Adapter
        mTableViewAdapter = new TableViewAdapter(this, demoTableData);
//        mTableView = findViewById(R.id.content_container);
        mTableView = new TableView(this);
        mTableView.setLayoutParams(new FrameLayout.LayoutParams(500,500));
        mTableView.setAdapter(mTableViewAdapter);


        // Create an instance of a Filter and pass the TableView.
        //mTableFilter = new Filter(mTableView);

        // Load the dummy data to the TableView
        mTableViewAdapter.setAllItems(demoTableData.getColumnHeaderList(), demoTableData.getRowHeaderList(), demoTableData.getCellList());

    }
}
