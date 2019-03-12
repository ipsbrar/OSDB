package com.elintminds.osdb.data.network


import com.elintminds.osdb.ui.dashboard.beans.*
import com.elintminds.osdb.ui.discussion_comments.beans.DiscussionCommentsBean
import com.elintminds.osdb.ui.login.beans.UserBean
import com.elintminds.osdb.ui.particular_sport_screen.beans.TeamInfoBean
import com.elintminds.osdb.ui.register.beans.RegisterBean
import com.elintminds.osdb.ui.team_details_screen.beans.TeamPlayersBean
import io.reactivex.Observable
import retrofit2.http.*
import java.util.*


@JvmSuppressWildcards
interface ApiHelper {

    @FormUrlEncoded
    @POST("login")
    fun getUserLogin(@Field("email") email: String, @Field("password") password: String): Observable<UserBean>

    @FormUrlEncoded
    @POST("register")
    fun getUserRegister(
        @Field("name") name: String,
        @Field("email") email: String,
        @Field("password") password: String,
        @Field("phone_number") phoneNumber: String,
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


    @GET("polls/{date}")
    fun getPollsData(@Path("date") curDate: String, @Query("user_id") user_id: String): Observable<ArrayList<PollAdapterBean>>

    @GET("discussion-board/threads")
    fun fetchDiscussions(): Observable<DiscussionAdapterBean>


    @GET("discussion-board/{id}/thread")
    fun fetchDiscussionById(@Path("id") noteId: String): Observable<DiscussionCommentsBean>

    @GET("home?")
    fun fetchHomeData(@Query("currentdate") curDate: String): Observable<HomeBean>

    //    sports/NBA/teams
    @GET("sports/{slug}/teams")
    fun fetchAllTeams(@Path("slug") slug: String): Observable<TeamInfoBean>

    @GET("teams/33/players")
    fun fetchAllTeamPlayers(@Path("team_id") teamId: String): Observable<TeamPlayersBean>




//
}
