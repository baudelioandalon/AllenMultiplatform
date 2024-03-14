package com.borealnetwork.shared.core.util

import dev.gitlive.firebase.auth.FirebaseUser


suspend fun FirebaseUser.getClaims(): Map<String, Any> = getIdTokenResult(false).claims
