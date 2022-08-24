package lotr.common.world.structure2;

import lotr.common.LOTRMod;
import lotr.common.entity.npc.*;
import lotr.common.world.structure.LOTRChestContents;
import net.minecraft.world.World;

public class LOTRWorldGenBlueMountainsSmithy extends LOTRWorldGenDwarfSmithy {
	public LOTRWorldGenBlueMountainsSmithy(boolean flag) {
		super(flag);
		baseBrickBlock = LOTRMod.brick2;
		baseBrickMeta = 2;
		carvedBrickBlock = LOTRMod.brick2;
		carvedBrickMeta = 2;
		pillarBlock = LOTRMod.pillar;
		pillarMeta = 4;
		tableBlock = LOTRMod.blueDwarvenTable;
		barsBlock = LOTRMod.blueDwarfBars;
	}

	@Override
	protected LOTREntityDwarf createSmith(World world) {
		return new LOTREntityBlueMountainsSmith(world);
	}

	@Override
	protected LOTRChestContents getChestContents() {
		return LOTRChestContents.BLUE_MOUNTAINS_SMITHY;
	}
}
