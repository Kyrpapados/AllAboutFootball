package kyrpapados.footballapp.ui.leagueboard.results


import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_results.*
import kyrpapados.footballapp.R
import kyrpapados.footballapp.data.model.local.matches.Matches
import kyrpapados.footballapp.ui.base.BaseFragment
import kyrpapados.footballapp.utils.Statics
import javax.inject.Inject


class ResultsFragment : BaseFragment(), ResultsContract.View {

    @Inject
    lateinit var mPresenter: ResultsPresenter<ResultsContract.View>

    private var competiotionId: Int = 0

    private var currentMatchday: Int = 0

    private lateinit var mAdapter: ResultsAdapter

    companion object {
        fun show(id: Int, currentMatchday: Int): ResultsFragment {
            val resultsFragment = ResultsFragment()

            val bundle = Bundle()
            bundle.putInt(Statics.COMPETITION_ID, id)
            bundle.putInt(Statics.CURRENT_MATCHDAY, currentMatchday)
            resultsFragment.arguments = bundle

            return resultsFragment

        }
    }

    override fun setLayout(): Int = R.layout.fragment_results

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

        mPresenter.getPreviousMatches(competiotionId)
    }

    override  fun showPreviousMatches(matchList: List<Matches>) {
        mAdapter = ResultsAdapter(this.context!!,  matchList)

        matchdayView.adapter = mAdapter

    }

}
