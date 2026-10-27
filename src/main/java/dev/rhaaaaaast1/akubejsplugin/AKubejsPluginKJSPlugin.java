package dev.rhaaaaaast1.akubejsplugin;

import dev.latvian.mods.kubejs.event.EventGroupRegistry;
import dev.latvian.mods.kubejs.plugin.ClassFilter;
import dev.latvian.mods.kubejs.plugin.KubeJSPlugin;
import dev.latvian.mods.kubejs.script.BindingRegistry;
import dev.rhaaaaaast1.akubejsplugin.api.BlockEntityAPI;
import dev.rhaaaaaast1.akubejsplugin.api.BlockEntitySlots;
import dev.rhaaaaaast1.akubejsplugin.api.ItemStackAPI;
import dev.rhaaaaaast1.akubejsplugin.block.BlockEntitySlotTracker;
import dev.rhaaaaaast1.akubejsplugin.event.RightClickBlockHandler;
import dev.rhaaaaaast1.akubejsplugin.recipe.RecipeIndex;
import net.neoforged.neoforge.common.NeoForge;

/**
 * KubeJS 2101 plugin entrypoint. Discovered through {@code kubejs.plugins.txt},
 * not through META-INF/services.
 */
public final class AKubejsPluginKJSPlugin implements KubeJSPlugin {
    private static boolean rightClickRegistered;

    @Override
    public void init() {
        if (!rightClickRegistered) {
            rightClickRegistered = true;
            NeoForge.EVENT_BUS.addListener(RightClickBlockHandler::onRightClickBlock);
        }
    }

    @Override
    public void registerEvents(EventGroupRegistry registry) {
        AKubejsPluginEvents.attach();
    }

    @Override
    public void registerBindings(BindingRegistry bindings) {
        if (bindings.type().isStartup() || bindings.type().isServer()) {
            bindings.add("ItemStackAPI", ItemStackAPI.class);
        }
        if (bindings.type().isServer()) {
            bindings.add("BlockEntityAPI", BlockEntityAPI.class);
        }
    }

    @Override
    public void registerClasses(ClassFilter filter) {
        filter.allow(ItemStackAPI.class);
        filter.allow(BlockEntityAPI.class);
        filter.allow(BlockEntitySlots.class);
    }

    @Override
    public void clearCaches() {
        RecipeIndex.clear();
        BlockEntitySlotTracker.clear();
    }
}
