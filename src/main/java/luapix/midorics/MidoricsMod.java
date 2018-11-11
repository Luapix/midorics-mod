package luapix.midorics;

import luapix.midorics.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = MidoricsMod.MOD_ID, name = MidoricsMod.MOD_NAME, version = MidoricsMod.MOD_VERSION, useMetadata = true)
public class MidoricsMod {
    public static final String MOD_ID = "midorics";
    public static final String MOD_NAME = "Midorics";
    public static final String MOD_VERSION = "0.1-dev";

    @Mod.Instance
    public static MidoricsMod instance;

    @SidedProxy(serverSide = "luapix.midorics.proxy.ServerProxy", clientSide = "luapix.midorics.proxy.ClientProxy")
    public static CommonProxy proxy;

	public static Logger logger;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent e) {
        logger = e.getModLog();
        logger.info(MOD_NAME + " is loading!");
        proxy.preInit(e);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e) {
        proxy.init(e);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        proxy.postInit(e);
    }
}
