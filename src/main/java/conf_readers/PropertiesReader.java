package conf_readers;

import java.io.FileInputStream;
import java.io.IOException;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class PropertiesReader implements IConfReaders {

    @Override
    public Map<String, String> read() {
       String rootDir = System.getProperty("user.dir");

        Map<String, String> prop = new HashMap<>();

        try {
        InputStream input = Files.newInputStream(Path.of(String.format("%s/src/java/resourses/%s", rootDir, "db.properties")));
            Properties properties = new Properties();
            properties.load(input);

            for(Object key: properties.keySet()) {
                prop.put((String) key, (String)properties.get(key));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return prop;
    }

}
