package gg.fridge.ProtectMyKeybinds;

import net.fabricmc.api.ClientModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModEntry implements ClientModInitializer {
    public static final String MOD_ID = "protectmykeybinds";
    public static final Logger LOGGER = LoggerFactory.getLogger("ProtectMyKeybinds");

    @Override
    public void onInitializeClient() {
        LOGGER.info("[ProtectMyKeybinds]: Hello, world!");
    }
}
