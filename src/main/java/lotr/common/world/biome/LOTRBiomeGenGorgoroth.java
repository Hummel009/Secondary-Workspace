/*
 * Decompiled with CFR 0.148.
 */
package lotr.common.world.biome;

public class LOTRBiomeGenGorgoroth extends LOTRBiomeGenMordor {
	public LOTRBiomeGenGorgoroth(int i, boolean major) {
		super(i, major);
		enableMordorBoulders = false;
		decorator.grassPerChunk = 0;
		biomeColors.setSky(5843484);
	}

	@Override
	public boolean isGorgoroth() {
		return true;
	}
}
