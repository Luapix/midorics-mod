package luapix.midorics.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

import javax.annotation.Nonnull;

public class RedstoneStaffContainer extends ContainerBase {
	public RedstoneStaffContainer(InventoryPlayer playerInventory, IItemHandler staffHandler) {
		super(playerInventory, 51);
		
		addSlotToContainer(new SlotItemHandler(staffHandler, 0, 80, 20));
		addPlayerSlots();
	}
	
	@Override
	public boolean canInteractWith(@Nonnull EntityPlayer player) {
		return true;
	}
}
