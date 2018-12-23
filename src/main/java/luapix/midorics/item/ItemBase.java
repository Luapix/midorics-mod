package luapix.midorics.item;

import luapix.midorics.MidoricsMod;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract class ItemBase extends Item {
	public ItemBase(String name) {
		setRegistryName(name);
		setUnlocalizedName(MidoricsMod.MOD_ID + "." + name);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerModel() {
		ModItems.registerDefaultModel(this, 0);
	}
}
