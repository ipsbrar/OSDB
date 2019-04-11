package com.osdb.android.ui.settings.view;

import android.support.v4.app.Fragment;
import com.osdb.android.ui.base.view.BaseView;

public interface SettingsView extends BaseView {


    void changeFragment(Fragment fragment, String tag);
}
