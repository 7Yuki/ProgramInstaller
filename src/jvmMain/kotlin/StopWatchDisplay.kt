import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun StopWatchDisplay(
    formattedTime: String,
    watchState: String,
    onStartClick: () -> Unit,
    onPauseClick: () -> Unit,
    onResetClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = formattedTime,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            color = Color.White
        )
        Spacer(Modifier.height(16.dp))
        Row(
           horizontalArrangement = Arrangement.Center,
           verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(onStartClick, colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)) {
                Text("Start Watch", color = Color.Black)
            }
            Spacer(Modifier.width(16.dp))
            Button(onPauseClick, colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)) {
                Text("Pause Watch", color = Color.Black)
            }
            Spacer(Modifier.width(16.dp))
            Button(onResetClick, colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)) {
                Text("Reset Watch", color = Color.Black)
            }
        }
        Text(
            text = watchState,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = Color.White
        )
    }
}