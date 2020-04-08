package peer.deepaffection.items;

import net.minecraft.block.BlockState;
import net.minecraft.block.GrassBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;

public class ModGrassBlock extends GrassBlock {

	public ModGrassBlock(Properties properties) {
		super(properties);
	}
	
	public static boolean canEntitySpawn(BlockState state, World worldIn, BlockPos pos, EntityType<Entity> entityType){
		return true;
	}
	
	public boolean canSustainPlant(BlockState state, IBlockReader world, BlockPos pos, Direction facing, IPlantable plantable) {
		if(facing.equals(Direction.UP)) {
		
			return true;
		}
		return false;
	}

}
