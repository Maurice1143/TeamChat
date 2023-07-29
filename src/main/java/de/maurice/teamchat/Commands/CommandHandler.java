package de.maurice.teamchat.Commands;

import com.google.common.base.Joiner;
import de.maurice.teamchat.Manager.TeamChatManager;
import de.maurice.teamchat.Settings;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandHandler implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) return false;
        Player player = (Player) sender;

        TeamChatManager tcm = TeamChatManager.getInstance();
        if (command.getName().equals("teamchat") || command.getName().equals("leadchat")) {
            String type = (command.getName().equals("teamchat")) ? "team" : "lead";
            if (args.length == 0) {
                if (tcm.hasChatPermission(player, type)) {
                    tcm.toggleAutoChat(player, type);
                    sender.sendMessage(Settings.getToggleMessage(type));
                    return true;
                }
            }

            if (args.length > 0) {
                String message = Joiner.on(" ").join(args);
                tcm.sendMessage(player, message, type);
                return true;
            }
        }

        return false;
    }
}
