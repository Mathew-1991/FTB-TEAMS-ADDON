package com.ftbteamsaddon;

import dev.ftb.mods.ftbteams.api.FTBTeamsAPI;
import dev.ftb.mods.ftbteams.data.Team;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;

public class TablistNameHandler {

    @SubscribeEvent
    public void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event) {
        if (!(event.getEntity() instanceof ServerPlayer player)) return;

        Team team = FTBTeamsAPI.api().getManager().getTeamForPlayer(player.getUUID()).orElse(null);
        if (team != null) {
            String teamName = team.getShortName();
            // Set custom name for tablist: [teamname] username
            player.setCustomName(Component.literal("[" + teamName + "] ").append(player.getDisplayName()));
            player.setCustomNameVisible(true);
        }
    }
}
