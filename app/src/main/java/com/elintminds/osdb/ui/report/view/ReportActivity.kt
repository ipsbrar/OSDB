package com.elintminds.osdb.ui.report.view

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.elintminds.osdb.R
import com.elintminds.osdb.ui.base.view.BaseActivity


class ReportActivity : BaseActivity() {

    private var backImg: ImageView? = null
    private var sendbtn: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_report_discussion)

        backImg = findViewById(R.id.backImg);
        sendbtn = findViewById(R.id.send_btn);

        backImg!!.setOnClickListener {
            finish()
        }
        sendbtn!!.setOnClickListener {
            finish()
        }

    }

}
