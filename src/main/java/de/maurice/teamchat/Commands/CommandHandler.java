package de.maurice.teamchat.Commands;

import com.google.common.base.Joiner;
import de.maurice.teamchat.Manager.TeamChatManager;
import de.maurice.teamchat.Settings;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class CommandHandler implements CommandExecutor, TabCompleter {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        if(!(sender instanceof Player player)) return false;

        TeamChatManager tcm = TeamChatManager.getInstance();
        if (command.getName().equals("teamchat") || command.getName().equals("leadchat")) {
            String type = (command.getName().equals("teamchat")) ? "team" : "lead";
            if (args.length == 0) {
                if (tcm.hasChatPermission(player, type)) {
                    boolean state = tcm.toggleAutoChat(player, type);
                    sender.sendMessage(Settings.getToggleMessage(type, state));
                    return true;
                }
            }

            if (args.length > 0) {
                String message = Joiner.on(" ").join(args);
                tcm.sendMessage(player, message, type);
                return true;
            }
        } else if (command.getName().equals("teamchatreload") && args.length == 0) {
            Settings.reloadConfig();
            sender.sendMessage("§7[§bTeamChat-Plugin§7] §6The config was successfully reloaded! ");
            return true;
        }

        return false;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        return new ArrayList<>();
    }
}
