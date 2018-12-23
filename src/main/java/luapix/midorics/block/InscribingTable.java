package luapix.midorics.block;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class InscribingTable extends BlockBase {
	public InscribingTable() {
		super("inscribing_table", Material.WOOD);
		setHardness(3F);
		setSoundType(SoundType.WOOD);
		setCreativeTab(CreativeTabs.DECORATIONS);
		setHarvestLevel("axe", 0);
	}
}
