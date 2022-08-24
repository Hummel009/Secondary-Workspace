/*
 * Decompiled with CFR 0.148.
 */
package lotr.common.world.biome;

public class LOTRBiomeGenWoodlandRealmHills extends LOTRBiomeGenWoodlandRealm {
	public LOTRBiomeGenWoodlandRealmHills(int i, boolean major) {
		super(i, major);
		clearBiomeVariants();
		decorator.treesPerChunk = 4;
		decorator.grassPerChunk = 10;
	}
}
