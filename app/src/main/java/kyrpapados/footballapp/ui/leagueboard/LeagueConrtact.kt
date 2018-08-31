package kyrpapados.footballapp.ui.leagueboard

import kyrpapados.footballapp.ui.base.BaseContract

interface LeagueConrtact {
    interface LeagueView : BaseContract.IView{


    }


    interface LeaguePresenter<V : LeagueConrtact.LeagueView> : BaseContract.Presenter<V>{

    }
}