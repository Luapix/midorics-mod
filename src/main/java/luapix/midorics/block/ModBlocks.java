package luapix.midorics.block;

import luapix.midorics.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;

public class ModBlocks {
	@GameRegistry.ObjectHolder("midorics:midorite_ore")
	public static MidoriteOre midoriteOre;
	
	public static void registerBlocks(IForgeRegistry<Block> registry) {
		registry.register(new MidoriteOre());
	}
	
	public static void registerItemBlocks(IForgeRegistry<Item> registry) {
		registry.register(midoriteOre.createItemBlock());
	}
	
	public static void registerModels() {
		ModItems.registerItemRenderer(Item.getItemFromBlock(midoriteOre), 0);
	}
}
