package kyrpapados.footballapp.ui.leagueboard

import kyrpapados.footballapp.data.network.FootballApi
import kyrpapados.footballapp.ui.base.BasePreseneter
import javax.inject.Inject

class LeaguePresenter<V : LeagueConrtact.LeagueView>@Inject constructor(var mFootballApi: FootballApi) : BasePreseneter<V>(), LeagueConrtact.LeaguePresenter<V> {
}