package nuxlox.nuxon.damage

import net.minecraft.entity.LivingEntity
import net.minecraft.entity.damage.DamageSource
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import net.minecraft.util.Identifier

object DamageHelper {

    /**
     * Returns a damage source from the name of an existing damage type.
     */
    fun createDamageSource(entity: LivingEntity, modId: String, damageTypeName: String): DamageSource {
        val damageType = RegistryKey.of(
            RegistryKeys.DAMAGE_TYPE, Identifier(modId, damageTypeName)
        )

        return DamageSource(
            entity.world.registryManager
                .get(RegistryKeys.DAMAGE_TYPE)
                .entryOf(damageType)
        )
    }

}