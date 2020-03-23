package themikeste1.miscmods;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.file.Path;


@Mod.EventBusSubscriber
public class Config {
    //Logging
    private static final Logger LOGGER = LogManager.getLogger();

    private static final ForgeConfigSpec.Builder COMMON_BUILDER = new ForgeConfigSpec.Builder();
//    private static final ForgeConfigSpec.Builder CLIENT_BUILDER = new ForgeConfigSpec.Builder();

    public static ForgeConfigSpec COMMON_CONFIG;
//    public static ForgeConfigSpec CLIENT_CONFIG;

    private static final String CATEGORY_GENERAL = "general";

    static {
        COMMON_BUILDER.comment("General Settings").push(CATEGORY_GENERAL);

        COMMON_BUILDER.pop();

        COMMON_CONFIG = COMMON_BUILDER.build();
//        CLIENT_CONFIG = CLIENT_BUILDER.build();
    }

    public static void loadConfig(ForgeConfigSpec spec, Path path) {
        final CommentedFileConfig configData = CommentedFileConfig.builder(path)
                .sync()
                .autosave()
                .writingMode(WritingMode.REPLACE)
                .build();

        configData.load();
        spec.setConfig(configData);
    }


    /* ***********************************************************************
     * configLoaded()
     * Use this function to make any calculations necessary based off of config
     * variables.
     ************************************************************************/
    @SubscribeEvent
    public static void configLoaded(final ModConfig.Loading event) {
        LOGGER.debug("Loaded {} config file {}", Constants.MOD_ID, event.getConfig().getFileName());
    }

    /* ***********************************************************************
     * configFileReload()
     * Use this function to make any calculations necessary based off of config
     * variables. This is used when a config file is reloaded.
     ************************************************************************/
    @SubscribeEvent
    public static void configFileReload(final ModConfig.Reloading event) {

    }
}
