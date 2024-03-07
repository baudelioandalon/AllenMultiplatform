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
import androidx.compose.foundation.shape.AbsoluteCutCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.borealnetwork.allen.domain.model.BirdImage
import com.borealnetwork.allen.domain.screen.HOME_CLIENT_GRAPH
import com.borealnetwork.allen.modules.cart.domain.navigation.detailBuyCartClientNavigationGraph
import com.borealnetwork.allen.modules.cart.domain.navigation.resumeBuyCartClientNavigationGraph
import com.borealnetwork.allen.modules.cart.domain.navigation.shoppingCartClientNavigationGraph
import com.borealnetwork.allen.modules.home_client.domain.navigation.homeClientNavigationGraph
import com.borealnetwork.allen.modules.notifications.domain.navigation.notificationClientNavigationGraph
import com.borealnetwork.allen.modules.orders.domain.navigation.orderClientDetailNavigationGraph
import com.borealnetwork.allen.modules.orders.domain.navigation.ordersClientNavigationGraph
import com.borealnetwork.allen.modules.payments.domain.navigation.newCardClientNavigationGraph
import com.borealnetwork.allen.modules.payments.domain.navigation.paymentsMethodClientNavigationGraph
import com.borealnetwork.allen.modules.product.domain.navigation.detailProductClientNavigationGraph
import com.borealnetwork.allen.modules.product.domain.navigation.questionsProductClientNavigationGraph
import com.borealnetwork.allen.modules.product.domain.navigation.ratingProductClientNavigationGraph
import com.borealnetwork.allen.modules.product.domain.navigation.resultProductsClientNavigationGraph
import com.borealnetwork.allen.modules.product.domain.navigation.searchClientNavigationGraph
import com.borealnetwork.allen.modules.profile.domain.navigation.addressClientNavigationGraph
import com.borealnetwork.allen.modules.profile.domain.navigation.newAddressClientNavigationGraph
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
fun BirdAppTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = MaterialTheme.colorScheme.copy(primary = Color.Black),
        shapes = MaterialTheme.shapes.copy(
            small = AbsoluteCutCornerShape(0.dp),
            medium = AbsoluteCutCornerShape(0.dp),
            large = AbsoluteCutCornerShape(0.dp)
        )
    ) {
        content()
    }
}

@Composable
internal fun App() = PreComposeApp {
    AppTheme {
        val loginViewModel = getViewModel(Unit, viewModelFactory { LoginViewModel() })
        val navigator = rememberNavigator()
        NavHost(
            navigator = navigator,
            initialRoute = HOME_CLIENT_GRAPH,
        ) {
            // Define a scene to the navigation graph
            homeClientNavigationGraph(navigator)
            notificationClientNavigationGraph(navigator)
            ordersClientNavigationGraph(navigator)
            orderClientDetailNavigationGraph(navigator)

            //Product
            searchClientNavigationGraph(navigator)
            resultProductsClientNavigationGraph(navigator)
            detailProductClientNavigationGraph(navigator)
            ratingProductClientNavigationGraph(navigator)
            questionsProductClientNavigationGraph(navigator)

            shoppingCartClientNavigationGraph(navigator)
            resumeBuyCartClientNavigationGraph(navigator)
            detailBuyCartClientNavigationGraph(navigator)
            addressClientNavigationGraph(navigator)
            newAddressClientNavigationGraph(navigator)
            newCardClientNavigationGraph(navigator)
            paymentsMethodClientNavigationGraph(navigator)
        }


//    WelcomeViewCompose()
//    RegisterViewCompose()
//    LoginViewCompose(loginViewModel)
//    HomeClientViewCompose()
//    ProductViewCompose()//TODO PROBLEMA CON FREESHIPPING
//    QuestionViewCompose()
//    RatingProductViewCompose()
//    ShoppingCartViewCompose()
//    DetailBuyCartStepOneViewCompose()
//    PaymentMethodsViewCompose()
//    NewCardViewCompose()
//    AddressClientViewCompose()
//    NewAddressClientViewCompose()
//    ResumeCartStepTwoViewCompose()
//    SearchProductViewCompose()
//    ResultProductsViewCompose()
//    StatusPurchaseViewCompose()
//    NotificationClientViewCompose()
//    OrderDetailViewCompose()
//    OrderStatusViewCompose()
//    OrderDetailViewCompose()
//        OrdersListViewCompose()
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
