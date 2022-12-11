package applications

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.BufferedReader
import java.io.InputStreamReader


data class DownloadableProgram(val programName: String, val chocolateyPackageName: String) {

    private var coroutineScope = CoroutineScope(Dispatchers.IO)

    fun installApplication() {
        println("Installing $programName via $chocolateyPackageName")
        val process = Runtime.getRuntime().exec("choco --version")
        coroutineScope.launch {
            val reader = BufferedReader(InputStreamReader(process.inputStream))
            var line: String?
            while (withContext(Dispatchers.IO) {
                    reader.readLine()
                }.also { line = it } != null) {
                if (line?.contains('.') == true) {
                    println("choco version $line")
                    println("Program to install: $programName via package: $chocolateyPackageName")
                } else {
                    println("uh oh choco version not found")
                }
            }
        }
    }
}