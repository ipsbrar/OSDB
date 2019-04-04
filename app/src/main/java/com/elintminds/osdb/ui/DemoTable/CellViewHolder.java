/*
 * Copyright (c) 2018. Evren Coşkun
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */

package com.elintminds.osdb.ui.DemoTable;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.elintminds.osdb.R;
import com.evrencoskun.tableview.adapter.recyclerview.holder.AbstractViewHolder;
/**
 * Created by evrencoskun on 23/10/2017.
 */

public class CellViewHolder extends AbstractViewHolder {

    public final TextView cell_textview;
    public final LinearLayout cell_container;
    private String cell;

    public CellViewHolder(View itemView) {
        super(itemView);
        cell_textview = (TextView) itemView.findViewById(R.id.cell_data);
        cell_container = (LinearLayout) itemView.findViewById(R.id.cell_container);
    }

    public void setCell(String cell) {
        this.cell = cell;
        cell_textview.setText(cell);

        // If your TableView should have auto resize for cells & columns.
        // Then you should consider the below lines. Otherwise, you can ignore them.

        // It is necessary to remeasure itself.
        cell_container.getLayoutParams().width = LinearLayout.LayoutParams.WRAP_CONTENT;
        cell_textview.requestLayout();
    }
}