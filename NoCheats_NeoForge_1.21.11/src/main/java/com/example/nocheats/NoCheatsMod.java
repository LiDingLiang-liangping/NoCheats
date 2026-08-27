package com.example.nocheats;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.CommandEvent;
import net.minecraft.network.chat.Component;
import net.minecraft.server.MinecraftServer;

@Mod(NoCheatsMod.MOD_ID)
public class NoCheatsMod {
    public static final String MOD_ID = "nocheats";

    public NoCheatsMod() {
        NeoForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onCommand(CommandEvent event) {
        String cmd = event.getParseResults().getReader().getString().trim().toLowerCase();
        var source = event.getParseResults().getContext().getSource();

        MinecraftServer server = source.getServer();
        if (server == null) return;
        if (server.isDedicatedServer()) return;
        if (!isLanHost(server)) return;

        // 禁用 /give
        if (cmd.startsWith("give")) {
            event.setCanceled(true);
            source.sendFailure(Component.literal("§c[NoCheats] /give 指令已被禁用"));
            return;
        }

        // 禁用创造模式切换
        if (cmd.matches("gamemode\\s+(creative|1|c)")) {
            event.setCanceled(true);
            source.sendFailure(Component.literal("§c[NoCheats] 创造模式已被禁用，可使用旁观模式 (/gamemode spectator)"));
            return;
        }
    }

    private boolean isLanHost(MinecraftServer server) {
        try {
            return server.isSingleplayer();
        } catch (Exception e) {
            return false;
        }
    }
}
