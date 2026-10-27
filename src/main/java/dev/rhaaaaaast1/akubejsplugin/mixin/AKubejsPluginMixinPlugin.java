package dev.rhaaaaaast1.akubejsplugin.mixin;

import net.neoforged.fml.ModList;
import net.neoforged.fml.loading.LoadingModList;
import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

import java.util.List;
import java.util.Set;

/**
 * Optional Tinkers' Construct integration. The tconstruct mixin config points at
 * this plugin; all of its mixins are skipped when tconstruct is absent, so the
 * core KubeJS toolkit can ship without TConstruct/Mantle on the classpath.
 */
public final class AKubejsPluginMixinPlugin implements IMixinConfigPlugin {
    @Override
    public void onLoad(String mixinPackage) {
    }

    @Override
    public String getRefMapperConfig() {
        return null;
    }

    @Override
    public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {
        // This runs before ModList is published on some launch targets.
        ModList modList = ModList.get();
        if (modList != null) {
            return modList.isLoaded("tconstruct");
        }

        LoadingModList loading = LoadingModList.get();
        return loading != null && loading.getModFileById("tconstruct") != null;
    }

    @Override
    public void acceptTargets(Set<String> myTargets, Set<String> otherTargets) {
    }

    @Override
    public List<String> getMixins() {
        return null;
    }

    @Override
    public void preApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {
    }

    @Override
    public void postApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {
    }
}
