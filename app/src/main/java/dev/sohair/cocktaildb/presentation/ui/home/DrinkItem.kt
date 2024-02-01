package dev.sohair.cocktaildb.presentation.ui.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import dev.sohair.cocktaildb.data.local.Drink

@Composable
fun DrinkItem(item: Drink, onClick: (Drink) -> Unit) {
    Column(
        modifier = Modifier
            .size(200.dp)
            .padding(8.dp)
            .clickable { onClick(item) }
    ) {
        AsyncImage(
            model = item.imageUrl,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .sizeIn(maxHeight = 120.dp)
                .clip(RoundedCornerShape(12.dp))
                .padding(bottom = 8.dp)
        )
        Text(
            text = item.name, fontWeight = FontWeight.SemiBold, fontSize = 14.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Text(text = item.category, fontSize = 12.sp)
    }
}