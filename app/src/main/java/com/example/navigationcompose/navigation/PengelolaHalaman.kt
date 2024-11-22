package com.example.navigationcompose.navigation

import android.widget.MediaController
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.navigationcompose.ui.view.screen.RencanaStudyView
import com.example.navigationcompose.ui.view.screen.SplashView
import com.example.navigationcompose.ui.view.viewmodel.MahasiswaViewModel
import com.example.navigationcompose.ui.view.viewmodel.RencanaStudyViewModel

enum class Halaman{
    Splash,
    Mahasiswa,
    MataKuliah,
    Tampil
}

@Composable
fun MahasiswaApp(
    modifier: Modifier = Modifier,
    mahasiswaViewModel: MahasiswaViewModel = viewModel(),
    krsViewModel: RencanaStudyViewModel = viewModel(),
    navController: NavHostController = remember NavController()
){
    val mahasiswaUiState = mahasiswaViewModel.mahasiswaUistate.collectAsState().value
    navHost(
        navController = navController,
        startDestination = Halaman.Splash.name,
        modifier = Modifier.padding()

    ){
        composable(route = Halaman.Splash.name){
            SplashView (onMulaiButton = {
                navController.navigate(
                    Halaman.Mahasiswa.name
                )
            })
        }
        composable(route = Halaman.Mahasiswa.name){
            MahasiswaFormView(
                onSubmitButtonClicked = {
                    MahasiswaViewModel.saveDataMahasiswa(it)
                    navController.navigate(Halaman.MataKuliah.name)
                },
                onBackButtonClicked = {
                    navController.popBackStack()
                }
            )
        }
        composable(route = Halaman.MataKuliah.name){
            RencanaStudyView(
                mahasiswa = mahasiswaUiState,
                onSubmitClicked = {krsViewModel.saveDataKrs(it)},
                onBackButtonClicked = {navController.popBackStack()}
            )
        }
    }
}