package luapix.midorics.item;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.List;

public class RedstoneStaff extends ItemBase {
	public RedstoneStaff() {
		super("redstone_staff");
		this.setCreativeTab(CreativeTabs.TOOLS);
		this.setMaxStackSize(1);
	}
	
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		tooltip.add("Uses redstone to power a Midorite crystal.");
	}
}
