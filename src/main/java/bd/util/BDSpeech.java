package bd.util;

import java.util.*;

import lotr.common.util.LOTRLog;
import net.minecraft.util.ResourceLocation;

public class BDSpeech {
	public static Map<String, String[]> getSpeechBanks() {
		return BDStringBanks.loadStringBank(new ResourceLocation("bd", "speech/"), "txt");
	}

	public static void onInit() {
		Map<String, String[]> speechBanks = getSpeechBanks();
		if (speechBanks.size() == 0) {
			LOTRLog.logger.error("Found no speech banks.");
		}
		for (Map.Entry<String, String[]> entry : speechBanks.entrySet()) {
			String speechBankName = entry.getKey();
			String[] lines = entry.getValue();
			ArrayList<String> speeches = new ArrayList<>();
			boolean random = true;
			for (String line : lines) {
				if ("!RANDOM".equals(line)) {
					random = false;
					continue;
				}
				speeches.add(line);
			}
			if (speeches.isEmpty()) {
				LOTRLog.logger.error("DR speech bank " + speechBankName + " is empty!", new Object[0]);
				continue;
			}
			BDCommander.addSpeechBank(speechBankName, random, speeches);
		}
	}
}
