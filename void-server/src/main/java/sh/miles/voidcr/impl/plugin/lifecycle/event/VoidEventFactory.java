package sh.miles.voidcr.impl.plugin.lifecycle.event;

import com.badlogic.gdx.graphics.Color;
import finalforeach.cosmicreach.BlockEntityScreenInfo;
import finalforeach.cosmicreach.accounts.Account;
import finalforeach.cosmicreach.blockentities.BlockEntitySign;
import finalforeach.cosmicreach.blocks.BlockPosition;
import finalforeach.cosmicreach.blocks.BlockState;
import finalforeach.cosmicreach.entities.IDamageSource;
import finalforeach.cosmicreach.entities.player.Player;
import finalforeach.cosmicreach.items.ItemSlot;
import finalforeach.cosmicreach.items.ItemStack;
import finalforeach.cosmicreach.items.containers.SlotContainer;
import finalforeach.cosmicreach.networking.NetworkIdentity;
import finalforeach.cosmicreach.networking.packets.items.SlotInteractionType;
import finalforeach.cosmicreach.world.World;
import sh.miles.voidcr.impl.plugin.lifecycle.event.chat.post.VoidPostPlayerChatEvent;
import sh.miles.voidcr.impl.plugin.lifecycle.event.chat.pre.VoidPrePlayerChatEvent;
import sh.miles.voidcr.impl.plugin.lifecycle.event.entity.post.VoidPostEntityDamageEvent;
import sh.miles.voidcr.impl.plugin.lifecycle.event.entity.pre.VoidPreEntityDamageEvent;
import sh.miles.voidcr.impl.plugin.lifecycle.event.server.network.post.VoidPostAccountJoinEvent;
import sh.miles.voidcr.impl.plugin.lifecycle.event.server.network.pre.VoidPreAccountJoinEvent;
import sh.miles.voidcr.impl.plugin.lifecycle.event.world.block.entity.post.VoidPostPlayerOpenBlockScreenEvent;
import sh.miles.voidcr.impl.plugin.lifecycle.event.world.block.entity.post.VoidPostPlayerSignUpdateEvent;
import sh.miles.voidcr.impl.plugin.lifecycle.event.world.block.entity.pre.VoidPrePlayerOpenBlockScreenEvent;
import sh.miles.voidcr.impl.plugin.lifecycle.event.world.block.entity.pre.VoidPrePlayerSignUpdateEvent;
import sh.miles.voidcr.impl.plugin.lifecycle.event.world.block.post.VoidPostPlayerBreakBlockEvent;
import sh.miles.voidcr.impl.plugin.lifecycle.event.world.block.post.VoidPostPlayerInteractEvent;
import sh.miles.voidcr.impl.plugin.lifecycle.event.world.block.post.VoidPostPlayerPlaceBlockEvent;
import sh.miles.voidcr.impl.plugin.lifecycle.event.world.block.pre.VoidPrePlayerBreakBlockEvent;
import sh.miles.voidcr.impl.plugin.lifecycle.event.world.block.pre.VoidPrePlayerInteractBlockEvent;
import sh.miles.voidcr.impl.plugin.lifecycle.event.world.block.pre.VoidPrePlayerPlaceBlockEvent;
import sh.miles.voidcr.impl.plugin.lifecycle.event.world.inventory.container.pre.VoidPrePlayerItemContainerInteractEvent;
import sh.miles.voidcr.impl.plugin.lifecycle.event.world.pre.VoidPreUniverseEndTickEvent;
import sh.miles.voidcr.impl.world.inventory.item.VoidItemStack;

import static sh.miles.voidcr.impl.plugin.lifecycle.VoidLifecycleManager.dispatchEvent;

public final class VoidEventFactory {

    private VoidEventFactory() {
        throw new UnsupportedOperationException("Can not create instance of utility class VoidEventFactory");
    }

    public static VoidPreEntityDamageEvent preEntityDamage(float damage, int invulnerabilityFrames, IDamageSource source, finalforeach.cosmicreach.entities.Entity effected) {
        return dispatchEvent(ctx -> new VoidPreEntityDamageEvent(ctx, effected, invulnerabilityFrames, damage, source));
    }

    public static void postEntityDamage(float damage, int invulnerabilityFrames, IDamageSource source, finalforeach.cosmicreach.entities.Entity effected) {
        dispatchEvent(ctx -> new VoidPostEntityDamageEvent(ctx, effected, invulnerabilityFrames, damage, source));
    }

    public static VoidPrePlayerSignUpdateEvent prePlayerSignUpdate(NetworkIdentity actor, BlockEntitySign sign, String[] lines, float fontSize, int color) {
        return dispatchEvent(ctx -> new VoidPrePlayerSignUpdateEvent(ctx, sign, lines, new Color(color), fontSize, actor.getPlayer()));
    }

    public static void postPlayerSignUpdate(NetworkIdentity actor, BlockEntitySign sign) {
        dispatchEvent(ctx -> new VoidPostPlayerSignUpdateEvent(ctx, sign, actor.getPlayer()));
    }

    public static VoidPrePlayerPlaceBlockEvent prePlayerPlaceBlock(NetworkIdentity identity, BlockPosition position, BlockState target) {
        return dispatchEvent(ctx -> new VoidPrePlayerPlaceBlockEvent(ctx, identity.getPlayer(), position, target));
    }

    public static void postPlayerPlaceBlock(NetworkIdentity identity, BlockPosition position, BlockState target) {
        dispatchEvent(ctx -> new VoidPostPlayerPlaceBlockEvent(ctx, identity.getPlayer(), position, target));
    }

    public static VoidPrePlayerBreakBlockEvent prePlayerBreakBlock(NetworkIdentity identity, BlockPosition position, BlockState target) {
        return dispatchEvent(ctx -> new VoidPrePlayerBreakBlockEvent(ctx, identity.getPlayer(), position, target));
    }

    public static void postPlayerBreakBlock(NetworkIdentity identity, BlockPosition position, BlockState state) {
        dispatchEvent(ctx -> new VoidPostPlayerBreakBlockEvent(ctx, identity.getPlayer(), position, state));
    }

    public static VoidPrePlayerInteractBlockEvent prePlayerInteractBlock(NetworkIdentity identity, BlockPosition position, BlockState target) {
        return dispatchEvent(ctx -> new VoidPrePlayerInteractBlockEvent(ctx, identity.getPlayer(), position, target));
    }

    public static void postPlayerInteractBlock(NetworkIdentity identity, BlockPosition position, BlockState target) {
        dispatchEvent(ctx -> new VoidPostPlayerInteractEvent(ctx, identity.getPlayer(), position, target));
    }

    public static boolean prePlayerOpenBlockScreen(BlockEntityScreenInfo info) {
        if (info.player().getZone() != info.blockEntity().getZone()) { // Don't allow opening screen from another world
            return false;
        }

        final var event = dispatchEvent(ctx -> new VoidPrePlayerOpenBlockScreenEvent(ctx, info.player(), info.blockEntity()));
        if (event == null) return true;

        return !event.isCanceled();
    }

    public static void postPlayerOpenBlockScreen(BlockEntityScreenInfo info) {
        dispatchEvent(ctx -> new VoidPostPlayerOpenBlockScreenEvent(ctx, info.player(), info.blockEntity()));
    }

    public static void preUniverseEndTick(World world, long time) {
        dispatchEvent(ctx -> new VoidPreUniverseEndTickEvent(ctx, world, time));
    }

    public static VoidPrePlayerChatEvent prePlayerChat(String message, Player sender) {
        return dispatchEvent(ctx -> new VoidPrePlayerChatEvent(ctx, message, sender));
    }

    public static void postPlayerChat(String message, Player sender) {
        dispatchEvent(ctx -> new VoidPostPlayerChatEvent(ctx, message, sender));
    }

    public static VoidPreAccountJoinEvent preAccountJoin(Account account) {
        return dispatchEvent(ctx -> new VoidPreAccountJoinEvent(ctx, account));
    }

    public static void postAccountJoin(Account account) {
        dispatchEvent(ctx -> new VoidPostAccountJoinEvent(ctx, account));
    }

    public static VoidPrePlayerItemContainerInteractEvent prePlayerItemContainerInteract(Player player, ItemSlot slot, SlotInteractionType interactionType) {
        final ItemStack item = slot.getItemStack() == null ? VoidItemStack.EMPTY.get() : slot.getItemStack();
        return dispatchEvent(ctx -> new VoidPrePlayerItemContainerInteractEvent(ctx, slot.getContainer(), slot.getSlotId(), player, interactionType, item));
    }
}
