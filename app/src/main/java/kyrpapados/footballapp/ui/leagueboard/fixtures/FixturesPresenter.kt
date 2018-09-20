package kyrpapados.footballapp.ui.leagueboard.fixtures

import kyrpapados.footballapp.data.repository.CompetitionRepository
import kyrpapados.footballapp.ui.base.BasePreseneter
import javax.inject.Inject

class FixturesPresenter<V : FixturesContract.View> @Inject constructor(private var competitionRepository: CompetitionRepository) : BasePreseneter<V>(), FixturesContract.Presenter<V> {
    override fun getUpcomingMatches(id: Int) {
        competitionRepository.fetchUpcomingMatches(id).subscribe({ t ->

            mView.showMatches(t.data!!.matches)
        })
    }
}