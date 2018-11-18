package luapix.midorics.world;

import luapix.midorics.block.ModBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

public class ModWorldGen implements IWorldGenerator {
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
		int x0 = chunkX*16;
		int z0 = chunkZ*16;
		if(world.provider.getDimension() == 0) {
			generateOre(ModBlocks.midoriteOre.getDefaultState(), world, random, x0, z0, 0, 20, 8, 8);
		}
	}
	
	private void generateOre(IBlockState ore, World world, Random random, int x0, int z0, int minY, int maxY, int size, int count) {
		WorldGenMinable generator = new WorldGenMinable(ore, size);
		for(int i = 0; i < count; i++) {
			BlockPos pos = new BlockPos(x0 + random.nextInt(16), minY + random.nextInt(maxY - minY), z0 + random.nextInt(16));
			generator.generate(world, random, pos);
		}
	}
}
