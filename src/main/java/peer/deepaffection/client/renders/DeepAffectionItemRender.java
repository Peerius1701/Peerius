package peer.deepaffection.client.renders;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import peer.deepaffection.lists.BlockList;

public class DeepAffectionItemRender {

	public static void render() {
	RenderTypeLookup.setRenderLayer(BlockList.heart_flower, RenderType.getCutout());
	RenderTypeLookup.setRenderLayer(BlockList.black_lantern, RenderType.getCutout());
	RenderTypeLookup.setRenderLayer(BlockList.blue_lantern, RenderType.getCutout());
	RenderTypeLookup.setRenderLayer(BlockList.brown_lantern, RenderType.getCutout());
	RenderTypeLookup.setRenderLayer(BlockList.white_lantern, RenderType.getCutout());
	RenderTypeLookup.setRenderLayer(BlockList.light_blue_lantern, RenderType.getCutout());
	RenderTypeLookup.setRenderLayer(BlockList.gray_lantern, RenderType.getCutout());
	RenderTypeLookup.setRenderLayer(BlockList.light_gray_lantern, RenderType.getCutout());
	RenderTypeLookup.setRenderLayer(BlockList.green_lantern, RenderType.getCutout());
	RenderTypeLookup.setRenderLayer(BlockList.lime_lantern, RenderType.getCutout());
	RenderTypeLookup.setRenderLayer(BlockList.red_lantern, RenderType.getCutout());
	RenderTypeLookup.setRenderLayer(BlockList.orange_lantern, RenderType.getCutout());
	RenderTypeLookup.setRenderLayer(BlockList.yellow_lantern, RenderType.getCutout());
	RenderTypeLookup.setRenderLayer(BlockList.cyan_lantern, RenderType.getCutout());
	RenderTypeLookup.setRenderLayer(BlockList.pink_lantern, RenderType.getCutout());
	RenderTypeLookup.setRenderLayer(BlockList.purple_lantern, RenderType.getCutout());
	RenderTypeLookup.setRenderLayer(BlockList.magenta_lantern, RenderType.getCutout());
	RenderTypeLookup.setRenderLayer(BlockList.fake_flower_pot, RenderType.getCutout());
	RenderTypeLookup.setRenderLayer(BlockList.pink_grass_block, RenderType.getCutout());
	}
}
