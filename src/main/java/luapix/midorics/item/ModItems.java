package luapix.midorics.item;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;

public class ModItems {
	@GameRegistry.ObjectHolder("midorics:midorite_gem")
	public static MidoriteGem midoriteGem;
	@GameRegistry.ObjectHolder("midorics:wand")
	public static Wand wand;
	
	
	public static void registerItems(IForgeRegistry<Item> registry) {
		registry.registerAll(new MidoriteGem(), new Wand());
	}
	
	@SideOnly(Side.CLIENT)
	public static void registerModels() {
		registerItemRenderer(midoriteGem, 0);
		registerItemRenderer(wand, 0);
	}
	
	public static void registerItemRenderer(Item item, int meta) {
		ModelLoader.setCustomModelResourceLocation(item, meta,
				new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
}
