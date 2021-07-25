package uz.texnopos.nogironlikhuquqlari.di

import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import uz.texnopos.nogironlikhuquqlari.data.DisibiltyRigthsDatabase
import uz.texnopos.nogironlikhuquqlari.ui.author.AuthorViewModel
import uz.texnopos.nogironlikhuquqlari.ui.legislation.LegislationViewModel
import uz.texnopos.nogironlikhuquqlari.ui.questions.QuestionsViewModel
import uz.texnopos.nogironlikhuquqlari.ui.rights.RightViewModel
import uz.texnopos.nogironlikhuquqlari.ui.settings.Settings

val dataModule = module {
    single { DisibiltyRigthsDatabase.getInstance(androidContext()).dao() }
    single { Settings() }
}
val viewModelModule = module {
    viewModel { AuthorViewModel(get()) }
    viewModel { RightViewModel(get()) }
    viewModel { QuestionsViewModel(get()) }
    viewModel { LegislationViewModel(get()) }
}