package sh.miles.voidcr.apigen;

import sh.miles.crdatalib.data.CRData;

import java.io.IOException;
import java.nio.file.Path;

public interface APIGenerator {
    void generate(CRData data, Path to) throws IOException;
}
