package luapix.midorics.proxy;

import luapix.midorics.block.ModBlocks;
import luapix.midorics.item.ModItems;
import luapix.midorics.world.ModWorldGen;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod.EventBusSubscriber
public class CommonProxy {
	public void preInit(FMLPreInitializationEvent e) {
		GameRegistry.registerWorldGenerator(new ModWorldGen(), 3);
	}
	
	public void init(FMLInitializationEvent e) {
	
	}
	
	public void postInit(FMLPostInitializationEvent e) {
	
	}
	
	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event) {
		ModBlocks.registerBlocks(event.getRegistry());
	}
	
	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		ModItems.registerItems(event.getRegistry());
		ModBlocks.registerItemBlocks(event.getRegistry());
	}
}
