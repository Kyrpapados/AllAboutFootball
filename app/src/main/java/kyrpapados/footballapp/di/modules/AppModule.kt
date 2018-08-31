package kyrpapados.footballapp.di.modules

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class AppModule  {

    @Provides
    fun provideApplication(applicationInst: Application): Context {
        return applicationInst.applicationContext
    }
}