package peer.deepaffection;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import peer.deepaffection.lists.ItemList;

public class DeepAffectionItemGroup extends ItemGroup {

	public DeepAffectionItemGroup() {
		super("deepaffection");
	}
	
	@Override
	public ItemStack createIcon() {
		return new ItemStack(ItemList.love_letter);
	}
	
}
