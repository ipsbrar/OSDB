package com.osdb.app.ui.DemoTable;

import java.io.Serializable;

public class ColumnHeader extends Cell implements Serializable {

    public ColumnHeader(String id) {
        super(id);
    }

    public ColumnHeader(String id, String data) {
        super(id, data);
    }
}
