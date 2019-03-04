package com.elintminds.osdb.data.network


import com.elintminds.osdb.ui.dashboard.beans.BornTodayAdapterBean
import com.elintminds.osdb.ui.dashboard.beans.DoYouKnow
import com.elintminds.osdb.ui.dashboard.beans.NewsAdapterBean
import com.elintminds.osdb.ui.dashboard.beans.SportsAdapterListBean
import com.elintminds.osdb.ui.dashboard.beans.DiscussionAdapterBean
import com.elintminds.osdb.ui.discussion_comments.beans.DiscussionCommentsBean
import com.elintminds.osdb.ui.login.beans.UserBean
import com.elintminds.osdb.ui.register.beans.RegisterBean
import io.reactivex.Observable
import retrofit2.http.*
import retrofit2.http.POST
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import java.util.ArrayList
import io.reactivex.Completable
import retrofit2.http.PUT




@JvmSuppressWildcards
interface ApiHelper {

    @FormUrlEncoded
    @POST("login")
    fun getUserLogin(@Field("email") email : String, @Field("password") password:String): Observable<UserBean>

    @FormUrlEncoded
    @POST("register")
    fun getUserRegister(@Field("name") name : String,
                        @Field("email") email : String,
                        @Field("password") password: String,
                        @Field("phone_number") phoneNumber:String,
                        @Field("type") type: String
    ): Observable<RegisterBean>


    @GET("sports/list")
    fun fetchAllSportsList(): Observable<ArrayList<SportsAdapterListBean>>

    @GET("born-today?")
    fun fetchBornTodayData(@Query("currentdate") curDate: String, @Query("limit") limit: String): Observable<ArrayList<BornTodayAdapterBean>>

    @GET("news")
    fun fetchAllNews(): Observable<NewsAdapterBean>

    @GET("did-you-know")
    fun fetchDoYouKnow(): Observable<ArrayList<DoYouKnow>>

    @GET("discussion-board/threads")
    fun fetchDiscussions(): Observable<DiscussionAdapterBean>


    @GET("discussion-board/{id}/thread")
    fun fetchDiscussionById(@Path("id") noteId: String): Observable<DiscussionCommentsBean>

}
