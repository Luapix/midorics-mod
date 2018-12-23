package luapix.midorics.item;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class MidoriteMatrix extends ItemBase {
	public MidoriteMatrix() {
		super("midorite_matrix");
		this.setCreativeTab(CreativeTabs.MATERIALS);
	}
	
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		tooltip.add("Channels mana in order to perform a specific function.");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack stack) {
		return true;
	}
}
