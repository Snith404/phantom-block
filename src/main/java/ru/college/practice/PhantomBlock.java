package ru.college.practice;

import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PhantomBlock implements ModInitializer {
	public static final String MOD_ID = "phantom-block";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Hello Fabric world!");
		ModBlocks.initialize();
		ModBlockEntities.initialize();

		net.fabricmc.fabric.api.event.player.UseBlockCallback.EVENT.register((player, world, hand, hitResult) -> {
			if (!world.isClient) {
				net.minecraft.block.BlockState state = world.getBlockState(hitResult.getBlockPos());
				if (state.isOf(ModBlocks.PHANTOM_BLOCK)) {
					player.sendMessage(net.minecraft.text.Text.literal("Блок-призрак активирован!"), false);
					return net.minecraft.util.ActionResult.SUCCESS;
				}
			}
			return net.minecraft.util.ActionResult.PASS;
		});
	}

	public static Identifier id(String path) {
		return Identifier.of(MOD_ID, path);
	}
}