package kyrpapados.footballapp.ui.leagueboard

import kyrpapados.footballapp.data.network.FootballApi
import kyrpapados.footballapp.ui.base.BasePreseneter
import javax.inject.Inject

class LeaguePresenter<V : LeagueContract.View>@Inject constructor(var mFootballApi: FootballApi) : BasePreseneter<V>(), LeagueContract.Presenter<V> {
}