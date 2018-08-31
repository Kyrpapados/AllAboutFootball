package kyrpapados.footballapp.data.repository

import android.util.Log
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kyrpapados.footballapp.data.model.local.teams.Teams
import kyrpapados.footballapp.data.model.responoces.CompetitionResponce
import kyrpapados.footballapp.data.model.responoces.MatchesResponce
import kyrpapados.footballapp.data.model.responoces.StandingsResponce
import kyrpapados.footballapp.data.network.FootballApi
import kyrpapados.footballapp.data.network.StateWrapper
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CompetitionRepository @Inject constructor(var mFootballApi: FootballApi) {

    fun fetchAllCompetitions(plan: String, areaList: List<String>) : Single<StateWrapper<CompetitionResponce>> {
        return mFootballApi.getAllCompetitions(plan, areaList)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map({ t ->
                    //Timber.tag("online").e("map")

                    StateWrapper.success(t!!.competitions)

                    StateWrapper.error(Exception(), t)
                })
                .onErrorReturn({ it ->
                    StateWrapper.error(it, null)
                })
                .doOnError({ error -> Log.d("online", "error: " + error.message) })
    }

    fun fetchStandings(id: Int ) : Single<StateWrapper<StandingsResponce>> {
        return mFootballApi.getStandings(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map { StateWrapper.success(it) }
                .onErrorReturn({ it ->
                    StateWrapper.error(it, null)
                })
                .doOnError({ error -> Log.d("online", "error: " + error.message) })
    }

    fun fetchMatches(id : Int, currentMatchday : Int) : Single<StateWrapper<MatchesResponce>> {
        return  mFootballApi.getLatestMatches(id, currentMatchday)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map { StateWrapper.success(it) }
                .onErrorReturn({ it ->
                    StateWrapper.error(it, null)
                })
                .doOnError({ error -> Log.d("online", "error: " + error.message) })
    }

    fun fetchTeamInfo(id : Int) : Single<StateWrapper<Teams>> {
        return mFootballApi.getTeamInformation(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map { StateWrapper.success(it) }
                .onErrorReturn({ it ->
                    StateWrapper.error(it, null)
                })
                .doOnError({ error -> Log.d("online", "error: " + error.message) })
    }


}