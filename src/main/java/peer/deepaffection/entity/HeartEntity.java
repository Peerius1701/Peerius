package peer.deepaffection.entity;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.item.Item;
import net.minecraft.network.IPacket;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.registries.ObjectHolder;
import peer.deepaffection.DeepAffection;
import peer.deepaffection.client.RegistryHandler;
import peer.deepaffection.lists.BlockList;
import peer.deepaffection.lists.ItemList;

public class HeartEntity extends ProjectileItemEntity {
	
	public final EntityType<HeartEntity> HEART = RegistryHandler.HEART_ENTITY.get();
	
	 	public HeartEntity(double x, double y, double z, World worldIn) {
	        super(RegistryHandler.HEART_ENTITY.get(), x, y, z, worldIn);
	    }

	 	protected HeartEntity(LivingEntity livingEntityIn, World worldIn) {
	        super(RegistryHandler.HEART_ENTITY.get(), livingEntityIn, worldIn);
	    }

	 	public HeartEntity(FMLPlayMessages.SpawnEntity packet, World world) {
	        super(RegistryHandler.HEART_ENTITY.get(), world);
	    }

	    @Override
	    public IPacket<?> createSpawnPacket() {
	        return NetworkHooks.getEntitySpawningPacket(this);
	    }

	    @Override
	    protected void onImpact(RayTraceResult result) {
	        if (result instanceof EntityRayTraceResult) {
	            EntityRayTraceResult entityRayTraceResult = (EntityRayTraceResult) result;
	            if(entityRayTraceResult.getEntity() instanceof AnimalEntity) {
	                MobEntity entity = (MobEntity) entityRayTraceResult.getEntity();
	                entity.addPotionEffect(new EffectInstance(Effects.REGENERATION,100,2));
	                this.remove();
	            } else if(entityRayTraceResult.getEntity() instanceof PlayerEntity) {
	                PlayerEntity entity = (PlayerEntity) entityRayTraceResult.getEntity();
	                entity.addPotionEffect(new EffectInstance(Effects.REGENERATION,100,2));
	                this.remove();
	            }else if(entityRayTraceResult.getEntity() instanceof MonsterEntity) {
	            	MobEntity entity = (MobEntity) entityRayTraceResult.getEntity();
	            	entity.addPotionEffect(new EffectInstance(Effects.SLOWNESS,100,10));
	            	this.remove();
	            }

	        }
	        else if (result instanceof BlockRayTraceResult) {
	            BlockRayTraceResult blockRayTraceResult = (BlockRayTraceResult) result;
	            World world = this.world;
	            Block block = world.getBlockState(blockRayTraceResult.getPos()).getBlock();
	            if(block == Blocks.GRASS_BLOCK) {
	            	world.setBlockState(blockRayTraceResult.getPos(), BlockList.pink_grass_block.getDefaultState());
	            	Vec3d vec = blockRayTraceResult.getHitVec();
		            double x = vec.getX();
		            double y = vec.getY();
		            double z = vec.getZ();
		            this.setMotion(x,y,z);
		            this.remove();
	            }
	            Vec3d vec = blockRayTraceResult.getHitVec();
	            double x = vec.getX();
	            double y = vec.getY();
	            double z = vec.getZ();
	            this.setMotion(x,y,z);
	            this.remove();
	        }
	    }
	    
		public void tick() {
        	System.out.println("hallo, ich werde aufgerufen 1.0");
	        	super.tick();
	        	if(!this.world.isRemote) {
		        Vec3d vec3d = this.getMotion();
		        double d0 = this.getPosX() + vec3d.x;
		        double d1 = this.getPosY() + vec3d.y;
		        double d2 = this.getPosZ() + vec3d.z;
		        this.world.addParticle(ParticleTypes.HEART, d0 - vec3d.x * 0.25D, d1 - vec3d.y * 0.25D, d2 - vec3d.z * 0.25D, vec3d.x, vec3d.y, vec3d.z);
		        System.out.println("x:"+(d0 - vec3d.x * 0.25D)+", y:"+(d1 - vec3d.y * 0.25D)+", z:"+(d2 - vec3d.z * 0.25D));
		        System.out.println("vecx:"+vec3d.x+",  vecy:"+vec3d.y+", vecz:"+vec3d.z);
		        }
		}

		@Override
		protected Item getDefaultItem() {
			return ItemList.heart;
		}
}
