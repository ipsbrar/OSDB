package com.osdb.android.ui.team_details_screen.view;

import com.osdb.android.ui.DemoTable.Cell;
import com.osdb.android.ui.DemoTable.ColumnHeader;
import com.osdb.android.ui.DemoTable.RowHeader;
import com.osdb.android.ui.base.view.BaseView;
import com.osdb.android.ui.team_details_screen.beans.StatsBeanVertical;

import java.util.ArrayList;
import java.util.List;

public interface StatsView extends BaseView {
//    void success(ArrayList<StatsBeans> statsData);
    void success(List<ColumnHeader> columnHeaderList, List<RowHeader> rowHeaderList, List<List<Cell>> cellList);
    void success(ArrayList<StatsBeanVertical> verticalArrayList);
    void error(String error);
}
