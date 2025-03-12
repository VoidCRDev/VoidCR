package sh.miles.voidcr.impl.plugin.lifecycle.event.server.network.pre;

import sh.miles.voidcr.impl.plugin.lifecycle.event.VoidLifecycleEvent;
import sh.miles.voidcr.plugin.lifecycle.event.LifecycleEvent;
import sh.miles.voidcr.plugin.lifecycle.event.server.network.pre.PreAccountJoinEvent;
import sh.miles.voidcr.server.Server;
import sh.miles.voidcr.server.network.Account;

public class VoidPreAccountJoinEvent extends VoidLifecycleEvent<Server> implements PreAccountJoinEvent {

    private boolean isKicked;
    private String kickMessage;
    private final Account account;

    public VoidPreAccountJoinEvent(Server ctx, finalforeach.cosmicreach.accounts.Account account) {
        super(ctx);
        this.account = account.getVoidMirror();
        this.kickMessage = null;
        this.isKicked = false;
    }

    @Override
    public void kick(final String message) {
        if (isKicked) return;
        isKicked = true;
        this.kickMessage = message;
    }

    @Override
    public boolean isKicked() {
        return isKicked;
    }

    @Override
    public Account getAccount() {
        return this.account;
    }

    @Override
    public Class<? extends LifecycleEvent<Server>> getEventClass() {
        return PreAccountJoinEvent.class;
    }

    public String getKickMessage() {
        return kickMessage;
    }
}
