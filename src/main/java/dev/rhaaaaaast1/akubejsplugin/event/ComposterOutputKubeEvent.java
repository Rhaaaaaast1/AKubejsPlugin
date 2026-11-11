package dev.rhaaaaaast1.akubejsplugin.event;

import dev.latvian.mods.kubejs.event.KubeEvent;
import dev.rhaaaaaast1.akubejsplugin.composter.ComposterOutput;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

/** Startup event for replacing the item produced by a full composter. */
public class ComposterOutputKubeEvent implements KubeEvent {
    public void setOutput(String itemId) {
        ResourceLocation id = ResourceLocation.tryParse(itemId);
        if (id == null) {
            return;
        }
        Item item = BuiltInRegistries.ITEM.get(id);
        if (item != Items.AIR) {
            ComposterOutput.set(item);
        }
    }

    public void setOutput(ItemStack stack) {
        if (stack != null && !stack.isEmpty()) {
            ComposterOutput.set(stack.getItem());
        }
    }

    public void setOutput(Item item) {
        ComposterOutput.set(item);
    }

    public String getOutput() {
        return BuiltInRegistries.ITEM.getKey(ComposterOutput.output()).toString();
    }
}
