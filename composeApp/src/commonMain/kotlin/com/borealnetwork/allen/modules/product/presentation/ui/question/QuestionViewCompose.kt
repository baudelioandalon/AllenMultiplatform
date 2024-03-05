package com.borealnetwork.allen.modules.product.presentation.ui.question

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.borealnetwork.allen.components.EditText
import com.borealnetwork.allen.components.QuestionItem
import com.borealnetwork.allen.components.SearcherWithButton
import com.borealnetwork.allen.components.SemiBoldText
import com.borealnetwork.allen.components.ShadowButton
import com.borealnetwork.allen.components.ToolbarTitle
import com.borealnetwork.allen.components.extensions.drawColoredShadow
import com.borealnetwork.allen.domain.model.QuestionModel
import com.borealnetwork.allen.theme.BlueTransparent
import com.borealnetwork.allen.theme.GrayBackgroundMain
import com.borealnetwork.allen.theme.GraySubtitleBottom

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun QuestionViewCompose() {

    Scaffold(
        modifier = Modifier.fillMaxSize(), topBar = {
            ToolbarTitle(
                titleText = "Preguntas", startClicked = {
//                navController?.navigateUp()
                },
                endIcon = "ic_questions_icon.xml"
            )

        },
        bottomBar = {
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
                            text = "Preguntar",
                            color = GraySubtitleBottom,
                            fontSize = 18.sp
                        )
                        EditText(
                            modifier = Modifier.padding(bottom = 30.dp, top = 18.dp),
                            placeHolderText = "Escribe una pregunta al vendedor",
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
                            text = "Hacer pregunta"
                        )
                    }
                }
            }
        }) {


        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(GrayBackgroundMain)
        ) {
            stickyHeader {
                SearcherWithButton(
                    modifier = Modifier
                        .background(White)
                        .padding(top = 30.dp, end = 30.dp, start = 30.dp, bottom = 15.dp),
                    value = "",
                    placeHolder = "Buscar pregunta...",
                    onValueChange = {

                    }
                )
            }

            val questionList = listOf(
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
                )
            )
            itemsIndexed(
                questionList
            ) { index, item ->
                QuestionItem(
                    text = item.question,
                    likesList = item.likesList,
                    answerList = item.answerList
                )
            }


            item {
                Spacer(modifier = Modifier.height(300.dp))
            }
        }


        it.calculateBottomPadding()
    }
}