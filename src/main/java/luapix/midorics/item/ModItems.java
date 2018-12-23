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
	@GameRegistry.ObjectHolder("midorics:redstone_staff")
	public static RedstoneStaff redstoneStaff;
	@GameRegistry.ObjectHolder("midorics:midorite_matrix")
	public static MidoriteMatrix midoriteMatrix;
	
	
	public static void registerItems(IForgeRegistry<Item> registry) {
		registry.registerAll(new MidoriteGem(), new RedstoneStaff(), new MidoriteMatrix());
	}
	
	@SideOnly(Side.CLIENT)
	public static void registerModels() {
		midoriteGem.registerModel();
		redstoneStaff.registerModel();
		midoriteMatrix.registerModel();
	}
	
	public static void registerDefaultModel(Item item, int meta) {
		ModelLoader.setCustomModelResourceLocation(item, meta,
				new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
}
