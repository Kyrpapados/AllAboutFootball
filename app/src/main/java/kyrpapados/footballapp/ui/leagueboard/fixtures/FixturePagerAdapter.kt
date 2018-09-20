package kyrpapados.footballapp.ui.leagueboard.fixtures

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import kyrpapados.footballapp.ui.leagueboard.fixtures.matchday.MatchDayFragment

class FixturePagerAdapter(fm: FragmentManager, val id : Int, val matchDays : List<Int>) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return MatchDayFragment.show(id, matchDays[position])
    }

    override fun getCount(): Int {
        return matchDays.size
    }

    override fun getPageTitle(position: Int): CharSequence {
        return "Matchday " + matchDays[position]
    }
}