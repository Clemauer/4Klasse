package at.htlhl.httpclientdemo;
/*
 * Usage exmple for a singelton implementation:
 *
 * Example demonstrates a single ressource (e.g. a file) accesss
 */

public class ConfigAccessSingelton {
    private static ConfigAccessSingelton instance = null;

    /**
     * PRIVATE constructor
     */

    private ConfigAccessSingelton() {}

    /**
     * Create (once) and return the singelton instance
     *
     * Note the keyword static and synchronized (needed for thread safety)
     *
     * @return
     */

    public static synchronized ConfigAccessSingelton getInstance() {
        if (instance == null) {
            instance = new ConfigAccessSingelton();
        }
        return instance;
    }

    // Example methods to access the values in an imagined configuration file

    /**
     * Read the first setting from the configuration file
     * (not implemented)
     * @return
     */

    public int readSettingOne(){
        return 42;
    }

    /**
     * Write a setting to the Configuration file
     * (not implemented)
     * @param setting
     */

    public void writeSettingOne(){
        //
    }
}
