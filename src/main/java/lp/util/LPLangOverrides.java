package lp.util;

import java.io.InputStream;
import java.util.*;

import org.apache.commons.io.IOUtils;

import com.google.common.collect.Lists;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.*;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.LanguageManager;
import net.minecraft.client.resources.Locale;
import net.minecraft.util.*;

public class LPLangOverrides {
	public static final LPLangOverrides INSTANCE = new LPLangOverrides();
	private static final String overridesPath = "lang_overrides/";

	private LPLangOverrides() {
	}

	public void overrideForgeLang() {
		Map<String, InputStream> langs = LPCommander.getInputStreams(new ResourceLocation("lp", overridesPath), "lang");
		for (Map.Entry<String, InputStream> e : langs.entrySet()) {
			String langKey = e.getKey();
			InputStream in = e.getValue();
			LanguageRegistry.instance().injectLanguage(langKey, StringTranslate.parseLangFile(in));
			if ("en_US".equals(langKey) && FMLCommonHandler.instance().getSide() == Side.SERVER) {
				StringTranslate.inject(in);
			}
			IOUtils.closeQuietly(in);
		}
	}

	public void overrideMinecraftLang() {
		String currentLang = Minecraft.getMinecraft().getLanguageManager().getCurrentLanguage().getLanguageCode();
		Locale locale = (Locale) ReflectionHelper.getPrivateValue(LanguageManager.class, null, "currentLocale", "field_135049_a");
		Map currentLangMap = (Map) ReflectionHelper.getPrivateValue(Locale.class, locale, "field_135032_a");
		ArrayList<String> langList = Lists.newArrayList("en_US");
		if (!"en_US".equals(currentLang)) {
			langList.add(currentLang);
		}
		for (String lang : langList) {
			InputStream in = LPCommander.getInputStream(new ResourceLocation("lp", overridesPath + lang + ".lang"));
			if (in == null) {
				continue;
			}
			currentLangMap.putAll(StringTranslate.parseLangFile(in));
			IOUtils.closeQuietly(in);
		}
		LanguageRegistry.instance().mergeLanguageTable(currentLangMap, currentLang);
		StringTranslate.replaceWith(currentLangMap);
	}
}
