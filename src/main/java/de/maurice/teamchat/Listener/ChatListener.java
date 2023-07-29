package de.maurice.teamchat.Listener;

import de.maurice.teamchat.Manager.TeamChatManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {
    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent e) {
        if (TeamChatManager.getInstance().hasAutoChatEnabled(e.getPlayer(), "team")) {
            TeamChatManager.getInstance().sendMessage(e.getPlayer(), e.getMessage(), "team");
            e.setCancelled(true);
        }

        if (TeamChatManager.getInstance().hasAutoChatEnabled(e.getPlayer(), "lead")) {
            TeamChatManager.getInstance().sendMessage(e.getPlayer(), e.getMessage(), "lead");
            e.setCancelled(true);
        }
    }

}
