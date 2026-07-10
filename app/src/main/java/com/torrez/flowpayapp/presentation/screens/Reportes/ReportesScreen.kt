package com.torrez.flowpayapp.presentation.screens.Reportes

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ShowChart
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AttachMoney
import androidx.compose.material.icons.filled.DirectionsBus
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocalCafe
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Savings
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Work
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

data class CategoryItem(
    val title: String,
    val icon: @Composable () -> Unit
)

val gastos = listOf(
    CategoryItem("Educación") { Icon(Icons.Default.School, null) },
    CategoryItem("Ocio") { Icon(Icons.Default.Home, null) },
    CategoryItem("Servicios") { Icon(Icons.Default.Home, null) },
    CategoryItem("Familia") { Icon(Icons.Default.Home, null) },
    CategoryItem("Café") { Icon(Icons.Default.LocalCafe, null) },
    CategoryItem("Transporte") { Icon(Icons.Default.DirectionsBus, null) },
    CategoryItem("Rutina") { Icon(Icons.Default.Favorite, null) },
    CategoryItem("Salud") { Icon(Icons.Default.Favorite, null) },
    CategoryItem("Alimentos") { Icon(Icons.Default.ShoppingCart, null) },
    CategoryItem("Crear") { Icon(Icons.Default.Add, null) }
)

val ingresos = listOf(
    CategoryItem("Regalo") { Icon(Icons.Default.AttachMoney, null) },
    CategoryItem("Banco") { Icon(Icons.Default.Home, null) },
    CategoryItem("Ahorro") { Icon(Icons.Default.Savings, null) },
    CategoryItem("Salario") { Icon(Icons.Default.Work, null) },
    CategoryItem("Crear") { Icon(Icons.Default.Add, null) }
)

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ReportesScreen(
    navController: NavController
) {
    var selectedTab by remember { mutableStateOf("Mes") }

    val backgroundColor = Color(0xFF464444)
    val cardColor = Color(0xFFA7A7A7)

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(backgroundColor)

                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {

            SectionTitle("GASTOS")

            Spacer(modifier = Modifier.height(12.dp))

            CategoryGrid(
                items = gastos,
                cardColor = cardColor
            )

            Spacer(modifier = Modifier.height(20.dp))

            SectionTitle("INGRESOS")

            Spacer(modifier = Modifier.height(12.dp))

            CategoryGrid(
                items = ingresos,
                cardColor = cardColor
            )

            Spacer(modifier = Modifier.height(20.dp))

            SectionTitle("GRÁFICOS")

            Spacer(modifier = Modifier.height(12.dp))

            ChartCard(
                selectedTab = selectedTab,
                onTabSelected = { selectedTab = it },
                cardColor = cardColor
            )

            Spacer(modifier = Modifier.height(24.dp))
        }
    }


@Composable
fun SectionTitle(text: String) {
    Column (
        modifier = Modifier.wrapContentWidth()
    ){
        Text(
            text = text,
            color = Color.White,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        HorizontalDivider(
            modifier = Modifier.fillMaxWidth(),
            thickness = 3.dp,
            color = Color.White
        )
    }
}

@Composable
fun CategoryGrid(
    items: List<CategoryItem>,
    cardColor: Color
) {
    Card(
        colors = CardDefaults.cardColors(containerColor = cardColor),
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier.fillMaxWidth()
    ) {

        LazyVerticalGrid(
            columns = GridCells.Fixed(5),
            modifier = Modifier
                .height(180.dp)
                .padding(12.dp),
            userScrollEnabled = false
        ) {

            items(items) { item ->

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(8.dp)
                ) {

                    Box(
                        modifier = Modifier.size(40.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        item.icon()
                    }

                    Text(
                        text = item.title,
                        fontSize = 8.sp,
                        color = Color.White
                    )
                }
            }
        }
    }
}

@Composable
fun ChartCard(
    selectedTab: String,
    onTabSelected: (String) -> Unit,
    cardColor: Color
) {

    val tabs = listOf("Día", "Semana", "Mes", "Año")

    Card(
        colors = CardDefaults.cardColors(containerColor = cardColor),
        shape = RoundedCornerShape(14.dp),
        modifier = Modifier.fillMaxWidth()
    ) {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {

                tabs.forEach { tab ->

                    TextButton(
                        onClick = { onTabSelected(tab) }
                    ) {

                        Text(
                            text = tab,
                            color = if (tab == selectedTab)
                                Color.White
                            else
                                Color.LightGray
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            PlaceholderChart()

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {

                LegendItem(Color(0xFF4CAF50), "Ingresos")
                LegendItem(Color(0xFFFFEB3B), "Gastos")
                LegendItem(Color(0xFF4FC3F7), "Beneficio")
                LegendItem(Color(0xFFFF5722), "Pérdida")
            }
        }
    }
}

@Composable
fun PlaceholderChart() {

    val values = listOf(20, 20, 18, 15, 80, 65)
    val colors = listOf(
        Color.Yellow,
        Color(0xFFFF5722),
        Color.Yellow,
        Color(0xFFFF5722),
        Color(0xFF4CAF50),
        Color(0xFF4FC3F7)
    )

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.Bottom
    ) {

        values.forEachIndexed { index, value ->

            Box(
                modifier = Modifier
                    .width(16.dp)
                    .height(value.dp)
                    .background(
                        colors[index],
                        RoundedCornerShape(topStart = 4.dp, topEnd = 4.dp)
                    )
            )
        }
    }
}

@Composable
fun LegendItem(
    color: Color,
    text: String
) {

    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {

        Box(
            modifier = Modifier
                .size(12.dp)
                .background(color, CircleShape)
        )

        Spacer(modifier = Modifier.width(6.dp))

        Text(
            text = text,
            color = Color.White,
            fontSize = 10.sp
        )
    }
}