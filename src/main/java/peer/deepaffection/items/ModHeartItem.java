package peer.deepaffection.items;






import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import peer.deepaffection.entity.HeartEntity;

public class ModHeartItem extends Item {

	public ModHeartItem(Properties properties) {
		super(properties);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		ItemStack stack = playerIn.getHeldItem(handIn);
        Vec3d look = playerIn.getLookVec();
        HeartEntity heart = new HeartEntity(1.0D,1.0D,1.0D,worldIn);
        heart.setPosition(playerIn.lastTickPosX + look.x , playerIn.lastTickPosY + look.y + 1, playerIn.lastTickPosZ + look.z);
        Vec3d vec3d = heart.getMotion();
        double d0 = heart.getPosX() + vec3d.x;
        double d1 = heart.getPosY() + vec3d.y;
        double d2 = heart.getPosZ() + vec3d.z;
        worldIn.addParticle(ParticleTypes.HEART, d0 - vec3d.x * 0.25D, d1 - vec3d.y * 0.25D, d2 - vec3d.z * 0.25D, vec3d.x, vec3d.y, vec3d.z);
        heart.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F,1.5F,0.0F);
        if (!worldIn.isRemote) {
            worldIn.addEntity(heart);
            if(!playerIn.isCreative()) {
            stack.shrink(1);
            }
        }
        worldIn.playSound(null,playerIn.getPosition(), SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.PLAYERS,1.0f,1.0f);
        return new ActionResult<ItemStack>(ActionResultType.SUCCESS, stack);
    }
	

}
