package com.dev.lab3_ph30375.lab4

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.dev.lab3_ph30375.lab4.data.Product

val productList = listOf(
    Product(1, "Sofa Grey", 100.0, "https://mediawinwin.vn/cosy/admin/upload/images/%E1%BA%A2nh%20N%E1%BB%99i%20Th%E1%BA%A5t/%E1%BA%A3nh%20n%E1%BB%99i%20th%E1%BA%A5t%2014.jpg", false),
    Product(2, "Bed Table", 200.0, "https://noithatnhadepnhaxinh.com/wp-content/uploads/2022/09/mau-giuong-ngu-go-dep-hien-dai-bang-cong-nghiep-LG-GN235-1.jpg", false),
    Product(3, "Sofa Pink", 300.0, "https://kika.vn/wp-content/uploads/2023/10/ghe-sofa-dep-SF307.jpg", false),
    Product(4, "Table Dinner", 400.0, "https://noithatxinh.vn/Images/Upload/images/bo-ban-ghe-phong-an-dep-ba205-1.jpg", false),
    Product(5, "Wood Combo", 500.0, "https://noithatthaibinh.com/wp-content/uploads/2023/01/bo-ban-tra-2-ghe-2734.jpg", false),
    Product(6, "Sofa Black", 600.0, "https://noithatxinh.vn/Images/Upload/images/sofa-da-cao-cap-1.jpg", false),
    Product(7, "Table Dinner", 700.0, "https://noithatxinh.vn/Images/Upload/images/bo-ban-ghe-phong-an-dep-ba205-1.jpg", false),
)

val cartList = mutableListOf<Product>()

@Preview
@Composable
fun ProductSection() {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2), // 2 columns
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp), // Padding around the grid
        horizontalArrangement = Arrangement.spacedBy(16.dp), // Horizontal spacing between items
        verticalArrangement = Arrangement.spacedBy(16.dp) // Vertical spacing between items
    ) {
        items(productList.size) { index ->
            ProductItem(index)
        }
    }
}

@Composable
fun ProductItem(index: Int) {
    val product = productList[index]

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(15.dp))
            .background(MaterialTheme.colorScheme.secondaryContainer)
            .clickable { }
            .padding(8.dp), // Padding inside the item for better spacing
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(8.dp) // Vertical spacing between the image and text
        ) {
            AsyncImage(
                model = product.image,
                contentDescription = "Product Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp) // Adjust the height as needed
                    .clip(RoundedCornerShape(15.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(Modifier.height(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically

            ) {
                Column (verticalArrangement = Arrangement.Center) {
                    Text(text = product.name, style = MaterialTheme.typography.labelLarge)
                    Text(text = "$${product.price}", style = MaterialTheme.typography.labelMedium)

                }
                Icon(imageVector = Icons.Rounded.ShoppingCart, contentDescription = "", Modifier.size(18.dp).clickable {
                    cartList.add(product)
                })
            }
        }
    }
}
