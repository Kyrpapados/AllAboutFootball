package kyrpapados.footballapp.ui.teams

import kyrpapados.footballapp.data.model.local.matches.Coach
import kyrpapados.footballapp.data.model.local.teams.SquadItem
import kyrpapados.footballapp.data.model.local.teams.Teams
import kyrpapados.footballapp.ui.base.BaseContract

interface TeamsContract {
    interface View : BaseContract.IView{

        fun showTeamInformation(team : Teams, coach: String, goalKeepersList: MutableList<SquadItem>, defendersList: MutableList<SquadItem>, midfieldersList: MutableList<SquadItem>, attackersList: MutableList<SquadItem>)

    }


    interface Presenter<V : TeamsContract.View> : BaseContract.Presenter<V>{

        fun fetchTeamInformation(id : Int)
    }
}