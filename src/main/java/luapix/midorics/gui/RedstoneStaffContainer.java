package luapix.midorics.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

import javax.annotation.Nonnull;

public class RedstoneStaffContainer extends Container {
	protected InventoryPlayer playerInventory;
	protected IItemHandler staffHandler;
	
	public RedstoneStaffContainer(InventoryPlayer playerInventory, IItemHandler staffHandler) {
		this.playerInventory = playerInventory;
		this.staffHandler = staffHandler;
		
		addSlotToContainer(new SlotItemHandler(staffHandler, 0, 80, 20));
		addPlayerSlots(playerInventory);
	}
	
	private void addPlayerSlots(InventoryPlayer playerInventory) {
		// Main inventory
		for(int row = 0; row < 3; row++) {
			for(int col = 0; col < 9; col++) {
				int x = 8 + col * 18;
				int y = 51 + row * 18;
				addSlotToContainer(new Slot(playerInventory, 9 + row * 9 + col, x, y));
			}
		}
		
		// Hotbar
		for(int col = 0; col < 9; col++) {
			int x = 8 + col * 18;
			int y = 109;
			addSlotToContainer(new Slot(playerInventory, col, x, y));
		}
	}
	
	@Override
	public @Nonnull
	ItemStack transferStackInSlot(EntityPlayer player, int index) {
		ItemStack itemStack = ItemStack.EMPTY;
		Slot slot = this.inventorySlots.get(index);
		
		if(slot != null && slot.getHasStack()) {
			ItemStack itemStack1 = slot.getStack();
			itemStack = itemStack1.copy();
			
			if(index == 0) {
				if(!this.mergeItemStack(itemStack1, 1, this.inventorySlots.size(), true)) {
					return ItemStack.EMPTY;
				}
			} else if(!this.mergeItemStack(itemStack1, 0, 1, false)) {
				return ItemStack.EMPTY;
			}
			
			if(itemStack1.isEmpty()) {
				slot.putStack(ItemStack.EMPTY);
			} else {
				slot.onSlotChanged();
			}
		}
		
		return itemStack;
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		return true;
	}
}
