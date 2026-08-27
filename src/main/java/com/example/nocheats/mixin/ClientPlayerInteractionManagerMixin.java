package com.example.nocheats.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.world.GameMode;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(net.minecraft.client.network.ClientPlayerInteractionManager.class)
public class ClientPlayerInteractionManagerMixin {

    @Inject(method = "setGameMode", at = @At("HEAD"), cancellable = true)
    private void onSetGameMode(GameMode gameMode, CallbackInfo ci) {
        MinecraftClient client = MinecraftClient.getInstance();

        if (client.getServer() == null) return;
        if (client.getServer().isDedicated()) return;

        // 禁止切换到创造模式
        if (gameMode == GameMode.CREATIVE) {
            ClientPlayerEntity player = client.player;
            if (player != null) {
                player.sendMessage(Text.literal("§c[NoCheats] 创造模式已被禁用"), true);
            }
            ci.cancel();
        }
    }
}
