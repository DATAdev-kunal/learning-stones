package me.giantnova.ecommerceapp.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import me.giantnova.ecommerceapp.data.models.Product
import me.giantnova.ecommerceapp.viewmodel.ProductViewModel

@Composable
fun ProductDetailScreen(
    productId: Int,
    viewModel: ProductViewModel = hiltViewModel(),
    onAddToCart: (Product) -> Unit
) {
    val product by viewModel.selectedProduct.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()

    LaunchedEffect(productId) {
        viewModel.getProductDetails(productId)
    }

    if (isLoading) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    } else {
        product?.let { product ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                AsyncImage(
                    model = product.image,
                    contentDescription = product.title,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = product.title,
                    style = MaterialTheme.typography.labelSmall
                )

                Text(
                    text = "$${product.price}",
                    style = MaterialTheme.typography.titleLarge
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Description",
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = product.description,
                    style = MaterialTheme.typography.bodyMedium
                )

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Rating: ${product.rating.rate}",
                        style = MaterialTheme.typography.titleMedium
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "(${product.rating.count} reviews)",
                        style = MaterialTheme.typography.titleSmall
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = { onAddToCart(product) },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Add to Cart")
                }
            }
        }
    }
}