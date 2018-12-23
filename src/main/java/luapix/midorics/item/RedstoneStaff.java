package luapix.midorics.item;

import luapix.midorics.MidoricsMod;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.play.server.SPacketEntityVelocity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

public class RedstoneStaff extends ItemBase {
	public RedstoneStaff() {
		super("redstone_staff");
		this.setCreativeTab(CreativeTabs.TOOLS);
		this.setMaxStackSize(1);
		this.addPropertyOverride(new ResourceLocation("midorics:active"), new IItemPropertyGetter() {
			@SideOnly(Side.CLIENT)
			@Override
			public float apply(@Nonnull ItemStack stack, @Nullable World world, @Nullable EntityLivingBase entity) {
				return RedstoneStaff.isActive(stack) ? 1.0f : 0.0f;
			}
		});
	}
	
	private static boolean isActive(ItemStack stack) {
		NBTTagCompound crystal = stack.getSubCompound("crystal");
		return crystal != null;
	}
	
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		tooltip.add("Uses redstone to power a Midorite crystal.");
	}
	
	@Override
	public @Nonnull String getUnlocalizedName(ItemStack stack) {
		return this.getUnlocalizedName() + (RedstoneStaff.isActive(stack) ? ".active" : ".inactive");
	}
	
	@Override
	public @Nonnull ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, @Nonnull EnumHand hand) {
		ItemStack stack = player.getHeldItem(hand);
		MidoricsMod.logger.info("You right clicked an " + (isActive(stack) ? "" : "in") + "active Redstone Staff." );
		if(!world.isRemote && isActive(stack)) {
			MidoricsMod.logger.info("Trying to add velocity.");
			player.addVelocity(0.0, 1.0, 0.0);
			((EntityPlayerMP) player).connection.sendPacket(new SPacketEntityVelocity(player));
		}
		return new ActionResult<>(EnumActionResult.SUCCESS, stack);
	}
}
