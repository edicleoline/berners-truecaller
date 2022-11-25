package com.berners.truecaller.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

//private val LightColorPalette = TruecallerColors(
//
//    link = Blue700,
//    primary = Gray900,
//    secondary = Gray700,
//    tertiary = GrayBlue,
//    placeholder = Gray400,
//    error = Red600,
//
//
//    brand = Shadow5,
//    uiBackground = Neutral0,
//    uiBorder = Neutral4,
//    uiFloated = FunctionalGrey,
//    textHelp = Neutral6,
//    textInteractive = Neutral0,
//    textLink = Ocean11,
//    iconPrimary = Shadow11,
//    iconSecondary = Neutral7,
//    iconInteractive = Neutral0,
//    iconInteractiveInactive = Neutral1,
//    gradient6_1 = listOf(Shadow4, Ocean3, Shadow2, Ocean3, Shadow4),
//    gradient6_2 = listOf(Rose4, Lavender3, Rose2, Lavender3, Rose4),
//    gradient3_1 = listOf(Shadow2, Ocean3, Shadow4),
//    gradient3_2 = listOf(Rose2, Lavender3, Rose4),
//    gradient2_1 = listOf(Shadow4, Shadow11),
//    gradient2_2 = listOf(Ocean3, Shadow3),
//    backdrop = Color.Black.copy(alpha = 0.55f, red = 0f, green = 0f, blue = 0f),
//    widgetPrimaryBackground = Gray100,
//    widgetSecondaryBackground = Blue700,
//    widgetTertiaryBackground = Gray100,
//    navigationBackground = Color.White,
//
//
//    isDark = false
//)
//
//private val DarkColorPalette = TruecallerColors(
//    brand = Shadow1,
//    uiBackground = Neutral8,
//    uiBorder = Neutral3,
//    uiFloated = FunctionalDarkGrey,
//    textHelp = Neutral1,
//    textInteractive = Neutral7,
//    textLink = Ocean2,
//    iconPrimary = Shadow1,
//    iconSecondary = Neutral0,
//    iconInteractive = Neutral7,
//    iconInteractiveInactive = Neutral6,
//    error = FunctionalRedDark,
//    gradient6_1 = listOf(Shadow5, Ocean7, Shadow9, Ocean7, Shadow5),
//    gradient6_2 = listOf(Rose11, Lavender7, Rose8, Lavender7, Rose11),
//    gradient3_1 = listOf(Shadow9, Ocean7, Shadow5),
//    gradient3_2 = listOf(Rose8, Lavender7, Rose11),
//    gradient2_1 = listOf(Ocean3, Shadow3),
//    gradient2_2 = listOf(Ocean7, Shadow7),
//
//    link = Blue700,
//    primary = Gray900,
//    secondary = Neutral0,
//    tertiary = Gray600,
//    placeholder = Gray600,
//    backdrop = Color.White.copy(alpha = 0.55f, red = 0f, green = 0f, blue = 0f),
//    widgetPrimaryBackground = Gray100,
//    widgetSecondaryBackground = Gray100,
//    widgetTertiaryBackground = Gray100,
//    navigationBackground = Color.White,
//
//    isDark = true
//)

@Composable
fun TruecallerTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
//    val colors = if (darkTheme) DarkColorPalette else LightColorPalette
//
//    val sysUiController = LocalSysUiController.current
//    SideEffect {
//        sysUiController.setSystemBarsColor(
//            color = colors.uiBackground.copy(alpha = AlphaNearOpaque)
//        )
//    }

    MaterialTheme(
        colors = if (darkTheme) TrueDarkColors else TrueLightColors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}

//object TruecallerTheme {
//    val colors: TruecallerColors
//        @Composable
//        get() = LocalTruecallerColors.current
//}
//
//@Stable
//class TruecallerColors(
//    primary: Color,
//    secondary: Color,
//    tertiary: Color,
//    link: Color,
//
//
//    gradient6_1: List<Color>,
//    gradient6_2: List<Color>,
//    gradient3_1: List<Color>,
//    gradient3_2: List<Color>,
//    gradient2_1: List<Color>,
//    gradient2_2: List<Color>,
//    brand: Color,
//    uiBackground: Color,
//    uiBorder: Color,
//    uiFloated: Color,
//    interactivePrimary: List<Color> = gradient2_1,
//    interactiveSecondary: List<Color> = gradient2_2,
//    interactiveMask: List<Color> = gradient6_1,
//    placeholder: Color,
//    textHelp: Color,
//    textInteractive: Color,
//    textLink: Color,
//    iconPrimary: Color = brand,
//    iconSecondary: Color,
//    iconInteractive: Color,
//    iconInteractiveInactive: Color,
//    error: Color,
//    notificationBadge: Color = error,
//
//    backdrop: Color,
//    widgetPrimaryBackground: Color,
//    widgetSecondaryBackground: Color,
//    widgetTertiaryBackground: Color,
//    navigationBackground: Color,
//
//    isDark: Boolean
//) {
//    var primary by mutableStateOf(primary)
//        private set
//    var secondary by mutableStateOf(secondary)
//        private set
//    var tertiary by mutableStateOf(tertiary)
//        private set
//    var link by mutableStateOf(link)
//        private set
//
//
//    var gradient6_1 by mutableStateOf(gradient6_1)
//        private set
//    var gradient6_2 by mutableStateOf(gradient6_2)
//        private set
//    var gradient3_1 by mutableStateOf(gradient3_1)
//        private set
//    var gradient3_2 by mutableStateOf(gradient3_2)
//        private set
//    var gradient2_1 by mutableStateOf(gradient2_1)
//        private set
//    var gradient2_2 by mutableStateOf(gradient2_2)
//        private set
//    var brand by mutableStateOf(brand)
//        private set
//    var uiBackground by mutableStateOf(uiBackground)
//        private set
//    var uiBorder by mutableStateOf(uiBorder)
//        private set
//    var uiFloated by mutableStateOf(uiFloated)
//        private set
//    var interactivePrimary by mutableStateOf(interactivePrimary)
//        private set
//    var interactiveSecondary by mutableStateOf(interactiveSecondary)
//        private set
//    var interactiveMask by mutableStateOf(interactiveMask)
//        private set
//
//    var placeholder by mutableStateOf(placeholder)
//        private set
//    var textHelp by mutableStateOf(textHelp)
//        private set
//    var textInteractive by mutableStateOf(textInteractive)
//        private set
//    var textLink by mutableStateOf(textLink)
//        private set
//    var iconPrimary by mutableStateOf(iconPrimary)
//        private set
//    var iconSecondary by mutableStateOf(iconSecondary)
//        private set
//    var iconInteractive by mutableStateOf(iconInteractive)
//        private set
//    var iconInteractiveInactive by mutableStateOf(iconInteractiveInactive)
//        private set
//    var error by mutableStateOf(error)
//        private set
//    var notificationBadge by mutableStateOf(notificationBadge)
//        private set
//
//    var backdrop by mutableStateOf(backdrop)
//        private set
//    var widgetPrimaryBackground by mutableStateOf(widgetPrimaryBackground)
//        private set
//    var widgetSecondaryBackground by mutableStateOf(widgetSecondaryBackground)
//        private set
//    var widgetTertiaryBackground by mutableStateOf(widgetTertiaryBackground)
//        private set
//    var navigationBackground by mutableStateOf(navigationBackground)
//        private set
//
//    var isDark by mutableStateOf(isDark)
//        private set
//
//    fun update(other: TruecallerColors) {
//        primary = other.primary
//        secondary = other.secondary
//        tertiary = other.tertiary
//        link = other.link
//
//
//        gradient6_1 = other.gradient6_1
//        gradient6_2 = other.gradient6_2
//        gradient3_1 = other.gradient3_1
//        gradient3_2 = other.gradient3_2
//        gradient2_1 = other.gradient2_1
//        gradient2_2 = other.gradient2_2
//        brand = other.brand
//        uiBackground = other.uiBackground
//        uiBorder = other.uiBorder
//        uiFloated = other.uiFloated
//        interactivePrimary = other.interactivePrimary
//        interactiveSecondary = other.interactiveSecondary
//        interactiveMask = other.interactiveMask
//        placeholder = other.placeholder
//        textHelp = other.textHelp
//        textInteractive = other.textInteractive
//        textLink = other.textLink
//        iconPrimary = other.iconPrimary
//        iconSecondary = other.iconSecondary
//        iconInteractive = other.iconInteractive
//        iconInteractiveInactive = other.iconInteractiveInactive
//        error = other.error
//        notificationBadge = other.notificationBadge
//
//        backdrop = other.backdrop
//        widgetPrimaryBackground = other.widgetPrimaryBackground
//        widgetSecondaryBackground = other.widgetSecondaryBackground
//        navigationBackground = other.navigationBackground
//        widgetTertiaryBackground = other.widgetTertiaryBackground
//
//        isDark = other.isDark
//    }
//}
//
//@Composable
//fun ProvideTruecallerColors(
//    colors: TruecallerColors,
//    content: @Composable () -> Unit
//) {
//    val colorPalette = remember { colors }
//    colorPalette.update(colors)
//    CompositionLocalProvider(LocalTruecallerColors provides colorPalette, content = content)
//}
//
//private val LocalTruecallerColors = staticCompositionLocalOf<TruecallerColors> {
//    error("No TruecallerColorPalette provided")
//}
//
//fun debugColors(
//    darkTheme: Boolean,
//
//    primary: Color = Color(0xFF6200EE),
//    primaryVariant: Color = Color(0xFF3700B3),
//    secondary: Color = Color(0xFF03DAC6),
//    secondaryVariant: Color = Color(0xFF018786),
//    background: Color = Color.White,
//    surface: Color = Color.White,
//    error: Color = Color(0xFFB00020),
//    onPrimary: Color = Color.White,
//    onSecondary: Color = Color.Black,
//    onBackground: Color = Color.Black,
//    onSurface: Color = Color.Black,
//    onError: Color = Color.White
//
//) = Colors(
//    primary,
//    primaryVariant,
//    secondary,
//    secondaryVariant,
//    background,
//    surface,
//    error,
//    onPrimary,
//    onSecondary,
//    onBackground,
//    onSurface,
//    onError,
//
//    isLight = !darkTheme
//)