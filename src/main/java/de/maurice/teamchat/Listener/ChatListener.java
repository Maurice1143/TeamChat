package de.maurice.teamchat.Listener;

import de.maurice.teamchat.Manager.TeamChatManager;
import io.papermc.paper.event.player.AsyncChatEvent;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;


public class ChatListener implements Listener {
    @EventHandler
    public void onPlayerChat(AsyncChatEvent e) {
        if (TeamChatManager.getInstance().hasAutoChatEnabled(e.getPlayer(), "team")) {
            String message = LegacyComponentSerializer.legacyAmpersand().serialize(e.message());
            TeamChatManager.getInstance().sendMessage(e.getPlayer(), message, "team");
            e.setCancelled(true);
        }

        if (TeamChatManager.getInstance().hasAutoChatEnabled(e.getPlayer(), "lead")) {
            String message = ChatColor.translateAlternateColorCodes('&', LegacyComponentSerializer.legacyAmpersand().serialize(e.message()));
            TeamChatManager.getInstance().sendMessage(e.getPlayer(), message, "lead");
            e.setCancelled(true);
        }
    }

}
