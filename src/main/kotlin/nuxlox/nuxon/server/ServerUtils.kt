package nuxlox.nuxon.server

import net.minecraft.server.MinecraftServer

object ServerUtils {

    fun scheduleTask(server: MinecraftServer, delaySeconds: Int, task: () -> Unit) {
        var remaining = delaySeconds * 20L

        fun tick() {
            if (--remaining <= 0) {
                task()
            } else {
                server.execute(::tick)
            }
        }

        server.execute(::tick)
    }
}