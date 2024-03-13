package com.borealnetwork.shared.core.network.domain.models

class AuthModel(
    var id: Int? = null,
    var aud: String = "",
    var auth_time: Int = 0,
    var dateCreated: Long = 0L,
    var email: String = "",
    var name: String = "",
    var email_verified: Boolean = false,
    var sign_in_provider: String = AuthenticationType.EMAIL.name,
    var picture: String = "",
    var exp: Int = 0,
    var iat: Int = 0,
    var userType: String = UserType.CLIENT.type,
    var user_id: String = ""
)