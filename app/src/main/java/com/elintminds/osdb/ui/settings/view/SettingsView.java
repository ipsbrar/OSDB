package com.elintminds.osdb.ui.settings.view;

import android.support.v4.app.Fragment;
import com.elintminds.osdb.ui.base.view.BaseView;

public interface SettingsView extends BaseView {


    void changeFragment(Fragment fragment, String tag);
}
