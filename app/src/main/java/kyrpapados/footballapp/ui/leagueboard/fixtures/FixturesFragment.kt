package kyrpapados.footballapp.ui.leagueboard.fixtures


import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_teams.*
import kotlinx.android.synthetic.main.fragment_fixtures.*
import kyrpapados.footballapp.R
import kyrpapados.footballapp.data.model.local.matches.Matches
import kyrpapados.footballapp.ui.base.BaseFragment
import kyrpapados.footballapp.utils.Statics
import javax.inject.Inject

class FixturesFragment : BaseFragment(), FixturesContract.View {

    @Inject
    lateinit var mPresenter: FixturesPresenter<FixturesContract.View>

    private var competiotionId: Int = 0

    private var currentMatchday: Int = 0

    private lateinit var mAdapter: FixturesAdapter

    companion object {
        fun show(id: Int, currentMatchday: Int): FixturesFragment {
            val fixturesFragment = FixturesFragment()

            val bundle = Bundle()
            bundle.putInt(Statics.COMPETITION_ID, id)
            bundle.putInt(Statics.CURRENT_MATCHDAY, currentMatchday)
            fixturesFragment.arguments = bundle

            return fixturesFragment

        }
    }

    override fun setLayout(): Int = R.layout.fragment_fixtures

    override fun attachView() {
        mPresenter.onAttach(this)
    }

    override fun detachView() {
        mPresenter.onDetach()
    }

    override fun handleArguments() {
        competiotionId = arguments!!.getInt(Statics.COMPETITION_ID)
        currentMatchday = arguments!!.getInt(Statics.CURRENT_MATCHDAY)
    }

    override fun init(savedInstanceState: Bundle?) {
        val mLayoutManager = LinearLayoutManager(this.context)
        matchdayView.layoutManager = mLayoutManager
        matchdayView.itemAnimator = DefaultItemAnimator()
        matchdayView.addItemDecoration(DividerItemDecoration(matchdayView.context, mLayoutManager.orientation))

        --currentMatchday
        matchday.text = getString(R.string.matchday, currentMatchday.toString())

        mPresenter.getMatches(competiotionId, currentMatchday)
    }

    override fun showMatches(matchList: List<Matches>) {
        mAdapter = FixturesAdapter(this.context!!, matchList)

        matchdayView.adapter = mAdapter
    }

}
