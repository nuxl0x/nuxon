package nuxlox.nuxon.item

import net.minecraft.item.Item
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.util.Identifier

/**
 * Should be extended in objects responsible for the declaration of new items, using the register function.
 */

open class ItemRegistrator(
    private val modId: String
) {

    fun register(id: String, item: Item): Item {
        val itemId = Identifier(modId, id)
        return Registry.register(Registries.ITEM, itemId, item)
    }

}