package nuxlox.nuxon.power

import net.minecraft.entity.player.PlayerEntity
import nuxlox.nuxon.server.ServerUtils

open class PalladiumPowerHandler(
    private val modId: String
) {

    fun addPower(player: PlayerEntity, powerName: String) {
        val server = player.server ?: return
        val powerId = "$modId:$powerName"

        server.commandManager.executeWithPrefix(
            server.commandSource,
            "superpower add $powerId ${player.gameProfile.name}"
        )
    }

    fun removePower(player: PlayerEntity, powerName: String) {
        val server = player.server ?: return
        val powerId = "$modId:$powerName"

        server.commandManager.executeWithPrefix(
            server.commandSource,
            "superpower remove $powerId ${player.gameProfile.name}"
        )
    }

    fun addPowerForDuration(player: PlayerEntity, powerName: String, durationSeconds: Int) {
        val server = player.server ?: return

        addPower(player, powerName)
        ServerUtils.scheduleTask(server, durationSeconds) { removePower(player, powerName) }
    }

}