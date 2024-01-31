package com.borealnetwork.allen.components.bottomnavigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

//@OptIn(ExperimentalAnimationApi::class)
@Composable
fun CustomBottomNavigation(
    currentScreenId: String,
    onItemSelected: () -> Unit
) {
//    val items = listOf(SellerScreen.HomeSellerScreen, SellerScreen.ProductsSellerScreen)

    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 0.dp,
            focusedElevation = 0.dp
        )
    ) {
        Row(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background)
                .padding(8.dp)
                .height(80.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
//            items.forEach { item ->
//                CustomBottomNavigationItem(
//                    item = item,
//                    isSelected = item.route == currentScreenId
//                ) {
//                    onItemSelected(item)
//                }
//            }
        }
    }

}

//@Composable
//fun CustomBottomNavigationItem(item: SellerScreen, isSelected: Boolean, onClick: () -> Unit) {
//
//    val background =
//        if (isSelected) MaterialTheme.colors.primary.copy(alpha = 0.1f) else Color.Transparent
//    val contentColor =
//        if (isSelected) MaterialTheme.colors.primary else GrayLetterShipping
//
//    Box(
//        modifier = Modifier
//            .clip(CircleShape)
//            .background(background)
//            .clickable(onClick = onClick)
//    ) {
//        Row(
//            modifier = Modifier
//                .padding(12.dp),
//            verticalAlignment = Alignment.CenterVertically,
//            horizontalArrangement = Arrangement.spacedBy(4.dp)
//        ) {
//
//            Icon(
//                painter = painterResource(id = item.icon),
//                contentDescription = null,
//                tint = contentColor
//            )
//
//            AnimatedVisibility(visible = isSelected) {
//                BoldText(
//                    text = item.title,
//                    color = contentColor,
//                    size = 12.sp
//                )
//            }
//
//        }
//    }
//}