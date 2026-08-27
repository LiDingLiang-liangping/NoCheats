package com.example.nocheats.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.debug.GameModeSwitcherScreen;
import net.minecraft.world.level.GameType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameModeSwitcherScreen.class)
public class GameModeSwitcherScreenMixin {

    @Inject(method = "switchToHoveredGameMode", at = @At("HEAD"), cancellable = true)
    private static void onSwitchToHovered(Minecraft minecraft, GameModeSwitcherScreen.GameModeIcon icon, CallbackInfo ci) {
        if (minecraft.getSingleplayerServer() == null) return;
        if (minecraft.getSingleplayerServer().isDedicatedServer()) return;

        GameType targetMode = icon.getGameType();

        if (targetMode == GameType.CREATIVE) {
            if (minecraft.player != null) {
                minecraft.player.displayClientMessage(
                    net.minecraft.network.chat.Component.literal("§c[NoCheats] 创造模式已被禁用"),
                    true
                );
            }
            ci.cancel();
        }
    }
}
