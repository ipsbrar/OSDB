package com.elintminds.osdb.data.app_prefs;


public interface PreferenceHelper {
    String prefsFile = "Introduceem_prefFile";

    String PREF_STORAGE_TYPE = "STORAGE_TYPE";
    String TOKEN = "TOKEN";
    String DEVICETOKEN = "DEVICETOKEN";
    String USER_CREDENTIALS = "UserCredentials";
    String PROJ_CONF_STR = "ProjectConfigration";
    String LOGIN_STR = "login";
    String USER_ID = "UserId";
    String TOUCH_ID = "TouchId";
    String IS_FIRST_TIME_LAUNCH = "isfirsttimelaunch";

    void saveLoginStatus(Boolean isLoggedin);

    Boolean getLoginStatus();

    void setFirstTimeLaunch(Boolean firstTimeLaunch);

    Boolean isFirstTimeLaunch();

    void saveToken(String saveToken);

    String getToken();

    String getUserId();

    String getTouchId();

    void saveProjConfData(String data);

    void setDeviceToken(String token);

    String getDeviceToken();

    void saveLoginData(String data);

    String getLoginData();

    String getProjConfData();

    void clearUserData();

    void saveUserId(String userID);

}
