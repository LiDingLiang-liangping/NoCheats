package com.example.nocheats;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.world.GameMode;

public class NoCheatsMod implements ModInitializer {
    public static final String MOD_ID = "nocheats";

    @Override
    public void onInitialize() {
        // 注册服务器 tick 事件，用于检测创造模式
        ServerTickEvents.END_SERVER_TICK.register(server -> {
            if (server.isDedicated()) return;
            if (!isLanHost(server)) return;

            for (ServerPlayerEntity player : server.getPlayerManager().getPlayerList()) {
                if (player.interactionManager.getGameMode() == GameMode.CREATIVE) {
                    player.changeGameMode(GameMode.SURVIVAL);
                    player.sendMessage(Text.literal("§c[NoCheats] 创造模式已被禁用，可使用旁观模式"), false);
                }
            }
        });
    }

    private boolean isLanHost(MinecraftServer server) {
        try {
            return server.isSingleplayer();
        } catch (Exception e) {
            return false;
        }
    }
}
