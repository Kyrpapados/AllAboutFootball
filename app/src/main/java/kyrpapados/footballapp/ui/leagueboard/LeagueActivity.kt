package kyrpapados.footballapp.ui.leagueboard

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_league.*
import kyrpapados.footballapp.R
import kyrpapados.footballapp.data.model.local.Competition
import kyrpapados.footballapp.ui.base.BaseActivity
import kyrpapados.footballapp.utils.Statics.Companion.COMPETITION
import javax.inject.Inject

class LeagueActivity : BaseActivity(), LeagueConrtact.LeagueView {

    @Inject
    lateinit var mPresenter: LeaguePresenter<LeagueConrtact.LeagueView>

    lateinit var competition : Competition

    companion object {
        fun newInstance(activity : Activity, competition: Competition) {
            val intent = Intent(activity, LeagueActivity::class.java)
            intent.putExtra(COMPETITION, competition)
            activity.startActivity(intent)
        }
    }

    override fun setLayout(): Int = R.layout.activity_league

    override fun attachView() {
        mPresenter.onAttach(this)
    }

    override fun detachView() {
        mPresenter.onDetach()
    }

    override fun handleIntent(intent: Intent) {
        competition = intent.getParcelableExtra(COMPETITION)
    }


    override fun init(savedInstanceState: Bundle?) {
        val fragmentAdapter = LeaguePagerAdapter(supportFragmentManager, competition.id!!, competition.currentSeason!!.currentMatchday!!)
        viewpager_main.adapter = fragmentAdapter

        tabs_main.setupWithViewPager(viewpager_main)
    }


}
