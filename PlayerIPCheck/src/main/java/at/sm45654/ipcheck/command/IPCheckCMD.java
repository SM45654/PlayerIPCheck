package at.sm45654.ipcheck.command;

import at.sm45654.ipcheck.PlayerIPCheck;
import at.sm45654.ipcheck.util.ColorUtil;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class IPCheckCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        Player p = (Player) s;

        if (!p.hasPermission("ipcheck.admin")) {
            p.sendMessage(PlayerIPCheck.prefix + ColorUtil.RED + "No permission!");
            return false;
        }

        if (args.length == 0) {
            p.sendMessage(PlayerIPCheck.prefix + ColorUtil.RED + "Usage: " + ColorUtil.ORANGE + "/ipcheck [name]");
            return false;
        }

        if (!Bukkit.getOnlinePlayers().contains(Bukkit.getPlayer(args[0]))) {
            p.sendMessage(PlayerIPCheck.prefix + ColorUtil.RED + "Player " + ColorUtil.ORANGE + args[0] + ColorUtil.RED + " does not exist or is not online!");
        } else {
            Player target = Bukkit.getPlayer(args[0]);
            p.sendMessage(PlayerIPCheck.prefix + ColorUtil.LIGHT_GREEN + target.getName() + "'s IP is: " + ColorUtil.ORANGE + target.getAddress());
            p.sendMessage(PlayerIPCheck.prefix + ColorUtil.LIGHT_GREEN + "Online players with this IP adress: ");
            for (Player online : Bukkit.getOnlinePlayers()) {
                if (online.getAddress().equals(target.getAddress())) {
                    p.sendMessage(PlayerIPCheck.prefix + ColorUtil.ORANGE + online.getName());
                }
            }


                }
        return false;
    }
}
