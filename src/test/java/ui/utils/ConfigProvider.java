package ui.utils;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public interface ConfigProvider {
    Config config = readConfig();

    static Config readConfig() {
        return ConfigFactory.load("ui.conf");
    }

    String URL = readConfig().getString("url");
    String PAGE_AGILES = readConfig().getString("page.agiles");
    String PAGE_HUB = readConfig().getString("page.hub");
    String PAGE_PROJECT = readConfig().getString("page.projects");
}
