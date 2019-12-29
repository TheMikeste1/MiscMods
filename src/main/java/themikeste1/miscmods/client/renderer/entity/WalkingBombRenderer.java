package themikeste1.miscmods.client.renderer.entity;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.loading.FMLEnvironment;
import themikeste1.miscmods.Constants;
import themikeste1.miscmods.client.renderer.entity.model.WalkingBombModel;
import themikeste1.miscmods.core.entities.WalkingBombEntity;

public class WalkingBombRenderer extends MobRenderer<WalkingBombEntity, WalkingBombModel<WalkingBombEntity>> {
    private static final ResourceLocation SKIN = new ResourceLocation(Constants.MOD_ID, "textures/entity/walking_bomb.png");

    public WalkingBombRenderer(EntityRendererManager renderManager) {
        //   (renderManager,               model,     shadowSize);
        super(renderManager, new WalkingBombModel<>(),0.0F);
    }

    @Override
    public ResourceLocation getEntityTexture(WalkingBombEntity walkingBombEntity) { return SKIN; }

    public static class Factory implements IRenderFactory<WalkingBombEntity> {
        public static final Factory INSTANCE = new WalkingBombRenderer.Factory();

        @Override
        public EntityRenderer<? super WalkingBombEntity> createRenderFor(EntityRendererManager manager) {
            if (FMLEnvironment.dist.isDedicatedServer())
                throw new IllegalStateException("Only run this on client!");

            return new WalkingBombRenderer(manager);
        }
    }
}
