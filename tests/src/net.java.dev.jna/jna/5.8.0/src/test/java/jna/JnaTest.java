/*
 * Copyright and related rights waived via CC0
 *
 * You should have received a copy of the CC0 legalcode along with this
 * work. If not, see <http://creativecommons.org/publicdomain/zero/1.0/>.
 */
package jna;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Platform;
import org.junit.jupiter.api.Test;

public class JnaTest {
    public interface CLibrary extends Library {
        CLibrary INSTANCE = Native.load(Platform.isWindows() ? "msvcrt" : "c", CLibrary.class);

        void printf(String format, Object... args);
    }

    @Test
    void name() {
        CLibrary.INSTANCE.printf("Hello, %s\n", "World");
    }
}
