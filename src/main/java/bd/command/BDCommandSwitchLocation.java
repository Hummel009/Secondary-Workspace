package bd.command;

import lotr.common.*;
import net.minecraft.command.*;
import net.minecraft.entity.player.EntityPlayer;

public class BDCommandSwitchLocation extends CommandBase {
	@Override
	public String getCommandName() {
		return "amogus";
	}

	@Override
	public String getCommandUsage(ICommandSender sender) {
		return "oh shit";
	}

	@Override
	public int getRequiredPermissionLevel() {
		return 2;
	}

	@Override
	public void processCommand(ICommandSender sender, String[] args) {
		if (sender instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) sender;
			LOTRPlayerData pd = LOTRLevelData.getData(player);
			boolean flag = pd.getHideMapLocation();
			pd.setHideMapLocation(!flag);
		}
	}
}