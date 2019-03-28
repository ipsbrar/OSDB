package com.elintminds.osdb.data.network


import com.elintminds.osdb.ui.dashboard.beans.*
import com.elintminds.osdb.ui.discussion_comments.beans.DiscussionCommentsBean
import com.elintminds.osdb.ui.forgot_password.ForgotPasswordBean
import com.elintminds.osdb.ui.login.beans.UserBean
import com.elintminds.osdb.ui.particular_sport_screen.beans.TeamInfoBean
import com.elintminds.osdb.ui.player_details_screen.beans.PlayersDetailBean
import com.elintminds.osdb.ui.profile.beans.UserInfo
import com.elintminds.osdb.ui.register.beans.RegisterBean
import com.elintminds.osdb.ui.search_finding_screen.beans.ScheduleBeans
import com.elintminds.osdb.ui.search_screen.beans.SearchModal
import com.elintminds.osdb.ui.team_details_screen.beans.TeamPlayersBean
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.*
import java.util.*


@JvmSuppressWildcards
interface ApiHelper {

    @FormUrlEncoded
    @POST("login")
    fun getUserLogin(@Field("email") email: String, @Field("password") password: String): Observable<UserBean>

    @GET("forgot-password?")
    fun sendForgotPasswordLink(@Query("email") email: String): Observable<Response<ForgotPasswordBean>>


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


    @GET("polls/get-poll?")
    fun getPollsData(@Query("user_id") user_id: String): Observable<PollAdapterBean>

    @GET("discussion-board/threads")
    fun fetchDiscussions(): Observable<DiscussionAdapterBean>


    @GET("discussion-board/{id}/thread")
    fun fetchDiscussionById(@Path("id") noteId: String): Observable<DiscussionCommentsBean>

    @GET("home?")
    fun fetchHomeData(@Query("currentdate") curDate: String): Observable<HomeBean>

    //    sports/NBA/teams
    @GET("sports/{slug}/teams")
    fun fetchAllTeams(@Path("slug") slug: String): Observable<TeamInfoBean>

    @GET("teams/{team_id}/players")
    fun fetchAllTeamPlayers(@Path("team_id") teamId: String): Observable<TeamPlayersBean>

    @GET("sports/{slug}/schedules")
    fun fetchAllSchedule(@Path("slug") slug: String): Observable<ScheduleBeans>

    @GET("user")
    fun fetchUserData(): Observable<UserInfo>

    @GET("discussion-board/{id}/report-comment")
    fun fetchReportThread(@Path("id") slug: String): Observable<Response<ScheduleBeans>>

    @GET("discussion-board/{id}/report-thread")
    fun fetchReportComment(@Path("id") slug: String): Observable<Response<ReportThreadBean>>

    @GET("search")
    fun search(@Query("search") searchContent : String , @Query("category") category : String): Observable<Response<SearchModal>>


//    @GET("teams/{team_id}/players")
//    fun fetchPlayerDetail(@Path("team_id") teamId: String): Observable<PlayersDetailBean>

}
