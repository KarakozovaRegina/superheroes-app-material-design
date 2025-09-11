package krv.fit.bstu.basic_superheroes_app_material_design

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import krv.fit.bstu.basic_superheroes_app_material_design.model.HeroesRepository
import krv.fit.bstu.basic_superheroes_app_material_design.page.HeroesScreen
import krv.fit.bstu.basic_superheroes_app_material_design.ui.theme.SuperheroesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SuperheroesTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.surface
                ) {
                    HeroesScreen()
                 }
            }
        }
    }
}

@Preview
@Composable
fun HeroesPreview() {
    SuperheroesTheme(darkTheme = false) {
        HeroesScreen()
    }
}