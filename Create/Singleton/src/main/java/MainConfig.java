import com.sun.tools.javac.Main;

/**
 * MainConfig.java
 * <p>
 * Description: [Add the description of the class]
 *
 * @author aleja
 * @since 01/01/2026
 */

public class MainConfig {

    private static MainConfig instance;

    private MainConfig(){
        this.language="ES";
        this.isDarkMode= false;
        this.version="1.0";
    }

    private String language;
    private boolean isDarkMode;
    private String version;

    public static MainConfig getInstance(){
        if(instance == null)
            instance = new MainConfig();

        return instance;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public boolean isDarkMode() {
        return isDarkMode;
    }

    public void setDarkMode(boolean darkMode) {
        isDarkMode = darkMode;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
