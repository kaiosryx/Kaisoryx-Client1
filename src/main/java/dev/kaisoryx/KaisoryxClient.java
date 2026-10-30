package dev.kaisoryx;

import dev.kaisoryx.gui.KaisoryxScreen;
import dev.kaisoryx.modules.ModuleManager;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import com.mojang.blaze3d.platform.InputConstants;
import org.lwjgl.glfw.GLFW;

public final class KaisoryxClient implements ClientModInitializer {
    public static final String MOD_ID = "kaisoryx";
    public static KeyMapping openMenu;
    public static KeyMapping toggleSprint;
    public static KeyMapping zoomKey;
    private boolean sprintEnabled;
    private double previousFov = 0.0;

    @Override
    public void onInitializeClient() {
        ModuleManager.init();
        KeyMapping.Category category = KeyMapping.Category.register(
            ResourceLocation.fromNamespaceAndPath(MOD_ID, "main")
        );
        openMenu = KeyBindingHelper.registerKeyBinding(new KeyMapping(
            "key.kaisoryx.open_menu", InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_RIGHT_SHIFT, category));
        toggleSprint = KeyBindingHelper.registerKeyBinding(new KeyMapping(
            "key.kaisoryx.toggle_sprint", InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_V, category));
        zoomKey = KeyBindingHelper.registerKeyBinding(new KeyMapping(
            "key.kaisoryx.zoom", InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_C, category));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (openMenu.consumeClick()) client.setScreen(new KaisoryxScreen());
            while (toggleSprint.consumeClick()) {
                sprintEnabled = !sprintEnabled;
                if (client.player != null) client.player.displayClientMessage(
                    Component.literal("§bKaisoryx §7» Toggle Sprint " + (sprintEnabled ? "§aON" : "§cOFF")), true);
            }
            if (client.player != null && sprintEnabled && client.player.input != null) {
                client.player.setSprinting(client.player.input.forwardImpulse > 0.0f);
            }
        });
    }
}
