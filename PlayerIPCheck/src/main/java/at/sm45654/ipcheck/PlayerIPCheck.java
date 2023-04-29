package at.sm45654.ipcheck;

import at.sm45654.ipcheck.command.IPCheckCMD;
import at.sm45654.ipcheck.util.ColorUtil;
import org.bukkit.plugin.java.JavaPlugin;

public final class PlayerIPCheck extends JavaPlugin {

    public static String prefix = ColorUtil.LIGHT_BLUE + "[" + ColorUtil.GREEN + "IPCHECK" + ColorUtil.LIGHT_BLUE + "] ";

    @Override
    public void onEnable() {
        getCommand("ipcheck").setExecutor(new IPCheckCMD());
    }

    @Override
    public void onDisable() {
    }
}
