package components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun OutputDisplay(
    modifier: Modifier = Modifier,
    consoleOutput: String
) {
    Spacer(Modifier.height(16.dp))
    Box(
        contentAlignment = Alignment.Center,
        content = {
            Text("State: $consoleOutput", fontSize = 20.sp, color = Color.White)

        },
        modifier = modifier
            .wrapContentWidth(align = Alignment.CenterHorizontally)
            .background(Color.DarkGray)
            .border(2.dp,Color.LightGray, RectangleShape)
    )
}