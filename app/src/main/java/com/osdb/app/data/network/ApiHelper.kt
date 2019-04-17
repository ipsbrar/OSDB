package com.osdb.app.data.network


import com.osdb.app.ui.dashboard.beans.*
import com.osdb.app.ui.discussion_comments.beans.DiscussionCommentsBean
import com.osdb.app.ui.forgot_password.ForgotPasswordBean
import com.osdb.app.ui.login.beans.UserBean
import com.osdb.app.ui.particular_sport_screen.beans.TeamInfoBean
import com.osdb.app.ui.profile.beans.UserInfo
import com.osdb.app.ui.register.beans.RegisterBean
import com.osdb.app.ui.search_finding_screen.beans.ScheduleBeans
import com.osdb.app.ui.search_screen.beans.SearchModal
import com.osdb.app.ui.team_details_screen.beans.TeamPlayersBean
import com.google.gson.JsonElement
import io.reactivex.Observable
import okhttp3.MultipartBody
import okhttp3.RequestBody
import org.json.JSONObject
import retrofit2.Response
import retrofit2.http.*
import kotlin.collections.ArrayList


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

    @FormUrlEncoded
    @POST("self-reset-password")
    fun ChangePassword(
        @Field("id") userID: String,
        @Field("old_password") email: String,
        @Field("password") password: String,
        @Field("confirm_password") phoneNumber: String
    ): Observable<Response<JSONObject>>


    @GET("sports/list")
    fun fetchAllSportsList(): Observable<ArrayList<SportsAdapterListBean>>

    @GET("born-today?")
    fun fetchBornTodayData(@Query("currentdate") curDate: String, @Query("limit") limit: String): Observable<ArrayList<BornTodayAdapterBean>>

    @GET("news?")
    fun fetchAllNews(@Query("offset") offset: Int): Observable<NewsAdapterBean>

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
    fun fetchAllTeams(
        @Path("slug") slug: String
    ): Observable<TeamInfoBean>

    @GET("teams/{team_id}/players")
    fun fetchAllTeamPlayers(@Path("team_id") teamId: String): Observable<TeamPlayersBean>

    @GET("sports/{slug}/schedules?")
    fun fetchAllSchedule(@Path("slug") slug: String
                         , @Query("year") year: String
                         , @Query("season") season: String): Observable<ScheduleBeans>

    @GET("user")
    fun fetchUserData(): Observable<UserInfo>

    @GET("discussion-board/{id}/report-comment")
    fun fetchReportThread(@Path("id") slug: String): Observable<Response<ScheduleBeans>>

    @GET("discussion-board/{id}/report-thread")
    fun fetchReportComment(@Path("id") slug: String): Observable<Response<ReportThreadBean>>

    @GET("search")
    fun search(@Query("search") searchContent: String, @Query("category") category: String): Observable<Response<SearchModal>>

    @FormUrlEncoded
    @POST("polls/vote/add")
    fun AddPollComment(
        @Field("poll_id") pollId: String,
        @Field("poll_option_id") pollOptionId: String
    ): Observable<Response<JsonElement>>
//    @GET("teams/{team_id}/players")
//    fun fetchPlayerDetail(@Path("team_id") teamId: String): Observable<PlayersDetailBean>

    @GET("players/{player_id}")
    fun fetchPlayerDetail(@Path("player_id") playerId: String): Observable<Response<JsonElement>>

    @GET("teams/{team_id}/stats")
    fun fetchTeamStats(@Path("team_id") teamId: String): Observable<Response<JsonElement>>

    @GET("discussion-board/{report_id}/report-thread")
    fun ReportThread(@Path("report_id") teamId: String): Observable<Response<JSONObject>>

    @GET("polls/{date}?")
    fun fetchPollsList(@Path("date") date: String, @Query("user_id") userId: String): Observable<Response<ArrayList<PollAdapterBean>>>

    @GET("team/{team_id}")
    fun fetchTeamData(@Path("team_id") teamId: String): Observable<Response<JsonElement>>

    @Multipart
    @POST("user")
    fun updateUserData(@Part("name") userName : RequestBody
    ,@Part("phone_number") phoneNumber : RequestBody
    ,@Part image: MultipartBody.Part) : Observable<Response<JsonElement>>
}
