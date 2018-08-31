package kyrpapados.footballapp.ui.home

import kyrpapados.footballapp.data.model.local.Competition
import kyrpapados.footballapp.ui.base.BaseContract

interface HomeContract {
    interface HomeView : BaseContract.IView{
        fun showAllCompetitions(competitionList: List<Competition>)

    }


    interface HomePresenter<V : HomeContract.HomeView> : BaseContract.Presenter<V>{
        fun getAllCompetitions()
    }
}