package dev.rhaaaaaast1.akubejsplugin.mixin;

import dev.rhaaaaaast1.akubejsplugin.block.BlockEntitySlotTracker;
import net.minecraft.world.level.block.entity.BlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BlockEntity.class)
public abstract class BlockEntitySetChangedMixin {
    @Inject(method = "setChanged", at = @At("TAIL"))
    private void akubejsplugin$afterSetChanged(CallbackInfo ci) {
        BlockEntitySlotTracker.onChanged((BlockEntity) (Object) this);
    }
}
