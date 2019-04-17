package com.osdb.app.ui.edit_profile.view;

import com.osdb.app.ui.base.view.BaseView;
import org.json.JSONObject;

public interface EditProfileView extends BaseView {
    void updateUserResult(String jsonObject);
    void error(String error);
}
