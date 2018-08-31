package kyrpapados.footballapp.di.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import kyrpapados.footballapp.ui.leagueboard.fixtures.FixturesFragment
import kyrpapados.footballapp.ui.leagueboard.results.ResultsFragment
import kyrpapados.footballapp.ui.leagueboard.standings.StandingsFragment


@Module
abstract class FragmentBindingModule {
    @ContributesAndroidInjector
    internal abstract fun contributeStandingsFragment(): StandingsFragment

    @ContributesAndroidInjector
    internal abstract fun contributeResultsFragment(): ResultsFragment

    @ContributesAndroidInjector
    internal abstract fun contributeFixturesFragment(): FixturesFragment
}