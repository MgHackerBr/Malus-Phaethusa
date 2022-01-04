package net.zestyblaze.malusphaethusa.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

@SuppressWarnings("deprecation")
public class GoldenAppleBlock extends Block {
    private static final VoxelShape SHAPE_CORE = Block.createCuboidShape(7.0D, 0.0D, 7.0D, 10.0D, 5.0D, 10.0D);
    private static final VoxelShape SHAPE_LEFT_SIDE = Block.createCuboidShape(6.0D, 2.0D, 5.0D, 6.0D, 5.0D, 7.0D);

    public GoldenAppleBlock(Settings settings) {
        super(settings);
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return VoxelShapes.union(SHAPE_CORE, SHAPE_LEFT_SIDE);
    }
}
