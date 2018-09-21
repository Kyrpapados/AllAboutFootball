package kyrpapados.footballapp.ui.leagueboard.fixtures.matchday


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_match_day.*
import kotlinx.android.synthetic.main.fragment_results.*

import kyrpapados.footballapp.R
import kyrpapados.footballapp.data.model.local.matches.Matches
import kyrpapados.footballapp.ui.base.BaseFragment
import kyrpapados.footballapp.utils.Statics
import kyrpapados.footballapp.utils.Statics.Companion.COMPETITION_ID
import kyrpapados.footballapp.utils.Statics.Companion.CURRENT_MATCHDAY
import kyrpapados.footballapp.utils.Statics.Companion.MATCHES
import javax.inject.Inject


class MatchDayFragment : BaseFragment(), MatchDayContract.View {

    @Inject
    lateinit var mPresenter: MatchDayPresenter<MatchDayContract.View>

    private var competiotionId: Int = 0
    private var currentMatchday: Int = 0

    private lateinit var mAdapter: MatchDayAdapter

    private lateinit var matchList: ArrayList<Matches>

    companion object {
        fun show(id: Int, currentMatchday: Int, matchList: ArrayList<Matches>): MatchDayFragment {
            val fixturesFragment = MatchDayFragment()

            val bundle = Bundle()
            bundle.putInt(COMPETITION_ID, id)
            bundle.putInt(CURRENT_MATCHDAY, currentMatchday)
            bundle.putParcelableArrayList(MATCHES, matchList)
            fixturesFragment.arguments = bundle

            return fixturesFragment

        }
    }

    override fun setLayout(): Int = R.layout.fragment_match_day

    override fun attachView() {
        mPresenter.onAttach(this)
    }

    override fun detachView() {
        mPresenter.onDetach()
    }

    override fun handleArguments() {
        competiotionId = arguments!!.getInt(COMPETITION_ID)
        currentMatchday = arguments!!.getInt(CURRENT_MATCHDAY)
        matchList = arguments!!.getParcelableArrayList(MATCHES)
    }

    override fun init(savedInstanceState: Bundle?) {
        val mLayoutManager = LinearLayoutManager(this.context)
        upcomingMatchesView.layoutManager = mLayoutManager
        upcomingMatchesView.itemAnimator = DefaultItemAnimator()
        upcomingMatchesView.addItemDecoration(DividerItemDecoration(upcomingMatchesView.context, mLayoutManager.orientation))

        //mPresenter.getMatches(competiotionId, currentMatchday)
        showMatches(matchList)
    }

    override fun showMatches(matchList: List<Matches>) {
        val filteredList = matchList.filter { matches ->  matches.matchday == currentMatchday}
        mAdapter = MatchDayAdapter(this.context!!,  filteredList)
        upcomingMatchesView.adapter = mAdapter

    }

}
