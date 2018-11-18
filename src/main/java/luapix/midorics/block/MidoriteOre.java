package luapix.midorics.block;

import luapix.midorics.item.ModItems;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import javax.annotation.Nonnull;
import java.util.Random;

public class MidoriteOre extends BlockBase {
	public MidoriteOre() {
		super("midorite_ore", Material.ROCK);
		setHardness(3f);
		setCreativeTab(CreativeTabs.MATERIALS);
		setHarvestLevel("pickaxe", 2);
	}
	
	@Override
	@Nonnull
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return ModItems.midoriteGem;
	}
	
	@Override
	public int quantityDroppedWithBonus(int fortune, @Nonnull Random random) {
		int i = random.nextInt(fortune + 2);
		return (i == 0) ? 1 : i;
	}
}
