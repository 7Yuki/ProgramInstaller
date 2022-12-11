// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application
import applications.DownloadableProgram
import chocolatey.Chocolatey
import components.DownloadProgramsButton
import components.ProgramCheckbox
import java.awt.Dimension


@OptIn(ExperimentalFoundationApi::class)
@Composable
@Preview
fun App() {
    MaterialTheme {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize().background(Color(67, 67, 67)),
            content = {
                val brave = remember { DownloadableProgram("Brave", "https://brave.com/") }
                val valorant = remember { DownloadableProgram("Valorant", "https://playvalorant.com") }
                val discord = remember { DownloadableProgram("Discord", "https://discordapp.com") }
                val cider = remember { DownloadableProgram("Cider", "https://cider.sh") }
                val osu = remember { DownloadableProgram("osu!", "https://osu.ppy.sh") }
                val intellij = remember { DownloadableProgram("IntelliJ", "something from jetbrains") }
                val miniplayerClassic = remember { DownloadableProgram("Miniplayer Classic", "some github link") }
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    //Text("Applications", color = Color.White, textAlign = TextAlign.Center, fontWeight = FontWeight.Bold, fontSize = 30.sp, modifier = Modifier.padding(bottom = 80.dp))
                    Text(
                        "Downloads",
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 20.sp
                    )
                    val programs =
                        remember { listOf(brave, valorant, discord, cider, osu, intellij, miniplayerClassic) }
                    val programsToInstall: MutableList<DownloadableProgram> = remember { mutableListOf() }

                    Box(modifier = Modifier.padding(top = 35.dp, start = 50.dp, end = 50.dp, bottom = 30.dp)) {
                        LazyVerticalGrid(
                            cells = GridCells.Fixed(3)
                        ) {
                            items(programs.size) { app ->
                                val program = programs[app]

                                ProgramCheckbox(
                                    doOnCheckedChange = {
                                        if (!it) {
                                            programsToInstall.remove(program)
                                            println("${program.programName} Deselected")
                                            println(programsToInstall)

                                        } else {
                                            if (!programsToInstall.contains(program)) programsToInstall.add(program)
                                            else println("Program is already selected to be installed")
                                            println("${program.programName} Selected")
                                            println(programsToInstall)
                                        }
                                    },
                                    program = program
                                )

                            }
                        }
                    }
                    DownloadProgramsButton(programsToInstall)


                }


            }
        )
    }
}

/*Row(
     horizontalArrangement = Arrangement.Center,
     verticalAlignment = Alignment.CenterVertically,
     modifier = Modifier.fillMaxWidth()
 ) {
     makeNewProgramRow(firstRow)
 }
 Row(
     horizontalArrangement = Arrangement.Center,
     verticalAlignment = Alignment.CenterVertically,
     modifier = Modifier.fillMaxWidth()
 ) {
     makeNewProgramRow(secondRow)
 }*/

// OutputDisplay(modifier = Modifier.background(Color(67, 67, 67)), brave.state)


/*val stopWatch = remember { StopWatch() }
StopWatchDisplay(
    formattedTime = stopWatch.formattedTime,
    watchState = stopWatch.watchState,
    onStartClick = stopWatch::startStopWatch,
    onPauseClick = stopWatch::pause,
    onResetClick = stopWatch::reset
)*/

/*@Composable
fun makeNewProgramRowBetter(listOfPrograms: List<DownloadableProgram>, numberOfRows: Int, numberOfButtons: Int) {

    for (i in IntRange(0,numberOfRows)) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
           for (x in IntRange(0,numberOfButtons)) {
              DownloadProgramButton(listOfPrograms[numberOfButtons * x * i + x])
           }
        }
    }
}*/

@Composable
fun defaultSpacer() {
    Spacer(Modifier.height(16.dp))
}

fun main() = application {
    Window(
        resizable = false,
        onCloseRequest = ::exitApplication,
        title = "yuki's Program Installer",
        state = WindowState(size = DpSize(800.dp, 800.dp))
    ) {
        window.minimumSize = Dimension(800, 800)
        val chocolatey = remember { Chocolatey() }

        if (chocolatey.isInstalled()) {
            println("Chocolatey is installed")
            App()
        } else if (chocolatey.installChocolatey()){
            println("installed chocolatey")
            App()
        } else {
            println("shit failed")
        }
    }
}
