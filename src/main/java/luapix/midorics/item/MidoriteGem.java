package luapix.midorics.item;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.List;

public class MidoriteGem extends ItemBase {
	public MidoriteGem() {
		super("midorite_gem");
		this.setCreativeTab(CreativeTabs.MATERIALS);
	}
	
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		tooltip.add("A shiny and electrifying jewel.");
	}
}
