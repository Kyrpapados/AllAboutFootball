package kyrpapados.footballapp.ui.leagueboard.fixtures

import android.util.Log
import kyrpapados.footballapp.data.repository.CompetitionRepository
import kyrpapados.footballapp.ui.base.BasePreseneter
import javax.inject.Inject

class FixturesPresenter<V : FixturesContract.View> @Inject constructor(private var competitionRepository: CompetitionRepository) : BasePreseneter<V>(), FixturesContract.Presenter<V> {
    override fun getMatches(id: Int, currentMatchday : Int) {
        competitionRepository.fetchMatches(id, currentMatchday).subscribe({ t ->

            //Log.d("Presenter", "data: "+t.data!!.matches)
            mView.showMatches(t.data!!.matches)
        })
    }
}