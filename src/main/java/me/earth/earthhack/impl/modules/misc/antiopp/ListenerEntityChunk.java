package me.earth.earthhack.impl.modules.misc.antiopp;

import com.mojang.realmsclient.gui.ChatFormatting;
import com.mojang.text2speech.Narrator;
import me.earth.earthhack.api.event.events.Stage;
import me.earth.earthhack.impl.event.events.network.EntityChunkEvent;
import me.earth.earthhack.impl.event.listeners.ModuleListener;
import me.earth.earthhack.impl.modules.combat.bowkill.BowKiller;
import me.earth.earthhack.impl.util.text.ChatUtil;

import java.util.ArrayList;

final class ListenerEntityChunk extends ModuleListener<AntiOpp, EntityChunkEvent> {
    private final Narrator narrator = Narrator.getNarrator();



    public ListenerEntityChunk(AntiOpp module) {
        super(module, EntityChunkEvent.class);
    }



    @Override
    public void invoke(EntityChunkEvent event) {

        if (event.getStage() == Stage.PRE && event.getEntity() != null) {
            if (module.isValid(event.getEntity())) {
                ChatUtil.sendMessage(ChatFormatting.WHITE + "[" + ChatFormatting.AQUA + "Calypso" + ChatFormatting.LIGHT_PURPLE + "+" + ChatFormatting.WHITE + "]" + ChatFormatting.AQUA + " Opp detected I repeat opp detected!");
                if (!module.hasEntity(event.getEntity().getUniqueID().toString())) {
                    narrator.clear();
                    narrator.say("Opp Detected! Watch out!");
                    module.entityDataArrayList.add(new AntiOpp.EntityData(event.getEntity().getUniqueID().toString(),
                            System.currentTimeMillis()));
                }
            }
        }
    }




}
