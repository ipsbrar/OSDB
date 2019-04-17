package com.osdb.app.ui.settings.view;

import android.support.v4.app.Fragment;
import com.osdb.app.ui.base.view.BaseView;

public interface SettingsView extends BaseView {


    void changeFragment(Fragment fragment, String tag);
}
