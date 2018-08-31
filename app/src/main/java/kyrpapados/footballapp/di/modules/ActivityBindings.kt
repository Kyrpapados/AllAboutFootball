package kyrpapados.footballapp.di.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import kyrpapados.footballapp.ui.home.HomeActivity
import kyrpapados.footballapp.ui.leagueboard.LeagueActivity
import kyrpapados.footballapp.ui.teams.TeamsActivity

@Module
abstract class ActivityBindings {
    @ContributesAndroidInjector
    abstract fun contributeHomeActivity(): HomeActivity

    @ContributesAndroidInjector(modules = [FragmentBindingModule::class])
    abstract fun contributeLeagueActivity(): LeagueActivity

    @ContributesAndroidInjector(modules = [FragmentBindingModule::class])
    abstract fun contributeTeamsActivity(): TeamsActivity
}