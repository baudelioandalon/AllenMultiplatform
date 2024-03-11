package com.borealnetwork.allen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.borealnetwork.allen.domain.model.BirdImage
import com.borealnetwork.allen.modules.auth.domain.navigation.AuthScreen
import com.borealnetwork.allen.modules.auth.domain.navigation.loginNavigationGraph
import com.borealnetwork.allen.modules.auth.domain.navigation.registerNavigationGraph
import com.borealnetwork.allen.modules.auth.domain.navigation.welcomeNavigationGraph
import com.borealnetwork.allen.modules.cart.domain.navigation.CartClientScreen
import com.borealnetwork.allen.modules.cart.domain.navigation.detailBuyCartClientNavigationGraph
import com.borealnetwork.allen.modules.cart.domain.navigation.resumeBuyCartClientNavigationGraph
import com.borealnetwork.allen.modules.cart.domain.navigation.shoppingCartClientNavigationGraph
import com.borealnetwork.allen.modules.home_client.domain.navigation.HomeClientScreen
import com.borealnetwork.allen.modules.home_client.domain.navigation.homeClientNavigationGraph
import com.borealnetwork.allen.modules.notifications.domain.navigation.notificationClientNavigationGraph
import com.borealnetwork.allen.modules.orders.domain.navigation.orderClientFinishDetailNavigationGraph
import com.borealnetwork.allen.modules.orders.domain.navigation.orderClientStatusNavigationGraph
import com.borealnetwork.allen.modules.orders.domain.navigation.ordersClientNavigationGraph
import com.borealnetwork.allen.modules.payments.domain.navigation.newCardClientNavigationGraph
import com.borealnetwork.allen.modules.payments.domain.navigation.paymentsMethodClientNavigationGraph
import com.borealnetwork.allen.modules.product.domain.navigation.detailProductClientNavigationGraph
import com.borealnetwork.allen.modules.product.domain.navigation.favoritesClientNavigationGraph
import com.borealnetwork.allen.modules.product.domain.navigation.questionsProductClientNavigationGraph
import com.borealnetwork.allen.modules.product.domain.navigation.ratingProductClientNavigationGraph
import com.borealnetwork.allen.modules.product.domain.navigation.resultProductsClientNavigationGraph
import com.borealnetwork.allen.modules.product.domain.navigation.searchClientNavigationGraph
import com.borealnetwork.allen.modules.profile.domain.navigation.addressClientNavigationGraph
import com.borealnetwork.allen.modules.profile.domain.navigation.newAddressClientNavigationGraph
import com.borealnetwork.allen.modules.stores.domain.navigation.storesInMapNavigationGraph
import com.borealnetwork.allen.theme.AppTheme
import com.borealnetwork.allen.viewmodel.LoginViewModel
import dev.icerock.moko.mvvm.compose.getViewModel
import dev.icerock.moko.mvvm.compose.viewModelFactory
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import moe.tlaster.precompose.PreComposeApp
import moe.tlaster.precompose.navigation.NavHost
import moe.tlaster.precompose.navigation.rememberNavigator


@Composable
internal fun App() = PreComposeApp {
    AppTheme {
        val loginViewModel = getViewModel(Unit, viewModelFactory { LoginViewModel() })
        val navigator = rememberNavigator()
        NavHost(
            navigator = navigator,
            initialRoute = AuthScreen.LoginScreen.route
//            initialRoute = HomeClientScreen.HomeDefaultClientScreen.route
        ) {
            //Auth
            welcomeNavigationGraph(navigator)
            loginNavigationGraph(navigator, loginViewModel)
            registerNavigationGraph(navigator)

            //HomeClient
            homeClientNavigationGraph(navigator)

            //Client
            notificationClientNavigationGraph(navigator)

            //Orders
            ordersClientNavigationGraph(navigator)
            orderClientFinishDetailNavigationGraph(navigator)
            orderClientStatusNavigationGraph(navigator)

            //Product
            searchClientNavigationGraph(navigator)
            resultProductsClientNavigationGraph(navigator)
            detailProductClientNavigationGraph(navigator)
            ratingProductClientNavigationGraph(navigator)
            questionsProductClientNavigationGraph(navigator)
            favoritesClientNavigationGraph(navigator)

            //Cart
            shoppingCartClientNavigationGraph(navigator)
            resumeBuyCartClientNavigationGraph(navigator)
            detailBuyCartClientNavigationGraph(navigator)

            //Profile
            addressClientNavigationGraph(navigator)
            newAddressClientNavigationGraph(navigator)

            //Payments
            newCardClientNavigationGraph(navigator)
            paymentsMethodClientNavigationGraph(navigator)

            //Stores
            storesInMapNavigationGraph(navigator)
        }


//    WelcomeViewCompose()
//    RegisterViewCompose()
//    LoginViewCompose(loginViewModel)
//    ProductViewCompose()//TODO PROBLEMA CON FREESHIPPING
    }
}

@Composable
fun BirdsPage(viewModel: LoginViewModel) {
    val uiState by viewModel.uiState.collectAsState()
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Row(
            Modifier.fillMaxWidth().padding(5.dp),
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            for (category in uiState.categories) {
                Button(
                    onClick = {
                        viewModel.selectCategory(category)
                    }, modifier = Modifier.aspectRatio(1.0f).fillMaxSize().weight(1.0f),
                    elevation = ButtonDefaults.buttonElevation(
                        defaultElevation = 0.dp,
                        focusedElevation = 0.dp
                    ), shape = RectangleShape
                ) {
                    Text(category)
                }
            }
        }

        AnimatedVisibility(visible = uiState.selectedImages.isNotEmpty()) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                horizontalArrangement = Arrangement.spacedBy(5.dp),
                verticalArrangement = Arrangement.spacedBy(5.dp),
                modifier = Modifier.fillMaxSize().padding(horizontal = 5.dp),
                content = {
//                    items(uiState.selectedImages) {
//                        BirdImageCell(it)
//                    }
                }
            )
        }
    }
}

@Composable
fun BirdImageCell(image: BirdImage) {
    KamelImage(
        asyncPainterResource(data = "https://sebi.io/demo-image-api/${image.path}"),
        contentDescription = "${image.category} by ${image.author}",
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxWidth().aspectRatio(1.0f)
    )
}
