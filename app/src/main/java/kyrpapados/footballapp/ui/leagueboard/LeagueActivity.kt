package kyrpapados.footballapp.ui.leagueboard

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v4.content.ContextCompat
import kotlinx.android.synthetic.main.activity_league.*
import kotlinx.android.synthetic.main.item_home.view.*
import kotlinx.android.synthetic.main.toolbar.*
import kyrpapados.footballapp.R
import kyrpapados.footballapp.data.model.local.Competition
import kyrpapados.footballapp.ui.base.BaseActivity
import kyrpapados.footballapp.utils.GlideApp
import kyrpapados.footballapp.utils.Statics.Companion.COMPETITION
import javax.inject.Inject

class LeagueActivity : BaseActivity(), LeagueContract.View {

    @Inject
    lateinit var mPresenter: LeaguePresenter<LeagueContract.View>

    lateinit var competition : Competition

    companion object {
        fun newInstance(activity : Activity, competition: Competition) {
            val intent = Intent(activity, LeagueActivity::class.java)
            intent.putExtra(COMPETITION, competition)
            activity.startActivity(intent)
        }
    }

    override fun setLayout(): Int = R.layout.activity_league

    override fun getActivityTitle(): String = ""

    override fun getActivityLogo(): String = ""

    override fun getLocalLogo(): Int {
        return if(competition.id == 2001){
            R.drawable.logo_cl
        }else if (competition.id == 2021){
            R.drawable.logo_premier_league
        }else if (competition.id == 2015){
            R.drawable.logo_ligue_1
        }else if (competition.id == 2002){
            R.drawable.logo_bundesliga
        }else if (competition.id == 2019){
            R.drawable.logo_serie_a
        }else{
            R.drawable.logo_laliga
        }
    }

    override fun attachView() {
        mPresenter.onAttach(this)
    }

    override fun detachView() {
        mPresenter.onDetach()
    }

    override fun handleIntent(intent: Intent) {
        competition = intent.getParcelableExtra(COMPETITION)
    }


    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun init(savedInstanceState: Bundle?) {
        //toolbar.setBackgroundColor(ContextCompat.getColor(this, R.color.info_light))
        supportActionBar!!.setDisplayHomeAsUpEnabled(false)
        //toolbar.navigationIcon!!.setTint(ContextCompat.getColor(this, R.color.colorBlack))
        val fragmentAdapter = LeaguePagerAdapter(supportFragmentManager, competition.id!!, competition.currentSeason!!.currentMatchday!!)
        viewpager_main.adapter = fragmentAdapter

        tabs_main.setupWithViewPager(viewpager_main)
    }


}
