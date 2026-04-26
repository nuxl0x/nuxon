package nuxlox.nuxon.damage

import net.minecraft.entity.damage.DamageSource
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import net.minecraft.util.Identifier
import net.minecraft.world.World

/**
 * [DamageHelper] provides an array of useful utilities for use with damage.
 *
 * Current utilities:
 * - [createDamageSource]
 */
object DamageHelper {

    /**
     * Returns the [DamageSource] associated with the provided [world] and [identifier].
     */
    fun createDamageSource(world: World, identifier: Identifier): DamageSource {
        val damageType = RegistryKey.of(
            RegistryKeys.DAMAGE_TYPE, identifier
        )

        return DamageSource(
            world.registryManager
                .get(RegistryKeys.DAMAGE_TYPE)
                .entryOf(damageType)
        )
    }

}