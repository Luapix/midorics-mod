package luapix.midorics.gui;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraftforge.items.IItemHandler;

public class RedstoneStaffGui extends GuiBase {
	private static final String background = "textures/gui/container/redstone_staff.png";
	private static final String title = "container.midorics.redstone_staff";
	
	public RedstoneStaffGui(InventoryPlayer playerInventory, IItemHandler staffHandler) {
		super(new RedstoneStaffContainer(playerInventory, staffHandler), background, title);
	}
}
