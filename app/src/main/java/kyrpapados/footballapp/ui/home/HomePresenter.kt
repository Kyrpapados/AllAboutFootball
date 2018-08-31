package kyrpapados.footballapp.ui.home

import kyrpapados.footballapp.data.repository.CompetitionRepository
import kyrpapados.footballapp.ui.base.BasePreseneter
import kyrpapados.footballapp.utils.Statics.Companion.AREAS_IDS
import kyrpapados.footballapp.utils.Statics.Companion.BUNDESLIGA
import kyrpapados.footballapp.utils.Statics.Companion.CHAMPIONS_LEAGUE
import kyrpapados.footballapp.utils.Statics.Companion.LIGUE_1
import kyrpapados.footballapp.utils.Statics.Companion.PREMIER_LEAGUE
import kyrpapados.footballapp.utils.Statics.Companion.PRIMERA_DIVISION
import kyrpapados.footballapp.utils.Statics.Companion.SERIE_A
import kyrpapados.footballapp.utils.Statics.Companion.TIER_ONE
import javax.inject.Inject

class HomePresenter<V : HomeContract.HomeView> @Inject constructor(private var competitionRepository: CompetitionRepository) : BasePreseneter<V>(), HomeContract.HomePresenter<V> {

    override fun getAllCompetitions() {
        val areaList: List<String> = arrayListOf(AREAS_IDS)

        competitionRepository.fetchAllCompetitions(TIER_ONE, areaList).subscribe({ result ->
            val competitionList = result.data!!.competitions.filter { competition ->
                competition.name.equals(PREMIER_LEAGUE) ||
                        competition.name.equals(CHAMPIONS_LEAGUE) ||
                        competition.name.equals(BUNDESLIGA) ||
                        competition.name.equals(SERIE_A) ||
                        competition.name.equals(PRIMERA_DIVISION) ||
                        competition.name.equals(LIGUE_1)
            }

            mView.showAllCompetitions(competitionList)

        })
    }
}