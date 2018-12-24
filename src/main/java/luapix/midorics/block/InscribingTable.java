package luapix.midorics.block;

import luapix.midorics.MidoricsMod;
import luapix.midorics.gui.ModGuis;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class InscribingTable extends BlockBase {
	public InscribingTable() {
		super("inscribing_table", Material.WOOD);
		setHardness(3F);
		setSoundType(SoundType.WOOD);
		setCreativeTab(CreativeTabs.DECORATIONS);
		setHarvestLevel("axe", 0);
	}
	
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		if(!world.isRemote) {
			player.openGui(MidoricsMod.instance, ModGuis.INSCRIBING_TABLE, world, pos.getX(), pos.getY(), pos.getZ());
		}
		return true;
	}
}
