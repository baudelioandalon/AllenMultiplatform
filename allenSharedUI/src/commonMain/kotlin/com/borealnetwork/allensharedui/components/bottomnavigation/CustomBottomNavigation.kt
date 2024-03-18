package com.borealnetwork.allensharedui.components.bottomnavigation

import androidx.compose.runtime.Composable

//@Composable
//fun CustomBottomNavigation(
//    currentScreenId: String,
//    onItemSelected: (SellerScreen) -> Unit
//) {
//    val items = listOf(SellerScreen.HomeSellerScreen, SellerScreen.ProductsSellerScreen)
//
//    Card(
//        elevation = CardDefaults.cardElevation(
//            defaultElevation = 0.dp,
//            focusedElevation = 0.dp
//        )
//    ) {
//        Row(
//            modifier = Modifier
//                .background(MaterialTheme.colorScheme.background)
//                .padding(8.dp)
//                .height(80.dp)
//                .fillMaxWidth(),
//            horizontalArrangement = Arrangement.SpaceAround,
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            items.forEach { item ->
//                CustomBottomNavigationItem(
//                    item = item,
//                    isSelected = item.route == currentScreenId
//                ) {
//                    onItemSelected(item)
//                }
//            }
//        }
//    }
//
//}

//@Composable
//fun CustomBottomNavigationItem(item: SellerScreen, isSelected: Boolean, onClick: () -> Unit) {
//
//    val background =
//        if (isSelected) MaterialTheme.colorScheme.primary.copy(alpha = 0.1f) else Color.Transparent
//    val contentColor =
//        if (isSelected) MaterialTheme.colorScheme.primary else GrayLetterShipping
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
//                painter = painterResource(resource = DrawableResource(item.icon)),
//                contentDescription = null,
//                tint = contentColor
//            )
//
//            AnimatedVisibility(visible = isSelected) {
//                BoldText(
//                    text = item.title,
//                    color = contentColor,
//                    fontSize = 12.sp
//                )
//            }
//
//        }
//    }
//}