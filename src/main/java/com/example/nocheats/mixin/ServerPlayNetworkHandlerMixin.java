package com.example.nocheats.mixin;

import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerPlayNetworkHandler.class)
public class ServerPlayNetworkHandlerMixin {

    @Inject(method = "executeCommand", at = @At("HEAD"), cancellable = true)
    private void onExecuteCommand(String command, CallbackInfo ci) {
        ServerPlayNetworkHandler handler = (ServerPlayNetworkHandler)(Object)this;
        ServerPlayerEntity player = handler.player;

        if (player == null) return;

        MinecraftServer server = player.server;
        if (server == null) return;
        if (server.isDedicated()) return;
        if (!server.isSingleplayer()) return;

        String cmd = command.trim().toLowerCase();

        // 禁用 give
        if (cmd.startsWith("give")) {
            player.sendMessage(Text.literal("§c[NoCheats] /give 指令已被禁用"), false);
            ci.cancel();
            return;
        }

        // 禁用创造模式
        if (cmd.matches("gamemode\\s+(creative|1|c)")) {
            player.sendMessage(Text.literal("§c[NoCheats] 创造模式已被禁用，可使用旁观模式 (/gamemode spectator)"), false);
            ci.cancel();
        }
    }
}
