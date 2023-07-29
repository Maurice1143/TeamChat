package de.maurice.teamchat;

import org.bukkit.configuration.file.FileConfiguration;

public class Settings {
    private static Settings instance;
    FileConfiguration config;
    private static String teamChatPattern;
    private static String leadChatPattern;
    private static String teamChatToggleMessage;
    private static String leadChatToggleMessage;
    public Settings() {
        Main.getInstance().saveDefaultConfig();
        config = Main.getInstance().getConfig();

        instance = this;

        teamChatPattern = config.getString("TeamChat.pattern", "[Team]§r {DISPLAY_NAME}: {MESSAGE}");
        leadChatPattern = config.getString("LeadChat.pattern", "[Lead]§r {DISPLAY_NAME}: {MESSAGE}");
        teamChatToggleMessage = config.getString("TeamChat.toggleMessage", "Toggled auto chat for TeamChat");
        leadChatToggleMessage = config.getString("LeadChat.toggleMessage", "Toggled auto chat for LeadChat");
    }

    public static String getTeamChatPattern() {
        return teamChatPattern;
    }

    public static String getLeadChatPattern() {
        return leadChatPattern;
    }

    public static String getToggleMessage(String type) {
        if (type.equals("team")) {
            return teamChatToggleMessage;
        } else if (type.equals("lead")) {
            return leadChatToggleMessage;
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

}
