package uz.texnopos.mehrtilsimi

import android.app.Application
import androidx.core.content.ContextCompat
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import uz.texnopos.mehrtilsimi.core.SharedPrefUtils
import uz.texnopos.mehrtilsimi.di.dataModule
import uz.texnopos.mehrtilsimi.di.viewModelModule

class App:Application() {
    private val modules = listOf(
         viewModelModule, dataModule
    )
    override fun onCreate() {
        super.onCreate()
        appInstance=this

        startKoin {
            androidLogger()
            androidContext(this@App)
            androidFileProperties()
            koin.loadModules(modules)
        }

    }
    companion object {
        private lateinit var appInstance: App
        var sharedPrefUtils: SharedPrefUtils? = null

        fun getAppInstance(): App {
            return appInstance
        }
    }
}