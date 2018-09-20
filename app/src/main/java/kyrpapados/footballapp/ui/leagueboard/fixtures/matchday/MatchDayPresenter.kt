package kyrpapados.footballapp.ui.leagueboard.fixtures.matchday

import kyrpapados.footballapp.data.repository.CompetitionRepository
import kyrpapados.footballapp.ui.base.BasePreseneter
import javax.inject.Inject

class MatchDayPresenter<V : MatchDayContract.View> @Inject constructor(private var competitionRepository: CompetitionRepository) : BasePreseneter<V>(), MatchDayContract.Presenter<V> {
    override fun getMatches(id: Int, currentMatchday: Int) {
        competitionRepository.fetchMatches(id, currentMatchday).subscribe({ t ->

            mView.showMatches(t.data!!.matches)
        })
    }
}