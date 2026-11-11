package dev.rhaaaaaast1.akubejsplugin.mixin;

import dev.rhaaaaaast1.akubejsplugin.composter.ComposterOutput;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.ComposterBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

/** Replaces the hardcoded bone meal read in ComposterBlock#extractProduce. */
@Mixin(ComposterBlock.class)
public abstract class ComposterBlockMixin {
    @Redirect(
            method = "extractProduce",
            at = @At(
                    value = "FIELD",
                    target = "Lnet/minecraft/world/item/Items;BONE_MEAL:Lnet/minecraft/world/item/Item;"
            )
    )
    private static Item akubejsplugin$composterOutput() {
        return ComposterOutput.output();
    }
}
