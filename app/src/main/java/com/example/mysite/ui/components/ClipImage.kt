package com.example.mysite.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp

@Composable
fun ClipImage(image: Painter, name: String, description: String) {
        Image(painter = image, contentDescription = name,
            modifier = Modifier
                .size(width = 80.dp, height = 80.dp)
                .clip(CircleShape)
                .border(
                    shape = CircleShape,
                    border = BorderStroke(4.dp, SolidColor(Color.White))
                )
                .padding(4.dp),
            contentScale = ContentScale.FillHeight,
            alignment = Alignment.CenterEnd,
            alpha = 0.9F,
        )
        Text(text = name, style = MaterialTheme.typography.subtitle1)
        Text(text = "「$description」", style = MaterialTheme.typography.subtitle2, color = Color.Gray)
}