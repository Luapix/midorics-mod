package luapix.midorics.gui;

import luapix.midorics.MidoricsMod;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.items.IItemHandler;

public class RedstoneStaffGui extends GuiContainer {
	private static final ResourceLocation background = new ResourceLocation(MidoricsMod.MOD_ID,
			"textures/gui/container/redstone_staff.png");
	
	private RedstoneStaffContainer container;
	
	public RedstoneStaffGui(InventoryPlayer playerInventory, IItemHandler staffHandler) {
		super(new RedstoneStaffContainer(playerInventory, staffHandler));
		this.container = (RedstoneStaffContainer) this.inventorySlots;
		this.ySize = 133;
	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		this.drawDefaultBackground();
		super.drawScreen(mouseX, mouseY, partialTicks);
		this.renderHoveredToolTip(mouseX, mouseY);
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		mc.getTextureManager().bindTexture(background);
		drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		this.fontRenderer.drawString(I18n.format("container.midorics.redstone_staff"), 8, 6, 0x404040);
		this.fontRenderer.drawString(this.container.playerInventory.getDisplayName().getUnformattedText(),
				8, this.ySize - 96 + 2, 0x404040);
	}
}
