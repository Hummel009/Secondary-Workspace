/*
 * Decompiled with CFR 0.148.
 */
package lotr.common.world.biome;

public class LOTRBiomeGenNurnen extends LOTRBiomeGenNurn {
	public LOTRBiomeGenNurnen(int i, boolean major) {
		super(i, major);
		npcSpawnList.clear();
		clearBiomeVariants();
	}

	@Override
	public boolean getEnableRiver() {
		return false;
	}
}
