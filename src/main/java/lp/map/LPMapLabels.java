package lp.map;

import lotr.client.gui.LOTRMapLabels;
import lp.biome.LPBiome;
import lp.util.LPCommander;

public class LPMapLabels {
	public static void preInit() {
		for (LOTRMapLabels lbl : LOTRMapLabels.values()) {
			if (lbl.posX > 2366 || lbl.posY > 1825) {
				LPCommander.removeMapLabel(lbl);
			}
		}
		LPCommander.removeMapLabel(LOTRMapLabels.MINHIRIATH);
		LPCommander.addMapLabel("CARDOLAN", LPBiome.cardolan, 850, 900, 3.0f, -40, -2.5f, 1.5f);
		LPCommander.addMapLabel("RHUDAUR", LPBiome.rhudaur, 1100, 670, 4.0f, 17, -2.5f, 0.5f);
		LPCommander.addMapLabel("ARTHEDAIN", LPBiome.arthedain, 850, 600, 4.0f, 17, -2.5f, 0.5f);
	}
}