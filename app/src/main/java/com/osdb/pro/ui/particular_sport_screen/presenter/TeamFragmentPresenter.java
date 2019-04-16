package com.osdb.pro.ui.particular_sport_screen.presenter;

import com.osdb.pro.ui.base.presenter.BasePresenter;
import com.osdb.pro.ui.particular_sport_screen.model.TeamFragmentInteractor;
import com.osdb.pro.ui.particular_sport_screen.view.TeamFragmentView;

public interface TeamFragmentPresenter<V extends TeamFragmentView, I extends TeamFragmentInteractor> extends BasePresenter<V, I>
{
       void getSlugName(String slugName);
}
