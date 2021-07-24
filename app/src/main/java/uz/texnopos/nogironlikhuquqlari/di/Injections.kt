package uz.texnopos.mehrtilsimi.di

import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import uz.texnopos.mehrtilsimi.data.DisibiltyRigthsDatabase
import uz.texnopos.mehrtilsimi.ui.author.AuthorViewModel
import uz.texnopos.mehrtilsimi.ui.rights.RightViewModel
import uz.texnopos.mehrtilsimi.ui.settings.Settings

val dataModule = module {
    single { DisibiltyRigthsDatabase.getInstance(androidContext()).dao() }
    single { Settings(androidContext()) }
}
val viewModelModule = module {
    viewModel { AuthorViewModel(get()) }
    viewModel { RightViewModel(get()) }
}