package sh.miles.voidcr.impl.server.network;

import com.google.common.base.Preconditions;
import finalforeach.cosmicreach.savelib.crbin.ICRBinSerializable;
import sh.miles.voidcr.impl.util.VoidMagicMethods;
import sh.miles.voidcr.server.network.Account;
import sh.miles.voidcr.server.network.AccountIdentifier;
import sh.miles.voidcr.util.CRSerializerHelper;

public final class VoidAccount implements Account {

    private final finalforeach.cosmicreach.accounts.Account mirror;
    private final AccountIdentifier uuid;

    public VoidAccount(finalforeach.cosmicreach.accounts.Account mirror) {
        this.mirror = mirror;
        this.uuid = new VoidAccountIdentifier(mirror.getUniqueId());
    }

    @Override
    public String getName() {
        return mirror.getUsername();
    }

    @Override
    public AccountIdentifier getIdentifier() {
        return this.uuid;
    }

    public static class VoidAccountIdentifier implements AccountIdentifier {

        private final String uuid;

        public VoidAccountIdentifier(String uuid) {
            this.uuid = uuid;
        }

        public String getRaw() {
            return this.uuid;
        }

        @Override
        public byte[] toBytes() {
            final CRSerializerHelper.CRBinSerializerWrapper<AccountIdentifier> wrapped = CRSerializerHelper.create(AccountIdentifier.class);
            wrapped.setResult(this);
            return VoidMagicMethods.serialize(wrapped);
        }

        public static VoidAccountIdentifier deserialize(ICRBinSerializable serializable) {
            if (serializable instanceof CRSerializerHelper.CRBinSerializerWrapper<?> wrapper) {
                return (VoidAccountIdentifier) wrapper.getResult();
            }

            throw new IllegalArgumentException("Unexpected serializable class " + serializable.getClass());
        }
    }
}
