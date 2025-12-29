package nuxlox.nuxon.server

import net.minecraft.server.MinecraftServer
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

object ServerUtils {

    private val scheduler = Executors.newSingleThreadScheduledExecutor()

    fun scheduleTask(server: MinecraftServer, delaySeconds: Int, task: () -> Unit) {
        scheduler.schedule(
            { server.execute(task)}, delaySeconds.toLong(), TimeUnit.SECONDS
        )
    }

}