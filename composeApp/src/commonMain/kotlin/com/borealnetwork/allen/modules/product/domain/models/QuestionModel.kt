package com.borealnetwork.allen.modules.product.domain.models

data class QuestionModel(
    val question: String,
    val imageUser: String,
    val likesList: List<String> = emptyList(),
    val answerList: List<String>
)