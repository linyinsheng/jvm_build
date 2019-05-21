package load;

import java.io.IOException;
import java.io.InputStream;

public interface Load {
    InputStream readClass(String className) throws IOException;
}
