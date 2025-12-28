package nuxlox.nuxon.effect

import net.minecraft.entity.effect.StatusEffect
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.util.Identifier

/**
 * Should be extended in objects responsible for the declaration of new effects, using the register function.
 */

open class EffectRegistrator(
    private val modId: String
) {

    fun register(id: String, effect: StatusEffect): StatusEffect {
        val effectId = Identifier(modId, id)

        return Registry.register(Registries.STATUS_EFFECT, effectId, effect)
    }

}