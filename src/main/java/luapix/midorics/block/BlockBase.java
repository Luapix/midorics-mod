package luapix.midorics.block;

import luapix.midorics.MidoricsMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public abstract class BlockBase extends Block {
    public BlockBase(String name, Material mat) {
        super(mat);
        setRegistryName(name);
        setUnlocalizedName(MidoricsMod.MOD_ID + "." + name);
    }
	
	public Item createItemBlock() {
		return new ItemBlock(this).setRegistryName(this.getRegistryName());
	}
}
