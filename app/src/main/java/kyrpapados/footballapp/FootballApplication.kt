package kyrpapados.footballapp


import android.app.Activity
import android.app.Application
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import kyrpapados.footballapp.di.DaggerAppComponent

import javax.inject.Inject

class FootballApplication : Application(), HasActivityInjector {
    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()


        DaggerAppComponent.builder()
                .application(this)
                .build().inject(this)
    }

    override fun activityInjector(): DispatchingAndroidInjector<Activity> = androidInjector

}