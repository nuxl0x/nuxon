package nuxlox.nuxon.item

import net.minecraft.item.Item
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.util.Identifier

/**
 * [ItemRegistrator] provides a helpful [register] utility that allows for easy registration of items.
 * Simply extend the class in your item registration object use [register].
 */

open class ItemRegistrator(
    private val modId: String
) {

    /**
     * [register] allows for the simple registration of an item through its [id] and the actual [item].
     *
     * E.g. ```register("cool_item", Item(FabricItemSettings()))```
     */
    fun register(id: String, item: Item): Item {
        val itemId = Identifier(modId, id)
        return Registry.register(Registries.ITEM, itemId, item)
    }

}