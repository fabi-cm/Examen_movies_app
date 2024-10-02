package com.example.practica_github

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
//import com.example.network.GithubRemoteDataSource
import com.example.network.Movie
import com.example.network.MovieRemoteDataSource
import com.example.network.RetrofitBuilder
import com.example.practica_github.ui.theme.Practica_githubTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GitUiActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        val context = applicationContext

//        val name = intent.extras?.getString("name")
//        if ( name !== null) {
//            Toast.makeText(context, name, Toast.LENGTH_LONG).show()
//        }
        intent.extras?.getString("name")?.let {
            Toast.makeText(context, it, Toast.LENGTH_LONG).show()
        }

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Practica_githubTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting2(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
                    MovieUi( modifier = Modifier.padding(innerPadding), context = context)
                }
            }
        }
    }
}

//@Composable
//fun GitUi(modifier: Modifier = Modifier, context: Context) {
//
//    val dataSource: GithubRemoteDataSource = GithubRemoteDataSource(
//        RetrofitBuilder
//    )
//
//    var urlImage by remember { mutableStateOf("")}
//    var userId by remember { mutableStateOf("") }
//
//    var name by remember { mutableStateOf("") }
//    var company by remember { mutableStateOf("") }
//    var bio by remember { mutableStateOf("") }
//
//    Column(
//        modifier = modifier
//            .fillMaxHeight()
//            .fillMaxWidth(),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Text(
//            text = stringResource(id = R.string.github_ui_title)
//        )
//        TextField(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(5.dp),
//            value = userId, onValueChange = {
//                userId = it
//
//            })
//        Button(onClick = {
//            urlImage = ""
//            CoroutineScope(Dispatchers.IO).launch {
//                try {
//                    val response = dataSource.getAvatarInfo(userId)
//                    urlImage = response.url
//                    name = response.name ?: "Name not available"
//                    company = response.company ?: "Company not available"
//                    bio = response.bio ?: "Bio not available"
//                } catch (e: Exception) {
//                    CoroutineScope(Dispatchers.Main).launch {
//                        Toast.makeText(context, "Error fetching data", Toast.LENGTH_LONG).show()
//                    }
//                }
//            }
//        }) {
//            Text(text = stringResource(id = R.string.github_ui_button))
//        }
//        Row {
//
//        }
//        AsyncImage(
//            model = urlImage,
//            contentDescription = null
//        )
//        Text(text = "Name: $name")
//        Text(text = "Company: $company")
//        Text(text = "Bio: $bio")
//    }
//}

@Composable
fun Greeting2(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    Practica_githubTheme {
        Greeting2("Android")
    }
}

@Composable
fun MovieUi(modifier: Modifier = Modifier, context: Context) {

    val dataSource: MovieRemoteDataSource = MovieRemoteDataSource(RetrofitBuilder.apiService)

    var movies by remember { mutableStateOf(listOf<Movie>()) }

    CoroutineScope(Dispatchers.IO).launch {
        movies = dataSource.getPopularMovies()
    }
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(movies) { movie ->
            MovieItem(movie = movie)
        }
    }
//    LazyColumn(
//        modifier = modifier
//            .fillMaxSize()
//            .padding(16.dp),
//        verticalArrangement = Arrangement.spacedBy(8.dp)
//    ) {
//        items(movies) { movie ->
//            MovieItem(movie = movie)
//        }
//    }
}

@Composable
fun MovieItem(movie: Movie) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            model = "https://image.tmdb.org/t/p/w185/${movie.posterPath}",
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
        )
        Text(
            text = movie.title,
            modifier = Modifier.padding(8.dp)
        )
    }
}