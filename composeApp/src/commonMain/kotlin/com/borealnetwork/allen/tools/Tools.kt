package com.borealnetwork.allen.tools


fun String.isEmailValid() = if (trim { it <= ' ' }.isEmpty()) {
    false
} else {
    val emailAddressRegex = Regex(
        "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                "\\@" +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                "(" +
                "\\." +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                ")+"
    )
    matches(emailAddressRegex)
}