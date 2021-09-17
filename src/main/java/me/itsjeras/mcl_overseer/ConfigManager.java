package me.itsjeras.mcl_overseer;

import org.bukkit.plugin.Plugin;

import org.bukkit.configuration.file.FileConfiguration;

import static me.itsjeras.mcl_overseer.MCL_Overseer.LoggerInstance;

public class ConfigManager {

    private static final Plugin plugin = MCL_Overseer.getPlugin(MCL_Overseer.class);
    static FileConfiguration config = plugin.getConfig();
    //Nether:
    public static int NetherPVE_X;
    public static int NetherPVE_Z;
    // Overworld:
    public static int OverworldPVE_X;
    public static int OverworldPVE_Z;
    // End
    public static boolean Allow_End;
    //Honor manager data:
    public static boolean AllowHonor;
    public static int MaxHonor;
    public static int HonorForPlaying;
    public static boolean CheckForAfk;
    //Penalties:
    public static int EndEntryPenalty;
    public static int EntitySpawnPenalty;
    public static int BlockPlacementPenalty;
    //Analytics:
    public static int SaveFileIntervalTicks;

    public static void ReadFromConfig(){
        try {
            NetherPVE_X = config.getInt("PvE.Nether.X");
            NetherPVE_Z = config.getInt("PvE.Nether.Z");

            OverworldPVE_X = config.getInt("PvE.Overworld.X");
            OverworldPVE_Z = config.getInt("PvE.Overworld.Z");

            Allow_End = config.getBoolean("Allow-End");
            //Honor score config stuff:
            AllowHonor = config.getBoolean("Honor-Score.Enable");
            CheckForAfk = config.getBoolean("Honor-Score.Check-For-Afk");
            MaxHonor = config.getInt("Honor-Score.Max-Amount");
            //Rewards:
            HonorForPlaying = config.getInt("Honor-Score.Reward-For-Playing");
            //Penalties:
            EndEntryPenalty = config.getInt("Honor-Score.End-Entry-Penalty");
            EntitySpawnPenalty = config.getInt("Honor-Score.Entity-Spawn-Penalty");
            BlockPlacementPenalty = config.getInt("Honor-Score.Block-Placement-Penalty");
            //Analytics:
            SaveFileIntervalTicks = config.getInt("Analytics.Save-File-Interval-Ticks");
        } catch (Exception e) {
            e.printStackTrace();
        }
        LoggerInstance.info("<[CONFIG]>");
        LoggerInstance.info("(int)     NetherPVE_X = " + NetherPVE_X);
        LoggerInstance.info("(int)     NetherPVE_Z = " + NetherPVE_Z);
        LoggerInstance.info("(int)     OverworldPVE_X = " + OverworldPVE_X);
        LoggerInstance.info("(int)     OverworldPVE_Z = " + OverworldPVE_Z);
        LoggerInstance.info("(boolean) Allow_End = " + Allow_End);
        LoggerInstance.info("(boolean) AllowHonor = " + AllowHonor);
        LoggerInstance.info("(int)     MaxHonor = " + MaxHonor);
        LoggerInstance.info("(int)     HonorForPlaying = " + HonorForPlaying);
        LoggerInstance.info("(boolean) CheckForAfk = " + CheckForAfk);
        LoggerInstance.info("(int)     EndEntryPenalty = " + EndEntryPenalty);
        LoggerInstance.info("(int)     EntitySpawnPenalty = " + EntitySpawnPenalty);
        LoggerInstance.info("(int)     BlockPlacementPenalty = " + BlockPlacementPenalty);
        LoggerInstance.info("(int)     SaveFileIntervalTicks = " + SaveFileIntervalTicks);
    }
}
