package com.borealnetwork.allen.modules.product.presentation.ui.rating

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.borealnetwork.allen.components.EditText
import com.borealnetwork.allen.components.RatingByUserItem
import com.borealnetwork.allen.components.SemiBoldText
import com.borealnetwork.allen.components.ShadowButton
import com.borealnetwork.allen.components.ToolbarTitle
import com.borealnetwork.allen.components.extensions.drawColoredShadow
import com.borealnetwork.allen.modules.product.domain.models.QuestionModel
import com.borealnetwork.allen.theme.BlueTransparent
import com.borealnetwork.allen.theme.GrayBackgroundMain
import com.borealnetwork.allen.theme.GraySubtitleBottom
import moe.tlaster.precompose.navigation.Navigator
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun RatingProductViewCompose(navigator: Navigator) {

    Scaffold(topBar = {
        ToolbarTitle(
            titleText = "Calificaciones", startClicked = {
//                navController.navigateUp()
            },
            endIcon = "ic_questions_icon.xml"
        )
    }, bottomBar = {
        Card(
            modifier = Modifier
                .fillMaxWidth(),
            elevation = 9.dp
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)
                    .background(White),
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    modifier = Modifier.padding(
                        start = 30.dp, end = 30.dp,
                        bottom = 18.dp
                    ),
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.Start
                ) {
                    SemiBoldText(
                        text = "Calificar",
                        color = GraySubtitleBottom,
                        fontSize = 18.sp
                    )
                    EditText(
                        modifier = Modifier.padding(bottom = 30.dp, top = 18.dp),
                        placeHolderText = "Califica el producto",
                        value = "",
                        onValueChange = {

                        }
                    )
                    ShadowButton(
                        modifier = Modifier
                            .padding(bottom = 18.dp)
                            .fillMaxWidth()
                            .drawColoredShadow(
                                color = BlueTransparent, alpha = 1f, borderRadius = 10.dp,
                                offsetY = 6.dp, offsetX = 5.dp, blurRadius = 10.dp
                            ),
                        text = "Enviar calificación"
                    )
                }
            }
        }
    }) {

        val ratingList = listOf(
            QuestionModel(
                question = "¿Sirve para 220v?",
                imageUser = "",
                likesList = listOf("33", "33333", "33332"),
                answerList = listOf("Si, incluso para 110v")
            ), QuestionModel(
                question = "¿Es nuevo el articulo?",
                imageUser = "",
                likesList = listOf("33", "333"),
                answerList = listOf(
                    "¡Asi es, todos nuestros " +
                            "articulos son nuevos " +
                            "completamente!", "A precios bajos"
                )
            ), QuestionModel(
                question = "¿Costo de envio?",
                imageUser = "",
                answerList = listOf(
                    "¡Comprando 4 el envio es gratis¡"
                )
            ),
            QuestionModel(
                question = "¿Costo de envio?",
                imageUser = "",
                answerList = listOf(
                    "¡Comprando 4 el envio es gratis¡"
                )
            ),
            QuestionModel(
                question = "¿Costo de envio?",
                imageUser = "",
                answerList = listOf(
                    "¡Comprando 4 el envio es gratis¡"
                )
            ), QuestionModel(
                question = "¿Costo de envio?",
                imageUser = "",
                answerList = listOf(
                    "¡Comprando 4 el envio es gratis¡"
                )
            ), QuestionModel(
                question = "¿Costo de envio?",
                imageUser = "",
                answerList = listOf(
                    "¡Comprando 4 el envio es gratis¡"
                )
            ), QuestionModel(
                question = "¿Costo de envio?",
                imageUser = "",
                answerList = listOf(
                    "¡Comprando 4 el envio es gratis¡"
                )
            ),
            QuestionModel(
                question = "¿Costo de envio a 48290?",
                imageUser = "",
                answerList = listOf(
                    "¡Comprando 4 el envio es gratis¡"
                )
            )
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(GrayBackgroundMain)
        ) {

            stickyHeader {
                Box(
                    modifier = Modifier.fillMaxWidth().background(White)
                        .padding(horizontal = 30.dp, vertical = 23.dp)
                ) {
                    SemiBoldText(
                        modifier = Modifier.align(Alignment.CenterStart),
                        text = "${ratingList.size} calificaciones",
                        fontSize = 15.sp
                    )
                    Row(
                        modifier = Modifier.align(Alignment.CenterEnd),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        SemiBoldText(
                            modifier = Modifier.padding(end = 15.dp),
                            text = "Todos",
                            fontSize = 18.sp
                        )
                        Icon(
                            painter = painterResource(resource = DrawableResource(  "ic_arrow_down.xml")),
                            contentDescription = "options"
                        )
                    }
                }

            }


            items(
                items = ratingList
            ) { item ->
                RatingByUserItem(
                    text = item.question,
                    likesList = item.likesList
                )
            }

            item {
                Spacer(modifier = Modifier.height(300.dp))
            }
        }
        it.calculateBottomPadding()
    }

}