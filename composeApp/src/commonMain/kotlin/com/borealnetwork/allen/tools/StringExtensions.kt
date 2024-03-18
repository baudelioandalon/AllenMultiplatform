package com.borealnetwork.allen.tools

fun String.cut(limit: Int = Int.MAX_VALUE) = if (limit > length) this else substring(0, limit)+"..."