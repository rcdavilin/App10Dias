package com.example.app10dias

import android.content.Intent
import android.net.Uri
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import com.example.app10dias.model.Monumentos
import com.example.app10dias.model.MonumentosRepository

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MonumentosTopAppBar() {

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
            items(MonumentosRepository.monumentos) {
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
        Column(modifier = Modifier
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessHigh
                )
            )
            .fillMaxSize()) {

            MonumentosName(monumentos.monumentoTitulo)
            MonumentosItemButton(
                expanded = expanded,
                onClick = {expanded = !expanded}
            )
            ImagenClickable(monumentos = monumentos)
           

            if(expanded){
                MonumentosInfo(
                    monumentosHobby = monumentos.monumentoInfo,
                    linkResId = monumentos.linkWikipedia,
                    modifier = Modifier.padding(start = dimensionResource(R.dimen.padding_medium),
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
fun MonumentosIcon(
    @DrawableRes monumentos: Int,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Image(
        modifier = modifier
            .fillMaxSize()
            .padding(dimensionResource(R.dimen.padding_small))
            .clip(MaterialTheme.shapes.small)
            .clickable(onClick = onClick),
        contentScale = ContentScale.Crop,
        painter = painterResource(monumentos),
        contentDescription = null
    )
}

@Composable
private fun ImagenClickable(monumentos : Monumentos){

    var posicion by remember { mutableStateOf(0) }

    when(posicion){
        0 -> MonumentosIcon(monumentos = monumentos.imageMonumento) {
            posicion = (posicion + 1) % 3
        }
        1 -> MonumentosIcon(monumentos = monumentos.imageMonumento1) {
            posicion = (posicion + 1) % 3
        }
        2 -> MonumentosIcon(monumentos = monumentos.imageMonumento2) {
            posicion = (posicion + 1) % 3
        }
    }
}

@Composable
fun MonumentosName(
    @StringRes monumentoName: Int,

    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .padding(dimensionResource(R.dimen.padding_small))
            .fillMaxSize(),
    ) {
        Text(
            modifier = Modifier
                .padding(top = dimensionResource(R.dimen.padding_small))
                .fillMaxSize(),
            text = stringResource(monumentoName),
            style = MaterialTheme.typography.displayMedium,
            textAlign = TextAlign.Center
        )


    }
}

@Composable
fun MonumentosInfo(
    @StringRes monumentosHobby: Int,
    @StringRes linkResId: Int,
    modifier: Modifier = Modifier
) {
    val localContext = LocalContext.current
    val link = stringResource(id = linkResId)
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

        TextButton(onClick = {

            val intento = Intent(Intent.ACTION_VIEW)
            intento.data = Uri.parse(link)
            ContextCompat.startActivity(localContext, intento, null)
        }) {
            Text(
                text = "\uD83C\uDF10"
            )
            Text(
                text = link,
                fontSize = 15.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp),
                textAlign = TextAlign.Left,
                color = Color.Black,
                textDecoration = TextDecoration.Underline
            )

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