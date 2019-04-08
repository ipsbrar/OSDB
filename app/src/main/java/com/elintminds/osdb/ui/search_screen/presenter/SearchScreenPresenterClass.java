package com.elintminds.osdb.ui.search_screen.presenter;

import android.content.Context;
import android.util.Log;
import com.elintminds.osdb.data.app_prefs.AppPreferenceHelperClass;
import com.elintminds.osdb.ui.base.presenter.BasePresenterClass;
import com.elintminds.osdb.ui.search_screen.adapters.SearchAdapter;
import com.elintminds.osdb.ui.search_screen.beans.SearchAdapterRemoteBean;
import com.elintminds.osdb.ui.search_screen.beans.SearchModal;
import com.elintminds.osdb.ui.search_screen.model.SearchScreenInteractor;
import com.elintminds.osdb.ui.search_screen.model.SearchScreenInteractorClass;
import com.elintminds.osdb.ui.search_screen.view.SearchScreenView;
import com.elintminds.osdb.utils.ConnectivityReceiver;
import io.reactivex.functions.Consumer;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Response;

import java.util.ArrayList;

public class SearchScreenPresenterClass<V extends SearchScreenView, I extends SearchScreenInteractor>
        extends BasePresenterClass<V, I> implements SearchScreenPresenter<V, I> {
    private SearchScreenPresenterClass(Context context, I interactor, V view) {
        super(context, interactor, view);
    }

    public SearchScreenPresenterClass(Context context, V view) {
        this(context, (I) new SearchScreenInteractorClass(new AppPreferenceHelperClass(context), context), view);
    }

    @Override
    public void getSearchData(String searchContent, String category) {
        if (ConnectivityReceiver.isConnected()) {
            getCompositeDisposable().add(getInteractor()
                    .searchModal(searchContent, category)
                    .subscribeOn(getSchedulerProvider().io())
                    .observeOn(getSchedulerProvider().ui())
                    .subscribe(new Consumer<Response<SearchModal>>() {
                                   @Override
                                   public void accept(Response<SearchModal> homeData) throws Exception {
                                       Log.e("HomeSwipeData", "   Inside Success");
                                       if (homeData.isSuccessful()) {
                                           if (homeData.body() != null && homeData.body() != null) {
                                               parseData(homeData.body().getMData());
                                           }

                                       } else {
                                           Log.e("HomeSwipeData", "   Success but fall in error");
                                       }
                                   }
                               },
                            new Consumer<Throwable>() {
                                @Override
                                public void accept(Throwable throwable) throws Exception {
                                    Log.e("HomeSwipeData", "   Inside Reject");
                                    getMvpView().getError(throwable.toString());
                                }
                            }));
        } else {
            getMvpView().getError("No Internet connection");
        }
    }

    private void parseData(SearchModal.data homeData) {
        ArrayList<SearchAdapterRemoteBean> searchAdapterRemoteBeanArrayList = new ArrayList<>();



        if (homeData.getPlayerArrayList() != null && homeData.getPlayerArrayList().size() > 0) {
            SearchAdapterRemoteBean playerBean = new SearchAdapterRemoteBean();
            playerBean.setSearchType(SearchAdapter.HEADING_TYPE);
            playerBean.setType("Player");
            searchAdapterRemoteBeanArrayList.add(playerBean);
            for (int i = 0; i < homeData.getPlayerArrayList().size(); i++) {
                SearchAdapterRemoteBean searchAdapterRemoteBean = new SearchAdapterRemoteBean();
                int playerId = homeData.getPlayerArrayList().get(i).getPlayerId();
                String fullName = homeData.getPlayerArrayList().get(i).getFullName();
                String slugName = homeData.getPlayerArrayList().get(i).getTeamArray().get(0).getSports().getSlugName();
                String teamName = homeData.getPlayerArrayList().get(i).getTeamArray().get(0).getTeamName();
                int teamId = homeData.getPlayerArrayList().get(i).getTeamArray().get(0).getTeamId();
                String imgUrl = homeData.getPlayerArrayList().get(i).getProPic();
                String imgPic = null;
                if (imgUrl != null && !imgUrl.equalsIgnoreCase("")) {
                    try {
                        JSONArray jsonArray = new JSONArray(imgUrl);
                        for (int j = 0; j < jsonArray.length(); j++) {
                            JSONObject jsonObject = jsonArray.getJSONObject(0);
                            imgPic = "https://s3-us-west-2.amazonaws.com/osdb/" + jsonObject.getString("href");
                            Log.e("MYIMAGEURL", imgPic);

                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                searchAdapterRemoteBean.setPlayerId(playerId);
                searchAdapterRemoteBean.setPlayerName(fullName == null ? "" : fullName);
                searchAdapterRemoteBean.setPlayerTeam(teamName == null ? "" : teamName);
                searchAdapterRemoteBean.setSlugName(slugName == null ? "" : slugName);
                searchAdapterRemoteBean.setTeamId(teamId);
                searchAdapterRemoteBean.setImgUrl(imgPic == null ? "" : imgPic);
                searchAdapterRemoteBean.setType("Player");
                searchAdapterRemoteBean.setSearchType(SearchAdapter.ITEM_TYPE);

                searchAdapterRemoteBeanArrayList.add(searchAdapterRemoteBean);
            }

        }

        if (homeData.getNewsArrayList() != null && homeData.getNewsArrayList().size() > 0) {
            SearchAdapterRemoteBean newsBean = new SearchAdapterRemoteBean();
            newsBean.setSearchType(SearchAdapter.HEADING_TYPE);
            newsBean.setType("News");
            searchAdapterRemoteBeanArrayList.add(newsBean);
            for (int i = 0; i < homeData.getNewsArrayList().size(); i++) {
                SearchAdapterRemoteBean searchAdapterRemoteBean = new SearchAdapterRemoteBean();
                int newsID = homeData.getNewsArrayList().get(i).getNewsId();
                String title = homeData.getNewsArrayList().get(i).getNewsTitle();
                String content = homeData.getNewsArrayList().get(i).getShortContent();
                String createdAt = homeData.getNewsArrayList().get(i).getCreatedAt();
                String tags = homeData.getNewsArrayList().get(i).getTags();
                String imgUrl = homeData.getNewsArrayList().get(i).getImageUrl();
                String slug = null;
                if (homeData.getNewsArrayList().get(i).getSlugName() != null) {
                    slug = homeData.getNewsArrayList().get(i).getSlugName();
                } else {
                    if (homeData.getNewsArrayList().get(i).getNewsSportsArrayList() != null
                            && homeData.getNewsArrayList().get(i).getNewsSportsArrayList().size() > 0
                            && homeData.getNewsArrayList().get(i).getNewsSportsArrayList().get(0).getSport() != null)
                        slug = homeData.getNewsArrayList().get(i).getNewsSportsArrayList().get(0).getSport().getName();
                }

                String imgPic = null;
                if (imgUrl != null && !imgUrl.equalsIgnoreCase("")) {
                    try {
                        JSONArray jsonArray = new JSONArray(imgUrl);
                        for (int j = 0; j < jsonArray.length(); j++) {
                            JSONObject jsonObject = jsonArray.getJSONObject(0);
                            imgPic = "https://s3-us-west-2.amazonaws.com/osdb/" + jsonObject.getString("href");
                            Log.e("MYIMAGEURL", imgPic);

                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                String longContent = homeData.getNewsArrayList().get(i).getLongContent();
                boolean isBreakingNews = homeData.getNewsArrayList().get(i).getIsBreakingNews() == 0 ? false : true;


                searchAdapterRemoteBean.setNewsId(newsID);
                searchAdapterRemoteBean.setBreakingNews(isBreakingNews);
                searchAdapterRemoteBean.setContent(content == null ? "" : content);
                searchAdapterRemoteBean.setCreatedAt(createdAt == null ? "" : createdAt);
                searchAdapterRemoteBean.setSlugName(slug == null ? "" : slug);
                searchAdapterRemoteBean.setTags(tags == null ? "" : tags);
                searchAdapterRemoteBean.setLongContent(longContent == null ? "" : longContent);
                searchAdapterRemoteBean.setImgUrl(imgPic == null ? "" : imgPic);
                searchAdapterRemoteBean.setTitle(title == null ? "" : title);
                searchAdapterRemoteBean.setType("News");
                searchAdapterRemoteBean.setSearchType(SearchAdapter.ITEM_TYPE);
                searchAdapterRemoteBeanArrayList.add(searchAdapterRemoteBean);
            }

        }



        if (homeData.getTeamArrayList() != null && homeData.getTeamArrayList().size() > 0) {
            SearchAdapterRemoteBean teamBean = new SearchAdapterRemoteBean();
            teamBean.setSearchType(SearchAdapter.HEADING_TYPE);
            teamBean.setType("Teams");
            searchAdapterRemoteBeanArrayList.add(teamBean);
            for (int i = 0; i < homeData.getTeamArrayList().size(); i++) {
                SearchAdapterRemoteBean searchAdapterRemoteBean = new SearchAdapterRemoteBean();
                String slugName = homeData.getTeamArrayList().get(i).getSports().getSlugName();
                String teamName = homeData.getTeamArrayList().get(i).getTeamName();
                int teamId = homeData.getTeamArrayList().get(i).getTeamId();
                String imgUrl = homeData.getTeamArrayList().get(i).getLogo();
                String imgPic = null;
                if (imgUrl != null && !imgUrl.equalsIgnoreCase("")) {
                    try {
                        JSONArray jsonArray = new JSONArray(imgUrl);
                        for (int j = 0; j < jsonArray.length(); j++) {
                            JSONObject jsonObject = jsonArray.getJSONObject(0);
                            imgPic = "https://s3-us-west-2.amazonaws.com/osdb/" + jsonObject.getString("href");
                            Log.e("MYIMAGEURL", imgPic);

                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                searchAdapterRemoteBean.setPlayerTeam(teamName == null ? "" : teamName);
                searchAdapterRemoteBean.setSlugName(slugName == null ? "" : slugName);
                searchAdapterRemoteBean.setTeamId(teamId);
                searchAdapterRemoteBean.setImgUrl(imgPic == null ? "" : imgPic);
                searchAdapterRemoteBean.setType("Teams");
                searchAdapterRemoteBean.setSearchType(SearchAdapter.ITEM_TYPE);
                searchAdapterRemoteBeanArrayList.add(searchAdapterRemoteBean);
            }

        }
        Log.e("ArrayListSize", "   " + searchAdapterRemoteBeanArrayList.size());
        getMvpView().searchOnClick(searchAdapterRemoteBeanArrayList);
    }
}
