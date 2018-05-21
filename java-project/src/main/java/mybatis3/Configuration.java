package mybatis3;

/**
 * Created by SF on 2018/1/9.
 */
public class Configuration {
    protected Environment environment;

    public Configuration(Environment environment) {
        this.environment = environment;
    }

    public Environment getEnvironment() {
        return environment;
    }

    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}
