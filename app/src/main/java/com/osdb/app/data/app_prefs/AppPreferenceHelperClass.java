package com.osdb.app.data.app_prefs;

import android.content.Context;
import android.content.SharedPreferences;


public class AppPreferenceHelperClass implements PreferenceHelper {

    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    private Context context;

    public AppPreferenceHelperClass(Context context) {
        this.context = context;
        preferences = context.getSharedPreferences(prefsFile, Context.MODE_PRIVATE);
        editor = preferences.edit();
    }


    @Override
    public void saveLoginStatus(Boolean isLoggedin) {
        editor.putBoolean(PREF_STORAGE_TYPE, isLoggedin);
        editor.commit();
    }

    @Override
    public Boolean getLoginStatus() {
        return preferences.getBoolean(PREF_STORAGE_TYPE, false);

    }

    @Override
    public void setFirstTimeLaunch(Boolean firstTimeLaunch) {
        editor.putBoolean(IS_FIRST_TIME_LAUNCH, firstTimeLaunch);
        editor.commit();
    }

    @Override
    public Boolean isFirstTimeLaunch() {
        return preferences.getBoolean(IS_FIRST_TIME_LAUNCH, true);
    }
    @Override
    public String getToken() {
        return preferences.getString(TOKEN, "");
    }
    @Override
    public String getUserId() {
        return preferences.getString(USER_ID, "");
    }

    @Override
    public String getTouchId() {
        return preferences.getString(TOUCH_ID, "");
    }


    @Override
    public void saveToken(String saveToken) {
        editor.putString(TOKEN, saveToken);
        editor.commit();
    }

    @Override
    public void saveProjConfData(String datum) {
        editor.putString(PROJ_CONF_STR, datum);
        editor.commit();
    }

    @Override
    public void setDeviceToken(String token) {
        editor.putString(DEVICETOKEN, token);
        editor.commit();

    }

    @Override
    public String getDeviceToken() {
        return preferences.getString(DEVICETOKEN, "");
    }

    @Override
    public void saveLoginData(String data) {
        editor.putString(LOGIN_STR, data);
        editor.commit();
    }

    @Override
    public String getLoginData() {
        return preferences.getString(LOGIN_STR, "");
    }

    @Override
    public String getProjConfData() {
        return preferences.getString(PROJ_CONF_STR, "");
    }

    @Override
    public void clearUserData() {
        editor.remove(USER_CREDENTIALS);
        editor.remove(LOGIN_STR);
        editor.remove(USER_ID);
        editor.remove(TOKEN);
        editor.remove(PREF_STORAGE_TYPE);
        editor.commit();
    }

    @Override
    public void saveUserId(String userID) {
        editor.putString(USER_ID, userID);
        editor.commit();
    }

    @Override
    public String getSeason() {
        return preferences.getString(SEASON, "");
    }

    @Override
    public String getYear() {
        return preferences.getString(YEAR, "");
    }

    @Override
    public String getWeekly() {
        return preferences.getString(WEEKLY, "");
    }

    @Override
    public void saveSeason(String data) {
        editor.putString(SEASON, data);
        editor.commit();
    }

    @Override
    public void saveYear(String data) {
        editor.putString(YEAR, data);
        editor.commit();
    }

    @Override
    public void saveWeekly(String data) {
        editor.putString(WEEKLY, data);
        editor.commit();
    }


}
