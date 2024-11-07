package com.soliid.ab_ignis.item.custom;

import com.soliid.ab_ignis.item.ModItems;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

import java.util.ArrayList;
import java.util.Random;

public class SieveTables
{
    public static ArrayList<ItemStack> getSandDrops()
    {
        ArrayList<Integer> sandThresholds = new ArrayList<>();
        ArrayList<ItemStack> sandResults = new ArrayList<>();

        Random random = new Random();
        sandThresholds.add(8*50);sandThresholds.add(4*50);sandThresholds.add(5*50);sandThresholds.add(2*50);sandThresholds.add(1*50);
        sandThresholds.add(3*50);sandThresholds.add(25);sandThresholds.add(5);sandThresholds.add(1);sandThresholds.add(5);sandThresholds.add(5);
        sandThresholds.add(25);

        ArrayList<ItemStack> sandDrop = new ArrayList<>();

        ItemStack boots = new ItemStack(Items.LEATHER_BOOTS);
        boots.setDamageValue(random.nextInt(50,62));
        ItemStack trident = new ItemStack(Items.TRIDENT);
        trident.setDamageValue(random.nextInt(100,225));
        sandResults.add(new ItemStack(Items.KELP));sandResults.add(new ItemStack(Items.SEAGRASS));sandResults.add(new ItemStack(ModItems.LIMESALT.get()));
        sandResults.add(new ItemStack(Items.BONE));sandResults.add(new ItemStack(Items.ROTTEN_FLESH));sandResults.add(new ItemStack(Items.STICK));
        sandResults.add(new ItemStack(Items.SCUTE));sandResults.add(boots);sandResults.add(trident);sandResults.add(new ItemStack(Items.PRISMARINE_SHARD));
        sandResults.add(new ItemStack(Items.PRISMARINE_CRYSTALS));sandResults.add(new ItemStack(Items.REDSTONE));

        //1 Kelp - 8%
        //2 Sea Grass - 4%
        //3 Limesalt - 5%
        //4 Bone - 2%
        //5 Rotten Flesh - 1%
        //6 Stick - 3%
        //7 Scute - 0.5%
        //8 Damaged Leather Boots - 0.1%
        //9 Damaged Trident - 0.02%
        //10 Prismarine Shard - 0.1%
        //11 Prismarine Crystals - 0.1%
        //12 Redstone - 0.5%

        ArrayList<Integer> chances = new ArrayList<>();

        for (int i = 0; i <= 11; i++) {
            int randomNumber = random.nextInt(5000);
            chances.add(randomNumber);
        }

        for (int x=0; x <= 11; x++)
        {
            if (chances.get(x) <= sandThresholds.get(x))
            {
                sandDrop.add(sandResults.get(x));
            }
        }
        System.out.println(sandDrop);
        return sandDrop;
    }

    public static ArrayList<ItemStack> getGravelDrops()
    {
        ArrayList<Integer> gravelThresholds = new ArrayList<>();
        ArrayList<ItemStack> gravelResults = new ArrayList<>();

        Random random = new Random();
        gravelThresholds.add(15*100);gravelThresholds.add(5*100);gravelThresholds.add(50);gravelThresholds.add(50);
        gravelThresholds.add(2);gravelThresholds.add(2);gravelThresholds.add(75);gravelThresholds.add(50);gravelThresholds.add(10);

        ArrayList<ItemStack> gravelDrop = new ArrayList<>();

        ItemStack shovel = new ItemStack(Items.IRON_SHOVEL);
        shovel.setDamageValue(random.nextInt(150,225));
        gravelResults.add(new ItemStack(Items.FLINT));gravelResults.add(new ItemStack(Items.IRON_NUGGET));gravelResults.add(shovel);
        gravelResults.add(new ItemStack(Items.LAPIS_LAZULI));gravelResults.add(new ItemStack(Items.DIAMOND));gravelResults.add(new ItemStack(Items.EMERALD));
        gravelResults.add(new ItemStack(Items.COAL));gravelResults.add(new ItemStack(Items.RAW_COPPER));gravelResults.add(new ItemStack(ModItems.RAW_TIN.get()));

        //1 Flint - 15%
        //2 Iron Nugget - 5%
        //3 Iron Shovel - 0.5%
        //4 Lapis - 0.5%
        //5 Diamond - 0.01%
        //6 Emerald - 0.01%
        //7 Coal - 0.75%
        //8 Raw Copper - 0.5%
        //9 Raw Tin - 0.1%

        ArrayList<Integer> chances = new ArrayList<>();
        System.out.println(chances);

        for (int i = 0; i <= 8; i++) {
            int randomNumber = random.nextInt(20000);
            chances.add(randomNumber);
        }

        for (int x=0; x <= 8; x++)
        {
            if (chances.get(x) <= gravelThresholds.get(x))
            {
                gravelDrop.add(gravelResults.get(x));
            }
        }
        System.out.println(gravelDrop);
        return gravelDrop;
    }

    public static ArrayList<ItemStack> getDirtDrops()
    {
        ArrayList<Integer> dirtThresholds = new ArrayList<>();
        ArrayList<ItemStack> dirtResults = new ArrayList<>();

        Random random = new Random();
        dirtThresholds.add(10);dirtThresholds.add(5);dirtThresholds.add(5);dirtThresholds.add(2);dirtThresholds.add(5);
        dirtThresholds.add(3);dirtThresholds.add(3);

        ArrayList<ItemStack> dirtDrop = new ArrayList<>();

        dirtResults.add(new ItemStack(Items.WHEAT_SEEDS));dirtResults.add(new ItemStack(Items.PUMPKIN_SEEDS));dirtResults.add(new ItemStack(Items.MELON_SEEDS));
        dirtResults.add(new ItemStack(Items.BEETROOT_SEEDS));dirtResults.add(new ItemStack(ModItems.FIBER.get()));dirtResults.add(new ItemStack(ModItems.BONE_SHARD.get()));
        dirtResults.add(new ItemStack(Items.BONE_MEAL));
        //1 Wheat Seeds - 10%
        //2 Pumpkin Seeds - 5%
        //3 Melon Seeds - 5%
        //4 Beetroot Seeds - 2%
        //4 Fiber - 5%
        //5 Bone Shard - 3%
        //6 Bone Meal - 3%

        ArrayList<Integer> chances = new ArrayList<>();

        for (int i = 0; i <= 5; i++) {
            int randomNumber = random.nextInt(100);
            chances.add(randomNumber);
        }

        for (int x=0; x <= 5; x++)
        {
            if (chances.get(x) <= dirtThresholds.get(x))
            {
                dirtDrop.add(dirtResults.get(x));
            }
        }
        return dirtDrop;
    }

    public static ArrayList<ItemStack> getMudDrops()
    {
        ArrayList<Integer> mudThresholds = new ArrayList<>();
        ArrayList<ItemStack> mudResults = new ArrayList<>();

        Random random = new Random();
        mudThresholds.add(10);mudThresholds.add(3);mudThresholds.add(2);mudThresholds.add(6);mudThresholds.add(1);mudThresholds.add(1);
        mudThresholds.add(1);
        ArrayList<ItemStack> dirtDrop = new ArrayList<>();

        mudResults.add(new ItemStack(Items.CLAY_BALL)); mudResults.add(new ItemStack(Items.CHARCOAL)); mudResults.add(new ItemStack(Items.STRING));
        mudResults.add(new ItemStack(Items.BONE_MEAL)); mudResults.add(new ItemStack(Items.VINE)); mudResults.add(new ItemStack(Items.SLIME_BALL));
        mudResults.add(new ItemStack(Items.SPIDER_EYE));
        //1 Clay - 10%
        //2 Charcoal - 3%
        //3 String - 2%
        //4 Bone Meal - 6%
        //5 Vines - 1%
        //6 Slimeball - 1%
        //7 Spider Eye - 1%

        ArrayList<Integer> chances = new ArrayList<>();

        for (int i = 0; i <= 6; i++) {
            int randomNumber = random.nextInt(100);
            chances.add(randomNumber);
        }

        for (int x=0; x <= 6; x++)
        {
            if (chances.get(x) <= mudThresholds.get(x))
            {
                dirtDrop.add(mudResults.get(x));
            }
        }
        return dirtDrop;
    }

    public static ArrayList<ItemStack> getRedSandDrops()
    {
        ArrayList<Integer> redSandThresholds = new ArrayList<>();
        ArrayList<ItemStack> redSandResults = new ArrayList<>();

        Random random = new Random();
        redSandThresholds.add(10);redSandThresholds.add(2);redSandThresholds.add(3);redSandThresholds.add(4);redSandThresholds.add(5);
        redSandThresholds.add(4);redSandThresholds.add(2);redSandThresholds.add(2);redSandThresholds.add(1);

        ArrayList<ItemStack> redSandDrop = new ArrayList<>();

        redSandResults.add(new ItemStack(Items.GOLD_NUGGET));redSandResults.add(new ItemStack(Items.RAW_GOLD));redSandResults.add(new ItemStack(Items.REDSTONE));
        redSandResults.add(new ItemStack(Items.DEAD_BUSH));redSandResults.add(new ItemStack(Items.STICK));redSandResults.add(new ItemStack(Items.FLINT));
        redSandResults.add(new ItemStack(Items.RABBIT_HIDE));redSandResults.add(new ItemStack(ModItems.BONE_SHARD.get()));

        //1 Gold Nugget - 10%
        //2 Raw Gold - 2%
        //3 Redstone - 5%
        //4 Dead Bush - 5%
        //5 Stick - 4%
        //6 Flint - 2%
        //7 Rabbit Hide - 2%
        //8 Bone Shard - 3%

        ArrayList<Integer> chances = new ArrayList<>();

        for (int i = 0; i <= 7; i++) {
            int randomNumber = random.nextInt(100);
            chances.add(randomNumber);
        }

        for (int x=0; x <= 7; x++)
        {
            if (chances.get(x) <= redSandThresholds.get(x))
            {
                redSandDrop.add(redSandResults.get(x));
            }
        }
        return redSandDrop;
    }

    public static ArrayList<ItemStack> getSoulDrops()
    {
        ArrayList<Integer> soulThresholds = new ArrayList<>();
        ArrayList<ItemStack> soulResults = new ArrayList<>();

        Random random = new Random();
        soulThresholds.add(1);soulThresholds.add(5);soulThresholds.add(5);soulThresholds.add(8);soulThresholds.add(3);
        soulThresholds.add(5);soulThresholds.add(1);

        ArrayList<ItemStack> soulDrop = new ArrayList<>();

        soulResults.add(new ItemStack(Items.GHAST_TEAR));soulResults.add(new ItemStack(Items.GOLD_NUGGET));soulResults.add(new ItemStack(ModItems.BONE_SHARD.get()));
        soulResults.add(new ItemStack(Items.QUARTZ));soulResults.add(new ItemStack(Items.COAL));soulResults.add(new ItemStack(Items.NETHER_WART));
        soulResults.add(new ItemStack(Items.CHARCOAL));

        //1 Ghast Tear - 1%
        //2 Gold Nugget - 5%
        //3 Bone Shard - 5%
        //4 Nether Quartz - 8%
        //5 Coal - 3%
        //6 Nether Wart - 5%
        //7 Charcoal - 1%


        ArrayList<Integer> chances = new ArrayList<>();

        for (int i = 0; i <= 6; i++) {
            int randomNumber = random.nextInt(100);
            chances.add(randomNumber);
        }

        for (int x=0; x <= 6; x++)
        {
            if (chances.get(x) <= soulThresholds.get(x))
            {
                soulDrop.add(soulResults.get(x));
            }
        }
        return soulDrop;
    }
}
