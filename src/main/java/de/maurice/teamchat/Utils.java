package de.maurice.teamchat;

import org.bukkit.entity.Player;

public class Utils {

    public static String formatMessage(Player player, String message, String type) {
       // String temp = "";
        String pattern = "";
        if (type.equals("team")) {
            pattern = Settings.getTeamChatPattern();
        } else if (type.equals("lead")) {
            pattern = Settings.getLeadChatPattern();
        }

        pattern = pattern.replace("{DISPLAY_NAME}", player.getDisplayName())
                .replace("{USERNAME}", player.getName())
                .replace("{MESSAGE}", message);


        return pattern;
    }
}
