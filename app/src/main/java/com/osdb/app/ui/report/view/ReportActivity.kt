package com.osdb.app.ui.report.view

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.osdb.app.R
import com.osdb.app.ui.base.view.BaseActivity


class ReportActivity : BaseActivity() ,ReportView{


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
    override fun getReportSuccess(reportMessage: String) {
        Toast.makeText(this,reportMessage,Toast.LENGTH_LONG).show()
    }

    override fun error(error: String) {
        Toast.makeText(this,error,Toast.LENGTH_LONG).show()
    }
}
