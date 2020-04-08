package peer.deepaffection.client.renders;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.SpriteRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.LivingEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import peer.deepaffection.DeepAffection;
import peer.deepaffection.client.RegistryHandler;
import peer.deepaffection.entity.HeartEntity;

@OnlyIn(Dist.CLIENT)
public class DeepAffectionRenderRegistry {
	
	public static void registryEntityRenders() {
		final Logger logger = LogManager.getLogger(DeepAffection.modid);
		
		RenderingRegistry.registerEntityRenderingHandler(RegistryHandler.HEART_ENTITY.get(), renderManager -> new SpriteRenderer<HeartEntity>(renderManager, Minecraft.getInstance().getItemRenderer()));
//		RenderingRegistry.registerEntityRenderingHandler(LivingEntity.class, renderManager -> new WhiteWingLayerRenderer());
		logger.info("Entity render registerd.");
	}
}
