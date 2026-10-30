package dev.kaisoryx.gui;

import dev.kaisoryx.modules.ClientModule;
import dev.kaisoryx.modules.ModuleManager;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public final class KaisoryxScreen extends Screen {
    private int scroll;
    public KaisoryxScreen() { super(Component.literal("KAISORYX")); }

    @Override
    public void render(GuiGraphics g, int mouseX, int mouseY, float delta) {
        int w = this.width, h = this.height;
        g.fill(0, 0, w, h, 0xCC070B16);
        int panelW = Math.min(520, w - 40), panelH = Math.min(390, h - 40);
        int x = (w - panelW) / 2, y = (h - panelH) / 2;
        g.fill(x, y, x + panelW, y + panelH, 0xF0111B2D);
        g.fill(x, y, x + panelW, y + 3, 0xFF36E6FF);
        g.drawString(this.font, "KAISORYX", x + 18, y + 15, 0xFF62EDFF, false);
        g.drawString(this.font, "CLIENT  /  MODULE MATRIX", x + 18, y + 30, 0xFF9AAFCB, false);
        int rowY = y + 55;
        var modules = ModuleManager.all();
        for (int i = 0; i < modules.size(); i++) {
            ClientModule m = modules.get(i);
            int ry = rowY + i * 22 - scroll;
            if (ry < y + 48 || ry > y + panelH - 22) continue;
            int bg = m.enabled() ? 0x6636E6FF : 0x442A3A55;
            g.fill(x + 14, ry - 3, x + panelW - 14, ry + 16, bg);
            g.drawString(this.font, m.name(), x + 24, ry + 1, 0xFFEAF7FF, false);
            g.drawString(this.font, m.enabled() ? "ON" : "OFF", x + panelW - 48, ry + 1,
                m.enabled() ? 0xFF66F2C2 : 0xFF9AAFCB, false);
        }
        g.drawString(this.font, "RIGHT SHIFT: CLOSE  •  CLICK A MODULE TO TOGGLE", x + 18, y + panelH - 18, 0xFF9AAFCB, false);
        super.render(g, mouseX, mouseY, delta);
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        if (button == 0) {
            int panelW = Math.min(520, this.width - 40), panelH = Math.min(390, this.height - 40);
            int x = (this.width - panelW) / 2, y = (this.height - panelH) / 2;
            int start = y + 55;
            for (int i = 0; i < ModuleManager.all().size(); i++) {
                int ry = start + i * 22 - scroll;
                if (mouseX >= x + 14 && mouseX <= x + panelW - 14 && mouseY >= ry - 3 && mouseY <= ry + 16) {
                    ModuleManager.all().get(i).toggle(); return true;
                }
            }
        }
        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public boolean mouseScrolled(double mouseX, double mouseY, double horizontalAmount, double verticalAmount) {
        scroll = Math.max(0, Math.min(ModuleManager.all().size() * 22 - 250, scroll - (int)(verticalAmount * 22)));
        return true;
    }

    @Override public boolean isPauseScreen() { return false; }
}
