package com.lihan.dogproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lihan.dogproject.home_list.presentation.DogScreenRoot
import com.lihan.dogproject.home_list.presentation.DogViewModel
import com.lihan.dogproject.ui.theme.DogProjectTheme
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DogProjectTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    DogScreenRoot(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                            .padding(8.dp)
                    )
                }
            }
        }
    }
}
