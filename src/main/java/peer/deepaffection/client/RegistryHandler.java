package peer.deepaffection.client;


import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import peer.deepaffection.DeepAffection;
import peer.deepaffection.entity.HeartEntity;

public class RegistryHandler {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = new DeferredRegister<>(ForgeRegistries.ENTITIES, DeepAffection.modid);

    public static void init(){
        ENTITY_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    //Entities
    public static final RegistryObject<EntityType<HeartEntity>> HEART_ENTITY = ENTITY_TYPES.register("heart_entity", () -> EntityType.Builder.<HeartEntity>create(EntityClassification.MISC).size(0.5F, 0.5F).build("heart_entity"));

}