package com.dev.lab3_ph30375

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dev.lab3_ph30375.ui.theme.bg
import com.dev.lab3_ph30375.ui.theme.buttonBg
import com.dev.lab3_ph30375.ui.theme.cash
import com.dev.lab3_ph30375.ui.theme.momo
import com.dev.lab3_ph30375.ui.theme.payPal
import com.dev.lab3_ph30375.ui.theme.visa
import com.dev.lab3_ph30375.ui.theme.zaloPay

@Composable
fun BT5() {
    Column (modifier = Modifier
        .background(bg)
        .fillMaxSize()) {
        //Headers
        Header()

        //Address
        Address()


        //Text guide pick payment method

        // 5 payment method

        Box(modifier = Modifier.background(bg)) {
            Column(
                verticalArrangement = Arrangement.spacedBy(12.dp), // Space between cards
                modifier = Modifier.padding(16.dp) // Outer padding for the whole column
            ) {
                CardPayment(
                    R.drawable.ic_paypal,
                    "Paypal",
                    payPal
                )
                CardPayment(
                    R.drawable.ic_visa,
                    "Visa",
                    visa
                )
                CardPayment(
                    R.drawable.ic_mo,
                    "Momo",
                    momo
                )
                CardPayment(
                    R.drawable.ic_zalo,
                    "ZaloPay",
                    zaloPay
                )
                CardPayment(
                    R.drawable.ic_cash,
                    "Thanh toán trực tiếp",
                    cash
                )
            }
        }
        // button next
        ButtonContinue()

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Header() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(bg)
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
        ) {
//            IconButton(
//                onClick = { /* Handle navigation icon press */ },
//                modifier = Modifier.size(24.dp)
//            ) {
//                Icon(
//                    painter = painterResource(id = R.drawable.ic_launcher_background), // Replace with actual icon resource
//                    contentDescription = "Back",
//                    tint = Color.White
//                )
//            }
            Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {
                Text(
                    text = "Thanh toán",
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            // Placeholder for possible action button to balance the layout
            IconButton(onClick = { /* Optional action */ }, modifier = Modifier.size(24.dp)) {
                // Optional icon, keep it empty if no action is needed
            }
        }
    }
}

@Composable
fun Address() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(bg)
            .padding(16.dp),
    ) {
        Column {
            Text(
                text = "Địa chỉ nhận hàng",
                style = MaterialTheme.typography.bodyLarge,
                color = Color.White,
                modifier = Modifier.padding(16.dp)
            )
            Row {
                //Image
                Column(
                    modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.Center
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_location),
                        tint = Color.White,
                        contentDescription = stringResource(id = R.string.bus_content_description)
                    )

                }
                //Address details
                Column(
                    modifier = Modifier.padding(0.dp), verticalArrangement = Arrangement.Center
                ) {
                    Text(text = "Huy | 0398922772", color = Color.White)
                    Text(text = "Số 1, Đường 1, Phường 1, Quận 1, TP.HN", color = Color.White)

                }


            }

            Text(
                text = "Vui lòng chọn 1 trong những phương thức sau",
                color = Color.White,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}

@Composable
fun CardPayment(icon_id: Int, name: String, bgColor: Color) {

    Box(
        modifier = Modifier
            .background(bgColor, shape = RoundedCornerShape(16.dp)) // Rounded corners
            .fillMaxWidth()
            .padding(bottom = 8.dp, start = 16.dp) // Space between cards

    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween

        ) {
            // Image
            Icon(
                painter = painterResource(icon_id),
                tint = Color.White,
                contentDescription = stringResource(id = R.string.bus_content_description)
            )

            // Name payment method
            Column(
                modifier = Modifier.align(Alignment.CenterVertically),
            ) {
                Text(text = name, color = Color.White)
            }

            // Radio Button
            IconButton(modifier = Modifier.align(Alignment.CenterVertically),
                onClick = { /* Handle radio button press */ }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_radio),
                    contentDescription = "Radio button unchecked",
                )
            }
        }

    }
}

@Composable
fun ButtonContinue() {
    Button(onClick = { /*TODO*/ }, modifier = Modifier.padding(16.dp).fillMaxWidth(), colors = ButtonDefaults.buttonColors(buttonBg)) {
        Text(text = "Tiếp tục", modifier = Modifier.padding(8.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun BT5Preview() {
    Box() {
        BT5()
    }
}
