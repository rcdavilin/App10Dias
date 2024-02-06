package com.example.app10dias

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.app10dias.model.Monumentos
import com.example.app10dias.model.MonumentosRepository.monumentos
import com.example.app10dias.ui.theme.App10DiasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App10DiasTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MonumentosApp()
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MonumentosTopAppBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier
                        .size(dimensionResource(id = R.dimen.image_size))
                        .padding(dimensionResource(id = R.dimen.padding_small)),
                    painter = painterResource(R.drawable.logo),

                    contentDescription = null
                )
                Text(
                    text = stringResource(R.string.app_name),
                    style = MaterialTheme.typography.displayLarge
                )
            }
        },
        modifier = modifier
    )
}
/**
 * Composable that displays an app bar and a list of dogs.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MonumentosApp() {
    Scaffold(
        topBar = {
            MonumentosTopAppBar()
        }
    ) { it ->
        LazyColumn(contentPadding = it) {
            items(monumentos) {
                MonumentosItem(
                    monumentos = it,
                    modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_small))
                )

            }
        }
    }
}




@Composable
fun MonumentosItem(
    monumentos: Monumentos,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }

    Card(
        modifier = modifier
    ) {
        Column(modifier = Modifier.animateContentSize(
            animationSpec = spring(
                dampingRatio = Spring.DampingRatioMediumBouncy,
                stiffness = Spring.StiffnessHigh
            )
        ).background(MaterialTheme.colorScheme.errorContainer) ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(R.dimen.padding_small))
            ) {
                MonumentosIcon(monumentos.imageMonumento)
                MonumentosName(monumentos.monumentoTitulo)
                Spacer(Modifier.weight(1f))
                MonumentosItemButton(
                    expanded = expanded,
                    onClick = { expanded = !expanded},
                )
            }
            if(expanded){
                MonumentosInfo(
                    monumentos.monumentoInfo,
                    modifier = Modifier.padding(
                        start = dimensionResource(R.dimen.padding_medium),
                       top = dimensionResource(R.dimen.padding_small),
                       end = dimensionResource(R.dimen.padding_medium),
                       bottom = dimensionResource(R.dimen.padding_medium)
                   )
               )
           }

        }
    }
}



@Composable
private fun MonumentosItemButton(
    expanded: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    IconButton(
        onClick = onClick,
        modifier = modifier
    ) {
        Icon(
            imageVector = if (expanded) Icons.Filled.KeyboardArrowDown else Icons.Filled.KeyboardArrowUp,
            contentDescription = stringResource(R.string.expand_button_content_description),
            tint = MaterialTheme.colorScheme.secondary
        )

    }
}


@Composable
fun MonumentosIcon(
    @DrawableRes monumentoIcon: Int,
    modifier: Modifier = Modifier
) {
    Image(
        modifier = modifier
            .size(dimensionResource(R.dimen.image_size))
            .padding(dimensionResource(R.dimen.padding_small))
            .clip(MaterialTheme.shapes.small),
        contentScale = ContentScale.Crop,
        painter = painterResource(monumentoIcon),
        contentDescription = null
    )
}


@Composable
fun MonumentosName(
    @StringRes monumentoName: Int,

    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(dimensionResource(R.dimen.padding_small)),
    ) {
        Text(
            text = stringResource(monumentoName),
            style = MaterialTheme.typography.displayMedium,
            modifier = Modifier.padding(top = dimensionResource(R.dimen.padding_small))
        )


    }
}

@Composable
fun MonumentosInfo(
   @StringRes monumentosHobby: Int,
   modifier: Modifier = Modifier
) {
   Column(
        modifier = modifier
    ) {
       Text(
           text = stringResource(R.string.informacion),
           style = MaterialTheme.typography.labelSmall
       )
        Text(
            text = stringResource(monumentosHobby),
           style = MaterialTheme.typography.bodyLarge
        )
   } }
/**
 * Composable that displays what the UI of the app looks like in light theme in the design tab.
 */
@Preview
@Composable
fun MonumentosPreview() {
    App10DiasTheme(darkTheme = false) {
        MonumentosApp()
    }
}

@Preview
@Composable
fun MonumentosDarkThemePreview() {
    App10DiasTheme(darkTheme = true) {
        MonumentosApp()
    }
}