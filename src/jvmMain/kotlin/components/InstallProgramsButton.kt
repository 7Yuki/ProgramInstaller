package components

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import applications.DownloadableProgram

@Composable
fun DownloadProgramsButton(programs: List<DownloadableProgram>) {
    Button(
        onClick = {
            if (programs.isEmpty()) {
                println("No programs to install")
            } else {
                for (i in programs) {
                    i.installApplication()
                }
            }

        },
        content = {
            Text("Install Programs")
        }
    )
}