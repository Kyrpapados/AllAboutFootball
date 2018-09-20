package kyrpapados.footballapp.ui.leagueboard

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import kyrpapados.footballapp.ui.leagueboard.fixtures.FixturesFragment
import kyrpapados.footballapp.ui.leagueboard.results.ResultsFragment
import kyrpapados.footballapp.ui.leagueboard.standings.StandingsFragment

class LeaguePagerAdapter (fm: FragmentManager,val id : Int,val currentMatchday : Int) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                StandingsFragment.newInstance(id)
            }
            1 -> FixturesFragment.show(id, currentMatchday)
            else -> {
                return ResultsFragment.show(id, currentMatchday)
            }
        }
    }

    override fun getCount(): Int {
        return 3
    }

    override fun getPageTitle(position: Int): CharSequence {
        return when (position) {
            0 -> "Table"
            1 -> "Fixtures"
            else -> {
                return "Results"
            }
        }
    }
}