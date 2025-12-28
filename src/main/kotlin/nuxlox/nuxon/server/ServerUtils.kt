package nuxlox.nuxon.server

import net.minecraft.server.MinecraftServer

object ServerUtils {

    fun scheduleTask(server: MinecraftServer, delaySeconds: Int, task: () -> Unit) {
        val delayTicks = delaySeconds * 20L
        var remaining = delayTicks

        object : Runnable {
            override fun run() {
                remaining--
                if (remaining <= 0) {
                    task()
                } else {
                    server.execute(this)
                }
            }
        }

    }

}