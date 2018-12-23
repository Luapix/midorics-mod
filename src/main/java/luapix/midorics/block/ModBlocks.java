package luapix.midorics.block;

import luapix.midorics.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;

public class ModBlocks {
	@GameRegistry.ObjectHolder("midorics:midorite_ore")
	public static MidoriteOre midoriteOre;
	@GameRegistry.ObjectHolder("midorics:inscribing_table")
	public static InscribingTable inscribingTable;
	
	public static void registerBlocks(IForgeRegistry<Block> registry) {
		registry.register(new MidoriteOre());
		registry.register(new InscribingTable());
	}
	
	public static void registerItemBlocks(IForgeRegistry<Item> registry) {
		registry.register(midoriteOre.createItemBlock());
		registry.register(inscribingTable.createItemBlock());
	}
	
	public static void registerModels() {
		ModItems.registerDefaultModel(Item.getItemFromBlock(midoriteOre), 0);
		ModItems.registerDefaultModel(Item.getItemFromBlock(inscribingTable), 0);
	}
}
