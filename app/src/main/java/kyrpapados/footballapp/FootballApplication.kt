package kyrpapados.footballapp


import android.app.Activity
import android.app.Application
import android.content.Context
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import kyrpapados.footballapp.di.DaggerAppComponent
import kyrpapados.footballapp.utils.Statics.Companion.BALL_DIMENS
import kyrpapados.footballapp.utils.Statics.Companion.FIRST_INSTALL
import kyrpapados.footballapp.utils.Statics.Companion.PREFERENCES
import kyrpapados.footballapp.utils.Statics.Companion.SCREEN_WIDTH
import kyrpapados.footballapp.utils.Statics.Companion.TEXT_DIMENS
import kyrpapados.footballapp.utils.helper.PreferencesHelper

import javax.inject.Inject

class FootballApplication : Application(), HasActivityInjector {
    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()


        DaggerAppComponent.builder()
                .application(this)
                .build().inject(this)

        val preferencesHelper = PreferencesHelper(getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE))
        // first install set locale language
        if (preferencesHelper.getFirstInstall()) {
            preferencesHelper.putBoolean(FIRST_INSTALL, false)


            // setup size & text
            setupBallViewMeasurements(preferencesHelper, 10)
        }
    }

    /**
     * find the ball size & text, for the specific device
     */
    private fun setupBallViewMeasurements(preferencesHelper: PreferencesHelper, maxBallsPerLine: Int) {
        val displayMetrics = resources.displayMetrics
        val ballSize = displayMetrics.widthPixels / (maxBallsPerLine + 1)
        val textSize = ballSize * 0.35f

        preferencesHelper.putInt(BALL_DIMENS, ballSize)
        preferencesHelper.putFloat(TEXT_DIMENS, textSize)

        // setup screen width
        preferencesHelper.putInt(SCREEN_WIDTH, displayMetrics.widthPixels)
    }

    override fun activityInjector(): DispatchingAndroidInjector<Activity> = androidInjector

}