package net.lumi_noble.rpgskillable_fork.common.data;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {

	@SubscribeEvent
	public static void gatherData(GatherDataEvent event) {
		
		DataGenerator generator = event.getGenerator();
		
		//generator.addProvider(event.includeServer(), new RpgSkillableDungeonLoot(event.getGenerator(), RpgSkillable.MODID));
		generator.addProvider(event.includeClient(), new RpgSkillableLang(generator, "en_us"));
	}
}
