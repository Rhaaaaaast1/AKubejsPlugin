package dev.rhaaaaaast1.akubejsplugin.composter;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

/** Global composter output selected by the KubeJS startup event. */
public final class ComposterOutput {
    private static Item output = Items.BONE_MEAL;

    private ComposterOutput() {
    }

    public static Item output() {
        return output;
    }

    public static void set(Item item) {
        output = item == null || item == Items.AIR ? Items.BONE_MEAL : item;
    }

    public static void reset() {
        output = Items.BONE_MEAL;
    }
}
