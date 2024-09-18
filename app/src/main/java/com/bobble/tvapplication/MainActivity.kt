package com.bobble.tvapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.tv.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.Surface
import com.bobble.tvapplication.data.repo.MovieRepository
import com.bobble.tvapplication.ui.screens.catalog.CatalogScreen
import com.bobble.tvapplication.ui.screens.catalog.CatalogViewModel
import com.bobble.tvapplication.ui.theme.TVApplicationTheme

class MainActivity : ComponentActivity() {

    private val viewModel: CatalogViewModel by viewModels<CatalogViewModel>()

    @OptIn(ExperimentalTvMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TVApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    shape = RectangleShape
                ) {
                    CatalogScreen(viewModel)
                }
            }
        }
    }
}