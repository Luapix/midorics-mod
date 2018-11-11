package luapix.midorics.block;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class MidoriteOre extends BlockBase {
    public MidoriteOre() {
        super("midorite_ore", Material.ROCK);
        setHardness(3f);
        setResistance(5f);
        setCreativeTab(CreativeTabs.MATERIALS);
    }
}
