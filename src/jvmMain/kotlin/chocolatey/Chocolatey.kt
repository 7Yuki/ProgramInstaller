package chocolatey

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class Chocolatey {
    fun isInstalled(): Boolean {
        return false
    }

    private var coroutineScope = CoroutineScope(Dispatchers.IO)

    fun installChocolatey():Boolean {
        var isInstalled = false
        if (!isInstalled) {
            coroutineScope.launch {
                delay(3000)
                println("chocolatey installed")
                isInstalled = true
            }
            return isInstalled
        }
        return false
    }


}