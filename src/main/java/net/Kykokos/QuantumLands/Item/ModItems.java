package net.Kykokos.QuantumLands.Item;

import net.Kykokos.QuantumLands.Item.custom.*;
import net.Kykokos.QuantumLands.QuantumLands;
import net.Kykokos.QuantumLands.fluid.ModFluids;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems
{
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, QuantumLands.MOD_ID);


    public static final RegistryObject<Item> SNIFFERITE = ITEMS.register("snifferite",
            () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON)));

    public static final RegistryObject<Item> SNIFFERITE_DUST = ITEMS.register("snifferite_dust",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE).food(ModFoodProperties.SNIFFERITE_DUST)));

    public static final RegistryObject<Item> BUKER_DETECTOR = ITEMS.register("bunker_detector",
            () -> new BunkerDetectorItem(new Item.Properties().fireResistant().durability(150).rarity(Rarity.UNCOMMON)));

    public static final RegistryObject<Item> BLACKOUT_POWDER = ITEMS.register("blackout_powder",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE).food(ModFoodProperties.BLACKOUT_POWDER)));

    public static final RegistryObject<Item> PEAT_BRICK = ITEMS.register("peat_brick",
            () -> new FuelItem(new Item.Properties(), 1700));

    public static final RegistryObject<Item> BLUE_SUBSTANCE = ITEMS.register("blue_substance",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE)));

    public static final RegistryObject<Item> RAW_QUANTALYTH = ITEMS.register("raw_quantalyth",
            () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON).fireResistant()));

    public static final RegistryObject<Item> QUANTALYTH_CAPSULE = ITEMS.register("quantalyth_capsule",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE).fireResistant()));

    public static final RegistryObject<Item> EMPTY_CAPSULE = ITEMS.register("empty_capsule",
            () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON).fireResistant()));

    public static final RegistryObject<Item> MOLTEN_QUANTALYTH_BUCKET = ITEMS.register("molten_quantalyth_bucket",
            () -> new BucketItem(ModFluids.SOURCE_MOLTEN_QUANTALYTH, new Item.Properties().rarity(Rarity.RARE).craftRemainder(Items.BUCKET).stacksTo(1).fireResistant()));

    public static final RegistryObject<Item> NITRIC_ACID_BUCKET = ITEMS.register("nitric_acid_bucket",
            () -> new BucketItem(ModFluids.SOURCE_NITRIC_ACID, new Item.Properties().rarity(Rarity.UNCOMMON).craftRemainder(Items.BUCKET).stacksTo(1)));

    public static final RegistryObject<Item> NITRATION_BATH_BUCKET = ITEMS.register("nitration_bath_bucket",
            () -> new BucketItem(ModFluids.SOURCE_NITRATION_BATH, new Item.Properties().rarity(Rarity.UNCOMMON).craftRemainder(Items.BUCKET).stacksTo(1)));

    public static final RegistryObject<Item>NITROGLYCERIN_BUCKET = ITEMS.register("nitroglycerin_bucket",
            () -> new BucketItem(ModFluids.SOURCE_NITROGLYCERIN, new Item.Properties().rarity(Rarity.RARE).craftRemainder(Items.BUCKET).stacksTo(1)));

    public static final RegistryObject<Item> QUANTALYTH_INGOT = ITEMS.register("quantalyth_ingot",
            () -> new Item(new Item.Properties().rarity(Rarity.EPIC).fireResistant()));

    public static final RegistryObject<Item> ESSENCE_TIER_1 = ITEMS.register("essence_tier_1",
            () -> new Item(new Item.Properties().rarity(Rarity.COMMON)));

    public static final RegistryObject<Item> ESSENCE_TIER_2 = ITEMS.register("essence_tier_2",
            () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON)));

    public static final RegistryObject<Item> ESSENCE_TIER_3 = ITEMS.register("essence_tier_3",
            () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON)));

    public static final RegistryObject<Item> ESSENCE_TIER_4 = ITEMS.register("essence_tier_4",
            () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON)));

    public static final RegistryObject<Item> ESSENCE_TIER_5 = ITEMS.register("essence_tier_5",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE).fireResistant()));

    public static final RegistryObject<Item> ESSENCE_TIER_6 = ITEMS.register("essence_tier_6",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE).fireResistant()));

    public static final RegistryObject<Item> ESSENCE_TIER_7 = ITEMS.register("essence_tier_7",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE).fireResistant()));

    public static final RegistryObject<Item> ESSENCE_TIER_8 = ITEMS.register("essence_tier_8",
            () -> new Item(new Item.Properties().rarity(Rarity.EPIC).fireResistant()));

    public static final RegistryObject<Item> SUPER_SINGULARITY = ITEMS.register("super_singularity",
            () -> new Item(new Item.Properties().rarity(Rarity.EPIC).fireResistant().stacksTo(4)));

    public static final RegistryObject<Item> RAW_QUANTALYTH_CHUNK = ITEMS.register("raw_quantalyth_chunk",
            () -> new Item(new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> INCOMPLETE_RAW_QUANTALYTH_CHUNK = ITEMS.register("incomplete_raw_quantalyth_chunk",
            () -> new Item(new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> POTASSIUM_NITRATE = ITEMS.register("potassium_nitrate",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> INCOMPLETE_CREATIVE_BLAZE_CAKE = ITEMS.register("incomplete_creative_blaze_cake",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> QUANTALYTH_SWORD = ITEMS.register("quantalyth_sword",
            () -> new WeakingSwordItem(ModToolTiers.QUANTALYTH, 20, 3, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> QUANTALYTH_HOE = ITEMS.register("quantalyth_hoe",
            () -> new HoeItem(ModToolTiers.QUANTALYTH, 1, 1, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> QUANTALYTH_AXE = ITEMS.register("quantalyth_axe",
            () -> new AxeItem(ModToolTiers.QUANTALYTH, 20, 2, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> QUANTALYTH_PICKAXE = ITEMS.register("quantalyth_pickaxe",
            () -> new PickaxeItem(ModToolTiers.QUANTALYTH, 1, 1, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> QUANTALYTH_SHOVEL = ITEMS.register("quantalyth_shovel",
            () -> new ShovelItem(ModToolTiers.QUANTALYTH, 1, 1, new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> QUANTALYTH_PAXEL = ITEMS.register("quantalyth_paxel",
            () -> new PaxelItem(ModToolTiers.QUANTALYTH, 1, 2, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> QUANTALYTH_HAMMER = ITEMS.register("quantalyth_hammer",
            () -> new HammerItem(ModToolTiers.QUANTALYTH, 1, 0.5f, new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> QUANTALYTH_HELMET = ITEMS.register("quantalyth_helmet",
            () -> new ModArmorItem(ModArmorMaterials.QUANTALYTH, ArmorItem.Type.HELMET, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> QUANTALYTH_CHESTPLATE = ITEMS.register("quantalyth_chestplate",
            () -> new ModArmorItem(ModArmorMaterials.QUANTALYTH, ArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> QUANTALYTH_LEGGINGS = ITEMS.register("quantalyth_leggings",
            () -> new ModArmorItem(ModArmorMaterials.QUANTALYTH, ArmorItem.Type.LEGGINGS, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> QUANTALYTH_BOOTS = ITEMS.register("quantalyth_boots",
            () -> new ModArmorItem(ModArmorMaterials.QUANTALYTH, ArmorItem.Type.BOOTS, new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> HEISENBERG_SHIRT = ITEMS.register("heisenberg_shirt",
            () -> new ModArmorItem(ModArmorMaterials.HEISENBERG, ArmorItem.Type.CHESTPLATE, new  Item.Properties()));


        public static void register(IEventBus eventBus)
        {
            ITEMS.register(eventBus);
        }
}
