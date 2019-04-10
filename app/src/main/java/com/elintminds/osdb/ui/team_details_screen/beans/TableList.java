package com.elintminds.osdb.ui.team_details_screen.beans;

import com.elintminds.osdb.ui.DemoTable.Cell;
import com.elintminds.osdb.ui.DemoTable.ColumnHeader;
import com.elintminds.osdb.ui.DemoTable.RowHeader;

import java.util.List;

public  class TableList{
    private List<RowHeader> rowHeaderList;
    private List<ColumnHeader> columnHeaderList;
    private List<List<Cell>>  cellList;

    public List<RowHeader> getRowHeaderList() {
        return rowHeaderList;
    }

    public void setRowHeaderList(List<RowHeader> rowHeaderList) {
        this.rowHeaderList = rowHeaderList;
    }

    public List<ColumnHeader> getColumnHeaderList() {
        return columnHeaderList;
    }

    public void setColumnHeaderList(List<ColumnHeader> columnHeaderList) {
        this.columnHeaderList = columnHeaderList;
    }

    public List<List<Cell>> getCellList() {
        return cellList;
    }

    public void setCellList(List<List<Cell>> cellList) {
        this.cellList = cellList;
    }
}