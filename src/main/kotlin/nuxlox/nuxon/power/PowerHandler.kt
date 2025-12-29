package nuxlox.nuxon.power

import net.minecraft.entity.player.PlayerEntity
import nuxlox.nuxon.server.ServerUtils

/**
 * Power handling API for the Palladium mod by ThreeTAG.
 * This API provides a variety of different functions in order to interact with the Palladium mod!
 * (These essentially just emulate commands due it not being possible to directly call Palladium's internal API.)
 *
 * Here are all the methods provided by `PowerHandler`:
 * - addPower(player, powerName)
 * - removePower(player, powerName)
 * - setPower(player, powerName)
 * - addPowerForDuration(player, powerName, duration)
 */

open class PowerHandler(
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

    fun setPower(player: PlayerEntity, powerName: String) {
        val server = player.server ?: return
        val powerId = "$modId:$powerName"

        server.commandManager.executeWithPrefix(
            server.commandSource,
            "superpower set $powerId ${player.gameProfile.name}"
        )
    }

    fun addPowerForDuration(player: PlayerEntity, powerName: String, durationSeconds: Int) {
        val server = player.server ?: return

        addPower(player, powerName)
        ServerUtils.scheduleTask(server, durationSeconds) { removePower(player, powerName) }
    }

}