package com.elintminds.osdb.ui.team_details_screen.view;

import com.elintminds.osdb.ui.DemoTable.Cell;
import com.elintminds.osdb.ui.DemoTable.ColumnHeader;
import com.elintminds.osdb.ui.DemoTable.RowHeader;
import com.elintminds.osdb.ui.base.view.BaseView;
import com.elintminds.osdb.ui.team_details_screen.beans.StatsBeanVertical;
import com.elintminds.osdb.ui.team_details_screen.beans.StatsBeans;

import java.util.ArrayList;
import java.util.List;

public interface StatsView extends BaseView {
//    void success(ArrayList<StatsBeans> statsData);
    void success(List<ColumnHeader> columnHeaderList, List<RowHeader> rowHeaderList, List<List<Cell>> cellList);
    void success(ArrayList<StatsBeanVertical> verticalArrayList);
    void error(String error);
}
