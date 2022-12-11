package components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import applications.DownloadableProgram
import defaultSpacer

@Composable
fun ProgramCheckbox(
    doOnCheckedChange: ((Boolean) -> Unit),
    program: DownloadableProgram
) {
    Row {
        var isChecked = remember { mutableStateOf(false) }
        Checkbox(
            checked = isChecked.value,
            onCheckedChange = doOnCheckedChange,

            enabled = true,
            colors = CheckboxDefaults.colors(
                checkedColor = Color(248, 200, 200),
                uncheckedColor = Color.White,
                checkmarkColor = Color.Black
            ),
        )
        defaultSpacer()
        Text(program.programName, color = Color.White, modifier = Modifier.padding(15.dp))
    }
    /*Button(
        { program.downloadApplication() },
        shape = RoundedCornerShape(100),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color(248,200,200,255)),
        modifier = Modifier.padding(5.dp)
    ) {
        Text(program.programName, fontWeight = FontWeight.SemiBold)
    }*/
}