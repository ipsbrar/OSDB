package com.osdb.app.ui.DemoTable;


import java.io.Serializable;

public class RowHeader extends Cell implements Serializable {

        public RowHeader(String id) {
            super(id);
        }

        public RowHeader(String id, String data) {
            super(id, data);
        }
    }

