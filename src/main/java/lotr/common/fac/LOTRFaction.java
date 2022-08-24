package lotr.common.fac;

import java.awt.Color;
import java.util.*;

import lotr.common.*;
import lotr.common.entity.LOTRNPCSelectForInfluence;
import lotr.common.item.LOTRItemBanner;
import lotr.common.world.LOTRWorldProvider;
import lotr.common.world.map.LOTRWaypoint;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.*;
import net.minecraft.world.World;

public enum LOTRFaction {
	GONDOR(16382457, LOTRDimension.DimensionRegion.WEST, new LOTRMapRegion(-170, 2068, 350), EnumSet.of(FactionType.TYPE_FREE, FactionType.TYPE_MAN)), HIGH_ELF(13035007, LOTRDimension.DimensionRegion.WEST, new LOTRMapRegion(570, 770, 200), EnumSet.of(FactionType.TYPE_FREE, FactionType.TYPE_ELF)), BREE(11373426, LOTRDimension.DimensionRegion.WEST, new LOTRMapRegion(925, 735, 50), EnumSet.of(FactionType.TYPE_FREE, FactionType.TYPE_MAN)), DURINS_FOLK(4940162, LOTRDimension.DimensionRegion.WEST, new LOTRMapRegion(1170, 850, 100), EnumSet.of(FactionType.TYPE_FREE, FactionType.TYPE_DWARF)), LOTHLORIEN(15716696, LOTRDimension.DimensionRegion.EAST, new LOTRMapRegion(1230, 900, 75), EnumSet.of(FactionType.TYPE_FREE, FactionType.TYPE_ELF)),

	WOOD_ELF(3774030, LOTRDimension.DimensionRegion.EAST, new LOTRMapRegion(1380, 870, 100), EnumSet.of(FactionType.TYPE_FREE, FactionType.TYPE_ELF)), DALE(13535071, LOTRDimension.DimensionRegion.EAST, new LOTRMapRegion(1500, 777, 175), EnumSet.of(FactionType.TYPE_FREE, FactionType.TYPE_MAN)), GUNDABAD(9858132, LOTRDimension.DimensionRegion.WEST, new LOTRMapRegion(1160, 670, 150), EnumSet.of(FactionType.TYPE_ORC)), DUNLAND(11048079, LOTRDimension.DimensionRegion.WEST, new LOTRMapRegion(1090, 1030, 125), EnumSet.of(FactionType.TYPE_MAN)), MORDOR(3481375, LOTRDimension.DimensionRegion.EAST, new LOTRMapRegion(1620, 1290, 225), EnumSet.of(FactionType.TYPE_ORC)), RHUDEL(12882471, LOTRDimension.DimensionRegion.EAST, new LOTRMapRegion(1890, 980, 200), EnumSet.of(FactionType.TYPE_MAN)), NEAR_HARAD(11868955, LOTRDimension.DimensionRegion.SOUTH, new LOTRMapRegion(1400, 1730, 375), EnumSet.of(FactionType.TYPE_MAN)), FANGORN(4831058, LOTRDimension.DimensionRegion.EAST, new LOTRMapRegion(1200, 1000, 75), EnumSet.of(FactionType.TYPE_FREE, FactionType.TYPE_TREE)), MORWAITH(14266458, LOTRDimension.DimensionRegion.SOUTH, new LOTRMapRegion(1400, 2360, 450), EnumSet.of(FactionType.TYPE_MAN)), EREGION(15716696, LOTRDimension.DimensionRegion.WEST, new LOTRMapRegion(1112, 870, 150), EnumSet.of(FactionType.TYPE_ELF)), KHAND(14266458, LOTRDimension.DimensionRegion.EAST, new LOTRMapRegion(2031, 1258, 250), EnumSet.of(FactionType.TYPE_MAN)), TAURETHRIM(3040066, LOTRDimension.DimensionRegion.SOUTH, new LOTRMapRegion(1250, 2870, 400), EnumSet.of(FactionType.TYPE_FREE, FactionType.TYPE_MAN)), HALF_TROLL(10388339, LOTRDimension.DimensionRegion.SOUTH, new LOTRMapRegion(1900, 2500, 200), EnumSet.of(FactionType.TYPE_MAN, FactionType.TYPE_TROLL)), BLUE_MOUNTAINS(0x570000, LOTRDimension.DimensionRegion.EAST, new LOTRMapRegion(2437, 898, 454), EnumSet.of(FactionType.TYPE_FREE, FactionType.TYPE_DWARF)), ANGMAR(7836023, LOTRDimension.DimensionRegion.WEST, new LOTRMapRegion(1080, 600, 125), EnumSet.of(FactionType.TYPE_ORC, FactionType.TYPE_TROLL)),

	HOBBIT(5885518, null, new LOTRMapRegion(830, 745, 100), EnumSet.of(FactionType.TYPE_FREE, FactionType.TYPE_MAN)), RANGER_NORTH(3823170, null, new LOTRMapRegion(800, 640, 150), EnumSet.of(FactionType.TYPE_FREE, FactionType.TYPE_MAN)), DOL_GULDUR(3488580, null, new LOTRMapRegion(1380, 870, 100), EnumSet.of(FactionType.TYPE_ORC)), ISENGARD(3356723, null, new LOTRMapRegion(1110, 1070, 50), EnumSet.of(FactionType.TYPE_ORC)), ROHAN(3508007, null, new LOTRMapRegion(1230, 1090, 150), EnumSet.of(FactionType.TYPE_FREE, FactionType.TYPE_MAN)), DORWINION(7155816, null, new LOTRMapRegion(1750, 900, 100), EnumSet.of(FactionType.TYPE_FREE, FactionType.TYPE_MAN, FactionType.TYPE_ELF)), RUFFIAN(0, null, null, true, true, 0, null, null), DARK_HUORN(0, null, null, true, true, -1, null, null), UTUMNO(3343616, LOTRDimension.UTUMNO, -66666, EnumSet.of(FactionType.TYPE_ORC)), HOSTILE(true, -1), UNALIGNED(false, 0);

	static {
		factionRand = new Random();
	}

	private static Random factionRand;

	public static final int CONTROL_ZONE_EXTRA_RANGE = 50;
	private Map<Float, float[]> facRGBCache = (Map) new HashMap<>();
	private Set<FactionType> factionTypes = new HashSet<>();
	public List<LOTRItemBanner.BannerType> factionBanners = new ArrayList<>();
	private List<LOTRFactionRank> ranksSortedDescending = new ArrayList<>();
	private List<LOTRControlZone> controlZones = new ArrayList<>();
	public boolean isolationist = false;
	public boolean approvesWarCrimes = true;
	private List<String> legacyAliases = new ArrayList<>();
	public LOTRDimension factionDimension;
	public LOTRDimension.DimensionRegion factionRegion;
	private Color factionColor;
	public boolean allowPlayer;
	public boolean allowEntityRegistry;
	public boolean hasFixedAlignment;
	public int fixedAlignment;
	private LOTRFactionRank pledgeRank;
	private LOTRAchievement.Category achieveCategory;
	public LOTRMapRegion factionMapInfo;

	LOTRFaction(boolean registry, int alignment) {
		this(0, null, null, false, registry, alignment, null, null);
	}

	LOTRFaction(int color, LOTRDimension dim, int alignment, EnumSet<FactionType> types) {
		this(color, dim, dim.dimensionRegions.get(0), true, true, alignment, null, types);
	}

	LOTRFaction(int color, LOTRDimension dim, LOTRDimension.DimensionRegion region, boolean player, boolean registry, int alignment, LOTRMapRegion mapInfo, EnumSet<FactionType> types) {
		allowPlayer = player;
		allowEntityRegistry = registry;
		factionColor = new Color(color);
		factionDimension = dim;
		if (factionDimension != null) {
			factionDimension.factionList.add(this);
		}
		factionRegion = region;
		if (factionRegion != null) {
			factionRegion.factionList.add(this);
			if (factionRegion.getDimension() != factionDimension) {
				throw new IllegalArgumentException("Faction dimension region must agree with faction dimension!");
			}
		}
		if (alignment != Integer.MIN_VALUE) {
			setFixedAlignment(alignment);
		}
		if (mapInfo != null) {
			factionMapInfo = mapInfo;
		}
		if (types != null) {
			factionTypes.addAll(types);
		}
	}

	LOTRFaction(int color, LOTRDimension dim, LOTRDimension.DimensionRegion region, LOTRMapRegion mapInfo, EnumSet<FactionType> types) {
		this(color, dim, region, true, true, Integer.MIN_VALUE, mapInfo, types);
	}

	LOTRFaction(int color, LOTRDimension.DimensionRegion region, LOTRMapRegion mapInfo, EnumSet<FactionType> types) {
		this(color, LOTRDimension.MIDDLE_EARTH, region, mapInfo, types);
	}

	private void addControlZone(LOTRControlZone zone) {
		controlZones.add(zone);
	}

	private LOTRFactionRank addRank(float alignment, String name) {
		return addRank(alignment, name, false);
	}

	private LOTRFactionRank addRank(float alignment, String name, boolean gendered) {
		LOTRFactionRank rank = new LOTRFactionRank(this, alignment, name, gendered);
		ranksSortedDescending.add(rank);
		Collections.sort(ranksSortedDescending);
		return rank;
	}

	public int[] calculateFullControlZoneWorldBorders() {
		int xMin = 0;
		int xMax = 0;
		int zMin = 0;
		int zMax = 0;
		boolean first = true;
		for (LOTRControlZone zone : controlZones) {
			int cxMin = zone.xCoord - zone.radiusCoord;
			int cxMax = zone.xCoord + zone.radiusCoord;
			int czMin = zone.zCoord - zone.radiusCoord;
			int czMax = zone.zCoord + zone.radiusCoord;
			if (first) {
				xMin = cxMin;
				xMax = cxMax;
				zMin = czMin;
				zMax = czMax;
				first = false;
				continue;
			}
			xMin = Math.min(xMin, cxMin);
			xMax = Math.max(xMax, cxMax);
			zMin = Math.min(zMin, czMin);
			zMax = Math.max(zMax, czMax);
		}
		return new int[] { xMin, xMax, zMin, zMax };
	}

	public void checkAlignmentAchievements(EntityPlayer entityplayer, float alignment) {
		LOTRPlayerData playerData = LOTRLevelData.getData(entityplayer);
		for (LOTRFactionRank rank : ranksSortedDescending) {
			LOTRAchievementRank rankAch = rank.getRankAchievement();
			if (rankAch != null && rankAch.isPlayerRequiredRank(entityplayer)) {
				playerData.addAchievement(rankAch);
			}
		}
	}

	public String codeName() {
		return name();
	}

	public double distanceToNearestControlZoneInRange(World world, double d, double d1, double d2, int mapRange) {
		double closestDist = -1.0D;
		if (isFactionDimension(world)) {
			int coordRange = LOTRWaypoint.mapToWorldR(mapRange);
			for (LOTRControlZone zone : controlZones) {
				double dx = d - zone.xCoord;
				double dz = d2 - zone.zCoord;
				double dSq = dx * dx + dz * dz;
				double dToEdge = Math.sqrt(dSq) - zone.radiusCoord;
				if (dToEdge <= coordRange && (closestDist < 0.0D || dToEdge < closestDist)) {
					closestDist = dToEdge;
				}
			}
		}
		return closestDist;
	}

	public String factionEntityName() {
		return StatCollector.translateToLocal("lotr.faction." + codeName() + ".entity");
	}

	public String factionName() {
		if (LOTRMod.isAprilFools()) {
			String[] names = { "Britain Stronger in Europe", "Vote Leave" };
			int i = ordinal();
			i = (int) (i + (i ^ 0xF385L) + 28703L * (i * i ^ 0x30C087L));
			factionRand.setSeed(i);
			List<String> list = Arrays.asList(names);
			Collections.shuffle(list, factionRand);
			return list.get(0);
		}
		return StatCollector.translateToLocal(untranslatedFactionName());
	}

	public String factionSubtitle() {
		return StatCollector.translateToLocal("lotr.faction." + codeName() + ".subtitle");
	}

	public LOTRAchievement.Category getAchieveCategory() {
		return achieveCategory;
	}

	public List<LOTRFaction> getBonusesForKilling() {
		List<LOTRFaction> list = new ArrayList<>();
		for (LOTRFaction f : values()) {
			if (f != this && isBadRelation(f)) {
				list.add(f);
			}
		}
		return list;
	}

	public List<LOTRFaction> getConquestBoostRelations() {
		List<LOTRFaction> list = new ArrayList<>();
		for (LOTRFaction f : values()) {
			if (f != this && f.isPlayableAlignmentFaction() && LOTRFactionRelations.getRelations(this, f) == LOTRFactionRelations.Relation.ALLY) {
				list.add(f);
			}
		}
		return list;
	}

	public float getControlZoneAlignmentMultiplier(EntityPlayer entityplayer) {
		if (inControlZone(entityplayer)) {
			return 1.0F;
		}
		if (isFactionDimension(entityplayer.worldObj)) {
			int reducedRange = getControlZoneReducedRange();
			double dist = distanceToNearestControlZoneInRange(entityplayer.worldObj, entityplayer.posX, entityplayer.boundingBox.minY, entityplayer.posZ, reducedRange);
			if (dist >= 0.0D) {
				double mapDist = LOTRWaypoint.worldToMapR(dist);
				float frac = (float) mapDist / reducedRange;
				float mplier = 1.0F - frac;
				return MathHelper.clamp_float(mplier, 0.0F, 1.0F);
			}
		}
		return 0.0F;
	}

	public int getControlZoneReducedRange() {
		return isolationist ? 0 : 50;
	}

	public List<LOTRControlZone> getControlZones() {
		return controlZones;
	}

	public int getFactionColor() {
		return factionColor.getRGB();
	}

	public float[] getFactionRGB() {
		return getFactionRGB_MinBrightness(0.0F);
	}

	public float[] getFactionRGB_MinBrightness(float minBrightness) {
		float[] rgb = facRGBCache.get(Float.valueOf(minBrightness));
		if (rgb == null) {
			float[] hsb = Color.RGBtoHSB(factionColor.getRed(), factionColor.getGreen(), factionColor.getBlue(), null);
			hsb[2] = Math.max(hsb[2], minBrightness);
			int alteredColor = Color.HSBtoRGB(hsb[0], hsb[1], hsb[2]);
			rgb = new Color(alteredColor).getColorComponents(null);
			facRGBCache.put(Float.valueOf(minBrightness), rgb);
		}
		return rgb;
	}

	public LOTRFactionRank getFirstRank() {
		if (ranksSortedDescending.isEmpty()) {
			return LOTRFactionRank.RANK_NEUTRAL;
		}
		return ranksSortedDescending.get(ranksSortedDescending.size() - 1);
	}

	public List<LOTRFaction> getOthersOfRelation(LOTRFactionRelations.Relation rel) {
		List<LOTRFaction> list = new ArrayList<>();
		for (LOTRFaction f : values()) {
			if (f != this && f.isPlayableAlignmentFaction() && LOTRFactionRelations.getRelations(this, f) == rel) {
				list.add(f);
			}
		}
		return list;
	}

	public List<LOTRFaction> getPenaltiesForKilling() {
		List<LOTRFaction> list = new ArrayList<>();
		list.add(this);
		for (LOTRFaction f : values()) {
			if (f != this && isGoodRelation(f)) {
				list.add(f);
			}
		}
		return list;
	}

	public float getPledgeAlignment() {
		if (pledgeRank != null) {
			return pledgeRank.alignment;
		}
		return 0.0F;
	}

	public LOTRFactionRank getPledgeRank() {
		return pledgeRank;
	}

	public LOTRFactionRank getRank(EntityPlayer entityplayer) {
		return getRank(LOTRLevelData.getData(entityplayer));
	}

	public LOTRFactionRank getRank(float alignment) {
		for (LOTRFactionRank rank : ranksSortedDescending) {
			if (!rank.isDummyRank() && alignment >= rank.alignment) {
				return rank;
			}
		}
		if (alignment >= 0.0F) {
			return LOTRFactionRank.RANK_NEUTRAL;
		}
		return LOTRFactionRank.RANK_ENEMY;
	}

	public LOTRFactionRank getRank(LOTRPlayerData pd) {
		float alignment = pd.getAlignment(this);
		return getRank(alignment);
	}

	public LOTRFactionRank getRankAbove(LOTRFactionRank curRank) {
		return getRankNAbove(curRank, 1);
	}

	public LOTRFactionRank getRankBelow(LOTRFactionRank curRank) {
		return getRankNAbove(curRank, -1);
	}

	public LOTRFactionRank getRankNAbove(LOTRFactionRank curRank, int n) {
		if (ranksSortedDescending.isEmpty() || curRank == null) {
			return LOTRFactionRank.RANK_NEUTRAL;
		}
		int index = -1;
		if (curRank.isDummyRank()) {
			index = ranksSortedDescending.size();
		} else if (ranksSortedDescending.contains(curRank)) {
			index = ranksSortedDescending.indexOf(curRank);
		}
		if (index >= 0) {
			index -= n;
			if (index < 0) {
				return ranksSortedDescending.get(0);
			}
			if (index > ranksSortedDescending.size() - 1) {
				return LOTRFactionRank.RANK_NEUTRAL;
			}
			return ranksSortedDescending.get(index);
		}
		return LOTRFactionRank.RANK_NEUTRAL;
	}

	public boolean inControlZone(EntityPlayer entityplayer) {
		return inControlZone(entityplayer.worldObj, entityplayer.posX, entityplayer.boundingBox.minY, entityplayer.posZ);
	}

	public boolean inControlZone(World world, double d, double d1, double d2) {
		if (inDefinedControlZone(world, d, d1, d2)) {
			return true;
		}
		double nearbyRange = 24.0D;
		AxisAlignedBB aabb = AxisAlignedBB.getBoundingBox(d, d1, d2, d, d1, d2).expand(nearbyRange, nearbyRange, nearbyRange);
		List nearbyNPCs = world.selectEntitiesWithinAABB(EntityLivingBase.class, aabb, new LOTRNPCSelectForInfluence(this));
		if (!nearbyNPCs.isEmpty()) {
			return true;
		}
		return false;
	}

	public boolean inDefinedControlZone(EntityPlayer entityplayer) {
		return inDefinedControlZone(entityplayer, 0);
	}

	public boolean inDefinedControlZone(EntityPlayer entityplayer, int extraMapRange) {
		return inDefinedControlZone(entityplayer.worldObj, entityplayer.posX, entityplayer.boundingBox.minY, entityplayer.posZ, extraMapRange);
	}

	public boolean inDefinedControlZone(World world, double d, double d1, double d2) {
		return inDefinedControlZone(world, d, d1, d2, 0);
	}

	public boolean inDefinedControlZone(World world, double d, double d1, double d2, int extraMapRange) {
		if (isFactionDimension(world)) {
			if (!controlZonesEnabled(world)) {
				return true;
			}
			for (LOTRControlZone zone : controlZones) {
				if (zone.inZone(d, d1, d2, extraMapRange)) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean isAlly(LOTRFaction other) {
		LOTRFactionRelations.Relation rel = LOTRFactionRelations.getRelations(this, other);
		return rel == LOTRFactionRelations.Relation.ALLY;
	}

	public boolean isBadRelation(LOTRFaction other) {
		LOTRFactionRelations.Relation rel = LOTRFactionRelations.getRelations(this, other);
		return rel == LOTRFactionRelations.Relation.ENEMY || rel == LOTRFactionRelations.Relation.MORTAL_ENEMY;
	}

	private boolean isFactionDimension(World world) {
		return world.provider instanceof LOTRWorldProvider && ((LOTRWorldProvider) world.provider).getLOTRDimension() == factionDimension;
	}

	public boolean isGoodRelation(LOTRFaction other) {
		LOTRFactionRelations.Relation rel = LOTRFactionRelations.getRelations(this, other);
		return rel == LOTRFactionRelations.Relation.ALLY || rel == LOTRFactionRelations.Relation.FRIEND;
	}

	public boolean isMortalEnemy(LOTRFaction other) {
		LOTRFactionRelations.Relation rel = LOTRFactionRelations.getRelations(this, other);
		return rel == LOTRFactionRelations.Relation.MORTAL_ENEMY;
	}

	public boolean isNeutral(LOTRFaction other) {
		return LOTRFactionRelations.getRelations(this, other) == LOTRFactionRelations.Relation.NEUTRAL;
	}

	public boolean isOfType(FactionType type) {
		return factionTypes.contains(type);
	}

	public boolean isPlayableAlignmentFaction() {
		return allowPlayer && !hasFixedAlignment;
	}

	public List<String> listAliases() {
		return new ArrayList<>(legacyAliases);
	}

	private boolean matchesNameOrAlias(String name) {
		if (codeName().equals(name)) {
			return true;
		}
		for (String alias : legacyAliases) {
			if (alias.equals(name)) {
				return true;
			}
		}
		return false;
	}

	private void setAchieveCategory(LOTRAchievement.Category cat) {
		achieveCategory = cat;
	}

	private void setFixedAlignment(int alignment) {
		hasFixedAlignment = true;
		fixedAlignment = alignment;
	}

	public void setPledgeRank(LOTRFactionRank rank) {
		if (rank.fac != this) {
			throw new IllegalArgumentException("Incompatible faction!");
		}
		if (pledgeRank != null) {
			throw new IllegalArgumentException("Faction already has a pledge rank!");
		}
		pledgeRank = rank;
	}

	public boolean sharesControlZoneWith(LOTRFaction other) {
		return sharesControlZoneWith(other, 0);
	}

	public boolean sharesControlZoneWith(LOTRFaction other, int extraMapRadius) {
		if (other.factionDimension == factionDimension) {
			for (LOTRControlZone zone : controlZones) {
				for (LOTRControlZone otherZone : other.controlZones) {
					if (zone.intersectsWith(otherZone, extraMapRadius)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public String untranslatedFactionName() {
		return "lotr.faction." + codeName() + ".name";
	}

	public static boolean controlZonesEnabled(World world) {
		return LOTRLevelData.enableAlignmentZones() && world.getWorldInfo().getTerrainType() != LOTRMod.worldTypeMiddleEarthClassic;
	}

	public static LOTRFaction forID(int ID) {
		for (LOTRFaction f : values()) {
			if (f.ordinal() == ID) {
				return f;
			}
		}
		return null;
	}

	public static LOTRFaction forName(String name) {
		for (LOTRFaction f : values()) {
			if (f.matchesNameOrAlias(name)) {
				return f;
			}
		}
		return null;
	}

	public static List<LOTRFaction> getAllHarad() {
		return getAllRegional(LOTRDimension.DimensionRegion.SOUTH);
	}

	public static List<LOTRFaction> getAllOfType(boolean includeUnplayable, FactionType... types) {
		List<LOTRFaction> factions = new ArrayList<>();
		for (LOTRFaction f : values()) {
			if (includeUnplayable || f.allowPlayer && !f.hasFixedAlignment) {
				boolean match = false;
				for (FactionType t : types) {
					if (f.isOfType(t)) {
						match = true;
						break;
					}
				}
				if (match) {
					factions.add(f);
				}
			}
		}
		return factions;
	}

	public static List<LOTRFaction> getAllOfType(FactionType... types) {
		return getAllOfType(false, types);
	}

	public static List<LOTRFaction> getAllRegional(LOTRDimension.DimensionRegion region) {
		List<LOTRFaction> factions = new ArrayList<>();
		for (LOTRFaction f : values()) {
			if (f.factionRegion == region) {
				factions.add(f);
			}
		}
		return factions;
	}

	public static List<LOTRFaction> getAllRhun() {
		return getAllRegional(LOTRDimension.DimensionRegion.EAST);
	}

	public static List<String> getPlayableAlignmentFactionNames() {
		List<LOTRFaction> factions = getPlayableAlignmentFactions();
		List<String> names = new ArrayList<>();
		for (LOTRFaction f : factions) {
			names.add(f.codeName());
		}
		return names;
	}

	public static List<LOTRFaction> getPlayableAlignmentFactions() {
		List<LOTRFaction> factions = new ArrayList<>();
		for (LOTRFaction f : values()) {
			if (f.isPlayableAlignmentFaction()) {
				factions.add(f);
			}
		}
		return factions;
	}

	public static void initAllProperties() {
		ArrayList<LOTRFaction> bright = new ArrayList<>();
		bright.add(GONDOR);
		bright.add(HIGH_ELF);
		bright.add(BREE);
		bright.add(DURINS_FOLK);
		bright.add(LOTHLORIEN);
		bright.add(WOOD_ELF);
		bright.add(DALE);
		bright.add(FANGORN);
		bright.add(EREGION);
		bright.add(TAURETHRIM);

		ArrayList<LOTRFaction> dark = new ArrayList<>();
		dark.add(GUNDABAD);
		dark.add(DUNLAND);
		dark.add(MORDOR);
		dark.add(RHUDEL);
		dark.add(NEAR_HARAD);
		dark.add(MORWAITH);
		dark.add(KHAND);
		dark.add(HALF_TROLL);
		dark.add(BLUE_MOUNTAINS);
		dark.add(ANGMAR);

		// NUMENOR
		for (LOTRFaction fac : bright) {
			if (fac != GONDOR) {
				LOTRFactionRelations.setDefaultRelations(GONDOR, fac, LOTRFactionRelations.Relation.FRIEND);
			}
		}
		for (LOTRFaction fac : dark) {
			LOTRFactionRelations.setDefaultRelations(GONDOR, fac, LOTRFactionRelations.Relation.ENEMY);
		}

		// NOLDOR
		for (LOTRFaction fac : bright) {
			if (fac != HIGH_ELF && fac != DALE && fac != DURINS_FOLK) {
				LOTRFactionRelations.setDefaultRelations(HIGH_ELF, fac, LOTRFactionRelations.Relation.FRIEND);
			}
		}
		for (LOTRFaction fac : dark) {
			LOTRFactionRelations.setDefaultRelations(HIGH_ELF, fac, LOTRFactionRelations.Relation.ENEMY);
		}

		// EREGION
		for (LOTRFaction fac : bright) {
			if (fac != EREGION && fac != DALE) {
				LOTRFactionRelations.setDefaultRelations(EREGION, fac, LOTRFactionRelations.Relation.FRIEND);
			}
		}
		for (LOTRFaction fac : dark) {
			LOTRFactionRelations.setDefaultRelations(EREGION, fac, LOTRFactionRelations.Relation.ENEMY);
		}

		// ERIADOR
		for (LOTRFaction fac : bright) {
			if (fac != BREE && fac != LOTHLORIEN && fac != WOOD_ELF) {
				LOTRFactionRelations.setDefaultRelations(BREE, fac, LOTRFactionRelations.Relation.FRIEND);
			}
		}
		for (LOTRFaction fac : dark) {
			LOTRFactionRelations.setDefaultRelations(BREE, fac, LOTRFactionRelations.Relation.ENEMY);
		}

		// RHOVANION
		for (LOTRFaction fac : bright) {
			if (fac == GONDOR || fac == BREE || fac == DURINS_FOLK || fac == WOOD_ELF) {
				LOTRFactionRelations.setDefaultRelations(DALE, fac, LOTRFactionRelations.Relation.FRIEND);
			}
		}
		for (LOTRFaction fac : dark) {
			LOTRFactionRelations.setDefaultRelations(DALE, fac, LOTRFactionRelations.Relation.ENEMY);
		}

		// SINDAR
		for (LOTRFaction fac : bright) {
			if (fac != LOTHLORIEN && fac != DALE && fac != BREE && fac != DURINS_FOLK) {
				LOTRFactionRelations.setDefaultRelations(LOTHLORIEN, fac, LOTRFactionRelations.Relation.FRIEND);
			}
		}
		for (LOTRFaction fac : dark) {
			LOTRFactionRelations.setDefaultRelations(LOTHLORIEN, fac, LOTRFactionRelations.Relation.ENEMY);
		}

		// NANDOR
		for (LOTRFaction fac : bright) {
			if (fac != WOOD_ELF && fac != DALE && fac != BREE) {
				LOTRFactionRelations.setDefaultRelations(WOOD_ELF, fac, LOTRFactionRelations.Relation.FRIEND);
			}
		}
		for (LOTRFaction fac : dark) {
			LOTRFactionRelations.setDefaultRelations(WOOD_ELF, fac, LOTRFactionRelations.Relation.ENEMY);
		}

		// KHAZAD
		for (LOTRFaction fac : bright) {
			if (fac == GONDOR || fac == BREE) {
				LOTRFactionRelations.setDefaultRelations(DURINS_FOLK, fac, LOTRFactionRelations.Relation.FRIEND);
			}
		}
		for (LOTRFaction fac : dark) {
			LOTRFactionRelations.setDefaultRelations(DURINS_FOLK, fac, LOTRFactionRelations.Relation.ENEMY);
		}

		// MORDOR
		for (LOTRFaction fac : dark) {
			if (fac != MORDOR) {
				LOTRFactionRelations.setDefaultRelations(MORDOR, fac, LOTRFactionRelations.Relation.FRIEND);
			}
		}
		for (LOTRFaction fac : bright) {
			LOTRFactionRelations.setDefaultRelations(MORDOR, fac, LOTRFactionRelations.Relation.ENEMY);
		}

		// GUNDABAD
		for (LOTRFaction fac : dark) {
			if (fac == MORDOR || fac == ANGMAR || fac == DUNLAND) {
				LOTRFactionRelations.setDefaultRelations(GUNDABAD, fac, LOTRFactionRelations.Relation.FRIEND);
			}
		}
		for (LOTRFaction fac : bright) {
			LOTRFactionRelations.setDefaultRelations(GUNDABAD, fac, LOTRFactionRelations.Relation.ENEMY);
		}

		// ENEDWAITH
		for (LOTRFaction fac : dark) {
			if (fac == MORDOR || fac == GUNDABAD) {
				LOTRFactionRelations.setDefaultRelations(DUNLAND, fac, LOTRFactionRelations.Relation.FRIEND);
			}
		}
		for (LOTRFaction fac : bright) {
			LOTRFactionRelations.setDefaultRelations(DUNLAND, fac, LOTRFactionRelations.Relation.ENEMY);
		}

		// KHAND
		for (LOTRFaction fac : dark) {
			if (fac != KHAND && fac != DUNLAND && fac != GUNDABAD && fac != ANGMAR) {
				LOTRFactionRelations.setDefaultRelations(KHAND, fac, LOTRFactionRelations.Relation.FRIEND);
			}
		}
		for (LOTRFaction fac : bright) {
			LOTRFactionRelations.setDefaultRelations(KHAND, fac, LOTRFactionRelations.Relation.ENEMY);
		}

		// RHUN
		for (LOTRFaction fac : dark) {
			if (fac != RHUDEL && fac != DUNLAND && fac != GUNDABAD && fac != ANGMAR) {
				LOTRFactionRelations.setDefaultRelations(RHUDEL, fac, LOTRFactionRelations.Relation.FRIEND);
			}
		}
		for (LOTRFaction fac : bright) {
			LOTRFactionRelations.setDefaultRelations(RHUDEL, fac, LOTRFactionRelations.Relation.ENEMY);
		}

		// NEAR_HARAD
		for (LOTRFaction fac : dark) {
			if (fac != NEAR_HARAD && fac != DUNLAND && fac != GUNDABAD && fac != ANGMAR) {
				LOTRFactionRelations.setDefaultRelations(NEAR_HARAD, fac, LOTRFactionRelations.Relation.FRIEND);
			}
		}
		for (LOTRFaction fac : bright) {
			LOTRFactionRelations.setDefaultRelations(NEAR_HARAD, fac, LOTRFactionRelations.Relation.ENEMY);
		}

		// BLUE_MOUNTAINS
		for (LOTRFaction fac : dark) {
			if (fac != BLUE_MOUNTAINS && fac != DUNLAND && fac != GUNDABAD && fac != ANGMAR) {
				LOTRFactionRelations.setDefaultRelations(BLUE_MOUNTAINS, fac, LOTRFactionRelations.Relation.FRIEND);
			}
		}
		for (LOTRFaction fac : bright) {
			LOTRFactionRelations.setDefaultRelations(BLUE_MOUNTAINS, fac, LOTRFactionRelations.Relation.ENEMY);
		}

		// ANGMAR
		for (LOTRFaction fac : dark) {
			if (fac == MORDOR || fac == GUNDABAD) {
				LOTRFactionRelations.setDefaultRelations(ANGMAR, fac, LOTRFactionRelations.Relation.FRIEND);
			}
		}
		for (LOTRFaction fac : bright) {
			LOTRFactionRelations.setDefaultRelations(ANGMAR, fac, LOTRFactionRelations.Relation.ENEMY);
		}

		LOTRFactionRelations.setDefaultRelations(TAURETHRIM, MORWAITH, LOTRFactionRelations.Relation.ENEMY);
		LOTRFactionRelations.setDefaultRelations(TAURETHRIM, HALF_TROLL, LOTRFactionRelations.Relation.ENEMY);
		LOTRFactionRelations.setDefaultRelations(MORWAITH, HALF_TROLL, LOTRFactionRelations.Relation.FRIEND);

		DALE.addControlZone(new LOTRControlZone(LOTRWaypoint.OLD_RHOVANION, 150));
		DALE.setAchieveCategory(LOTRAchievement.Category.DALE);
		DALE.addRank(10.0F, "guest").makeAchievement().makeTitle();
		DALE.addRank(100.0F, "soldier").makeAchievement().makeTitle().setPledgeRank();
		DALE.addRank(1000.0F, "marshal").makeAchievement().makeTitle();
		DALE.addRank(200.0F, "herald").makeAchievement().makeTitle();
		DALE.addRank(2000.0F, "lord", true).makeAchievement().makeTitle();
		DALE.addRank(50.0F, "friend").makeAchievement().makeTitle();
		DALE.addRank(500.0F, "captain").makeAchievement().makeTitle();
		DALE.approvesWarCrimes = false;

		DUNLAND.setAchieveCategory(LOTRAchievement.Category.DUNLAND);
		DUNLAND.addControlZone(new LOTRControlZone(LOTRWaypoint.WULFBURG, 125));
		DUNLAND.addRank(10.0F, "guest").makeAchievement().makeTitle();
		DUNLAND.addRank(100.0F, "warrior").makeAchievement().makeTitle().setPledgeRank();
		DUNLAND.addRank(1000.0F, "warlord").makeAchievement().makeTitle();
		DUNLAND.addRank(200.0F, "bearer").makeAchievement().makeTitle();
		DUNLAND.addRank(2000.0F, "chieftain").makeAchievement().makeTitle();
		DUNLAND.addRank(50.0F, "kinsman").makeAchievement().makeTitle();
		DUNLAND.addRank(500.0F, "avenger").makeAchievement().makeTitle();
		DUNLAND.approvesWarCrimes = true;

		DURINS_FOLK.setAchieveCategory(LOTRAchievement.Category.IRON_HILLS);
		DURINS_FOLK.addControlZone(new LOTRControlZone(LOTRWaypoint.BARAZ_DUM, 100));
		DURINS_FOLK.addControlZone(new LOTRControlZone(LOTRWaypoint.BELEGOST, 75));
		DURINS_FOLK.addControlZone(new LOTRControlZone(LOTRWaypoint.MOUNT_GUNDABAD, 100));
		DURINS_FOLK.addControlZone(new LOTRControlZone(LOTRWaypoint.NOGROD, 75));
		DURINS_FOLK.addControlZone(new LOTRControlZone(LOTRWaypoint.WEST_GATE, 100));
		DURINS_FOLK.addRank(10.0F, "guest").makeAchievement().makeTitle();
		DURINS_FOLK.addRank(100.0F, "oathfriend").makeAchievement().makeTitle().setPledgeRank();
		DURINS_FOLK.addRank(1000.0F, "commander").makeAchievement().makeTitle();
		DURINS_FOLK.addRank(1500.0F, "lord", true).makeAchievement().makeTitle();
		DURINS_FOLK.addRank(200.0F, "axebearer").makeAchievement().makeTitle();
		DURINS_FOLK.addRank(3000.0F, "uzbad", true).makeAchievement().makeTitle();
		DURINS_FOLK.addRank(50.0F, "friend").makeAchievement().makeTitle();
		DURINS_FOLK.addRank(500.0F, "champion").makeAchievement().makeTitle();
		DURINS_FOLK.approvesWarCrimes = false;

		EREGION.setAchieveCategory(LOTRAchievement.Category.EREGION);
		EREGION.addControlZone(new LOTRControlZone(LOTRWaypoint.OST_IN_EDHIL, 150));
		EREGION.addRank(10.0F, "guest").makeAchievement().makeTitle();
		EREGION.addRank(100.0F, "warden").makeAchievement().makeTitle().setPledgeRank();
		EREGION.addRank(1000.0F, "captain").makeAchievement().makeTitle();
		EREGION.addRank(200.0F, "warrior").makeAchievement().makeTitle();
		EREGION.addRank(2000.0F, "noble").makeAchievement().makeTitle();
		EREGION.addRank(3000.0F, "lord", true).makeAchievement().makeTitle();
		EREGION.addRank(50.0F, "friend").makeAchievement().makeTitle();
		EREGION.addRank(500.0F, "herald", true).makeAchievement().makeTitle();
		EREGION.approvesWarCrimes = false;

		FANGORN.setAchieveCategory(LOTRAchievement.Category.FANGORN);
		FANGORN.addControlZone(new LOTRControlZone(1180, 1005, 70));
		FANGORN.addRank(10.0F, "newcomer").makeAchievement().makeTitle();
		FANGORN.addRank(100.0F, "treeherd").makeAchievement().makeTitle().setPledgeRank();
		FANGORN.addRank(250.0F, "master").makeAchievement().makeTitle();
		FANGORN.addRank(50.0F, "friend").makeAchievement().makeTitle();
		FANGORN.addRank(500.0F, "elder").makeAchievement().makeTitle();
		FANGORN.approvesWarCrimes = false;
		FANGORN.isolationist = true;

		GONDOR.setAchieveCategory(LOTRAchievement.Category.GONDOR);
		GONDOR.addControlZone(new LOTRControlZone(-170, 2068, 350));
		GONDOR.addControlZone(new LOTRControlZone(LOTRWaypoint.BARAD_DUR, 150));
		GONDOR.addControlZone(new LOTRControlZone(LOTRWaypoint.LOND_DAER, 100));
		GONDOR.addControlZone(new LOTRControlZone(LOTRWaypoint.THARBAD, 100));
		GONDOR.addControlZone(new LOTRControlZone(LOTRWaypoint.UMBAR_CITY, 150));
		GONDOR.addControlZone(new LOTRControlZone(LOTRWaypoint.WULFBURG, 125));
		GONDOR.addRank(10.0F, "guest").makeAchievement().makeTitle();
		GONDOR.addRank(100.0F, "atarms").makeAchievement().makeTitle().setPledgeRank();
		GONDOR.addRank(1000.0F, "champion").makeAchievement().makeTitle();
		GONDOR.addRank(1500.0F, "captain").makeAchievement().makeTitle();
		GONDOR.addRank(200.0F, "soldier").makeAchievement().makeTitle();
		GONDOR.addRank(3000.0F, "lord", true).makeAchievement().makeTitle();
		GONDOR.addRank(50.0F, "friend").makeAchievement().makeTitle();
		GONDOR.addRank(500.0F, "knight").makeAchievement().makeTitle();
		GONDOR.approvesWarCrimes = false;

		GUNDABAD.setAchieveCategory(LOTRAchievement.Category.ERIADOR);
		GUNDABAD.addControlZone(new LOTRControlZone(LOTRWaypoint.MOUNT_GRAM, 125));
		GUNDABAD.addControlZone(new LOTRControlZone(LOTRWaypoint.MOUNT_GRAM, 200));
		GUNDABAD.addControlZone(new LOTRControlZone(LOTRWaypoint.MOUNT_GUNDABAD, 200));
		GUNDABAD.addControlZone(new LOTRControlZone(LOTRWaypoint.WEST_GATE, 100));
		GUNDABAD.addRank(10.0F, "thrall").makeAchievement().makeTitle();
		GUNDABAD.addRank(100.0F, "raider").makeAchievement().makeTitle().setPledgeRank();
		GUNDABAD.addRank(1000.0F, "warlord").makeAchievement().makeTitle();
		GUNDABAD.addRank(200.0F, "ravager").makeAchievement().makeTitle();
		GUNDABAD.addRank(2000.0F, "chieftain").makeAchievement().makeTitle();
		GUNDABAD.addRank(50.0F, "snaga").makeAchievement().makeTitle();
		GUNDABAD.addRank(500.0F, "scourge").makeAchievement().makeTitle();
		GUNDABAD.approvesWarCrimes = true;

		HALF_TROLL.setAchieveCategory(LOTRAchievement.Category.PERDOROGWAITH);
		HALF_TROLL.addControlZone(new LOTRControlZone(LOTRWaypoint.BLOOD_RIVER, 200));
		HALF_TROLL.addControlZone(new LOTRControlZone(LOTRWaypoint.CROSSINGS_OF_POROS, 40));
		HALF_TROLL.addControlZone(new LOTRControlZone(LOTRWaypoint.HARADUIN_BRIDGE, 100));
		HALF_TROLL.addControlZone(new LOTRControlZone(LOTRWaypoint.SHADOW_POINT, 100));
		HALF_TROLL.addControlZone(new LOTRControlZone(LOTRWaypoint.TROLL_ISLAND, 100));
		HALF_TROLL.addRank(10.0F, "guest").makeAchievement().makeTitle();
		HALF_TROLL.addRank(100.0F, "kin").makeAchievement().makeTitle().setPledgeRank();
		HALF_TROLL.addRank(1000.0F, "warlord").makeAchievement().makeTitle();
		HALF_TROLL.addRank(200.0F, "warrior").makeAchievement().makeTitle();
		HALF_TROLL.addRank(2000.0F, "chieftain").makeAchievement().makeTitle();
		HALF_TROLL.addRank(50.0F, "scavenger").makeAchievement().makeTitle();
		HALF_TROLL.addRank(500.0F, "raider").makeAchievement().makeTitle();
		HALF_TROLL.approvesWarCrimes = true;

		HIGH_ELF.setAchieveCategory(LOTRAchievement.Category.LINDON);
		HIGH_ELF.addControlZone(new LOTRControlZone(LOTRWaypoint.FORLOND, 80));
		HIGH_ELF.addControlZone(new LOTRControlZone(LOTRWaypoint.HARLOND, 80));
		HIGH_ELF.addControlZone(new LOTRControlZone(LOTRWaypoint.MITHLOND_SOUTH, 60));
		HIGH_ELF.addControlZone(new LOTRControlZone(LOTRWaypoint.OST_IN_EDHIL, 50));
		HIGH_ELF.addRank(10.0F, "guest").makeAchievement().makeTitle();
		HIGH_ELF.addRank(100.0F, "warrior").makeAchievement().makeTitle().setPledgeRank();
		HIGH_ELF.addRank(1000.0F, "noble").makeAchievement().makeTitle();
		HIGH_ELF.addRank(200.0F, "herald").makeAchievement().makeTitle();
		HIGH_ELF.addRank(2000.0F, "commander").makeAchievement().makeTitle();
		HIGH_ELF.addRank(3000.0F, "lord", true).makeAchievement().makeTitle();
		HIGH_ELF.addRank(50.0F, "friend").makeAchievement().makeTitle();
		HIGH_ELF.addRank(500.0F, "captain").makeAchievement().makeTitle();
		HIGH_ELF.approvesWarCrimes = false;

		KHAND.setAchieveCategory(LOTRAchievement.Category.RHUN);
		KHAND.addControlZone(new LOTRControlZone(2031, 1258, 250));
		KHAND.addRank(10.0F, "bondsman").makeAchievement().makeTitle();
		KHAND.addRank(100.0F, "clansman").makeAchievement().makeTitle().setPledgeRank();
		KHAND.addRank(1000.0F, "golden").makeAchievement().makeTitle();
		KHAND.addRank(1500.0F, "warlord").makeAchievement().makeTitle();
		KHAND.addRank(200.0F, "warrior").makeAchievement().makeTitle();
		KHAND.addRank(3000.0F, "chieftain").makeAchievement().makeTitle();
		KHAND.addRank(50.0F, "levyman").makeAchievement().makeTitle();
		KHAND.addRank(500.0F, "champion").makeAchievement().makeTitle();
		KHAND.approvesWarCrimes = false;

		LOTHLORIEN.setAchieveCategory(LOTRAchievement.Category.LOTHLORIEN);
		LOTHLORIEN.addControlZone(new LOTRControlZone(LOTRWaypoint.CARAS_GALADHON, 100));
		LOTHLORIEN.addRank(10.0F, "guest").makeAchievement().makeTitle();
		LOTHLORIEN.addRank(100.0F, "warden").makeAchievement().makeTitle().setPledgeRank();
		LOTHLORIEN.addRank(1000.0F, "captain").makeAchievement().makeTitle();
		LOTHLORIEN.addRank(200.0F, "warrior").makeAchievement().makeTitle();
		LOTHLORIEN.addRank(2000.0F, "noble").makeAchievement().makeTitle();
		LOTHLORIEN.addRank(3000.0F, "lord", true).makeAchievement().makeTitle();
		LOTHLORIEN.addRank(50.0F, "friend").makeAchievement().makeTitle();
		LOTHLORIEN.addRank(500.0F, "herald", true).makeAchievement().makeTitle();
		LOTHLORIEN.approvesWarCrimes = false;

		MORDOR.setAchieveCategory(LOTRAchievement.Category.MORDOR);
		MORDOR.addControlZone(new LOTRControlZone(LOTRWaypoint.BARAD_DUR, 500));
		MORDOR.addRank(10.0F, "thrall").makeAchievement().makeTitle();
		MORDOR.addRank(100.0F, "brigand").makeAchievement().makeTitle().setPledgeRank();
		MORDOR.addRank(1000.0F, "captain").makeAchievement().makeTitle();
		MORDOR.addRank(1500.0F, "lieutenant").makeAchievement().makeTitle();
		MORDOR.addRank(200.0F, "slavedriver").makeAchievement().makeTitle();
		MORDOR.addRank(3000.0F, "commander").makeAchievement().makeTitle();
		MORDOR.addRank(50.0F, "snaga").makeAchievement().makeTitle();
		MORDOR.addRank(500.0F, "despoiler").makeAchievement().makeTitle();
		MORDOR.approvesWarCrimes = true;

		MORWAITH.setAchieveCategory(LOTRAchievement.Category.FAR_HARAD_SAVANNAH);
		MORWAITH.addControlZone(new LOTRControlZone(LOTRWaypoint.GREAT_PLAINS_EAST, 200));
		MORWAITH.addControlZone(new LOTRControlZone(LOTRWaypoint.GREAT_PLAINS_NORTH, 75));
		MORWAITH.addControlZone(new LOTRControlZone(LOTRWaypoint.GREAT_PLAINS_SOUTH, 350));
		MORWAITH.addControlZone(new LOTRControlZone(LOTRWaypoint.GREAT_PLAINS_WEST, 170));
		MORWAITH.addRank(10.0F, "guest").makeAchievement().makeTitle();
		MORWAITH.addRank(100.0F, "kinsman").makeAchievement().makeTitle().setPledgeRank();
		MORWAITH.addRank(1000.0F, "chief").makeAchievement().makeTitle();
		MORWAITH.addRank(250.0F, "hunter").makeAchievement().makeTitle();
		MORWAITH.addRank(3000.0F, "greatchief").makeAchievement().makeTitle();
		MORWAITH.addRank(50.0F, "friend").makeAchievement().makeTitle();
		MORWAITH.addRank(500.0F, "warrior").makeAchievement().makeTitle();
		MORWAITH.approvesWarCrimes = true;

		NEAR_HARAD.setAchieveCategory(LOTRAchievement.Category.NEAR_HARAD);
		NEAR_HARAD.addControlZone(new LOTRControlZone(LOTRWaypoint.CROSSINGS_OF_HARAD, 75));
		NEAR_HARAD.addControlZone(new LOTRControlZone(LOTRWaypoint.DESERT_TOWN, 50));
		NEAR_HARAD.addControlZone(new LOTRControlZone(LOTRWaypoint.FERTILE_VALLEY, 150));
		NEAR_HARAD.addControlZone(new LOTRControlZone(LOTRWaypoint.GULF_CITY, 150));
		NEAR_HARAD.addControlZone(new LOTRControlZone(LOTRWaypoint.HARNEN_RIVER_TOWN, 60));
		NEAR_HARAD.addControlZone(new LOTRControlZone(LOTRWaypoint.HARNEN_SEA_TOWN, 60));
		NEAR_HARAD.addControlZone(new LOTRControlZone(LOTRWaypoint.SOUTH_DESERT_TOWN, 50));
		NEAR_HARAD.addControlZone(new LOTRControlZone(LOTRWaypoint.UMBAR_CITY, 200));
		NEAR_HARAD.addRank(10.0F, "guest").makeAchievement().makeTitle();
		NEAR_HARAD.addRank(100.0F, "kinsman").makeAchievement().makeTitle().setPledgeRank();
		NEAR_HARAD.addRank(1000.0F, "serpentguard").makeAchievement().makeTitle();
		NEAR_HARAD.addRank(1500.0F, "warlord").makeAchievement().makeTitle();
		NEAR_HARAD.addRank(200.0F, "warrior").makeAchievement().makeTitle();
		NEAR_HARAD.addRank(3000.0F, "prince", true).makeAchievement().makeTitle();
		NEAR_HARAD.addRank(50.0F, "friend").makeAchievement().makeTitle();
		NEAR_HARAD.addRank(500.0F, "champion").makeAchievement().makeTitle();
		NEAR_HARAD.approvesWarCrimes = false;

		BLUE_MOUNTAINS.setAchieveCategory(LOTRAchievement.Category.OROCARNI);
		BLUE_MOUNTAINS.addControlZone(new LOTRControlZone(2437, 898, 454));
		BLUE_MOUNTAINS.addControlZone(new LOTRControlZone(LOTRWaypoint.DIMRILL_DALE, 1));
		BLUE_MOUNTAINS.addControlZone(new LOTRControlZone(LOTRWaypoint.MORANNON, 70));
		BLUE_MOUNTAINS.addRank(10.0F, "guest").makeAchievement().makeTitle();
		BLUE_MOUNTAINS.addRank(100.0F, "oathfriend").makeAchievement().makeTitle().setPledgeRank();
		BLUE_MOUNTAINS.addRank(1000.0F, "commander").makeAchievement().makeTitle();
		BLUE_MOUNTAINS.addRank(1500.0F, "lord", true).makeAchievement().makeTitle();
		BLUE_MOUNTAINS.addRank(200.0F, "axebearer").makeAchievement().makeTitle();
		BLUE_MOUNTAINS.addRank(3000.0F, "uzbad", true).makeAchievement().makeTitle();
		BLUE_MOUNTAINS.addRank(50.0F, "friend").makeAchievement().makeTitle();
		BLUE_MOUNTAINS.addRank(500.0F, "champion").makeAchievement().makeTitle();
		BLUE_MOUNTAINS.approvesWarCrimes = false;

		RHUDEL.setAchieveCategory(LOTRAchievement.Category.RHUN);
		RHUDEL.addControlZone(new LOTRControlZone(LOTRWaypoint.OLD_RHOVANION, 100));
		RHUDEL.addControlZone(new LOTRControlZone(LOTRWaypoint.RHUN_CAPITAL, 175));
		RHUDEL.addRank(10.0F, "bondsman").makeAchievement().makeTitle();
		RHUDEL.addRank(100.0F, "clansman").makeAchievement().makeTitle().setPledgeRank();
		RHUDEL.addRank(1000.0F, "golden").makeAchievement().makeTitle();
		RHUDEL.addRank(1500.0F, "warlord").makeAchievement().makeTitle();
		RHUDEL.addRank(200.0F, "warrior").makeAchievement().makeTitle();
		RHUDEL.addRank(3000.0F, "chieftain").makeAchievement().makeTitle();
		RHUDEL.addRank(50.0F, "levyman").makeAchievement().makeTitle();
		RHUDEL.addRank(500.0F, "champion").makeAchievement().makeTitle();
		RHUDEL.approvesWarCrimes = false;

		TAURETHRIM.setAchieveCategory(LOTRAchievement.Category.FAR_HARAD_JUNGLE);
		TAURETHRIM.addControlZone(new LOTRControlZone(LOTRWaypoint.JUNGLE_CITY_CAPITAL, 400));
		TAURETHRIM.addControlZone(new LOTRControlZone(LOTRWaypoint.OLD_JUNGLE_RUIN, 75));
		TAURETHRIM.addRank(10.0F, "guest").makeAchievement().makeTitle();
		TAURETHRIM.addRank(100.0F, "forestman").makeAchievement().makeTitle().setPledgeRank();
		TAURETHRIM.addRank(1000.0F, "warlord").makeAchievement().makeTitle();
		TAURETHRIM.addRank(200.0F, "warrior").makeAchievement().makeTitle();
		TAURETHRIM.addRank(3000.0F, "splendour").makeAchievement().makeTitle();
		TAURETHRIM.addRank(50.0F, "friend").makeAchievement().makeTitle();
		TAURETHRIM.addRank(500.0F, "champion").makeAchievement().makeTitle();
		TAURETHRIM.approvesWarCrimes = true;

		WOOD_ELF.setAchieveCategory(LOTRAchievement.Category.MIRKWOOD);
		WOOD_ELF.addControlZone(new LOTRControlZone(LOTRWaypoint.AMON_LANK, 30));
		WOOD_ELF.addControlZone(new LOTRControlZone(LOTRWaypoint.FOREST_GATE, 20));
		WOOD_ELF.addRank(100.0F, "friend").makeAchievement().makeTitle().setPledgeRank();
		WOOD_ELF.addRank(1000.0F, "captain").makeAchievement().makeTitle();
		WOOD_ELF.addRank(200.0F, "guard").makeAchievement().makeTitle();
		WOOD_ELF.addRank(2000.0F, "noble").makeAchievement().makeTitle();
		WOOD_ELF.addRank(3000.0F, "lord", true).makeAchievement().makeTitle();
		WOOD_ELF.addRank(50.0F, "guest").makeAchievement().makeTitle();
		WOOD_ELF.addRank(500.0F, "herald").makeAchievement().makeTitle();
		WOOD_ELF.approvesWarCrimes = false;
	}

	public enum FactionType {
		TYPE_FREE, TYPE_ELF, TYPE_MAN, TYPE_DWARF, TYPE_ORC, TYPE_TROLL, TYPE_TREE;
	}

}
