package luapix.midorics.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;

import javax.annotation.Nonnull;

public abstract class ContainerBase extends Container {
	protected InventoryPlayer playerInventory;
	protected int playerInventoryTop;
	private int ownSlots;
	
	public ContainerBase(InventoryPlayer playerInventory, int playerInventoryTop) {
		this.playerInventory = playerInventory;
		this.playerInventoryTop = playerInventoryTop;
	}
	
	protected void addPlayerSlots() {
		this.ownSlots = this.inventorySlots.size();
		
		// Main inventory
		for(int row = 0; row < 3; row++) {
			for(int col = 0; col < 9; col++) {
				int x = 8 + col * 18;
				int y = playerInventoryTop + row * 18;
				addSlotToContainer(new Slot(playerInventory, 9 + row * 9 + col, x, y));
			}
		}
		
		// Hotbar
		for(int col = 0; col < 9; col++) {
			int x = 8 + col * 18;
			int y = playerInventoryTop + 3 * 18 + 4;
			addSlotToContainer(new Slot(playerInventory, col, x, y));
		}
	}
	
	@Override
	@Nonnull
	public ItemStack transferStackInSlot(EntityPlayer player, int index) {
		ItemStack itemStack = ItemStack.EMPTY;
		Slot slot = this.inventorySlots.get(index);
		
		if(slot != null && slot.getHasStack()) {
			ItemStack itemStack1 = slot.getStack();
			itemStack = itemStack1.copy();
			
			if(index < this.ownSlots) {
				if(!this.mergeItemStack(itemStack1, this.ownSlots, this.inventorySlots.size(), true)) {
					return ItemStack.EMPTY;
				}
			} else if(!this.mergeItemStack(itemStack1, 0, this.ownSlots, false)) {
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
	
	protected boolean canInteractWith(EntityPlayer player, BlockPos pos) {
		return player.getDistanceSq(pos) <= 64d;
	}
}
