package luapix.midorics.item;

import luapix.midorics.MidoricsMod;
import luapix.midorics.gui.ModGuiHandler;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.server.SPacketEntityVelocity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nonnull;
import java.util.List;

public class RedstoneStaff extends ItemBase {
	public RedstoneStaff() {
		super("redstone_staff");
		this.setCreativeTab(CreativeTabs.TOOLS);
		this.setMaxStackSize(1);
	}
	
	private static boolean isActive(ItemStack stack) {
		ItemStack matrix = RedstoneStaff.getItemHandler(stack).getStackInSlot(0);
		return matrix.getItem() == ModItems.midoriteMatrix;
	}
	
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		tooltip.add("Uses redstone to power a Midorite Matrix.");
	}
	
	@Override
	public @Nonnull
	String getUnlocalizedName(ItemStack stack) {
		return this.getUnlocalizedName() + (RedstoneStaff.isActive(stack) ? ".active" : ".inactive");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerModel() {
		ModelResourceLocation inactiveModel = new ModelResourceLocation(getRegistryName(), "inventory");
		ModelResourceLocation activeModel = new ModelResourceLocation(getRegistryName() + "_active", "inventory");
		ModelBakery.registerItemVariants(this, inactiveModel, activeModel);
		ModelLoader.setCustomMeshDefinition(this, stack -> isActive(stack) ? activeModel : inactiveModel);
	}
	
	@Override
	public @Nonnull
	ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, @Nonnull EnumHand hand) {
		ItemStack stack = player.getHeldItem(hand);
		if(!world.isRemote) {
			if(player.isSneaking()) {
				player.openGui(MidoricsMod.instance, ModGuiHandler.REDSTONE_STAFF, world, 0, 0, 0);
			} else if(isActive(stack)) {
				player.addVelocity(0.0, 1.0, 0.0);
				((EntityPlayerMP) player).connection.sendPacket(new SPacketEntityVelocity(player));
			}
		}
		return new ActionResult<>(EnumActionResult.SUCCESS, stack);
	}
	
	public static IItemHandler getItemHandler(ItemStack stack) {
		assert stack.getItem() == ModItems.redstoneStaff;
		ItemStackHandler handler = new ItemStackHandler() {
			@Override
			protected void onContentsChanged(int slot) {
				stack.setTagInfo("matrix", this.serializeNBT());
			}
			
			@Override
			public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
				return stack.getItem() == ModItems.midoriteMatrix;
			}
		};
		handler.deserializeNBT(stack.getOrCreateSubCompound("matrix"));
		return handler;
	}
}
