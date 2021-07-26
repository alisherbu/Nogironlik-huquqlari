package uz.texnopos.nogironlikhuquqlari

import android.app.Application
import android.content.Context
import android.content.res.Resources
import dev.b3nedikt.app_locale.AppLocale
import dev.b3nedikt.app_locale.SharedPrefsAppLocaleRepository
import dev.b3nedikt.reword.RewordInterceptor
import dev.b3nedikt.viewpump.ViewPump
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import uz.texnopos.nogironlikhuquqlari.core.Constants.CYRIL
import uz.texnopos.nogironlikhuquqlari.core.Constants.LATIN
import uz.texnopos.nogironlikhuquqlari.core.SharedPrefUtils
import uz.texnopos.nogironlikhuquqlari.di.dataModule
import uz.texnopos.nogironlikhuquqlari.di.viewModelModule
import java.util.*

class App:Application() {
    private val modules = listOf(
         viewModelModule, dataModule
    )
    override fun onCreate() {
        super.onCreate()
        appInstance =this
        AppLocale.supportedLocales= listOf(LATIN,CYRIL)

        // Optional: Persist changes to the desiredLocale to sharedPreferences
        AppLocale.appLocaleRepository = SharedPrefsAppLocaleRepository(this)

        ViewPump.init(RewordInterceptor)

        startKoin {
            androidLogger()
            androidContext(this@App)
            androidFileProperties()
            koin.loadModules(modules)
        }

    }

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(AppLocale.wrap(newBase))
    }

    override fun getResources(): Resources {
        return AppLocale.wrap(baseContext).resources
    }

    companion object {
        private lateinit var appInstance: App
        var sharedPrefUtils: SharedPrefUtils? = null

        fun getAppInstance(): App {
            return appInstance
        }
    }

}