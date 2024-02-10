package com.borealnetwork.allen.presentation.ui.general.logingraph

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.borealnetwork.allen.components.BoldText
import com.borealnetwork.allen.components.BackButton
import com.borealnetwork.allen.components.BlueButton
import com.borealnetwork.allen.components.CornerButton
import com.borealnetwork.allen.components.CornerImgButton
import com.borealnetwork.allen.components.FavoriteButton
import com.borealnetwork.allen.components.FavoriteCounterButton
import com.borealnetwork.allen.components.GoalIcon
import com.borealnetwork.allen.components.GrayButton
import com.borealnetwork.allen.components.LittleAddButton
import com.borealnetwork.allen.components.LocationIcon
import com.borealnetwork.allen.components.MinimumAddButton
import com.borealnetwork.allen.components.RightRoundedButton
import com.borealnetwork.allen.components.ScannerButton
import com.borealnetwork.allen.components.ShareButton
import com.borealnetwork.allen.openUrl
import com.borealnetwork.allen.platform
import com.borealnetwork.allen.theme.AppTheme
import com.borealnetwork.allen.theme.LocalThemeIsDark
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource

@Composable
internal fun LoginUI() = AppTheme {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisibility by remember { mutableStateOf(false) }
    val scrollState = rememberScrollState()

    Column(modifier = Modifier.fillMaxSize().windowInsetsPadding(WindowInsets.safeDrawing).verticalScroll(scrollState)) {

        Row(
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Login",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(16.dp)
            )

            Spacer(modifier = Modifier.weight(1.0f))

            var isDark by LocalThemeIsDark.current
            IconButton(
                onClick = { isDark = !isDark }
            ) {
                Icon(
                    modifier = Modifier.padding(8.dp).size(20.dp),
                    imageVector = if (isDark) Icons.Default.LightMode else Icons.Default.DarkMode,
                    contentDescription = null
                )
            }
        }

        Row(
            modifier = Modifier.height(200.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            KamelImage(
                asyncPainterResource(
                    "https://firebasestorage.googleapis.com/v0/b/safestudent-a0e1e.appspot.com/o/Alter%2Fproducts%2F0ac75350-4c79-428e-ae20-ad74688a8dde-_s?alt=media&token=aa8aedd6-f250-45b7-a2e9-6762bd1576a0",
                ),
                contentDescription = "imageExample"
            )
        }

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth().padding(16.dp)
        )

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            singleLine = true,
            visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            ),
            trailingIcon = {
                IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                    val imageVector =
                        if (passwordVisibility) Icons.Default.Close else Icons.Default.Edit
                    Icon(
                        imageVector,
                        contentDescription = if (passwordVisibility) "Hide password" else "Show password"
                    )
                }
            }
        )

        Button(
            onClick = { /* Handle login logic here */ },
            modifier = Modifier.fillMaxWidth().padding(16.dp)
        ) {
            BoldText(text = "Login en ${platform().name}")
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            FavoriteButton()
            FavoriteCounterButton()
            ShareButton()
            BackButton()
            LittleAddButton(modifier = Modifier.padding(10.dp))
            MinimumAddButton(modifier = Modifier.padding(10.dp))

        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            LocationIcon()
            GoalIcon()
            RightRoundedButton()
        }

        BlueButton(modifier = Modifier.padding(10.dp),text = "Bienvenido")
//        ShadowButton(labelId = R.string.welcome_button_enter)
        CornerButton(modifier = Modifier.padding(10.dp), text = "Entrar")
        CornerImgButton(modifier = Modifier.padding(10.dp), text = "Entrar")
//        CornerImgButton(
//            imgId = R.drawable.ic_google_logo,
//            labelId = R.string.google_name,
//            modifier = Modifier.fillMaxWidth()
//        )
        ScannerButton(text = "Scanner")

        GrayButton()
        TextButton(
            onClick = {
                openUrl("https://github.com/baudelioandalon")
            },
            modifier = Modifier.fillMaxWidth().padding(16.dp)
        ) {
            Text("Open github")
        }
    }
}