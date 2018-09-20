package kyrpapados.footballapp.ui.leagueboard.fixtures

import kyrpapados.footballapp.data.model.local.matches.Matches
import kyrpapados.footballapp.ui.base.BaseContract

interface FixturesContract {
    interface View : BaseContract.IView{

        fun showMatches(matchList: List<Matches>)


    }


    interface Presenter<V : FixturesContract.View> : BaseContract.Presenter<V>{

        fun getUpcomingMatches(id : Int)

    }
}