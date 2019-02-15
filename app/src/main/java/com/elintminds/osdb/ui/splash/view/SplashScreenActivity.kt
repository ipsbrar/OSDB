package com.elintminds.osdb.ui.splash.view


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import com.elintminds.osdb.R
import com.elintminds.osdb.data.app_prefs.AppPreferenceHelperClass
import com.elintminds.osdb.ui.base.view.BaseActivity
import com.elintminds.osdb.ui.login.view.LoginActivity
import com.elintminds.osdb.ui.login_options.view.LoginOptionsActivity
import com.elintminds.osdb.ui.welcome_screen.view.WelcomeActivity
import java.util.*


class SplashScreenActivity : BaseActivity() {
    var uniqueID: String? = null

    val secondsDelayed = 2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler().postDelayed({
            if (AppPreferenceHelperClass(this@SplashScreenActivity).isFirstTimeLaunch!!) {

                startActivity(Intent(this@SplashScreenActivity, WelcomeActivity::class.java))
            } else {
                startActivity(Intent(this@SplashScreenActivity, LoginOptionsActivity::class.java))
            }
            finish()

        }, (secondsDelayed * 1000).toLong())


    }

    @Synchronized
    fun getUniqueId(context: Context) {

        if (uniqueID == null) {
            uniqueID = UUID.randomUUID().toString()
            AppPreferenceHelperClass(context).deviceToken = uniqueID
            startActivity(Intent(this@SplashScreenActivity, LoginActivity::class.java))
            finish()
        }
    }
}
