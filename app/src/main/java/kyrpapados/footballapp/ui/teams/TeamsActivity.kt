package kyrpapados.footballapp.ui.teams

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_teams.*
import kyrpapados.footballapp.R
import kyrpapados.footballapp.data.model.local.teams.SquadItem
import kyrpapados.footballapp.data.model.local.teams.Teams
import kyrpapados.footballapp.ui.base.BaseActivity
import kyrpapados.footballapp.utils.GlideApp
import kyrpapados.footballapp.utils.Statics
import kyrpapados.footballapp.utils.Statics.Companion.COMPETITION_ID
import kyrpapados.footballapp.utils.Statics.Companion.TEAM_ID
import javax.inject.Inject

class TeamsActivity : BaseActivity(), TeamsContract.View {

    @Inject
    lateinit var mPresenter: TeamsPresenter<TeamsContract.View>

    private var teamId: Int = 0

    private lateinit var mAdapter: TeamsAdapter

    private var competitionId: Int = 0

    companion object {
        fun show(activity: Activity, id: Int, competitionId: Int) {
            val intent = Intent(activity, TeamsActivity::class.java)
            intent.putExtra(TEAM_ID, id)
            intent.putExtra(COMPETITION_ID, competitionId)
            activity.startActivity(intent)
        }
    }

    override fun setLayout(): Int = R.layout.activity_teams

    override fun getActivityTitle(): String = ""

    override fun getActivityLogo(): String = ""

    override fun getLocalLogo(): Int {
        return if(competitionId == 2001){
            R.drawable.logo_cl
        }else if (competitionId == 2021){
            R.drawable.logo_premier_league
        }else if (competitionId == 2015){
            R.drawable.logo_ligue_1
        }else if (competitionId == 2002){
            R.drawable.logo_bundesliga
        }else if (competitionId == 2019){
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
        teamId = intent.getIntExtra(TEAM_ID, 0)
        competitionId = intent.getIntExtra(COMPETITION_ID, 0)
    }

    override fun init(savedInstanceState: Bundle?) {
        val mLayoutManager = LinearLayoutManager(this)
        squadView.layoutManager = mLayoutManager
        squadView.itemAnimator = DefaultItemAnimator()
        squadView.addItemDecoration(DividerItemDecoration(squadView.context, mLayoutManager.orientation))

        mPresenter.fetchTeamInformation(teamId)
    }


    override fun showTeamInformation(team: Teams, coach: String, goalKeepersList: MutableList<SquadItem>, defendersList: MutableList<SquadItem>, midfieldersList: MutableList<SquadItem>, attackersList: MutableList<SquadItem>) {
        GlideApp.with(this)
                .load(team.crestUrl)
                .override(350, 350)
                .centerCrop()
                .into(team_img)

        team_name.text = team.name
        team_address.text = getString(R.string.team_address, team.address)
        team_phone.text = getString(R.string.team_phone, team.phone)
        team_website.text = getString(R.string.team_website, team.website)
        team_email.text = getString(R.string.team_email, team.email)
        team_founded.text = getString(R.string.team_founded, team.founded.toString())
        team_colors.text = getString(R.string.team_colors, team.clubColors)



        team_coach.text = getString(R.string.team_coach, coach)

        var squadList : MutableList<SquadItem> = arrayListOf()

        squadList.addAll(goalKeepersList)
        squadList.addAll(defendersList)
        squadList.addAll(midfieldersList)
        squadList.addAll(attackersList)

        mAdapter = TeamsAdapter(this, squadList)
        squadView.adapter = mAdapter
    }

}
