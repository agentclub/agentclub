package me.earth.earthhack.impl.modules.misc.rpc;

import me.earth.earthhack.api.module.Module;
import me.earth.earthhack.api.module.util.Category;
import me.earth.earthhack.api.setting.Setting;
import me.earth.earthhack.api.setting.settings.BooleanSetting;
import me.earth.earthhack.api.setting.settings.StringSetting;
import me.earth.earthhack.impl.event.events.client.ShutDownEvent;
import me.earth.earthhack.impl.event.listeners.LambdaListener;
import me.earth.earthhack.impl.util.discord.DiscordPresence;

public class RPC extends Module
{
    private final DiscordPresence presence = new DiscordPresence(this);

    public RPC()
    {
        super("RPC", Category.Misc);
        this.listeners.add(new LambdaListener<>(ShutDownEvent.class,
                                                e -> presence.stop()));
    }

    @Override
    protected void onEnable()
    {
        presence.start();
    }

    @Override
    protected void onDisable()
    {
        presence.stop();
    }

}
