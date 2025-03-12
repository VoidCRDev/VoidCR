package sh.miles.voidcr.impl.plugin.lifecycle.event.server.network.post;

import sh.miles.voidcr.entity.PlayerEntity;
import sh.miles.voidcr.impl.plugin.lifecycle.event.VoidLifecycleEvent;
import sh.miles.voidcr.plugin.lifecycle.event.LifecycleEvent;
import sh.miles.voidcr.plugin.lifecycle.event.server.network.post.PostAccountJoinEvent;
import sh.miles.voidcr.server.Server;
import sh.miles.voidcr.server.network.Account;

public class VoidPostAccountJoinEvent extends VoidLifecycleEvent<Server> implements PostAccountJoinEvent {

    private final Account account;
    private final PlayerEntity player;

    public VoidPostAccountJoinEvent(final Server context, final finalforeach.cosmicreach.accounts.Account account) {
        super(context);
        this.account = account.getVoidMirror();
        this.player = (PlayerEntity) account.getPlayer().getEntity().getVoidMirror();
    }

    @Override
    public PlayerEntity getPlayer() {
        return this.player;
    }

    @Override
    public Account getAccount() {
        return this.account;
    }

    @Override
    public Class<? extends LifecycleEvent<Server>> getEventClass() {
        return PostAccountJoinEvent.class;
    }
}
