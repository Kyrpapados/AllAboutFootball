package kyrpapados.footballapp.ui.home

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import kotlinx.android.synthetic.main.activity_home.*
import kyrpapados.footballapp.R
import kyrpapados.footballapp.data.model.local.Competition
import kyrpapados.footballapp.ui.base.BaseActivity
import kyrpapados.footballapp.ui.leagueboard.LeagueActivity
import javax.inject.Inject

class HomeActivity : BaseActivity(), HomeContract.HomeView, ItemClickListener {


    @Inject
    lateinit var mPresenter: HomePresenter<HomeContract.HomeView>

    override fun setLayout(): Int = R.layout.activity_home

    override fun attachView() {
        mPresenter.onAttach(this)
    }

    override fun detachView() {
        mPresenter.onDetach()
    }

    override fun handleIntent(intent: Intent) {

    }

    override fun init(savedInstanceState: Bundle?) {
        competitionView.layoutManager = GridLayoutManager(this, 2)

        mPresenter.getAllCompetitions()
    }

    override fun showAllCompetitions(competitionList: List<Competition>) {
        Log.d("ACTIVITY", "list: "+competitionList)
        competitionView.adapter = HomeAdapter(this, competitionList, this::onItemClick)
    }

    override fun onItemClick(competition: Competition) {
        LeagueActivity.newInstance(this, competition)
    }

}
