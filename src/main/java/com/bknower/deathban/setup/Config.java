package com.bknower.deathban.setup;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

import java.util.Map;

@Mod.EventBusSubscriber
public class Config {

    public static ForgeConfigSpec SERVER_CONFIG;
    public static ForgeConfigSpec CLIENT_CONFIG;

    public static ForgeConfigSpec.ConfigValue<Map<String, Long>[]> BANS;
    public static ForgeConfigSpec.IntValue BAN_MINUTES;

    public static ForgeConfigSpec.BooleanValue BAN_ENABLED;


    static {

        ForgeConfigSpec.Builder SERVER_BUILDER = new ForgeConfigSpec.Builder();
        ForgeConfigSpec.Builder CLIENT_BUILDER = new ForgeConfigSpec.Builder();

        SERVER_BUILDER.comment("Server settings").push("general");

        setupBanConfig(SERVER_BUILDER, CLIENT_BUILDER);

        SERVER_BUILDER.pop();


        SERVER_CONFIG = SERVER_BUILDER.build();
        CLIENT_CONFIG = CLIENT_BUILDER.build();
    }

    private static void setupBanConfig(ForgeConfigSpec.Builder SERVER_BUILDER, ForgeConfigSpec.Builder CLIENT_BUILDER) {
        SERVER_BUILDER.comment("Death Ban Settings").push("settings");

        BAN_MINUTES = SERVER_BUILDER.comment("The number of minutes to ban players for after death")
                .defineInRange("banMinutes", 60, 0, Integer.MAX_VALUE);

        BAN_ENABLED = SERVER_BUILDER.comment("Whether players are banned on death")
                .define("enable", true);


        SERVER_BUILDER.pop();
    }

    public static Boolean isDeathBanEnabled() {
        return BAN_ENABLED.get();
    }

    @SubscribeEvent
    public static void onLoad(final ModConfig.Loading configEvent) {

    }

    @SubscribeEvent
    public static void onReload(final ModConfig.Reloading configEvent) {
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public void onPlayerDeath(LivingDeathEvent event) {
        // is not a player
        if (event.getEntityLiving() == null) {
            return;
        }

        PlayerEntity player = (PlayerEntity) event.getEntityLiving();
    }
}

}