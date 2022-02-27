package com.example.mysite.ui.girl

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.mysite.data.girls
import com.example.mysite.ui.components.ClipImage

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun GirlBody() {
    Column(
        Modifier.fillMaxSize(1f).padding(10.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Lovely Girls", style = MaterialTheme.typography.subtitle1, color = MaterialTheme.colors.primary)
        Text("大家都是我的天使！", style = MaterialTheme.typography.subtitle2, color = Color.Gray)
        Spacer(Modifier.height(16.dp))
        LazyVerticalGrid(
            cells = GridCells.Fixed(2)
        ) {
            items(girls.size) {
                Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(bottom = 8.dp)) {
                    var item = girls[it]
                    val image: Painter = rememberImagePainter(item.avatar)
                    ClipImage(image = image, name = item.name, description = item.description)
                }
            }
        }
    }

}
