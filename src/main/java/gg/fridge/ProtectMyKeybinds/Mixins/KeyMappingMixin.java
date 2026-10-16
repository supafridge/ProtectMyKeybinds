package gg.fridge.ProtectMyKeybinds.Mixins;

import gg.fridge.ProtectMyKeybinds.ModEntry;
import gg.fridge.ProtectMyKeybinds.ModdedKeybinds;
import net.minecraft.client.KeyMapping;
import net.minecraft.network.chat.Component;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.function.Supplier;

// Priority is set here because ExploitPreventer may inject before we do.
@Mixin(value = KeyMapping.class, priority = 1100)
public class KeyMappingMixin {
    @Inject(method = "createNameSupplier", at = @At("HEAD"), cancellable = true)
    private static void ProtectMyKeybinds$hideModdedKeybinds(String name,
                                                             CallbackInfoReturnable<Supplier<Component>> callbackInfoReturnable) {
        if (ModdedKeybinds.isModdedKeybind(name)) {
            ModEntry.LOGGER.info("[ProtectMyKeybinds]: Blocked resolution of modded keybind: {}", name);
            callbackInfoReturnable.setReturnValue(() -> Component.literal(name));
        }
    }
}
