package de.maurice.teamchat;

import java.util.logging.Logger;

import de.maurice.teamchat.Commands.CommandHandler;
import de.maurice.teamchat.Listener.ChatListener;
import de.maurice.teamchat.Manager.TeamChatManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

/*
 * teamchat java plugin
 */
public class Main extends JavaPlugin {
  private static Main instance;
  private static final Logger LOGGER=Logger.getLogger("teamchat");

  public void onEnable()
  {
    instance = this;
    createManager();
    registerListerner();
    registerCommands();

    LOGGER.info("teamchat enabled");
  }

  public void onDisable()
  {
    LOGGER.info("teamchat disabled");
  }

  public void createManager() {
    new Settings();
    new TeamChatManager();
  }

  public void registerListerner() {
    PluginManager manager = Bukkit.getPluginManager();
    manager.registerEvents(new ChatListener(), this);
  }

  public void registerCommands() {
      getCommand("teamchat").setExecutor(new CommandHandler());
      getCommand("leadchat").setExecutor(new CommandHandler());
  }

  public static Main getInstance() {
    return instance;
  }
}
