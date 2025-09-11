package krv.fit.bstu.basic_superheroes_app_material_design.page

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import krv.fit.bstu.basic_superheroes_app_material_design.R
import krv.fit.bstu.basic_superheroes_app_material_design.model.Hero
import krv.fit.bstu.basic_superheroes_app_material_design.model.HeroesRepository.heroes

@Preview
@Composable
fun HeroesScreen() {

    Scaffold(
        topBar = { TopAppBar() }
    ){ it ->

        LazyColumn(contentPadding = it) {
            items(heroes){
                ItemHero(
                    hero = it,
                    modifier = Modifier
                        .padding(
                        horizontal = dimensionResource(R.dimen.padding_medium),
                        vertical = dimensionResource(R.dimen.padding_small))
                        .clip(MaterialTheme.shapes.medium),
                )
            }
        }
    }

}


@Composable
fun ItemHero(
    hero: Hero,
    modifier: Modifier = Modifier
){
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        ),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
    )
    {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.padding_medium))
        ){

            ItemInfo(hero.nameRes, hero.descriptionRes,modifier = Modifier.weight(1f))
            ItemImg(hero.imageRes)
        }
    }
}

@Composable
fun ItemImg(
    @DrawableRes heroImage: Int,
    modifier: Modifier = Modifier
){
    Image(
        contentDescription = null,
        modifier = modifier
            .size(dimensionResource(id = R.dimen.image_size))
            .width(dimensionResource(id = R.dimen.image_size))
            .padding(start = dimensionResource(id = R.dimen.padding_medium))
            .clip(MaterialTheme.shapes.small),
        contentScale = ContentScale.Crop,
        painter = painterResource(heroImage),
    )

}

@Composable
fun ItemInfo(
    @StringRes heroName: Int,
    @StringRes heroInfo: Int,
    modifier: Modifier = Modifier
){
    Column(modifier = modifier) {
        Text(stringResource(heroName),
            style = MaterialTheme.typography.displaySmall,
           // modifier = Modifier.padding(top = dimensionResource(R.dimen.padding_small))
        )
        Text(stringResource(heroInfo),
            style = MaterialTheme.typography.bodyLarge,
            lineHeight = MaterialTheme.typography.displayMedium.fontSize
        )
    }

}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(
    modifier: Modifier = Modifier
){
    CenterAlignedTopAppBar(
        title = {
            Row(
            verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(R.string.top_app_bar),
                    style = MaterialTheme.typography.displayLarge
                )
            }
                },
        modifier = modifier
    )
}