package kyrpapados.footballapp.ui.leagueboard.fixtures.matchday

import kyrpapados.footballapp.data.model.local.matches.Matches
import kyrpapados.footballapp.ui.base.BaseContract

interface MatchDayContract {
    interface View : BaseContract.IView{

        fun showMatches(matchList: List<Matches>)


    }


    interface Presenter<V : MatchDayContract.View> : BaseContract.Presenter<V>{

        fun getMatches(id : Int, currentMatchday : Int)

    }
}