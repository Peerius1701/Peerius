package peer.deepaffection.world;


import java.util.Map;

import com.google.common.collect.Maps;

import net.minecraft.data.loot.EntityLootTables;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootTable;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.ForgeRegistries;
import peer.deepaffection.lists.ItemList;

public class EntityDrops {

	public static void setupEntityDrops() {
		for(EntityType<?> entity: ForgeRegistries.ENTITIES) {
			if(entity.getClassification() == EntityClassification.MONSTER||entity.getClassification() == EntityClassification.CREATURE || entity.getClassification() == EntityClassification.WATER_CREATURE) {
				Map<ResourceLocation, LootTable.Builder> field_218587_b = Maps.newHashMap();
				ResourceLocation res = entity.getLootTable();
				
			}
		}
	}
	
	@SubscribeEvent
	public void onLootTablesLoaded(LivingDropsEvent event) {
	    if (event.getEntity() instanceof LivingEntity) {
	        final LivingEntity ent = event.getEntityLiving();
	        	if(event.getLootingLevel()!=0) {
	    	        int loot = event.getLootingLevel();
	    	        ItemStack stack = new ItemStack(ItemList.heart, 1*loot);
	    	        ent.entityDropItem(stack, 1.0f);
	    	        }else {
	    	        	ItemStack stack = new ItemStack(ItemList.heart, 1);
	    	        	ent.entityDropItem(stack, 1.0f);
	    	        }
	        	
	    }
	}
}
