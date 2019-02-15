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

    void saveLoginStatus(Boolean isLoggedin);
    Boolean getLoginStatus();

    void saveToken(String saveToken, String userId, String touchId);
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


}
