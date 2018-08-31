package kyrpapados.footballapp.ui.leagueboard.standings

import kyrpapados.footballapp.data.model.local.Standings
import kyrpapados.footballapp.ui.base.BaseContract

interface StandingsContract {
    interface StandingsView : BaseContract.IView{

        fun showStandings(standings: List<Standings>)

        fun showSeason(stardDate : String, endDate: String)

    }


    interface StandingsPresenter<V : StandingsContract.StandingsView> : BaseContract.Presenter<V>{
        fun getStandings(id : Int)

    }
}