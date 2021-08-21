package net.zestyblaze.malusphaethusa.blocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class AppleBlock {

    public static final Block APPLE_BLOCK = new BlockApple(FabricBlockSettings.of(Material.PLANT)
            .noCollision()
            .ticksRandomly()
            .breakInstantly()
    );

    public static class BlockApple extends Block {
        protected static final VoxelShape SHAPE_CORE;
        protected static final VoxelShape SHAPE_LEFT_SIDE;
        public BlockApple(AbstractBlock.Settings settings) {
            super(settings);
        }
        public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
            return VoxelShapes.union(SHAPE_CORE, SHAPE_LEFT_SIDE);
        }
        static {
            SHAPE_CORE = Block.createCuboidShape(7.0D, 0.0D, 7.0D, 10.0D, 5.0D, 10.0D);
            SHAPE_LEFT_SIDE = Block.createCuboidShape(6.0D, 2.0D, 5.0D, 6.0D, 5.0D, 7.0D);
        }
    }

}
