/**
 * Main.java
 * <p>
 * Description: [Add the description of the class]
 *
 * @author aleja
 * @since 01/01/2026
 */

public class Main {
    public static void main(String [] args){
        ///Instance the Configuration
        MainConfig config = MainConfig.getInstance();

        ///Default Values of instance
        System.out.println("Configuration Default Values");
        System.out.println("Language: " + config.getLanguage());
        System.out.println("Version: " + config.getVersion());
        System.out.println("Dark Mode: " + (config.isDarkMode()?"True":"False"));

        ///Change Values
        config.setLanguage("EN");
        config.setVersion("1.2");

        System.out.println("Modify Configuration");
        System.out.println("Language: " + config.getLanguage());
        System.out.println("Version: " + config.getVersion());
        System.out.println("Dark Mode: " + (config.isDarkMode()?"True":"False"));


        ///New instance of config, to verify is the same config
        MainConfig config1 = MainConfig.getInstance();
        System.out.println("¿Same Instance?: " + (config1.equals(config)?"True": "False"));
    }
}
