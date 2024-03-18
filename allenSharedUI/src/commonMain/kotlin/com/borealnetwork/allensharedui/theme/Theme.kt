package com.borealnetwork.allensharedui.theme


import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Shapes
import androidx.compose.material.Typography
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
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
import com.borealnetwork.shared.SystemAppearance
import com.borealnetwork.shared.font

private enum class TypographyEmbedded() {
    ROBOTO, MONTSERRAT
}

private val DEFAULT_TYPOGRAPHY = TypographyEmbedded.MONTSERRAT
const val loadingString =
    "{\"nm\":\"Comp 1\",\"ddd\":0,\"h\":500,\"w\":500,\"meta\":{\"g\":\"@lottiefiles/toolkit-js 0.33.2\"},\"layers\":[{\"ty\":4,\"nm\":\"Shape Layer 5\",\"sr\":1,\"st\":0,\"op\":387.000015762833,\"ip\":0,\"hd\":false,\"ddd\":0,\"bm\":0,\"hasMask\":false,\"ao\":0,\"ks\":{\"a\":{\"a\":0,\"k\":[0,0,0],\"ix\":1},\"s\":{\"a\":0,\"k\":[362.228,362.228,100],\"ix\":6},\"sk\":{\"a\":0,\"k\":0},\"p\":{\"a\":0,\"k\":[250,250,0],\"ix\":2},\"r\":{\"a\":0,\"k\":0,\"ix\":10},\"sa\":{\"a\":0,\"k\":0},\"o\":{\"a\":0,\"k\":100,\"ix\":11}},\"ef\":[],\"shapes\":[{\"ty\":\"gr\",\"bm\":0,\"hd\":false,\"mn\":\"ADBE Vector Group\",\"nm\":\"Shape 1\",\"ix\":1,\"cix\":2,\"np\":3,\"it\":[{\"ty\":\"sh\",\"bm\":0,\"hd\":false,\"mn\":\"ADBE Vector Shape - Group\",\"nm\":\"Path 1\",\"ix\":1,\"d\":1,\"ks\":{\"a\":0,\"k\":{\"c\":true,\"i\":[[-2.003,0],[-0.231,-6.654],[-4.034,-2.519],[0,-4.262],[3.615,-2.257],[0.165,-4.753],[6.655,0],[1.814,0.965],[2.33,0],[2.057,-1.094],[2.003,0],[0.231,6.654],[4.034,2.519],[0,4.262],[-3.615,2.257],[-0.165,4.753],[-6.655,0],[-1.814,-0.965],[-2.33,0],[-2.057,1.094]],\"o\":[[6.655,0],[0.165,4.753],[3.615,2.257],[0,4.262],[-4.034,2.519],[-0.231,6.654],[-2.003,0],[-2.057,-1.094],[-2.33,0],[-1.814,0.965],[-6.655,0],[-0.165,-4.753],[-3.615,-2.257],[0,-4.262],[4.034,-2.519],[0.231,-6.654],[2.003,0],[2.057,1.094],[2.33,0],[1.814,-0.965]],\"v\":[[12.457,-33.889],[24.737,-22.024],[31.441,-10.411],[37.214,0],[31.442,10.411],[24.737,22.024],[12.457,33.889],[6.705,32.435],[0,30.762],[-6.705,32.435],[-12.457,33.889],[-24.737,22.024],[-31.441,10.411],[-37.214,0],[-31.441,-10.411],[-24.737,-22.024],[-12.457,-33.889],[-6.705,-32.434],[0,-30.762],[6.705,-32.434]]},\"ix\":2}},{\"ty\":\"gs\",\"bm\":0,\"hd\":false,\"mn\":\"ADBE Vector Graphic - G-Stroke\",\"nm\":\"Gradient Stroke 1\",\"e\":{\"a\":0,\"k\":[100,0],\"ix\":5},\"g\":{\"p\":3,\"k\":{\"a\":0,\"k\":[0,0.20392156862745098,0.5607843137254902,0.8666666666666667,0.485,0.9725490196078431,0.2235294117647059,0.5019607843137255,1,0.9411764705882353,0,1],\"ix\":8}},\"t\":1,\"a\":{\"a\":0,\"k\":0},\"h\":{\"a\":0,\"k\":0},\"s\":{\"a\":0,\"k\":[0,0],\"ix\":4},\"lc\":2,\"lj\":1,\"ml\":4,\"o\":{\"a\":0,\"k\":100,\"ix\":9},\"w\":{\"a\":0,\"k\":2,\"ix\":10}},{\"ty\":\"fl\",\"bm\":0,\"hd\":false,\"mn\":\"ADBE Vector Graphic - Fill\",\"nm\":\"Fill 1\",\"c\":{\"a\":0,\"k\":[0.4118,0.6784,0.7765],\"ix\":4},\"r\":1,\"o\":{\"a\":0,\"k\":0,\"ix\":5}},{\"ty\":\"tr\",\"a\":{\"a\":0,\"k\":[0,0],\"ix\":1},\"s\":{\"a\":0,\"k\":[100,100],\"ix\":3},\"sk\":{\"a\":0,\"k\":0,\"ix\":4},\"p\":{\"a\":0,\"k\":[0,0],\"ix\":2},\"r\":{\"a\":0,\"k\":0,\"ix\":6},\"sa\":{\"a\":0,\"k\":0,\"ix\":5},\"o\":{\"a\":0,\"k\":100,\"ix\":7}}]},{\"ty\":\"tm\",\"bm\":0,\"hd\":false,\"mn\":\"ADBE Vector Filter - Trim\",\"nm\":\"Trim Paths 1\",\"ix\":2,\"e\":{\"a\":0,\"k\":28,\"ix\":2},\"o\":{\"a\":1,\"k\":[{\"o\":{\"x\":0.167,\"y\":0.167},\"i\":{\"x\":0.833,\"y\":0.833},\"s\":[0],\"t\":0},{\"s\":[360],\"t\":90.0000036657751}],\"ix\":3},\"s\":{\"a\":0,\"k\":0,\"ix\":1},\"m\":1}],\"ind\":1},{\"ty\":4,\"nm\":\"Shape Layer 4\",\"sr\":1,\"st\":0,\"op\":387.000015762833,\"ip\":0,\"hd\":false,\"ddd\":0,\"bm\":0,\"hasMask\":false,\"ao\":0,\"ks\":{\"a\":{\"a\":0,\"k\":[0,0,0],\"ix\":1},\"s\":{\"a\":0,\"k\":[362.228,362.228,100],\"ix\":6},\"sk\":{\"a\":0,\"k\":0},\"p\":{\"a\":0,\"k\":[250,250,0],\"ix\":2},\"r\":{\"a\":0,\"k\":60,\"ix\":10},\"sa\":{\"a\":0,\"k\":0},\"o\":{\"a\":0,\"k\":100,\"ix\":11}},\"ef\":[],\"shapes\":[{\"ty\":\"gr\",\"bm\":0,\"hd\":false,\"mn\":\"ADBE Vector Group\",\"nm\":\"Shape 1\",\"ix\":1,\"cix\":2,\"np\":3,\"it\":[{\"ty\":\"sh\",\"bm\":0,\"hd\":false,\"mn\":\"ADBE Vector Shape - Group\",\"nm\":\"Path 1\",\"ix\":1,\"d\":1,\"ks\":{\"a\":0,\"k\":{\"c\":true,\"i\":[[-2.003,0],[-0.231,-6.654],[-4.034,-2.519],[0,-4.262],[3.615,-2.257],[0.165,-4.753],[6.655,0],[1.814,0.965],[2.33,0],[2.057,-1.094],[2.003,0],[0.231,6.654],[4.034,2.519],[0,4.262],[-3.615,2.257],[-0.165,4.753],[-6.655,0],[-1.814,-0.965],[-2.33,0],[-2.057,1.094]],\"o\":[[6.655,0],[0.165,4.753],[3.615,2.257],[0,4.262],[-4.034,2.519],[-0.231,6.654],[-2.003,0],[-2.057,-1.094],[-2.33,0],[-1.814,0.965],[-6.655,0],[-0.165,-4.753],[-3.615,-2.257],[0,-4.262],[4.034,-2.519],[0.231,-6.654],[2.003,0],[2.057,1.094],[2.33,0],[1.814,-0.965]],\"v\":[[12.457,-33.889],[24.737,-22.024],[31.441,-10.411],[37.214,0],[31.442,10.411],[24.737,22.024],[12.457,33.889],[6.705,32.435],[0,30.762],[-6.705,32.435],[-12.457,33.889],[-24.737,22.024],[-31.441,10.411],[-37.214,0],[-31.441,-10.411],[-24.737,-22.024],[-12.457,-33.889],[-6.705,-32.434],[0,-30.762],[6.705,-32.434]]},\"ix\":2}},{\"ty\":\"gs\",\"bm\":0,\"hd\":false,\"mn\":\"ADBE Vector Graphic - G-Stroke\",\"nm\":\"Gradient Stroke 1\",\"e\":{\"a\":0,\"k\":[100,0],\"ix\":5},\"g\":{\"p\":3,\"k\":{\"a\":0,\"k\":[0,0,0.7764705882352941,1,0.485,0.24705882352941178,0.38823529411764707,1,1,0.49411764705882355,0,1],\"ix\":8}},\"t\":1,\"a\":{\"a\":0,\"k\":0},\"h\":{\"a\":0,\"k\":0},\"s\":{\"a\":0,\"k\":[0,0],\"ix\":4},\"lc\":2,\"lj\":1,\"ml\":4,\"o\":{\"a\":0,\"k\":100,\"ix\":9},\"w\":{\"a\":0,\"k\":0.5,\"ix\":10}},{\"ty\":\"fl\",\"bm\":0,\"hd\":false,\"mn\":\"ADBE Vector Graphic - Fill\",\"nm\":\"Fill 1\",\"c\":{\"a\":0,\"k\":[0.4118,0.6784,0.7765],\"ix\":4},\"r\":1,\"o\":{\"a\":0,\"k\":0,\"ix\":5}},{\"ty\":\"tr\",\"a\":{\"a\":0,\"k\":[0,0],\"ix\":1},\"s\":{\"a\":0,\"k\":[100,100],\"ix\":3},\"sk\":{\"a\":0,\"k\":0,\"ix\":4},\"p\":{\"a\":0,\"k\":[0,0],\"ix\":2},\"r\":{\"a\":0,\"k\":0,\"ix\":6},\"sa\":{\"a\":0,\"k\":0,\"ix\":5},\"o\":{\"a\":0,\"k\":100,\"ix\":7}}]},{\"ty\":\"tm\",\"bm\":0,\"hd\":false,\"mn\":\"ADBE Vector Filter - Trim\",\"nm\":\"Trim Paths 1\",\"ix\":2,\"e\":{\"a\":0,\"k\":28,\"ix\":2},\"o\":{\"a\":1,\"k\":[{\"o\":{\"x\":0.167,\"y\":0.167},\"i\":{\"x\":0.833,\"y\":0.833},\"s\":[0],\"t\":0},{\"s\":[360],\"t\":90.0000036657751}],\"ix\":3},\"s\":{\"a\":0,\"k\":0,\"ix\":1},\"m\":1}],\"ind\":2},{\"ty\":4,\"nm\":\"Shape Layer 3\",\"sr\":1,\"st\":0,\"op\":387.000015762833,\"ip\":0,\"hd\":false,\"ddd\":0,\"bm\":0,\"hasMask\":false,\"ao\":0,\"ks\":{\"a\":{\"a\":0,\"k\":[0,0,0],\"ix\":1},\"s\":{\"a\":0,\"k\":[362.228,362.228,100],\"ix\":6},\"sk\":{\"a\":0,\"k\":0},\"p\":{\"a\":0,\"k\":[250,250,0],\"ix\":2},\"r\":{\"a\":0,\"k\":30,\"ix\":10},\"sa\":{\"a\":0,\"k\":0},\"o\":{\"a\":0,\"k\":100,\"ix\":11}},\"ef\":[],\"shapes\":[{\"ty\":\"gr\",\"bm\":0,\"hd\":false,\"mn\":\"ADBE Vector Group\",\"nm\":\"Shape 1\",\"ix\":1,\"cix\":2,\"np\":3,\"it\":[{\"ty\":\"sh\",\"bm\":0,\"hd\":false,\"mn\":\"ADBE Vector Shape - Group\",\"nm\":\"Path 1\",\"ix\":1,\"d\":1,\"ks\":{\"a\":0,\"k\":{\"c\":true,\"i\":[[-2.003,0],[-0.231,-6.654],[-4.034,-2.519],[0,-4.262],[3.615,-2.257],[0.165,-4.753],[6.655,0],[1.814,0.965],[2.33,0],[2.057,-1.094],[2.003,0],[0.231,6.654],[4.034,2.519],[0,4.262],[-3.615,2.257],[-0.165,4.753],[-6.655,0],[-1.814,-0.965],[-2.33,0],[-2.057,1.094]],\"o\":[[6.655,0],[0.165,4.753],[3.615,2.257],[0,4.262],[-4.034,2.519],[-0.231,6.654],[-2.003,0],[-2.057,-1.094],[-2.33,0],[-1.814,0.965],[-6.655,0],[-0.165,-4.753],[-3.615,-2.257],[0,-4.262],[4.034,-2.519],[0.231,-6.654],[2.003,0],[2.057,1.094],[2.33,0],[1.814,-0.965]],\"v\":[[12.457,-33.889],[24.737,-22.024],[31.441,-10.411],[37.214,0],[31.442,10.411],[24.737,22.024],[12.457,33.889],[6.705,32.435],[0,30.762],[-6.705,32.435],[-12.457,33.889],[-24.737,22.024],[-31.441,10.411],[-37.214,0],[-31.441,-10.411],[-24.737,-22.024],[-12.457,-33.889],[-6.705,-32.434],[0,-30.762],[6.705,-32.434]]},\"ix\":2}},{\"ty\":\"gs\",\"bm\":0,\"hd\":false,\"mn\":\"ADBE Vector Graphic - G-Stroke\",\"nm\":\"Gradient Stroke 1\",\"e\":{\"a\":0,\"k\":[100,0],\"ix\":5},\"g\":{\"p\":3,\"k\":{\"a\":0,\"k\":[0,1,0.8235294117647058,0,0.485,0.5019607843137255,0.8117647058823529,0.5019607843137255,1,0,0.8,1],\"ix\":8}},\"t\":1,\"a\":{\"a\":0,\"k\":0},\"h\":{\"a\":0,\"k\":0},\"s\":{\"a\":0,\"k\":[0,0],\"ix\":4},\"lc\":2,\"lj\":1,\"ml\":4,\"o\":{\"a\":0,\"k\":100,\"ix\":9},\"w\":{\"a\":0,\"k\":0.5,\"ix\":10}},{\"ty\":\"fl\",\"bm\":0,\"hd\":false,\"mn\":\"ADBE Vector Graphic - Fill\",\"nm\":\"Fill 1\",\"c\":{\"a\":0,\"k\":[0.4118,0.6784,0.7765],\"ix\":4},\"r\":1,\"o\":{\"a\":0,\"k\":0,\"ix\":5}},{\"ty\":\"tr\",\"a\":{\"a\":0,\"k\":[0,0],\"ix\":1},\"s\":{\"a\":0,\"k\":[100,100],\"ix\":3},\"sk\":{\"a\":0,\"k\":0,\"ix\":4},\"p\":{\"a\":0,\"k\":[0,0],\"ix\":2},\"r\":{\"a\":0,\"k\":0,\"ix\":6},\"sa\":{\"a\":0,\"k\":0,\"ix\":5},\"o\":{\"a\":0,\"k\":100,\"ix\":7}}]},{\"ty\":\"tm\",\"bm\":0,\"hd\":false,\"mn\":\"ADBE Vector Filter - Trim\",\"nm\":\"Trim Paths 1\",\"ix\":2,\"e\":{\"a\":0,\"k\":28,\"ix\":2},\"o\":{\"a\":1,\"k\":[{\"o\":{\"x\":0.167,\"y\":0.167},\"i\":{\"x\":0.833,\"y\":0.833},\"s\":[0],\"t\":0},{\"s\":[360],\"t\":90.0000036657751}],\"ix\":3},\"s\":{\"a\":0,\"k\":0,\"ix\":1},\"m\":1}],\"ind\":3},{\"ty\":4,\"nm\":\"Shape Layer 1\",\"sr\":1,\"st\":0,\"op\":387.000015762833,\"ip\":0,\"hd\":false,\"ddd\":0,\"bm\":0,\"hasMask\":false,\"ao\":0,\"ks\":{\"a\":{\"a\":0,\"k\":[0,0,0],\"ix\":1},\"s\":{\"a\":0,\"k\":[362.228,362.228,100],\"ix\":6},\"sk\":{\"a\":0,\"k\":0},\"p\":{\"a\":0,\"k\":[250,250,0],\"ix\":2},\"r\":{\"a\":0,\"k\":0,\"ix\":10},\"sa\":{\"a\":0,\"k\":0},\"o\":{\"a\":0,\"k\":8,\"ix\":11}},\"ef\":[],\"shapes\":[{\"ty\":\"gr\",\"bm\":0,\"hd\":false,\"mn\":\"ADBE Vector Group\",\"nm\":\"Shape 1\",\"ix\":1,\"cix\":2,\"np\":3,\"it\":[{\"ty\":\"sh\",\"bm\":0,\"hd\":false,\"mn\":\"ADBE Vector Shape - Group\",\"nm\":\"Path 1\",\"ix\":1,\"d\":1,\"ks\":{\"a\":0,\"k\":{\"c\":true,\"i\":[[-2.003,0],[-0.231,-6.654],[-4.034,-2.519],[0,-4.262],[3.615,-2.257],[0.165,-4.753],[6.655,0],[1.814,0.965],[2.33,0],[2.057,-1.094],[2.003,0],[0.231,6.654],[4.034,2.519],[0,4.262],[-3.615,2.257],[-0.165,4.753],[-6.655,0],[-1.814,-0.965],[-2.33,0],[-2.057,1.094]],\"o\":[[6.655,0],[0.165,4.753],[3.615,2.257],[0,4.262],[-4.034,2.519],[-0.231,6.654],[-2.003,0],[-2.057,-1.094],[-2.33,0],[-1.814,0.965],[-6.655,0],[-0.165,-4.753],[-3.615,-2.257],[0,-4.262],[4.034,-2.519],[0.231,-6.654],[2.003,0],[2.057,1.094],[2.33,0],[1.814,-0.965]],\"v\":[[12.457,-33.889],[24.737,-22.024],[31.441,-10.411],[37.214,0],[31.442,10.411],[24.737,22.024],[12.457,33.889],[6.705,32.435],[0,30.762],[-6.705,32.435],[-12.457,33.889],[-24.737,22.024],[-31.441,10.411],[-37.214,0],[-31.441,-10.411],[-24.737,-22.024],[-12.457,-33.889],[-6.705,-32.434],[0,-30.762],[6.705,-32.434]]},\"ix\":2}},{\"ty\":\"st\",\"bm\":0,\"hd\":false,\"mn\":\"ADBE Vector Graphic - Stroke\",\"nm\":\"Stroke 1\",\"lc\":2,\"lj\":1,\"ml\":4,\"o\":{\"a\":0,\"k\":100,\"ix\":4},\"w\":{\"a\":0,\"k\":4,\"ix\":5},\"c\":{\"a\":0,\"k\":[0.8157,0.8157,0.8157],\"ix\":3}},{\"ty\":\"fl\",\"bm\":0,\"hd\":false,\"mn\":\"ADBE Vector Graphic - Fill\",\"nm\":\"Fill 1\",\"c\":{\"a\":0,\"k\":[0.4118,0.6784,0.7765],\"ix\":4},\"r\":1,\"o\":{\"a\":0,\"k\":0,\"ix\":5}},{\"ty\":\"tr\",\"a\":{\"a\":0,\"k\":[0,0],\"ix\":1},\"s\":{\"a\":0,\"k\":[100,100],\"ix\":3},\"sk\":{\"a\":0,\"k\":0,\"ix\":4},\"p\":{\"a\":0,\"k\":[0,0],\"ix\":2},\"r\":{\"a\":0,\"k\":0,\"ix\":6},\"sa\":{\"a\":0,\"k\":0,\"ix\":5},\"o\":{\"a\":0,\"k\":100,\"ix\":7}}]},{\"ty\":\"tm\",\"bm\":0,\"hd\":false,\"mn\":\"ADBE Vector Filter - Trim\",\"nm\":\"Trim Paths 1\",\"ix\":2,\"e\":{\"a\":0,\"k\":100,\"ix\":2},\"o\":{\"a\":0,\"k\":0,\"ix\":3},\"s\":{\"a\":0,\"k\":0,\"ix\":1},\"m\":1}],\"ind\":4}],\"v\":\"5.5.5\",\"fr\":29.9700012207031,\"op\":91.000003706506,\"ip\":0,\"assets\":[]}"

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
fun robotoMediumTypo() = FontFamily(
    font(
        "Roboto", "roboto_medium", Normal, FontStyle.Normal
    )
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
            content = content
        )
    }
}

