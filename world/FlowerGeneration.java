package peer.deepaffection.world;



import net.minecraft.block.BlockState;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.feature.BlockClusterFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;
import peer.deepaffection.lists.BlockList;

public class FlowerGeneration {

	public static void setupFlowerGeneration() {
		for(Biome biome: ForgeRegistries.BIOMES) {
			if(biome==Biomes.SAVANNA||biome==Biomes.SAVANNA_PLATEAU||biome==Biomes.SUNFLOWER_PLAINS||biome==Biomes.FLOWER_FOREST||biome==Biomes.MOUNTAIN_EDGE||biome==Biomes.MOUNTAINS||biome==Biomes.WOODED_HILLS||biome==Biomes.WOODED_MOUNTAINS||biome==Biomes.PLAINS||biome==Biomes.FOREST||biome==Biomes.BIRCH_FOREST||biome==Biomes.BIRCH_FOREST_HILLS||biome==Biomes.DARK_FOREST||biome==Biomes.DARK_FOREST_HILLS) {
			BlockState state = BlockList.heart_flower.getDefaultState();
			BlockClusterFeatureConfig DEFAULT_FLOWER_CONFIG = (new BlockClusterFeatureConfig.Builder((new WeightedBlockStateProvider()).func_227407_a_(state, 2), new SimpleBlockPlacer())).tries(64).build(); 
			biome.addFeature(Decoration.VEGETAL_DECORATION, Feature.FLOWER.withConfiguration(DEFAULT_FLOWER_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(2))));
			}
		}
	}
}
