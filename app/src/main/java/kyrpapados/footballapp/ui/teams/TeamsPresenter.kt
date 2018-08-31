package kyrpapados.footballapp.ui.teams

import kyrpapados.footballapp.data.model.local.teams.SquadItem
import kyrpapados.footballapp.data.repository.CompetitionRepository
import kyrpapados.footballapp.ui.base.BasePreseneter
import kyrpapados.footballapp.utils.Statics
import kyrpapados.footballapp.utils.Statics.Companion.POSITION_ATTACKER
import kyrpapados.footballapp.utils.Statics.Companion.POSITION_DEFENDER
import kyrpapados.footballapp.utils.Statics.Companion.POSITION_GOALKEEPER
import kyrpapados.footballapp.utils.Statics.Companion.POSITION_MIDFIELDER
import javax.inject.Inject

class TeamsPresenter<V : TeamsContract.View> @Inject constructor(private var competitionRepository: CompetitionRepository) : BasePreseneter<V>(), TeamsContract.Presenter<V> {

    private var coach = "-"

    private var goalKeepersList: MutableList<SquadItem> = arrayListOf()
    private var defendersList: MutableList<SquadItem> = arrayListOf()
    private var midfieldersList: MutableList<SquadItem> = arrayListOf()
    private var attackersList: MutableList<SquadItem> = arrayListOf()

    override fun fetchTeamInformation(id: Int) {
        competitionRepository.fetchTeamInfo(id).subscribe({ t ->


            t.data!!.squad!!.forEach { squadItem: SquadItem? ->
                if (squadItem!!.role.equals(Statics.ROLE_COACH)) {
                    coach = squadItem.name.toString()
                } else {
                    when {
                        squadItem.position.equals(POSITION_GOALKEEPER) -> goalKeepersList.add(squadItem)
                        squadItem.position.equals(POSITION_DEFENDER) -> defendersList.add(squadItem)
                        squadItem.position.equals(POSITION_MIDFIELDER) -> midfieldersList.add(squadItem)
                        squadItem.position.equals(POSITION_ATTACKER) -> attackersList.add(squadItem)
                    }
                }
            }

            mView.showTeamInformation(t.data!!, coach, goalKeepersList, defendersList, midfieldersList, attackersList)
        })
    }
}