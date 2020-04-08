package peer.deepaffection;

import java.util.function.Supplier;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.block.Block;
import net.minecraft.block.FlowerBlock;
import net.minecraft.block.FlowerPotBlock;
import net.minecraft.block.LanternBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ElytraItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Rarity;
import net.minecraft.potion.Effect;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.storage.loot.LootPool;
import net.minecraft.world.storage.loot.TableLootEntry;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import peer.deepaffection.lists.BlockList;
import peer.deepaffection.lists.ItemList;
import peer.deepaffection.client.RegistryHandler;
import peer.deepaffection.client.renders.DeepAffectionItemRender;
import peer.deepaffection.client.renders.DeepAffectionRenderRegistry;
import peer.deepaffection.entity.HeartEntity;
import peer.deepaffection.items.ModGrassBlock;
import peer.deepaffection.items.ModHeartItem;

@Mod("deepaffection")
public class DeepAffection {

	public static DeepAffection instance;
	public static final String modid = "deepaffection";
	private static final Logger Logger = LogManager.getLogger(modid);
	public static final ItemGroup group = new DeepAffectionItemGroup();
	
	public DeepAffection() {
		instance = this;
		
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);
		
		RegistryHandler.init();
		
		MinecraftForge.EVENT_BUS.register(this);
		
	}

	private void setup(final FMLCommonSetupEvent event) {
//		EntityDrops.setupEntityDrops();
//		FlowerGeneration.setupFlowerGeneration();
		Logger.info("Setup method registred.");
	}
	
	private void clientRegistries(final FMLClientSetupEvent event) {
		DeepAffectionRenderRegistry.registryEntityRenders();
//		DeepAffectionItemRender.render();
		Logger.info("clientRegistries method registred.");
	}
	
//	@SubscribeEvent
//    public static void onLootLoad(LootTableLoadEvent event) {
//        if (event.getName().equals(new ResourceLocation("minecraft", "entities/bat"))||event.getName().equals(new ResourceLocation("minecraft", "entities/bee"))||event.getName().equals(new ResourceLocation("minecraft", "entities/blaze"))||
//        		event.getName().equals(new ResourceLocation("minecraft", "entities/cat"))||event.getName().equals(new ResourceLocation("minecraft", "entities/cave_spider"))||event.getName().equals(new ResourceLocation("minecraft", "entities/chicken"))||
//        		event.getName().equals(new ResourceLocation("minecraft", "entities/cod"))||event.getName().equals(new ResourceLocation("minecraft", "entities/cow"))||event.getName().equals(new ResourceLocation("minecraft", "entities/creeper"))||
//        		event.getName().equals(new ResourceLocation("minecraft", "entities/dolphin"))||event.getName().equals(new ResourceLocation("minecraft", "entities/drowned"))||event.getName().equals(new ResourceLocation("minecraft", "entities/elder_guardian"))||
//        		event.getName().equals(new ResourceLocation("minecraft", "entities/ender_dragon"))||event.getName().equals(new ResourceLocation("minecraft", "entities/enderman"))||event.getName().equals(new ResourceLocation("minecraft", "entities/endermite"))||
//        		event.getName().equals(new ResourceLocation("minecraft", "entities/evoker"))||event.getName().equals(new ResourceLocation("minecraft", "entities/fox"))||event.getName().equals(new ResourceLocation("minecraft", "entities/ghast"))||
//        		event.getName().equals(new ResourceLocation("minecraft", "entities/giant"))||event.getName().equals(new ResourceLocation("minecraft", "entities/guardian"))||event.getName().equals(new ResourceLocation("minecraft", "entities/horse"))||
//        		event.getName().equals(new ResourceLocation("minecraft", "entities/husk"))||event.getName().equals(new ResourceLocation("minecraft", "entities/illusioner"))||event.getName().equals(new ResourceLocation("minecraft", "entities/iron_golem"))||
//        		event.getName().equals(new ResourceLocation("minecraft", "entities/llama"))||event.getName().equals(new ResourceLocation("minecraft", "entities/magma_cube"))||event.getName().equals(new ResourceLocation("minecraft", "entities/mooshroom"))||
//        		event.getName().equals(new ResourceLocation("minecraft", "entities/mule"))||event.getName().equals(new ResourceLocation("minecraft", "entities/ocelot"))||event.getName().equals(new ResourceLocation("minecraft", "entities/panda"))||
//        		event.getName().equals(new ResourceLocation("minecraft", "entities/parrot"))||event.getName().equals(new ResourceLocation("minecraft", "entities/phantom"))||event.getName().equals(new ResourceLocation("minecraft", "entities/pig"))||
//        		event.getName().equals(new ResourceLocation("minecraft", "entities/pillager"))||event.getName().equals(new ResourceLocation("minecraft", "entities/polar_bear"))||event.getName().equals(new ResourceLocation("minecraft", "entities/pufferfish"))||
//        		event.getName().equals(new ResourceLocation("minecraft", "entities/rabbit"))||event.getName().equals(new ResourceLocation("minecraft", "entities/ravager"))||event.getName().equals(new ResourceLocation("minecraft", "entities/salmon"))||
//        		event.getName().equals(new ResourceLocation("minecraft", "entities/sheep"))||event.getName().equals(new ResourceLocation("minecraft", "entities/shulker"))||event.getName().equals(new ResourceLocation("minecraft", "entities/silverfish"))||
//        		event.getName().equals(new ResourceLocation("minecraft", "entities/skeleton_horse"))||event.getName().equals(new ResourceLocation("minecraft", "entities/skeleton"))||event.getName().equals(new ResourceLocation("minecraft", "entities/slime"))||
//        		event.getName().equals(new ResourceLocation("minecraft", "entities/snow_golem"))||event.getName().equals(new ResourceLocation("minecraft", "entities/spider"))||event.getName().equals(new ResourceLocation("minecraft", "entities/squid"))||
//        		event.getName().equals(new ResourceLocation("minecraft", "entities/stray"))||event.getName().equals(new ResourceLocation("minecraft", "entities/trader_llama"))||event.getName().equals(new ResourceLocation("minecraft", "entities/tropical_fish"))||
//        		event.getName().equals(new ResourceLocation("minecraft", "entities/turtle"))||event.getName().equals(new ResourceLocation("minecraft", "entities/vex"))||event.getName().equals(new ResourceLocation("minecraft", "villager"))||
//        		event.getName().equals(new ResourceLocation("minecraft", "entities/vindicator"))||event.getName().equals(new ResourceLocation("minecraft", "entities/wandering_trader"))||event.getName().equals(new ResourceLocation("minecraft", "entities/witch"))||
//        		event.getName().equals(new ResourceLocation("minecraft", "entities/wither_skeleton"))||event.getName().equals(new ResourceLocation("minecraft", "entities/wither"))||event.getName().equals(new ResourceLocation("minecraft", "entities/wolf"))||
//        		event.getName().equals(new ResourceLocation("minecraft", "entities/zombie_horse"))||event.getName().equals(new ResourceLocation("minecraft", "entities/zombie_pigman"))||event.getName().equals(new ResourceLocation("minecraft", "entities/zombie_villager"))||
//        		event.getName().equals(new ResourceLocation("minecraft", "entities/zombie"))||event.getName().equals(new ResourceLocation("minecraft", "entities/sheep/black"))||event.getName().equals(new ResourceLocation("minecraft", "entities/sheep/blue"))||
//        		event.getName().equals(new ResourceLocation("minecraft", "entities/sheep/brown"))||event.getName().equals(new ResourceLocation("minecraft", "entities/sheep/cyan"))||event.getName().equals(new ResourceLocation("minecraft", "entities/sheep/gray"))||
//        		event.getName().equals(new ResourceLocation("minecraft", "entities/sheep/green"))||event.getName().equals(new ResourceLocation("minecraft", "entities/sheep/light_gray"))||
//        		event.getName().equals(new ResourceLocation("minecraft", "entities/sheep/lime"))||event.getName().equals(new ResourceLocation("minecraft", "entities/sheep/light_blue"))||event.getName().equals(new ResourceLocation("minecraft", "entities/sheep/pink"))||
//        		event.getName().equals(new ResourceLocation("minecraft", "entities/sheep/purple"))||event.getName().equals(new ResourceLocation("minecraft", "entities/sheep/magenta"))||event.getName().equals(new ResourceLocation("minecraft", "entities/sheep/orange"))||
//        		event.getName().equals(new ResourceLocation("minecraft", "entities/sheep/red"))||event.getName().equals(new ResourceLocation("minecraft", "entities/sheep/white"))||event.getName().equals(new ResourceLocation("minecraft", "entities/sheep/yellow"))) {
//            event.getTable().addPool(LootPool.builder().addEntry(TableLootEntry.builder(new ResourceLocation(DeepAffection.modid, "entities/heart_loot_table"))).build());
//        }
//	}
	
	@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
	public static class RegistryEvents{

		@SubscribeEvent
		public static void registerItems(final RegistryEvent.Register<Item> event) {
			event.getRegistry().registerAll
			(
//				ItemList.love_letter = new Item(new Item.Properties().group(group)).setRegistryName(location("love_letter")),
				
				ItemList.heart = new ModHeartItem(new Item.Properties().group(group)).setRegistryName(location("heart")),	
//				ItemList.record_laputa = new ModMusicDiscItem(17, new SoundEvent(location("record_laputa")), (new Item.Properties().maxStackSize(1).group(group).rarity(Rarity.RARE))).setRegistryName("record_laputa"),
//				ItemList.heart_flower = new ModFlowerItem(new Item.Properties().group(group)).setRegistryName(location("heart_flower")),	
//				ItemList.white_wings = new ElytraItem(new Item.Properties().maxStackSize(1).group(group)).setRegistryName(location("white_wings")),
//				ItemList.black_wings = new ElytraItem(new Item.Properties().maxStackSize(1).group(group)).setRegistryName(location("black_wings")),
//				ItemList.white_wing = new Item(new Item.Properties().group(group)).setRegistryName(location("white_wing")),
//				ItemList.black_wing = new Item(new Item.Properties().group(group)).setRegistryName(location("black_wing")),
//				ItemList.white_spring_bundle = new Item(new Item.Properties().group(group)).setRegistryName(location("white_spring_bundle")),
//				ItemList.black_spring_bundle = new Item(new Item.Properties().group(group)).setRegistryName(location("black_spring_bundle")),
						
//				ItemList.black_lantern = new BlockItem(BlockList.black_lantern, new Item.Properties().group(group)).setRegistryName(location("black_lantern")),
//				ItemList.white_lantern = new BlockItem(BlockList.white_lantern, new Item.Properties().group(group)).setRegistryName(location("white_lantern")),
//				ItemList.red_lantern = new BlockItem(BlockList.red_lantern, new Item.Properties().group(group)).setRegistryName(location("red_lantern")),
//				ItemList.magenta_lantern = new BlockItem(BlockList.magenta_lantern, new Item.Properties().group(group)).setRegistryName(location("magenta_lantern")),
//				ItemList.purple_lantern = new BlockItem(BlockList.purple_lantern, new Item.Properties().group(group)).setRegistryName(location("purple_lantern")),
//				ItemList.pink_lantern = new BlockItem(BlockList.pink_lantern, new Item.Properties().group(group)).setRegistryName(location("pink_lantern")),
//				ItemList.green_lantern = new BlockItem(BlockList.green_lantern, new Item.Properties().group(group)).setRegistryName(location("green_lantern")),
//				ItemList.lime_lantern = new BlockItem(BlockList.lime_lantern, new Item.Properties().group(group)).setRegistryName(location("lime_lantern")),
//				ItemList.gray_lantern = new BlockItem(BlockList.gray_lantern, new Item.Properties().group(group)).setRegistryName(location("gray_lantern")),
//				ItemList.light_gray_lantern = new BlockItem(BlockList.light_gray_lantern, new Item.Properties().group(group)).setRegistryName(location("light_gray_lantern")),
//				ItemList.cyan_lantern = new BlockItem(BlockList.cyan_lantern, new Item.Properties().group(group)).setRegistryName(location("cyan_lantern")),
//				ItemList.blue_lantern = new BlockItem(BlockList.blue_lantern, new Item.Properties().group(group)).setRegistryName(location("blue_lantern")),
//				ItemList.orange_lantern = new BlockItem(BlockList.orange_lantern, new Item.Properties().group(group)).setRegistryName(location("orange_lantern")),
//				ItemList.yellow_lantern = new BlockItem(BlockList.yellow_lantern, new Item.Properties().group(group)).setRegistryName(location("yellow_lantern")),
//				ItemList.brown_lantern = new BlockItem(BlockList.brown_lantern, new Item.Properties().group(group)).setRegistryName(location("brown_lantern")),
//				ItemList.light_blue_lantern = new BlockItem(BlockList.light_blue_lantern, new Item.Properties().group(group)).setRegistryName(location("light_blue_lantern")),
				ItemList.pink_grass_block = new BlockItem(BlockList.pink_grass_block, new Item.Properties().group(group)).setRegistryName(location("pink_grass_block"))
				);
			
			Logger.info("Items registred.");
		}
		
//		@SubscribeEvent
//		public void registerSoundEvents(final RegistryEvent.Register<SoundEvent> event)
//		{
//			ModSounds.INSTANCE.init();
//			event.getRegistry().registerAll
//			(
//					ModSounds.INSTANCE.getSounds().toArray(new SoundEvent[0])
//			);
//			
//			Logger.info("SoundEvents registred.");
//		}
		
		@SubscribeEvent
		public static void registerBlocks(final RegistryEvent.Register<Block> event) {
			Supplier<Block> s2 = () ->  BlockList.heart_flower = new FlowerBlock(Effect.get(10) , 0, Block.Properties.create(Material.PLANTS).hardnessAndResistance(0.0f).doesNotBlockMovement().lightValue(10).sound(SoundType.PLANT)).setRegistryName(location("heart_flower")); 
			event.getRegistry().registerAll
			(
//				BlockList.heart_flower = new FlowerBlock(Effect.get(10) , 0, Block.Properties.create(Material.PLANTS).hardnessAndResistance(0.0f).doesNotBlockMovement().lightValue(10).sound(SoundType.PLANT)).setRegistryName(location("heart_flower")),
//				BlockList.black_lantern = new LanternBlock(Block.Properties.create(Material.ANVIL).harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(17.5f).lightValue(15).sound(SoundType.LANTERN)).setRegistryName(location("black_lantern")),
//				BlockList.white_lantern = new LanternBlock(Block.Properties.create(Material.ANVIL).harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(17.5f).lightValue(15).sound(SoundType.LANTERN)).setRegistryName(location("white_lantern")),
//				BlockList.red_lantern = new LanternBlock(Block.Properties.create(Material.ANVIL).harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(17.5f).lightValue(15).sound(SoundType.LANTERN)).setRegistryName(location("red_lantern")),
//				BlockList.magenta_lantern = new LanternBlock(Block.Properties.create(Material.ANVIL).harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(17.5f).lightValue(15).sound(SoundType.LANTERN)).setRegistryName(location("magenta_lantern")),
//				BlockList.purple_lantern = new LanternBlock(Block.Properties.create(Material.ANVIL).harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(17.5f).lightValue(15).sound(SoundType.LANTERN)).setRegistryName(location("purple_lantern")),
//				BlockList.pink_lantern = new LanternBlock(Block.Properties.create(Material.ANVIL).harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(17.5f).lightValue(15).sound(SoundType.LANTERN)).setRegistryName(location("pink_lantern")),
//				BlockList.green_lantern = new LanternBlock(Block.Properties.create(Material.ANVIL).harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(17.5f).lightValue(15).sound(SoundType.LANTERN)).setRegistryName(location("green_lantern")),
//				BlockList.lime_lantern = new LanternBlock(Block.Properties.create(Material.ANVIL).harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(17.5f).lightValue(15).sound(SoundType.LANTERN)).setRegistryName(location("lime_lantern")),
//				BlockList.gray_lantern = new LanternBlock(Block.Properties.create(Material.ANVIL).harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(17.5f).lightValue(15).sound(SoundType.LANTERN)).setRegistryName(location("gray_lantern")),
//				BlockList.light_gray_lantern = new LanternBlock(Block.Properties.create(Material.ANVIL).harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(17.5f).lightValue(15).sound(SoundType.LANTERN)).setRegistryName(location("light_gray_lantern")),
//				BlockList.cyan_lantern = new LanternBlock(Block.Properties.create(Material.ANVIL).harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(17.5f).lightValue(15).sound(SoundType.LANTERN)).setRegistryName(location("cyan_lantern")),
//				BlockList.blue_lantern = new LanternBlock(Block.Properties.create(Material.ANVIL).harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(17.5f).lightValue(15).sound(SoundType.LANTERN)).setRegistryName(location("blue_lantern")),
//				BlockList.orange_lantern = new LanternBlock(Block.Properties.create(Material.ANVIL).harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(17.5f).lightValue(15).sound(SoundType.LANTERN)).setRegistryName(location("orange_lantern")),
//				BlockList.yellow_lantern = new LanternBlock(Block.Properties.create(Material.ANVIL).harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(17.5f).lightValue(15).sound(SoundType.LANTERN)).setRegistryName(location("yellow_lantern")),
//				BlockList.brown_lantern = new LanternBlock(Block.Properties.create(Material.ANVIL).harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(17.5f).lightValue(15).sound(SoundType.LANTERN)).setRegistryName(location("brown_lantern")),		
//				BlockList.light_blue_lantern = new LanternBlock(Block.Properties.create(Material.ANVIL).harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(17.5f).lightValue(15).sound(SoundType.LANTERN)).setRegistryName(location("light_blue_lantern")),
//				BlockList.fake_flower_pot = new FlowerPotBlock(null, s2, Block.Properties.create(Material.MISCELLANEOUS).harvestLevel(0).hardnessAndResistance(0.0f).sound(SoundType.STONE)).setRegistryName(location("fake_flower_pot")),
				BlockList.pink_grass_block = new ModGrassBlock(Block.Properties.create(Material.EARTH).harvestLevel(2).harvestTool(ToolType.SHOVEL).hardnessAndResistance(0.6f, 3f).sound(SoundType.PLANT).tickRandomly()).setRegistryName(location("pink_grass_block"))
				);
			
			Logger.info("Blocks registred.");
		}
		
		public static ResourceLocation location (String name) {
			return new ResourceLocation(modid, name);
		}
	}
}
