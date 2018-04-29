package com.juliosampaio.minecraft.adventuretime;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import com.juliosampaio.minecraft.adventuretime.proxy.CommonProxy;
import com.juliosampaio.minecraft.adventuretime.util.RegistryHandler;

import org.apache.logging.log4j.Logger;

@Mod(modid = AdventureTime.MODID, name = AdventureTime.NAME, version = AdventureTime.VERSION)
public class AdventureTime {
	public static final String MODID = "adventuretime";
	public static final String NAME = "Adventure Time Mod";
	public static final String VERSION = "1.0";
	public static final String CLIENT_PROXY = "com.juliosampaio.minecraft.adventuretime.proxy.ClientProxy";
	public static final String SERVER_PROXY = "com.juliosampaio.minecraft.adventuretime.proxy.ServerProxy";

	private static Logger logger;

	@Instance
	public static AdventureTime instance;

	@SidedProxy(clientSide = CLIENT_PROXY, serverSide = SERVER_PROXY)
	public static CommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		logger = event.getModLog();
		RegistryHandler.preInitRegistries();
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		RegistryHandler.initRegistries();
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		RegistryHandler.postInitRegistries();
	}
}
