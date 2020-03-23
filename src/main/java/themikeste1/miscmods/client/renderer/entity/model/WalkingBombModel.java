package themikeste1.miscmods.client.renderer.entity.model;

import com.google.common.collect.ImmutableList;

import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import themikeste1.miscmods.core.entities.WalkingBombEntity;

@OnlyIn(Dist.CLIENT)
public class WalkingBombModel<T extends WalkingBombEntity> extends SegmentedModel<T> {
    private final ModelRenderer face;
    private final ModelRenderer outerTopCrown;
    private final ModelRenderer innerTopCrown;
    private final ModelRenderer outerBottomCrown;
    private final ModelRenderer innerBottomCrown;
    private final ModelRenderer outerLeftCrown;
    private final ModelRenderer innerLeftCrown;
    private final ModelRenderer outerRightCrown;
    private final ModelRenderer innerRightCrown;
    private final ModelRenderer outerBackCrown;
    private final ModelRenderer innerBackCrown;


    public WalkingBombModel() { this(0.0f); }


    public WalkingBombModel(float scale) {

        /*
         * TODO:
         *  Swap inner <-> outer
         */
        //Face
        //         ModelRenderer(Model, textureOffsetX, textureOffsetY)
        face = new ModelRenderer(this, 0, 0);
        face.setRotationPoint(0, 16, 0);
        face.addBox(-4f, -6f, -5f, 8.0F, 8.0F, 1.0F, scale);

        //Top Crown
        outerTopCrown = new ModelRenderer(this, 0, 9);
        outerTopCrown.setRotationPoint(0, 16, 0);
        outerTopCrown.addBox(-3f, -8f, -3f, 6.0F, 1.0F, 6.0F, scale);

        innerTopCrown = new ModelRenderer(this, 0, 9);
        innerTopCrown.setRotationPoint(0, 16, 0);
        innerTopCrown.addBox(-4f, -7f, -4f, 8.0F, 1.0F, 8.0F, scale);

        //Bottom Crown
        outerBottomCrown = new ModelRenderer(this, 0, 9);
        outerBottomCrown.setRotationPoint(0, 16, 0);
        outerBottomCrown.addBox(-3f, 3f, -3f, 6.0F, 1.0F, 6.0F, scale);

        innerBottomCrown = new ModelRenderer(this, 0, 9);
        innerBottomCrown.setRotationPoint(0, 16, 0);
        innerBottomCrown.addBox(-4f, 2f, -4f, 8.0F, 1.0F, 8.0F, scale);

        //Left Crown
        outerLeftCrown = new ModelRenderer(this, 0, 9);
        outerLeftCrown.setRotationPoint(0, 16, 0);
        outerLeftCrown.addBox(6f, -5f, -3f, -1.0F, 6.0F, 6.0F, scale);

        innerLeftCrown = new ModelRenderer(this, 90, 16);
        innerLeftCrown.setRotationPoint(0, 16, 0);
        innerLeftCrown.addBox(5f, -6f, -4f, -1.0F, 8.0F, 8.0F, scale);

        //Right Crown
        outerRightCrown = new ModelRenderer(this, 0, 9);
        outerRightCrown.setRotationPoint(0, 16, 0);
        outerRightCrown.addBox(-6f, -5f, -3f, 1.0F, 6.0F, 6.0F, scale);

        innerRightCrown = new ModelRenderer(this, 18, 32);
        innerRightCrown.setRotationPoint(0, 16, 0);
        innerRightCrown.addBox(-5f, -6f, -4f, 1.0F, 8.0F, 8.0F, scale);
        
        //Back Crown
        outerBackCrown = new ModelRenderer(this, 0, 9);
        outerBackCrown.setRotationPoint(0, 16, 0);
        outerBackCrown.addBox(-3f, -5f, 5f, 6.0F, 6.0F, 1.0F, scale);

        innerBackCrown = new ModelRenderer(this, 0, 9);
        innerBackCrown.setRotationPoint(0, 16, 0);
        innerBackCrown.addBox(-4f, -6f, 4f, 8.0F, 8.0F, 1.0F, scale);
    }


    @Override
    public void setRotationAngles(T t, float v, float v1, float v2, float v3, float v4) {

    }

/*    @Override
    //#render
    public void func_225598_a_(MatrixStack matrixStack, IVertexBuilder iVertexBuilder, int i, int i1, float v, float v1, float v2, float v3) {

    }*/

    @Override
    public Iterable<ModelRenderer> getParts() {
        return ImmutableList.of(face, /*innerTopCrown, innerBottomCrown,*/ innerLeftCrown, innerRightCrown, innerBackCrown
                /*, outerTopCrown, outerBottomCrown, outerLeftCrown, outerRightCrown, outerBackCrown*/);
    }
}
