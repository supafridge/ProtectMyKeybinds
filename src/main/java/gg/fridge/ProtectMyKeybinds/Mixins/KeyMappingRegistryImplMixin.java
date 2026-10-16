package gg.fridge.ProtectMyKeybinds.Mixins;

import gg.fridge.ProtectMyKeybinds.ModEntry;
import gg.fridge.ProtectMyKeybinds.ModdedKeybinds;
import net.fabricmc.fabric.impl.client.keymapping.KeyMappingRegistryImpl;
import net.minecraft.client.KeyMapping;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.LinkedHashSet;

@Mixin(KeyMappingRegistryImpl.class)
public class KeyMappingRegistryImplMixin {
    @Inject(method = "registerKeyMapping", at = @At("RETURN"))
    private static void ProtectMyKeybinds$registerKeyMapping(KeyMapping binding,
                                                             CallbackInfoReturnable<KeyMapping> callbackInfoReturnable) {
        ModdedKeybinds.add(binding.getName());
    }
}
