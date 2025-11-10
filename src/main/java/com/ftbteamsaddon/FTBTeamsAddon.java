package com.ftbteamsaddon;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("ftbteamsaddon")
public class FTBTeamsAddon {
    public static final String MOD_ID = "ftbteamsaddon";
    public static final Logger LOGGER = LogManager.getLogger();

    public FTBTeamsAddon() {
        LOGGER.info("FTB Teams Addon initializing...");
        
        // Register event handlers
        MinecraftForge.EVENT_BUS.register(new ChatEventHandler());
                MinecraftForge.EVENT_BUS.register(new TablistNameHandler());
       
        LOGGER.info("FTB Teams Addon initialized successfully!");
    }
}
