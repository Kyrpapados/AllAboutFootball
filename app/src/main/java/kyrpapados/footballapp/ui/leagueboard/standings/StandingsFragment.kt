package kyrpapados.footballapp.ui.leagueboard.standings


import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_standings.*
import kyrpapados.footballapp.R
import kyrpapados.footballapp.data.model.local.Standings
import kyrpapados.footballapp.data.model.local.TableItem
import kyrpapados.footballapp.ui.base.BaseFragment
import kyrpapados.footballapp.ui.teams.TeamsActivity
import kyrpapados.footballapp.utils.Statics.Companion.COMPETITION_ID
import kyrpapados.footballapp.utils.Statics.Companion.TOTAL_TYPE
import kyrpapados.footballapp.utils.helper.FormatHelper
import kyrpapados.footballapp.utils.helper.PreferencesHelper
import javax.inject.Inject


class StandingsFragment : BaseFragment(), StandingsContract.StandingsView, StandingsAdapter.Listener {

    private var competitionId: Int = 0

    @Inject
    lateinit var mPresenter: StandingsPresenter<StandingsContract.StandingsView>

    var mPreferencesHelper: PreferencesHelper? = null
    @Inject set

    private lateinit var mAdapter: StandingsAdapter

    companion object {
        fun newInstance(id: Int): StandingsFragment {
            val standingsFragment = StandingsFragment()

            val bundle = Bundle()
            bundle.putInt(COMPETITION_ID, id)
            standingsFragment.arguments = bundle

            return standingsFragment

        }
    }

    override fun setLayout(): Int = R.layout.fragment_standings

    override fun attachView() {
        mPresenter.onAttach(this)
    }

    override fun detachView() {
        mPresenter.onDetach()
    }

    override fun handleArguments() {

        competitionId = arguments!!.getInt(COMPETITION_ID)


    }

    override fun init(savedInstanceState: Bundle?) {
        val mLayoutManager = LinearLayoutManager(this.activity!!)
        standingsView.layoutManager = mLayoutManager
        standingsView.itemAnimator = DefaultItemAnimator()
        standingsView.addItemDecoration(DividerItemDecoration(standingsView.context, mLayoutManager.orientation))


       /* teamlost.layoutParams.width = mPreferencesHelper!!.getInt(BALL_DIMENS)
        teamlost.layoutParams.height = mPreferencesHelper!!.getInt(BALL_DIMENS)
        teamlost.background = UIHelper.drawCircle(ContextCompat.getColor(this.context!!, R.color.lost_red))
        teamDraws.layoutParams.width = mPreferencesHelper!!.getInt(BALL_DIMENS)
        teamDraws.layoutParams.height = mPreferencesHelper!!.getInt(BALL_DIMENS)
        teamDraws.background = UIHelper.drawCircle(ContextCompat.getColor(this.context!!, R.color.draw_orange))
        teamWon.layoutParams.width = mPreferencesHelper!!.getInt(BALL_DIMENS)
        teamWon.layoutParams.height = mPreferencesHelper!!.getInt(BALL_DIMENS)
        teamWon.background = UIHelper.drawCircle(ContextCompat.getColor(this.context!!, R.color.win_green))*/

       /* GlideApp.with(this.context!!)
                .load(R.drawable.logo_cl)
                .override(60, 60)
                .centerCrop()
                .into(teamUri)*/

        /*teamGames.layoutParams.width = mPreferencesHelper!!.getInt(BALL_DIMENS)
        teamGames.layoutParams.height = mPreferencesHelper!!.getInt(BALL_DIMENS)
        teamPoints.layoutParams.width = mPreferencesHelper!!.getInt(BALL_DIMENS)
        teamPoints.layoutParams.height = mPreferencesHelper!!.getInt(BALL_DIMENS)*/




        mPresenter.getStandings(competitionId)

    }

    override fun showStandings(standings: MutableList<Standings>) {
        var filteredList = standings.filter { it.type.equals(TOTAL_TYPE) }[0].table as MutableList<TableItem>

        mAdapter = StandingsAdapter(this.activity!!, filteredList, this)
        standingsView.adapter = mAdapter
    }

    override fun showSeason(stardDate: String, endDate: String) {
        season.text = "Season: " + FormatHelper.getSeason(stardDate) + " - " + FormatHelper.getSeason(endDate)
    }

    override fun onItemClick(tableItem: TableItem) {
        TeamsActivity.show(this.activity!!, tableItem.team!!.id!!)
    }

}
