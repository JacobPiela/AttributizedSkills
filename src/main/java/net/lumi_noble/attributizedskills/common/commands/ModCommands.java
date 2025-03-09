package net.lumi_noble.attributizedskills.common.commands;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.lumi_noble.attributizedskills.common.commands.common.*;
import net.minecraft.commands.CommandSourceStack;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;

public class ModCommands {

  @SubscribeEvent
  public void onRegisterCommands(RegisterCommandsEvent event) {
    event
        .getDispatcher()
        .register(
            LiteralArgumentBuilder.<CommandSourceStack>literal("attributized")
                .requires(source -> source.hasPermission(2))
                .then(SetCommand.register())
                .then(GetCommand.register())
                .then(AddRequirementsCommand.register())
                .then(RemoveRequirementsCommand.register())
                .then(AddSkillBonusCommand.register())
                .then(RemoveSkillBonusCommand.register())
                .then(AddTearPointsCommand.register())
                .then(SetTearPointsCommand.register()));
  }

  @SubscribeEvent
  public void onRegisterCommandsMods(RegisterCommandsEvent event) {
    if (ModList.get().isLoaded(IronsSpellbooks.MODID)) {
      event
          .getDispatcher()
          .register(
              LiteralArgumentBuilder.<CommandSourceStack>literal("attributized")
                  .requires(source -> source.hasPermission(2))
                  .then(AddSpellRequirementCommand.register())
                      .then(RemoveSpellRequirementCommand.register()));
    }
  }
}
