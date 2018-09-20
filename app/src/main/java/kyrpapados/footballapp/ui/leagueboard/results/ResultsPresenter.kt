package kyrpapados.footballapp.ui.leagueboard.results

import kyrpapados.footballapp.data.repository.CompetitionRepository
import kyrpapados.footballapp.ui.base.BasePreseneter
import javax.inject.Inject

class ResultsPresenter<V : ResultsContract.View> @Inject constructor(private var competitionRepository: CompetitionRepository) : BasePreseneter<V>(), ResultsContract.Presenter<V> {


    override fun getCurrentMatch(id: Int, currentMatchday: Int) {
        competitionRepository.fetchMatches(id, currentMatchday).subscribe({ t ->

           // mView.showMatch(t.data!!.matches)
        })
    }

    override fun getPreviousMatches(id: Int) {
        competitionRepository.fetchPreviousMatches(id).subscribe({ t ->

            mView.showPreviousMatches(t.data!!.matches)
        })
    }
}