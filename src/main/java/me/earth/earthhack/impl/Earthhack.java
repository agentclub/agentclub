package me.earth.earthhack.impl;

import me.earth.earthhack.api.util.interfaces.Globals;
import me.earth.earthhack.impl.core.ducks.IMinecraft;
import me.earth.earthhack.impl.managers.Managers;
import me.earth.earthhack.impl.managers.thread.GlobalExecutor;
import me.earth.earthhack.impl.modules.client.commands.Commands;
import me.earth.earthhack.impl.util.icon.IconUtil;
import me.earth.earthhack.impl.util.math.geocache.Sphere;
import me.earth.earthhack.impl.util.render.SplashScreenHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.util.Util;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.opengl.Display;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;


public class Earthhack implements Globals {
    private static final Logger LOGGER = LogManager.getLogger("agent.club");
    public static final String NAME = "agent.club";
    public static final String VERSION = "b4";

    public static void preInit() {
        GlobalExecutor.EXECUTOR.submit(() -> Sphere.cacheSphere(LOGGER));
    }

    public static void init() throws IOException {

        LOGGER.info("\n\nInitializing agent.club.");
        SplashScreenHelper.setSplashScreen("Initializing agent.club", 7);
        Display.setTitle(NAME + " " + VERSION);
        Earthhack.setWindowIcon();
        Managers.load();
        LOGGER.info("Prefix is " + Commands.getPrefix());
        SplashScreenHelper.clear();
        LOGGER.info("\nagent.club initialized.\n");
    }


    public static void postInit() {
        // For Plugins if they need it.
    }

    public static Logger getLogger() {
        return LOGGER;
    }

    public static boolean isRunning() {
        return ((IMinecraft) mc).isEarthhackRunning();
    }

    public static void setWindowIcon() {
        if (Util.getOSType() != Util.EnumOS.OSX) {
            try (InputStream inputStream16x = Minecraft.class.getResourceAsStream("/assets/earthhack/icons/agentclub_16x16.png");
                 InputStream inputStream32x = Minecraft.class.getResourceAsStream("/assets/earthhack/icons/agentclub_32x32.png");){
                ByteBuffer[] icons = new ByteBuffer[]{IconUtil.INSTANCE.readImageToBuffer(inputStream16x), IconUtil.INSTANCE.readImageToBuffer(inputStream32x)};
                Display.setIcon(icons);
            }
            catch (Exception e) {
                LOGGER.error("Couldn't set Windows Icon", e);
            }
        }
    }

    }

