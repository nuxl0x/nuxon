package nuxlox.nuxon

import net.fabricmc.api.ModInitializer
import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * [Nuxon] is a library mod that contains a variety of useful utilities for minecraft modding.
 * This library may be used as either an external dependency or directly embedded.
 */
object Nuxon : ModInitializer {
    const val MOD_ID: String = "nuxon"
    val logger: Logger = LoggerFactory.getLogger(MOD_ID)

	override fun onInitialize() {
		logger.info("Loading $MOD_ID library mod.")
	}

}