package com.borealnetwork.allen.theme


import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Shapes
import androidx.compose.material.Surface
import androidx.compose.material.Typography
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.font.FontWeight.Companion.Light
import androidx.compose.ui.text.font.FontWeight.Companion.Medium
import androidx.compose.ui.text.font.FontWeight.Companion.Normal
import androidx.compose.ui.text.font.FontWeight.Companion.SemiBold
import androidx.compose.ui.text.font.FontWeight.Companion.Thin
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.borealnetwork.allen.font

private enum class TypographyEmbedded() {
    ROBOTO, MONTSERRAT
}

private val DEFAULT_TYPOGRAPHY = TypographyEmbedded.MONTSERRAT

private val LightColorScheme = lightColors(
    primary = PrimaryColor,
    onPrimary = PrimaryEndColor,
    secondary = md_theme_light_secondary,
    onSecondary = md_theme_light_onSecondary,
    error = md_theme_light_error,
    onError = md_theme_light_onError,
    background = md_theme_light_background,
    onBackground = md_theme_light_onBackground,
    surface = md_theme_light_surface,
    onSurface = md_theme_light_onSurface,
)

private val DarkColorScheme = darkColors(
    primary = md_theme_dark_primary,
    onPrimary = md_theme_dark_onPrimary,
    secondary = md_theme_dark_secondary,
    onSecondary = md_theme_dark_onSecondary,
    error = md_theme_dark_error,
    onError = md_theme_dark_onError,
    background = md_theme_dark_background,
    onBackground = md_theme_dark_onBackground,
    surface = md_theme_dark_surface,
    onSurface = md_theme_dark_onSurface,
)

private val AppShapes = Shapes(
    small = RoundedCornerShape(4.dp),
    medium = RoundedCornerShape(8.dp),
    large = RoundedCornerShape(16.dp),
)


@Composable
fun thinTypo() = FontFamily(
    when (DEFAULT_TYPOGRAPHY) {
        TypographyEmbedded.MONTSERRAT -> font(
            "Montserrat",
            "montserrat_thin",
            Thin,
            FontStyle.Normal
        )

        else -> {

            font(
                "Roboto", "roboto_thin", Thin, FontStyle.Normal
            )
        }
    }
)

@Composable
fun lightTypo() = FontFamily(
    when (DEFAULT_TYPOGRAPHY) {
        TypographyEmbedded.MONTSERRAT -> font(
            "Montserrat",
            "montserrat_light",
            Light,
            FontStyle.Normal
        )

        else -> {

            font(
                "Roboto", "roboto_light", Light, FontStyle.Normal
            )
        }
    }
)

@Composable
fun regularTypo() = FontFamily(
    when (DEFAULT_TYPOGRAPHY) {
        TypographyEmbedded.MONTSERRAT -> font(
            "Montserrat",
            "montserrat_regular",
            Normal,
            FontStyle.Normal
        )

        else -> {

            font(
                "Roboto", "roboto", Normal, FontStyle.Normal
            )
        }
    }
)

@Composable
fun mediumTypo() =
    FontFamily(
        when (DEFAULT_TYPOGRAPHY) {
            TypographyEmbedded.MONTSERRAT -> font(
                "Montserrat",
                "montserrat_medium",
                Medium,
                FontStyle.Normal
            )

            else -> {

                font(
                    "Roboto", "roboto", Medium, FontStyle.Normal
                )
            }
        }
    )

@Composable
fun semiBoldTypo() = FontFamily(
    when (DEFAULT_TYPOGRAPHY) {
        TypographyEmbedded.MONTSERRAT -> font(
            "Montserrat",
            "montserrat_semibold",
            Normal,
            FontStyle.Normal
        )

        else -> {

            font(
                "Roboto", "roboto", SemiBold, FontStyle.Normal
            )
        }
    }
)

@Composable
fun boldTypo() =
    FontFamily(
        when (DEFAULT_TYPOGRAPHY) {
            TypographyEmbedded.MONTSERRAT -> font(
                "Montserrat",
                "montserrat_bold",
                Bold,
                FontStyle.Normal
            )

            else -> {

                font(
                    "Roboto", "roboto_bold", Bold, FontStyle.Normal
                )
            }
        }
    )


internal val LocalThemeIsDark = compositionLocalOf { mutableStateOf(false) }


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTheme(
    content: @Composable () -> Unit,
) {
    val systemIsDark = isSystemInDarkTheme()
    val isDarkState = remember { mutableStateOf(systemIsDark) }

    val defaultTypography = Typography(
        defaultFontFamily = regularTypo(),
        h1 = TextStyle(
            fontFamily = regularTypo(),
            fontWeight = Bold,
            fontSize = 30.sp,
            color = Color.Black
        ),
        h2 = TextStyle(
            fontFamily = regularTypo(),
            fontWeight = SemiBold,
            fontSize = 24.sp,
            color = Color.Black
        ),
        h3 = TextStyle(
            fontFamily = regularTypo(),
            fontWeight = Medium,
            fontSize = 20.sp,
            color = Color.Black
        ),
        h4 = MaterialTheme.typography.h4.copy(fontFamily = regularTypo()),
        h5 = MaterialTheme.typography.h5.copy(fontFamily = regularTypo()),
        h6 = MaterialTheme.typography.h6.copy(fontFamily = regularTypo()),
        body1 = MaterialTheme.typography.body1.copy(fontFamily = regularTypo()),
        body2 = MaterialTheme.typography.body2.copy(fontFamily = regularTypo()),
        caption = TextStyle(
            fontFamily = regularTypo(),
            fontWeight = Normal,
            fontSize = 12.sp,
        ),
        subtitle1 = MaterialTheme.typography.subtitle1.copy(fontFamily = regularTypo()),
        subtitle2 = MaterialTheme.typography.subtitle2.copy(fontFamily = regularTypo())
    )


    CompositionLocalProvider(
        LocalThemeIsDark provides isDarkState
    ) {

        val isDark by isDarkState
        SystemAppearance(isDark)

        MaterialTheme(
            typography = defaultTypography,
            shapes = AppShapes,
            colors = if (isDark) DarkColorScheme else LightColorScheme,
            content = {
                Surface(content = content)
            }
        )
    }
}

@Composable
internal expect fun SystemAppearance(isDark: Boolean)
