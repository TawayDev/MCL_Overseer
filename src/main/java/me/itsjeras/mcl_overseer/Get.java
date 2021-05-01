package me.itsjeras.mcl_overseer;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Get {
    public static int RandomNumInRange (int min, int max) {
        // Generates a random number in a specified range.
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static String CurrentTime () {
        //return System.currentTimeMillis();
        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public static String CurrentDate () {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public static EntityType[] getBannedEntityList() {
        return new EntityType[] {
                EntityType.ENDER_CRYSTAL,
                EntityType.PRIMED_TNT,
                EntityType.WITHER,
        };
    }
    public static Material[] getBannedBlockList() {
        return new Material[] {
                Material.TNT,
        };
    }

    public static Material[] getBannedEntitySpawnItem() {
        return new Material[] {
                Material.SOUL_SAND,
                Material.END_CRYSTAL,
                Material.WITHER_SKELETON_SKULL,
                Material.TNT_MINECART,
        };
    }

    public static EntityType[] getBannedMinecartList() {
        return new EntityType[] {
                EntityType.MINECART_TNT
        };
    }

    public static boolean isInPvE(Location location) {
        if (Objects.requireNonNull(location.getWorld()).getName().equals("world")) {
            if ((-ConfigManager.OverworldPVE_X < location.getBlockX() && location.getBlockX() < ConfigManager.OverworldPVE_X) && (-ConfigManager.OverworldPVE_Z < location.getBlockZ() && location.getBlockZ() < ConfigManager.OverworldPVE_Z)) {
                return true;
            }
        } else if (location.getWorld().getName().equals("world_nether")) {
            if ((-ConfigManager.NetherPVE_X < location.getBlockX() && location.getBlockX() < ConfigManager.NetherPVE_X) && (-ConfigManager.NetherPVE_Z < location.getBlockZ() && location.getBlockZ() < ConfigManager.NetherPVE_Z)) {
                return true;
            }
        }
        return false;
    }

    public static List<Entity> getNearbyEntityList(Entity entity) {
        List<Entity> entities = null;
        for (int i = 0; i < 256; i++) {
            entities = entity.getNearbyEntities(i, 16, i);
        }
        System.out.println(entities);
        return entities;
    }

    public static List<Player> getNearbyPlayerList(Entity entity) {
        List<Player> players = new ArrayList<>();
        for (Player p : Bukkit.getOnlinePlayers()) {
            Double distance;
            Location playerLoc = p.getLocation();
            Location entityLoc = entity.getLocation();
            distance = playerLoc.distance(entityLoc);
            if (distance < 32) {
                players.add(p);
            }
        }
        return players;
    }
//    public static EntityType[] getBannedEntityList_Global() {
//        return new EntityType[] {
//
//        };
//    }
//    public static Material[] getBannedBlockList_Global() {
//        return new Material[] {
//
//        };
//    }
//    public static Material[] getBannedInteractionList_Global() {
//        return new Material[] {
//                Material.END_PORTAL_FRAME,
//        };
//    }
}