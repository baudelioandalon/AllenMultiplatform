package com.borealnetwork.shared.core.network.domain.models.error_handler

import dev.gitlive.firebase.firestore.FirestoreExceptionCode


enum class FirestoreErrorEnum(
    val defaultError: String,
    val messageError: String,
    val errorCode: Int,
    val reason: String
) {
    ERROR_INVALID_PATH(
        "Invalid document reference. Document references must have an even number of segments",
        "La referencia del documento es invalida", FirestoreExceptionCode.NOT_FOUND.ordinal,
        ""
    ),
    ERROR_INVALID_FIELD_PATH(
        "Invalid field path",
        "Campo de ruta invalido", FirestoreExceptionCode.INVALID_ARGUMENT.ordinal,
        ""
    ),
    ERROR_NOT_FOUND(
        "NOT_FOUND: No document to update:",
        "No se encontró el documento a actualizar.", FirestoreExceptionCode.NOT_FOUND.ordinal,
        ""
    ),
    ERROR_DESERIALIZE_OBJECT(
        "Could not deserialize object.",
        "Ocurrio un error al deserializar un modelo, favor de validar la integridad de los datos.",
        7000,
        ""
    ),
    ERROR_PAYMENT_PAYED(
        "NOT_FOUND: No document to update:",
        "No se pudo completar porque el pago ya fue efectuado.",
        FirestoreExceptionCode.ABORTED.ordinal,
        ""
    ),
    ERROR_PERMISSION_DENIED(
        "PERMISSION_DENIED: Missing or insufficient permissions.",
        "No tienes permisos de lectura y/o escritura.",
        FirestoreExceptionCode.PERMISSION_DENIED.ordinal,
        ""
    ),
    ERROR_USER_NOT_FOUND(
        "There is no user record corresponding to this identifier. The user may have been deleted.",
        "No se encontró el correo registrado.",
        1,
        "Aún no está registrado"
    ),
    ERROR_INVALID_PASSWORD(
        "The supplied auth credential is incorrect, malformed or has expired.",
        "Usuario o contraseña invalidos",
        1,
        "Revise el correo y/o la contraseña."
    ),
    ERROR_NOT_VERIFIED_EMAIL(
        "The email isn't verified.",
        "Favor de revisar el correo para confirmar.",
        1,
        "Aún falta confirmar el correo, favor de revisar en spam."
    ),
    ERROR_USER_NOT_LOGGED_IN(
        "The user not logged in",
        "Favor de revisar el usuario y la contraseña",
        1,
        "Aún no se pudo iniciar sesion"
    ),
    ERROR_DEFAULT(
        "Error default",
        "Error desconocido", 0, "Se desconoce la causa"
    ),
    ERROR_UNAVAILABLE(
        "",
        "",
        FirestoreExceptionCode.UNAVAILABLE.ordinal,
        "The service is currently unavailable. This is a most likely a transient condition and may be corrected by retrying with a backoff."
    )
}