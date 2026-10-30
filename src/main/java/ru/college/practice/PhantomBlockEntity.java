package ru.college.practice;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

public class PhantomBlockEntity extends BlockEntity {
    private BlockState copiedState = null;

    public PhantomBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.PHANTOM_BLOCK_ENTITY, pos, state);
    }

    public void setCopiedState(BlockState state) {
        this.copiedState = state;
        markDirty();
    }

    public BlockState getCopiedState() {
        return copiedState;
    }

    @Override
    public void readNbt(NbtCompound nbt, net.minecraft.registry.RegistryWrapper.WrapperLookup registryLookup) {
        super.readNbt(nbt, registryLookup);
        if (nbt.contains("CopiedBlock")) {
            String blockId = nbt.getString("CopiedBlock");
            this.copiedState = net.minecraft.registry.Registries.BLOCK.get(net.minecraft.util.Identifier.of(blockId)).getDefaultState();
        }
    }

    @Override
    protected void writeNbt(NbtCompound nbt, net.minecraft.registry.RegistryWrapper.WrapperLookup registryLookup) {
        super.writeNbt(nbt, registryLookup);
        if (copiedState != null) {
            nbt.putString("CopiedBlock", net.minecraft.registry.Registries.BLOCK.getId(copiedState.getBlock()).toString());
        }
    }
}