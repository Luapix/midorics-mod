package luapix.midorics.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.math.BlockPos;

public class InscribingTableContainer extends ContainerBase {
	private BlockPos tablePos;
	
	public InscribingTableContainer(InventoryPlayer playerInventory, int blockX, int blockY, int blockZ) {
		super(playerInventory, 100);
		this.tablePos = new BlockPos(blockX, blockY, blockZ);
		
		// TODO: Add slots
		this.addPlayerSlots();
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return this.canInteractWith(player, this.tablePos.add(0.5d, 0.5d, 0.5d));
	}
}
