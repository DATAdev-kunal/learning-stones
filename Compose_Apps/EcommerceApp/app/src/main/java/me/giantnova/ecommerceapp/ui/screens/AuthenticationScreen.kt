package me.giantnova.ecommerceapp.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import me.giantnova.ecommerceapp.data.models.Product
import me.giantnova.ecommerceapp.viewmodel.ProductViewModel

@Composable
fun HomeScreen(
    viewModel: ProductViewModel = hiltViewModel(),
    onProductClick: (Product) -> Unit
) {
    val products by viewModel.products.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    val gridState = rememberLazyGridState()

    // Infinite scroll logic
    val shouldLoadMore = remember {
        derivedStateOf {
            val lastVisibleItemIndex = gridState.layoutInfo.visibleItemsInfo.lastOrNull()?.index ?: 0
            lastVisibleItemIndex >= products.size - 5
        }
    }

    LaunchedEffect(shouldLoadMore.value) {
        if (shouldLoadMore.value && !isLoading) {
            viewModel.fetchProducts()
        }
    }

    Column {
        // Sort and Filter Row
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Sort Dropdown
            var expanded by remember { mutableStateOf(false) }
            Box {
                Button(onClick = { expanded = true }) {
                    Text("Sort")
                }
                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    DropdownMenuItem(
                        onClick = {
                        viewModel.sortProducts(ProductViewModel.SortType.PRICE_LOW_TO_HIGH)
                        expanded = false
                        },
                        text = {
                            Text("Prices: Low to High")
                        }
                    )
                    DropdownMenuItem(onClick = {
                        viewModel.sortProducts(ProductViewModel.SortType.PRICE_HIGH_TO_LOW)
                        expanded = false
                        },
                        text = {
                            Text("Price: High to Low")
                        }
                    )

                    DropdownMenuItem(
                        onClick = {
                        viewModel.sortProducts(ProductViewModel.SortType.RATING)
                        expanded = false
                        },
                        text = {
                            Text("Rating")
                        }
                    )
                }
            }
        }

        // Product Grid
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            state = gridState,
            contentPadding = PaddingValues(8.dp)
        ) {
            itemsIndexed(products) { index, product ->
                ProductGridItem(
                    product = product,
                    onClick = { onProductClick(product) }
                )
            }

            // Loading indicator
            if (isLoading) {
                item {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator()
                    }
                }
            }
        }
    }
}

@Composable
fun ProductGridItem(
    product: Product,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .padding(4.dp)
            .clickable(onClick = onClick),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(8.dp)
        ) {
            AsyncImage(
                model = product.image,
                contentDescription = product.title,
                modifier = Modifier
                    .size(120.dp)
                    .padding(8.dp)
            )
            Text(
                text = product.title,
                style = MaterialTheme.typography.titleLarge,
                maxLines = 2
            )
            Text(
                text = "$${product.price}",
                style = MaterialTheme.typography.titleMedium
            )
            Row {
                Text(
                    text = "Rating: ${product.rating.rate}",
                    style = MaterialTheme.typography.titleSmall
                )
            }
        }
    }
}