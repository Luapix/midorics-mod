package luapix.midorics.item;

import luapix.midorics.MidoricsMod;
import net.minecraft.item.Item;

public abstract class ItemBase extends Item {
	public ItemBase(String name) {
		setRegistryName(name);
		setUnlocalizedName(MidoricsMod.MOD_ID + "." + name);
	}
}
