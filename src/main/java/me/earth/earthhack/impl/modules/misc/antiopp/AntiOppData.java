package me.earth.earthhack.impl.modules.misc.antiopp;

import me.earth.earthhack.api.module.data.DefaultData;
import me.earth.earthhack.impl.modules.misc.chat.Chat;

final class AntiOppData extends DefaultData<AntiOpp>
{

    public AntiOppData(AntiOpp module) {
        super(module);
    }

    @Override
    public String getDescription()
    {
        return "Sends a Chat message and plays a narrators voice when a player is detected around you. (WARNING: May possibly contain LOUD audio.)";
    }

}

