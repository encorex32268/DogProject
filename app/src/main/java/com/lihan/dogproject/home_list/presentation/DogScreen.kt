package com.lihan.dogproject.home_list.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil3.compose.AsyncImagePainter
import coil3.compose.SubcomposeAsyncImage
import coil3.compose.SubcomposeAsyncImageContent
import com.lihan.dogproject.home_list.domain.model.Dog
import com.lihan.dogproject.ui.theme.DogProjectTheme
import org.koin.androidx.compose.koinViewModel

@Composable
fun DogScreenRoot(
    modifier: Modifier = Modifier,
    viewModel: DogViewModel = koinViewModel()
){
    val state by viewModel.state.collectAsStateWithLifecycle()

    DogScreen(
        modifier = modifier,
        state = state
    )
}

@Composable
fun DogScreen(
    modifier: Modifier = Modifier,
    state: DogState
) {
    Column(
        modifier = modifier,
    ){
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            text = "Dogs",
            style = MaterialTheme.typography.displayMedium
        )
        if (state.isLoading){
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                CircularProgressIndicator(
                    modifier = Modifier.size(50.dp)
                )
            }
        }else{
            LazyVerticalGrid(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                columns = GridCells.Fixed(2),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ){
                items(state.items){ dog ->
                    DogItem(
                        modifier = Modifier.fillMaxWidth(),
                        item = dog
                    )
                }
            }

        }
    }



}

@Composable
private fun DogItem(
    modifier: Modifier = Modifier,
    item: Dog
){
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(4.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        SubcomposeAsyncImage(
            modifier = Modifier.aspectRatio(
                ratio = 16/9f,
                matchHeightConstraintsFirst = true
            ),
            model = item.imageUrl,
            contentDescription = null,
            contentScale = ContentScale.Fit
        ) {
            val state by painter.state.collectAsState()
            if (state is AsyncImagePainter.State.Success) {
                SubcomposeAsyncImageContent()
            } else {
                Box(
                    modifier = Modifier.size(25.dp),
                    contentAlignment = Alignment.Center){
                    CircularProgressIndicator()
                }

            }
        }
        val name = item.breeds.firstOrNull()?.name?:"Unknown"
        Text(
            text = name,
            style = MaterialTheme.typography.bodyMedium
        )
    }

}


@Preview(showSystemUi = true)
@Composable
fun DogScreenPreview() {
    DogProjectTheme {
        DogScreenRoot()
    }

}