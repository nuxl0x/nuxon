package nuxlox.nuxon

import net.fabricmc.api.ModInitializer
import org.slf4j.Logger
import org.slf4j.LoggerFactory

object Nuxon : ModInitializer {
    const val MOD_ID: String = "nuxon"
    val logger: Logger = LoggerFactory.getLogger(MOD_ID)

	override fun onInitialize() {
		logger.info("Loading $MOD_ID library mod.")
	}

    /**
     * Greetings!
     *
     * This library mod is responsible for containing utility scripts that I commonly find myself using.
     * Feel free to use this as either an external dependency or as an embed within a mod.
     */

}