package ru.college.practice;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {
    public static final BlockEntityType<PhantomBlockEntity> PHANTOM_BLOCK_ENTITY =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of("phantom-block", "phantom_block_entity"),
                    FabricBlockEntityTypeBuilder.create(PhantomBlockEntity::new, ModBlocks.PHANTOM_BLOCK).build());

    public static void initialize() {
        // Регистрация происходит выше
    }
}