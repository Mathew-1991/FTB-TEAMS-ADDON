package com.ftbteamsaddon;

import dev.ftb.mods.ftbteams.api.FTBTeamsAPI;
import dev.ftb.mods.ftbteams.api.Team;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ChatEventHandler {

    @SubscribeEvent
    public void onChat(ServerChatEvent event) {
        ServerPlayer player = event.getPlayer();
        
        // Get the player's team
        Team team = FTBTeamsAPI.api().getManager().getTeamForPlayer(player.getUUID()).orElse(null);
        
        if (team != null && !team.isPlayerTeam()) {
            // Get team name or display name
            String teamName = team.getShortName();
            
            // Create new message with team tag
            Component originalMessage = event.getMessage();
            Component newMessage = Component.literal("[" + teamName + "] ")
                .append(player.getDisplayName())
                .append(": ")
                .append(originalMessage);
            
            // Update the message
            event.setMessage(newMessage);
        }
    }
}
