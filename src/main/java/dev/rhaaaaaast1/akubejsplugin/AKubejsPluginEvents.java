package dev.rhaaaaaast1.akubejsplugin;

import dev.latvian.mods.kubejs.event.EventHandler;
import dev.latvian.mods.kubejs.plugin.builtin.event.BlockEvents;
import dev.latvian.mods.kubejs.plugin.builtin.event.PlayerEvents;
import dev.latvian.mods.kubejs.plugin.builtin.event.ServerEvents;
import dev.rhaaaaaast1.akubejsplugin.event.BlockEntitySlotChangedKubeEvent;
import dev.rhaaaaaast1.akubejsplugin.event.RecipeOutputKubeEvent;
import dev.rhaaaaaast1.akubejsplugin.event.RightClickBlockPreKubeEvent;

/**
 * Event handlers attached to KubeJS' existing event groups, so scripts can use
 * {@code ServerEvents.recipeOutput(...)}, {@code BlockEvents.blockEntitySlotChanged(...)}
 * and {@code PlayerEvents.rightClickBlockPre(...)} directly.
 */
public final class AKubejsPluginEvents {
    public static EventHandler RECIPE_OUTPUT;
    public static EventHandler BLOCK_ENTITY_SLOT_CHANGED;
    public static EventHandler RIGHT_CLICK_BLOCK_PRE;

    private AKubejsPluginEvents() {
    }

    public static void attach() {
        if (RECIPE_OUTPUT != null) {
            return;
        }

        RECIPE_OUTPUT = ServerEvents.GROUP.server("recipeOutput", () -> RecipeOutputKubeEvent.class);
        BLOCK_ENTITY_SLOT_CHANGED = BlockEvents.GROUP.server("blockEntitySlotChanged", () -> BlockEntitySlotChangedKubeEvent.class);
        RIGHT_CLICK_BLOCK_PRE = PlayerEvents.GROUP.server("rightClickBlockPre", () -> RightClickBlockPreKubeEvent.class);
    }

    public static boolean hasRecipeListeners() {
        return RECIPE_OUTPUT != null && RECIPE_OUTPUT.hasListeners();
    }

    public static boolean hasSlotListeners() {
        return BLOCK_ENTITY_SLOT_CHANGED != null && BLOCK_ENTITY_SLOT_CHANGED.hasListeners();
    }

    public static boolean hasRightClickListeners() {
        return RIGHT_CLICK_BLOCK_PRE != null && RIGHT_CLICK_BLOCK_PRE.hasListeners();
    }
}
