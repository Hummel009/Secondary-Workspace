/*
 * Decompiled with CFR 0.148.
 */
package lotr.common.world.biome;

public class LOTRBiomeGenFarHaradJungleLake extends LOTRBiomeGenFarHaradJungle {
	public LOTRBiomeGenFarHaradJungleLake(int i, boolean major) {
		super(i, major);
		clearBiomeVariants();
		decorator.sandPerChunk = 0;
	}

	@Override
	public boolean getEnableRiver() {
		return false;
	}
}
