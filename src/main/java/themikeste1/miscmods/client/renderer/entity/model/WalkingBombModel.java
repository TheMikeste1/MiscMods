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
    private final ModelRenderer topCrown;
    private final ModelRenderer bottomCrown;
    private final ModelRenderer leftCrown;
    private final ModelRenderer rightCrown;
    private final ModelRenderer backCrown;

    public WalkingBombModel() { this(0.0f); }





    public WalkingBombModel(float scale) {

        /*
         * TODO:
         *  The textures do not work correctly when modeling the crown with the larger part of the body. I need to separate them.
         */
        //Face
        //         ModelRenderer(Model, textureOffsetX, textureOffsetY)
        face = new ModelRenderer(this, 0, 0);
        face.setRotationPoint(0, 16, 0);
        face.addBox(-4f, -6f, -5f, 8.0F, 8.0F, 1.0F, scale);
        //Top Crown
        topCrown = new ModelRenderer(this, 0, 9);
        topCrown.setRotationPoint(0, 16, 0);
        topCrown.addBox(-4f, -7f, -4f, 8.0F, 1.0F, 8.0F, scale);
        topCrown.addBox(-3f, -8f, -3f, 6.0F, 1.0F, 6.0F, scale);
        //Bottom Crown
        bottomCrown = new ModelRenderer(this, 0, 9);
        bottomCrown.setRotationPoint(0, 16, 0);
        bottomCrown.addBox(-4f, 2f, -4f, 8.0F, 1.0F, 8.0F, scale);
        bottomCrown.addBox(-3f, 3f, -3f, 6.0F, 1.0F, 6.0F, scale);
        //Left Crown
        leftCrown = new ModelRenderer(this, 0, 9);
        leftCrown.setRotationPoint(0, 16, 0);
        leftCrown.addBox(-5f, -6f, -4f, 1.0F, 8.0F, 8.0F, scale);
        leftCrown.addBox(-6f, -5f, -3f, 1.0F, 6.0F, 6.0F, scale);
        //Right Crown
        rightCrown = new ModelRenderer(this, 0, 9);
        rightCrown.setRotationPoint(0, 16, 0);
        rightCrown.addBox(5f, -6f, -4f, -1.0F, 8.0F, 8.0F, scale);
        rightCrown.addBox(6f, -5f, -3f, -1.0F, 6.0F, 6.0F, scale);
        //Back Crown
        backCrown = new ModelRenderer(this, 0, 9);
        backCrown.setRotationPoint(0, 16, 0);
        backCrown.addBox(-4f, -6f, 4f, 8.0F, 8.0F, 1.0F, scale);
        backCrown.addBox(-3f, -5f, 5f, 6.0F, 6.0F, 1.0F, scale);

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
        return ImmutableList.of(face, topCrown, bottomCrown, leftCrown, rightCrown, backCrown);
    }
}
