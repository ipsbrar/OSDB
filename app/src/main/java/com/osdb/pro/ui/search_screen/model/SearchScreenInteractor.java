package com.osdb.pro.ui.search_screen.model;

import com.osdb.pro.ui.base.model.BaseInteractor;
import com.osdb.pro.ui.search_screen.beans.SearchModal;
import io.reactivex.Observable;
import retrofit2.Response;

public interface SearchScreenInteractor extends BaseInteractor {

    Observable<Response<SearchModal>> searchModal(String searchContent, String category);
}
