package luapix.midorics.gui;

import luapix.midorics.MidoricsMod;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.ResourceLocation;

public class GuiBase extends GuiContainer {
	private ContainerBase container;
	private ResourceLocation background;
	private String title;
	
	public GuiBase(ContainerBase container, String background, String title) {
		super(container);
		this.container = container;
		this.background = new ResourceLocation(MidoricsMod.MOD_ID, background);
		this.ySize = container.playerInventoryTop + 4 * 18 + 10;
		this.title = title;
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
		mc.getTextureManager().bindTexture(this.background);
		drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		this.fontRenderer.drawString(I18n.format(this.title), 8, 6, 0x404040);
		this.fontRenderer.drawString(this.container.playerInventory.getDisplayName().getUnformattedText(),
				8, this.container.playerInventoryTop - 12, 0x404040);
	}
}
