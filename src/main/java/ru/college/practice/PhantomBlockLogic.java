package ru.college.practice;

import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class PhantomBlockLogic extends Block implements BlockEntityProvider {

    public PhantomBlockLogic(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return VoxelShapes.empty(); // Проходим сквозь блок
    }

    @Override
    public int getOpacity(BlockState state, BlockView world, BlockPos pos) {
        return 15; // Не пропускаем свет
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new PhantomBlockEntity(pos, state);
    }

    @Override
    public BlockState getAppearance(BlockState state, net.minecraft.world.BlockRenderView renderView, BlockPos pos, net.minecraft.util.math.Direction side, @org.jetbrains.annotations.Nullable BlockState sourceState, @org.jetbrains.annotations.Nullable BlockPos sourcePos) {
        BlockEntity be = renderView.getBlockEntity(pos);
        if (be instanceof PhantomBlockEntity phantomBE && phantomBE.getCopiedState() != null) {
            return phantomBE.getCopiedState();
        }
        return state;
    }
}

