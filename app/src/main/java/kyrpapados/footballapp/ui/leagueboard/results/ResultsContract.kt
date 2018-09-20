package kyrpapados.footballapp.ui.leagueboard.results

import kyrpapados.footballapp.data.model.local.matches.Matches
import kyrpapados.footballapp.ui.base.BaseContract

interface ResultsContract {
    interface View : BaseContract.IView{

        fun showPreviousMatches(matchList: List<Matches>)

    }


    interface Presenter<V : ResultsContract.View> : BaseContract.Presenter<V>{

        fun getCurrentMatch(id : Int, currentMatchday : Int)

        fun getPreviousMatches(id : Int)

    }
}