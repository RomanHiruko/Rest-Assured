package config;

import java.util.ResourceBundle;
// ������ ���������� �� �����
public class ApiConfig {
    private static final ResourceBundle CONFIG = ResourceBundle.getBundle("config");

    public static String getBaseUrl() {
        return CONFIG.getString("baseURL");
    }

    public static int getTimeout() {
        return Integer.parseInt(CONFIG.getString("timeout"));
    }
}
