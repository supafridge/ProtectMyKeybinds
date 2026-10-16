package gg.fridge.ProtectMyKeybinds;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class ModdedKeybinds {
    private static final Set<String> NAMES = ConcurrentHashMap.newKeySet();

    public static void add(String name) { NAMES.add(name); }
    public static boolean isModdedKeybind(String name) { return NAMES.contains(name); }
}
