package nuxlox.nuxon.effect

import net.minecraft.entity.effect.StatusEffect
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.util.Identifier
import nuxlox.nuxon.item.ItemRegistrator

/**
 * [EffectRegistrator] provides a helpful [register] utility that allows for the simple registration of effects.
 * Simply extend the class in your effect registration object use [register].
 */
open class EffectRegistrator(
    private val modId: String
) {

    /**
     * [register] allows for the simple registration of an effect through its [id] and the actual [effect].
     *
     * E.g. ```register("cool_effect", CoolEffect)```
     */
    fun register(id: String, effect: StatusEffect): StatusEffect {
        val effectId = Identifier(modId, id)
        return Registry.register(Registries.STATUS_EFFECT, effectId, effect)
    }

}