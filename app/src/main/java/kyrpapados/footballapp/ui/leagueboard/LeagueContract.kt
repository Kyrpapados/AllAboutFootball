package kyrpapados.footballapp.ui.leagueboard

import kyrpapados.footballapp.ui.base.BaseContract

interface LeagueContract {
    interface View : BaseContract.IView{


    }


    interface Presenter<V : LeagueContract.View> : BaseContract.Presenter<V>{

    }
}