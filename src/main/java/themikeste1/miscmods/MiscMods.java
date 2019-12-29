package themikeste1.miscmods;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;
import net.minecraftforge.fml.loading.FMLPaths;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import themikeste1.miscmods.atlas.EntityTypes;
import themikeste1.miscmods.client.renderer.entity.WalkingBombRenderer;
import themikeste1.miscmods.core.entities.WalkingBombEntity;

import java.util.stream.Collectors;


/**
 * Sets up the mod.
 *
 * @version 1.0
 * @since 0.0.0.0
 * @author TheMikeste1
 */
@Mod(Constants.MOD_ID)
@Mod.EventBusSubscriber(modid = Constants.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class MiscMods {
    //Logging
    public static final Logger LOGGER = LogManager.getLogger();

    public MiscMods() {
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        //Client stuff
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
        // Register the enqueueIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    } //MiscMods()

    private void setup(final FMLCommonSetupEvent event) {
        // some preinit code
        LOGGER.info("HELLO FROM " + Constants.MOD_NAME + " " + Constants.VERSION);

        //Setup config
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.COMMON_CONFIG);
        Config.loadConfig(Config.COMMON_CONFIG, FMLPaths.CONFIGDIR.get().resolve(Constants.MOD_ID + "-common.toml"));
    } //setup()

    private void doClientStuff(final FMLClientSetupEvent event) {
        if (FMLEnvironment.dist.isDedicatedServer())
            return;

        // do something that can only be done on the client
        LOGGER.info("Got game settings {}", event.getMinecraftSupplier().get().gameSettings);

        RenderingRegistry.registerEntityRenderingHandler(EntityTypes.walking_bomb, WalkingBombRenderer.Factory.INSTANCE);
    }


    private void enqueueIMC(final InterModEnqueueEvent event) {
        // some example code to dispatch IMC to another mod
        InterModComms.sendTo(Constants.MOD_ID, "helloworld", () -> { LOGGER.info("Hello world from the MDK"); return "Hello world";});
    } //enqueueIMC()

    private void processIMC(final InterModProcessEvent event) {
        // some example code to receive and process InterModComms from other mods
        LOGGER.info("Got IMC {}", event.getIMCStream().
                map(m->m.getMessageSupplier().get()).
                collect(Collectors.toList()));

    } //processIMC()
}
