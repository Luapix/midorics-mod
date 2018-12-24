package luapix.midorics.gui;

import luapix.midorics.item.RedstoneStaff;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.items.IItemHandler;

public class ModGuis implements IGuiHandler {
	public static final int REDSTONE_STAFF = 1;
	public static final int INSCRIBING_TABLE = 2;
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch(ID) {
			case REDSTONE_STAFF:
				ItemStack stack = player.getHeldItemMainhand();
				IItemHandler handler = RedstoneStaff.getItemHandler(stack);
				return new RedstoneStaffContainer(player.inventory, handler);
			case INSCRIBING_TABLE:
				return new InscribingTableContainer(player.inventory, x, y, z);
			default:
				return null;
		}
	}
	
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch(ID) {
			case REDSTONE_STAFF:
				ItemStack stack = player.getHeldItemMainhand();
				IItemHandler handler = RedstoneStaff.getItemHandler(stack);
				return new RedstoneStaffGui(player.inventory, handler);
			case INSCRIBING_TABLE:
				return new InscribingTableGui(player.inventory, x, y, z);
			default:
				return null;
		}
	}
}
