package de.maurice.teamchat.Manager;

import de.maurice.teamchat.Utils;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TeamChatManager {
    private static TeamChatManager instance;
    private final List<Player> teamAutoChatEnabled = new LinkedList<>();
    private final List<Player> leadAutoChatEnabled = new LinkedList<>();

    public TeamChatManager() {
        instance = this;
    }

    public void sendMessage(Player player, String message, String type) {
        String formatted = ChatColor.translateAlternateColorCodes('&', Utils.formatMessage(player, message, type));
        for (Player p : getMessageReceiver(type)) {
            p.sendMessage(formatted);
        }
    }

    public boolean hasAutoChatEnabled(Player player, String type) {
        if (type.equals("team")) {
            return teamAutoChatEnabled.contains(player);
        } else if (type.equals("lead")) {
            return leadAutoChatEnabled.contains(player);
        }
        return false;
    }

    public boolean toggleAutoChat(Player player, String type) {
        boolean state = false;
        if (type.equals("team")) {
            if (teamAutoChatEnabled.contains(player)) {
                teamAutoChatEnabled.remove(player);
            } else {
                teamAutoChatEnabled.add(player);
                state = true;
            }
        } else if (type.equals("lead")) {
            if (leadAutoChatEnabled.contains(player)) {
                leadAutoChatEnabled.remove(player);
            } else {
                leadAutoChatEnabled.add(player);
                state = true;
            }
        }
        return state;
    }

    public boolean hasChatPermission(Player player, String type) {
        if (type.equals("team")) {
            return player.hasPermission("teamchat.chat.team");
        } else if (type.equals("lead")) {
            return player.hasPermission("teamchat.chat.lead");
        }
        return false;
    }

    public List<Player> getMessageReceiver(String type) {
        List<Player> pList = new ArrayList<>();
        for (Player p : Bukkit.getOnlinePlayers()) {
            if (p.hasPermission(String.format("teamchat.receive.%s", type))) pList.add(p);
        }
        return pList;
    }


    public static TeamChatManager getInstance() {
        return instance;
    }
}
