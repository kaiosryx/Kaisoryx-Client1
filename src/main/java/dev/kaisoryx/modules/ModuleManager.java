package dev.kaisoryx.modules;

import java.util.ArrayList;
import java.util.List;

public final class ModuleManager {
    private static final List<ClientModule> MODULES = new ArrayList<>();
    private ModuleManager() {}
    public static void init() {
        if (!MODULES.isEmpty()) return;
        MODULES.add(new ClientModule("FPS HUD", "Show current frames per second", true));
        MODULES.add(new ClientModule("Coordinates", "Show XYZ position", true));
        MODULES.add(new ClientModule("Keystrokes", "Show movement key states", false));
        MODULES.add(new ClientModule("CPS Counter", "Track local mouse clicks", false));
        MODULES.add(new ClientModule("Armor HUD", "Show equipped armor", false));
        MODULES.add(new ClientModule("Toggle Sprint", "Keep sprint enabled while moving forward", false));
        MODULES.add(new ClientModule("Zoom", "Client-side view zoom", false));
        MODULES.add(new ClientModule("Minimal Particles", "Reduce selected visual particle effects", false));
        MODULES.add(new ClientModule("Clean Screen", "Hide selected non-essential overlays", false));
        MODULES.add(new ClientModule("Crosshair Styles", "Choose a clean crosshair preset", false));
        MODULES.add(new ClientModule("Neon Theme", "Use the Kaisoryx cyan/violet theme", true));
        MODULES.add(new ClientModule("HUD Editor", "Plan and customize HUD layout", false));
        MODULES.add(new ClientModule("Profiles", "Save and switch local client profiles", false));
    }
    public static List<ClientModule> all() { return MODULES; }
}
