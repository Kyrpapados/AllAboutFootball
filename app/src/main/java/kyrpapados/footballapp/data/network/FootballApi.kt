package kyrpapados.footballapp.data.network

import io.reactivex.Single
import kyrpapados.footballapp.data.model.local.Area
import kyrpapados.footballapp.data.model.local.teams.Teams
import kyrpapados.footballapp.data.model.responoces.CompetitionResponce
import kyrpapados.footballapp.data.model.responoces.MatchesResponce
import kyrpapados.footballapp.data.model.responoces.StandingsResponce
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import java.util.*

interface FootballApi {

    @GET("competitions")
    fun getAllCompetitions(@Query("plan") plan: String, @Query("areas") areaList : List<String>): Single<CompetitionResponce>

    @GET("competitions/{id}/standings")
    fun getStandings(@Path("id") id : Int): Single<StandingsResponce>

    @GET("competitions/{id}/matches")
    fun getLatestMatches(@Path("id") id : Int, @Query("matchday") matchDay: Int): Single<MatchesResponce>

    @GET("teams/{id}")
    fun getTeamInformation(@Path("id") id : Int): Single<Teams>
}