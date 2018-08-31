package kyrpapados.footballapp.ui.leagueboard.standings

import kyrpapados.footballapp.data.repository.CompetitionRepository
import kyrpapados.footballapp.ui.base.BasePreseneter
import javax.inject.Inject

class StandingsPresenter<V : StandingsContract.StandingsView> @Inject constructor(private var competitionRepository: CompetitionRepository) : BasePreseneter<V>(), StandingsContract.StandingsPresenter<V> {

    override fun getStandings(id: Int) {

        competitionRepository.fetchStandings(id).subscribe({ t ->
            mView.showStandings(t.data!!.standings)
            mView.showSeason(t.data!!.season.startDate!!, t.data!!.season.endDate!!)
        })
    }


}