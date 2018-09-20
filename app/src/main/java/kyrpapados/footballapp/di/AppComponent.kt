package kyrpapados.footballapp.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import kyrpapados.footballapp.FootballApplication
import kyrpapados.footballapp.di.modules.*
import javax.inject.Singleton

@Singleton
@Component(modules = [(AndroidSupportInjectionModule::class), (ActivityBindings::class), (AppModule::class), (StorageModule::class), (FragmentBindingModule::class), (NetworkModule::class)])
interface AppComponent : AndroidInjector<FootballApplication> {
    fun inject(application: Application)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}