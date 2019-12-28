package themikeste1.miscmods.atlas;

import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import themikeste1.miscmods.Constants;

@ObjectHolder(Constants.MOD_ID)
@Mod.EventBusSubscriber(modid = Constants.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EntityTypes {
    //Logging
    private static final Logger LOGGER = LogManager.getLogger();


    @SubscribeEvent
    public static void registerEntities(final RegistryEvent.Register<EntityType<?>> event) {
        LOGGER.debug("MiscMods: Registering Entities...");
        event.getRegistry().registerAll(
        );
    } //registerEntities()

    @SubscribeEvent
    public static void registerSpawnEggs(final RegistryEvent.Register<Item> event) {
        generateEntityTypes();
        LOGGER.debug("MiscMods: Registering Spawn Eggs...");
        event.getRegistry().registerAll(
        );
    } //registerSpawnEggs()


    private static void generateEntityTypes() {
        LOGGER.debug("MiscMods: Creating EntityTypes...");
    }
} //class EntityTypes
