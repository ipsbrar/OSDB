package com.osdb.pro.ui.splash.view


import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Handler
import android.util.Log
import com.osdb.pro.R
import com.osdb.pro.data.app_prefs.AppPreferenceHelperClass
import com.osdb.pro.ui.base.view.BaseActivity
import com.osdb.pro.ui.dashboard.view.DashboardActivity
import com.osdb.pro.ui.login.view.LoginActivity
import com.osdb.pro.ui.welcome_screen.view.WelcomeActivity
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException


class SplashScreenActivity : BaseActivity() {
    var uniqueID: String? = null

    val secondsDelayed = 2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        getUniqueId();

        Handler().postDelayed({
            if (AppPreferenceHelperClass(this@SplashScreenActivity).isFirstTimeLaunch!!) {

                startActivity(Intent(this@SplashScreenActivity, WelcomeActivity::class.java))
            } else {
                if(appPreferenceHelperClass.loginStatus)
                    startActivity(Intent(this@SplashScreenActivity, DashboardActivity::class.java))
                    else
                startActivity(Intent(this@SplashScreenActivity, LoginActivity::class.java))
            }
            finish()

        }, (secondsDelayed * 1000).toLong())


    }

    @Synchronized
    fun getUniqueId() {
        try {

            val info = packageManager.getPackageInfo("com.elintminds.osdb", PackageManager.GET_SIGNATURES)

            for (signature in info.signatures) {
                val md = MessageDigest.getInstance("SHA")
                md.update(signature.toByteArray())
                Log.d("KeyHash:", android.util.Base64.encodeToString(md.digest(), android.util.Base64.DEFAULT))
            }

        } catch (e: PackageManager.NameNotFoundException) {
            Log.e("name not found", e.toString())

        } catch (e: NoSuchAlgorithmException) {
            Log.e("no such an algorithm", e.toString())
        }

//        if (uniqueID == null) {
//            uniqueID = UUID.randomUUID().toString()
//            AppPreferenceHelperClass(context).deviceToken = uniqueID
//            startActivity(Intent(this@SplashScreenActivity, LoginActivity::class.java))
//            finish()
//        }
    }
}
