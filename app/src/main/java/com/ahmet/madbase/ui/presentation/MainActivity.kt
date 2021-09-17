package com.ahmet.madbase.ui.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.Observer
import com.ahmet.madbase.ui.theme.MADBaseTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.InternalCoroutinesApi
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MADBaseTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting("Android")
                }
            }
        }

        mainViewModel.getPokemonList()

        mainViewModel.event.observe(this, Observer {
            it.getContentIfNotHandled()?.let { st ->
                when (st) {
                    MainUIState.SUCCESS -> Timber.tag("PokemonList").e("SUCCESS")
                    MainUIState.LOADING -> Timber.tag("PokemonList").e("LOADİNG")
                    MainUIState.ERROR -> Timber.tag("PokemonList").e("ERROR")
                }
            }
        })
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MADBaseTheme {
        Greeting("Android")
    }
}