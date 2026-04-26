package nuxlox.nuxon.server

import net.minecraft.server.MinecraftServer
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

/**
 * [ServerUtils] provides some server-side utilities, such as task scheduling.
 *
 * Current utilities:
 * - [scheduleTask]
 */
object ServerUtils {

    private val scheduler = Executors.newSingleThreadScheduledExecutor()

    /**
     * [scheduleTask] takes the given [server], a time to wait ([delaySeconds]), and a [task].
     * This will cause the given task to execute on the server after the amount of time specified.
     */
    fun scheduleTask(server: MinecraftServer, delaySeconds: Int, task: () -> Unit) {
        scheduler.schedule(
            { server.execute(task) }, delaySeconds.toLong(), TimeUnit.SECONDS
        )
    }

}