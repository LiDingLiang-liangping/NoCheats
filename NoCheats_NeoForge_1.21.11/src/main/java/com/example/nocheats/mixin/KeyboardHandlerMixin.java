package com.example.nocheats.mixin;

import net.minecraft.client.KeyboardHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.world.level.GameType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(KeyboardHandler.class)
public class KeyboardHandlerMixin {

    @Inject(method = "handleDebugKeys", at = @At("HEAD"), cancellable = true)
    private void onDebugKey(int key, CallbackInfo ci) {
        if (key != 292) return;

        Minecraft mc = Minecraft.getInstance();
        if (mc.getSingleplayerServer() == null) return;
        if (mc.getSingleplayerServer().isDedicatedServer()) return;

        if (mc.gameMode == null) return;

        GameType currentMode = mc.gameMode.getPlayerMode();

        if (currentMode == GameType.SURVIVAL) {
            if (mc.player != null) {
                mc.player.connection.sendCommand("gamemode spectator");
                mc.player.displayClientMessage(
                    net.minecraft.network.chat.Component.literal("§a[NoCheats] 已切换至旁观模式（创造模式已禁用）"),
                    true
                );
            }
            ci.cancel();
        }
    }
}
