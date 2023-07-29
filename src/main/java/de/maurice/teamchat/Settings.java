package de.maurice.teamchat;

import de.maurice.teamchat.Manager.TeamChatManager;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import javax.swing.*;

public class Settings {
    private static FileConfiguration config;
    private static String teamChatPattern;
    private static String leadChatPattern;
    private static String teamChatToggleEnabledMessage;
    private static String leadChatToggleEnabledMessage;
    private static String teamChatToggleDisabledMessage;
    private static String leadChatToggleDisabledMessage;
    public Settings() {
        Main.getInstance().saveDefaultConfig();
        config = Main.getInstance().getConfig();

        teamChatPattern = config.getString("TeamChat.pattern", "[Team]§r {DISPLAY_NAME}: {MESSAGE}");
        leadChatPattern = config.getString("LeadChat.pattern", "[Lead]§r {DISPLAY_NAME}: {MESSAGE}");
        teamChatToggleEnabledMessage = config.getString("TeamChat.toggleEnabledMessage", "Toggled auto chat for TeamChat");
        leadChatToggleEnabledMessage = config.getString("LeadChat.toggleEnabledMessage", "Toggled auto chat for LeadChat");
        teamChatToggleDisabledMessage = config.getString("TeamChat.toggleDisabledMessage", "Toggled auto chat for LeadChat");
        leadChatToggleDisabledMessage = config.getString("LeadChat.toggleDisabledMessage", "Toggled auto chat for LeadChat");
    }

    public static String getTeamChatPattern() {
        return teamChatPattern;
    }

    public static String getLeadChatPattern() {
        return leadChatPattern;
    }

    public static String getToggleMessage(String type, boolean state) {
        if (state == true) {
            if (type.equals("team")) {
                return teamChatToggleEnabledMessage;
            } else if (type.equals("lead")) {
                return leadChatToggleEnabledMessage;
            }
        } else {
            if (type.equals("team")) {
                return teamChatToggleDisabledMessage;
            } else if (type.equals("lead")) {
                return leadChatToggleDisabledMessage;
            }
        }
        return "Toggled auto chat";
    }


    public static String getPattern(String type) {
        if (type.equals("team")) {
            return teamChatPattern;
        } else if (type.equals("lead")) {
            return leadChatPattern;
        }
        return "[Staff]§r {DISPLAY_NAME}: {MESSAGE}";
    }

    public static void reloadConfig() {
        Main.getInstance().reloadConfig();
        config = Main.getInstance().getConfig();

        teamChatPattern = config.getString("TeamChat.pattern", "[Team]§r {DISPLAY_NAME}: {MESSAGE}");
        leadChatPattern = config.getString("LeadChat.pattern", "[Lead]§r {DISPLAY_NAME}: {MESSAGE}");
        teamChatToggleEnabledMessage = config.getString("TeamChat.toggleEnabledMessage", "Toggled auto chat for TeamChat");
        leadChatToggleEnabledMessage = config.getString("LeadChat.toggleEnabledMessage", "Toggled auto chat for LeadChat");
        teamChatToggleDisabledMessage = config.getString("TeamChat.toggleDisabledMessage", "Toggled auto chat for LeadChat");
        leadChatToggleDisabledMessage = config.getString("LeadChat.toggleDisabledMessage", "Toggled auto chat for LeadChat");
    }

}
