package lp.biome;

import lotr.common.world.biome.LOTRBiome;

public class LPBiome {
	public static LOTRBiome cardolan;
	public static LOTRBiome rhudaur;
	public static LOTRBiome arthedain;

	public static void preInit() {
		cardolan = new LPBiomeCardolan(171, true).setTemperatureRainfall(0.4f, 0.7f).setMinMaxHeight(0.1f, 0.1f).setColor(0x87B25E).setBiomeName("cardolan");
		rhudaur = new LPBiomeRhudaur(172, true).setTemperatureRainfall(0.4f, 0.7f).setMinMaxHeight(0.3f, 0.5f).setColor(0x8EB259).setBiomeName("rhudaur");
		arthedain = new LPBiomeArthedain(173, true).setTemperatureRainfall(0.4f, 0.7f).setMinMaxHeight(0.1f, 0.15f).setColor(0x78B252).setBiomeName("arthedain");
	}
}