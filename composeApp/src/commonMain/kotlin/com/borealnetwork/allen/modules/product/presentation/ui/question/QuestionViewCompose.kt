package com.borealnetwork.allen.modules.product.presentation.ui.question

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.unit.dp
import com.borealnetwork.allensharedui.components.QuestionItem
import com.borealnetwork.allensharedui.components.SearcherWithButton
import com.borealnetwork.allensharedui.components.ToolbarTitle
import com.borealnetwork.allensharedui.components.bottom_actions.BottomEditTextItem
import com.borealnetwork.allen.modules.product.domain.models.QuestionModel
import com.borealnetwork.allensharedui.theme.GrayBackgroundMain
import moe.tlaster.precompose.navigation.Navigator

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun QuestionViewCompose(navigator: Navigator) {

    Scaffold(
        modifier = Modifier.fillMaxSize(), topBar = {
            ToolbarTitle(
                titleText = "Preguntas", startClicked = {
                    navigator.goBack()
                },
                endIconTint = null,
                endIcon = "ic_questions.xml"
            )

        },
        bottomBar = {
            BottomEditTextItem(
                topText = "Preguntar",
                placeHolderText = "Escribe una preguna al vendedor",
                buttonText = "Hacer pregunta"
            ) {

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