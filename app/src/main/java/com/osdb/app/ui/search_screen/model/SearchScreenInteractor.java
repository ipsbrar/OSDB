package com.osdb.app.ui.search_screen.model;

import com.osdb.app.ui.base.model.BaseInteractor;
import com.osdb.app.ui.search_screen.beans.SearchModal;
import io.reactivex.Observable;
import retrofit2.Response;

public interface SearchScreenInteractor extends BaseInteractor {

    Observable<Response<SearchModal>> searchModal(String searchContent, String category);
}
