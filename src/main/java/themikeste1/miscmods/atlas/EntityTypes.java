package themikeste1.miscmods.atlas;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import themikeste1.miscmods.Constants;
import themikeste1.miscmods.core.entities.WalkingBombEntity;

@ObjectHolder(Constants.MOD_ID)
@Mod.EventBusSubscriber(modid = Constants.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EntityTypes {
    //Logging
    private static final Logger LOGGER = LogManager.getLogger();

    //Entities
    @ObjectHolder(WalkingBombEntity.ID)
    public static EntityType<WalkingBombEntity> walking_bomb = null;

    //SpawnEggs
    @ObjectHolder("spawn_" + WalkingBombEntity.ID)
    public static final Item spawn_walking_bomb = null;

    @SubscribeEvent
    public static void registerEntities(final RegistryEvent.Register<EntityType<?>> event) {
        LOGGER.debug("MiscMods: Registering Entities...");
        event.getRegistry().registerAll(
                walking_bomb
        );
    } //registerEntities()

    @SubscribeEvent
    public static void registerSpawnEggs(final RegistryEvent.Register<Item> event) {
        generateEntityTypes();
        LOGGER.debug("MiscMods: Registering Spawn Eggs...");
        event.getRegistry().registerAll(
                new SpawnEggItem(walking_bomb, 0, 256,
                        new Item.Properties()).setRegistryName(Constants.MOD_ID, "spawn_" + WalkingBombEntity.ID)
        );
    } //registerSpawnEggs()


    private static void generateEntityTypes() {
        LOGGER.debug("MiscMods: Creating EntityTypes...");
        walking_bomb = EntityType.Builder
                .create(WalkingBombEntity::new, EntityClassification.CREATURE)
                .size(1, 1)
                .build(WalkingBombEntity.ID);
        walking_bomb.setRegistryName(Constants.MOD_ID, WalkingBombEntity.ID);
    }
} //class EntityTypes
