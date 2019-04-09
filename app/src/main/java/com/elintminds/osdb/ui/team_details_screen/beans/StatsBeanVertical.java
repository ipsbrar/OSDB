package com.elintminds.osdb.ui.team_details_screen.beans;

import com.elintminds.osdb.ui.DemoTable.Cell;
import com.elintminds.osdb.ui.DemoTable.ColumnHeader;
import com.elintminds.osdb.ui.DemoTable.RowHeader;

import java.util.ArrayList;
import java.util.List;

public class StatsBeanVertical {

    private String mainHeader;
    private String header;
    private TableList tableList;

    public String getMainHeader() {
        return mainHeader;
    }

    public void setMainHeader(String mainHeader) {
        this.mainHeader = mainHeader;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public TableList getTableList() {
        return tableList;
    }

    public void setTableList(TableList tableList) {
        this.tableList = tableList;
    }

    public static class TableList{
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
}
