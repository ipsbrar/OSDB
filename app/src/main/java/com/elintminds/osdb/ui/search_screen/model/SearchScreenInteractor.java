package com.elintminds.osdb.ui.search_screen.model;

import com.elintminds.osdb.ui.base.model.BaseInteractor;
import com.elintminds.osdb.ui.search_screen.beans.SearchModal;
import io.reactivex.Observable;
import retrofit2.Response;

public interface SearchScreenInteractor extends BaseInteractor {

    Observable<Response<SearchModal>> searchModal(String searchContent, String category);
}
