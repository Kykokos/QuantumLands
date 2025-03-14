package net.Kykokos.QuantumLands.event;


import net.Kykokos.QuantumLands.QuantumLands;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.registries.ForgeRegistries;


@Mod.EventBusSubscriber(modid = QuantumLands.MOD_ID)
public class GuideBookHandler {

    private static final String BOOK_GIVEN_TAG = "quantum_lexicon_given";

    @SubscribeEvent
    public static void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event) {
        Player player = event.getEntity();
        Level level = player.level();

        if (!level.isClientSide() && player instanceof ServerPlayer serverPlayer) {
            CompoundTag persistentData = serverPlayer.getPersistentData();

            if (!persistentData.getBoolean(BOOK_GIVEN_TAG)) {
                Item item = ForgeRegistries.ITEMS.getValue(new ResourceLocation("patchouli", "guide_book"));
                if (item != null) {
                    ItemStack guideBook = new ItemStack(item);
                    CompoundTag bookTag = guideBook.getOrCreateTag();
                    bookTag.putString("patchouli:book", "quantum_lands:quantum_lexicon");

                    serverPlayer.addItem(guideBook);
                    persistentData.putBoolean(BOOK_GIVEN_TAG, true);
                }
            }
        }
    }
}
