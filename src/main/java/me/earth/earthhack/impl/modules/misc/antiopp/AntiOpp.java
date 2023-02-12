package me.earth.earthhack.impl.modules.misc.antiopp;

import me.earth.earthhack.api.module.util.Category;
import me.earth.earthhack.impl.util.minecraft.entity.module.EntityTypeModule;

import java.util.ArrayList;
import java.util.Objects;

public class AntiOpp extends EntityTypeModule implements AntiOppInter {

    public final ArrayList<EntityData> entityDataArrayList = new ArrayList<>();

    public AntiOpp() {
        super("AntiOpp", Category.Misc);

        this.listeners.add(new ListenerEntityChunk(this));
    }



    public boolean hasEntity(String id) {
        return entityDataArrayList.stream().anyMatch(entityData -> Objects.equals(entityData.id, id));
    }

    public static class EntityData {
        private final String id;
        private final long time;

        public EntityData(String id, long time) {
            this.id = id;
            this.time = time;
        }

    }

    @Override
    public String getDescription()
    {
        return "Sends a Chat message and plays a narrators voice when a player is detected around you. (WARNING: May possibly contain LOUD audio.)";
    }

}
