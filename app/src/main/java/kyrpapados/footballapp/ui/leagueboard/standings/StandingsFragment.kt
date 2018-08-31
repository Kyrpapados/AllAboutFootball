package kyrpapados.footballapp.ui.leagueboard.standings


import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import kotlinx.android.synthetic.main.fragment_standings.*
import kyrpapados.footballapp.R
import kyrpapados.footballapp.data.model.local.Standings
import kyrpapados.footballapp.data.model.local.TableItem
import kyrpapados.footballapp.ui.base.BaseFragment
import kyrpapados.footballapp.ui.teams.TeamsActivity
import kyrpapados.footballapp.utils.Statics.Companion.COMPETITION_ID
import kyrpapados.footballapp.utils.Statics.Companion.TOTAL_TYPE
import kyrpapados.footballapp.utils.helper.FormatHelper
import java.util.function.Consumer
import javax.inject.Inject


class StandingsFragment : BaseFragment(), StandingsContract.StandingsView, StandingsAdapter.Listener {


    private var competiotionId: Int = 0

    @Inject
    lateinit var mPresenter: StandingsPresenter<StandingsContract.StandingsView>

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

        competiotionId = arguments!!.getInt(COMPETITION_ID)


    }

    override fun init(savedInstanceState: Bundle?) {
        val mLayoutManager = LinearLayoutManager(this.activity)
        standingsView.layoutManager = mLayoutManager
        standingsView.itemAnimator = DefaultItemAnimator()
        standingsView.addItemDecoration(DividerItemDecoration(standingsView.context, mLayoutManager.orientation))


        mPresenter.getStandings(competiotionId)

    }

    override fun showStandings(standings: List<Standings>) {
        Log.d("STANDINGS", "standings: " + standings.toList())
        var filteredList = standings.filter { it.type.equals(TOTAL_TYPE) }[0].table as List<TableItem>
        var tableItem = TableItem(0, 0, 0, 0, -1, null, 0, 0, 0, 0)
        filteredList.toMutableList().add(tableItem)

        mAdapter = StandingsAdapter(this.activity!!, filteredList, this)
        standingsView.adapter = mAdapter

    }

    override fun showSeason(stardDate: String, endDate: String) {
        season.text = "Season: " + FormatHelper.getSeason(stardDate) + " - " + FormatHelper.getSeason(endDate)
    }

    override fun showLoading() {

    }

    override fun hideLoading() {

    }

    override fun loadError(e: Throwable) {

    }

    override fun loadError(msg: String) {

    }

    override fun onItemClick(tableItem: TableItem) {
        TeamsActivity.show(this.activity!!, tableItem.team!!.id!!)
    }

}
