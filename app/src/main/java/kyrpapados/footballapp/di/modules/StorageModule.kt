package kyrpapados.footballapp.di.modules

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import kyrpapados.footballapp.utils.Statics.Companion.PREFERENCES

@Module
class StorageModule {
    @Provides
    internal fun provideSharedPreferences(application: Application): SharedPreferences {
        return application.getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE)
    }
}