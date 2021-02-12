package properties;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.util.Properties;

public class DatabaseConfiguration {

//    private static final String ENCODING_UTF8 = "UTF-8";

    private Properties properties = new Properties();

    public DatabaseConfiguration() {
        try (BufferedReader bufferedReader = new BufferedReader
                (new InputStreamReader(
                        this.getClass().getClassLoader().getResourceAsStream("properties/db.properties")))) {
            {
                properties.load(bufferedReader);
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("Cannot read file");
        }
    }

    public DatabaseConfiguration(File file) {
        try (BufferedReader bufferedReader = new BufferedReader
                (Files.newBufferedReader(file.toPath()))) {
            {
                properties.load(bufferedReader);
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("Cannot read file");
        }
    }


    public String getHost() {
        return properties.getProperty("db.host");
    }

    public int getPort() {
        return Integer.parseInt(properties.getProperty("db.port"));
    }

    public String getSchema() {
        return properties.getProperty("db.schema");
    }

}





