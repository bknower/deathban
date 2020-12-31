package com.bknower.deathban.setup;


import com.bknower.deathban.DeathBan;
import com.bknower.deathban.commands.DeathBanCommands;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = DeathBan.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModSetup {

//    public static final ItemGroup ITEM_GROUP = new ItemGroup("mytutorial") {
//        @Override
//        public ItemStack createIcon() {
//            return new ItemStack(Registration.FIRSTBLOCK.get());
//        }
//    };

//    public static void init(final FMLCommonSetupEvent event) {
//        Networking.registerMessages();
//        CapabilityEntityCharge.register();
//
//        MinecraftForge.EVENT_BUS.addListener(ChargeEventHandler::onAttachCapabilitiesEvent);
//        MinecraftForge.EVENT_BUS.addListener(ChargeEventHandler::onAttackEvent);
//        MinecraftForge.EVENT_BUS.addListener(ChargeEventHandler::onDeathEvent);
//    }

    @SubscribeEvent
    public static void serverLoad(RegisterCommandsEvent event) {
        DeathBanCommands.register(event.getDispatcher());
    }

//    @SubscribeEvent
//    public static void onDimensionRegistry(RegisterDimensionsEvent event) {
//        ModDimensions.DIMENSION_TYPE = DimensionManager.registerOrGetDimension(ModDimensions.DIMENSION_ID, Registration.DIMENSION.get(), null, true);
//    }

}