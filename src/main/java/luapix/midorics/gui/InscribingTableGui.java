package luapix.midorics.gui;

import net.minecraft.entity.player.InventoryPlayer;

public class InscribingTableGui extends GuiBase {
	private static final String background = "textures/gui/container/inscribing_table.png";
	private static final String title = "container.midorics.inscribing_table";
	
	public InscribingTableGui(InventoryPlayer playerInventory, int x, int y, int z) {
		super(new InscribingTableContainer(playerInventory, x, y, z), background, title);
	}
}
