package me.earth.earthhack.impl.modules.misc.log;

import me.earth.earthhack.api.module.Module;
import me.earth.earthhack.api.util.interfaces.Globals;
import me.earth.earthhack.api.module.util.Category;
import me.earth.earthhack.api.setting.Setting;
import me.earth.earthhack.api.setting.settings.StringSetting;
import me.earth.earthhack.impl.Earthhack;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log extends Module {
    private static final Logger LOGGER = LogManager.getLogger("3arthh4ck");
    protected final Setting<String> consoleLog =
            register(new StringSetting("ConsoleLogger", ""));

    public Log() {
        super("ConsoleLogger", Category.Misc);
        LOGGER.info("[CLIENT INPUT] [FROM USER]: " + consoleLog.getValue());
    }
}

