package de.realzone.cloud.api;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class DownloadSoftware {

    public static void downloadSoftwareSpigot(String version) {
        try {
            InputStream in = new URL("https://cdn.getbukkit.org/spigot/spigot-" + version + ".jar").openStream();
            Files.copy(in, Paths.get("spigot.jar"), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void downloadSoftwarePaper(String version) {
        if (version.equalsIgnoreCase("1.19")) {
            try {
                InputStream in = new URL("https://api.papermc.io/v2/projects/paper/versions/1.19/builds/66/downloads/paper-1.19-66.jar").openStream();
                Files.copy(in, Paths.get("paper.jar"), StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (version.equalsIgnoreCase("1.18")) {
            try {
                InputStream in = new URL("https://api.papermc.io/v2/projects/paper/versions/1.18.2/builds/387/downloads/paper-1.18.2-387.jar").openStream();
                Files.copy(in, Paths.get("paper.jar"), StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (version.equalsIgnoreCase("1.17")) {
            try {
                InputStream in = new URL("https://api.papermc.io/v2/projects/paper/versions/1.17.1/builds/411/downloads/paper-1.17.1-411.jar").openStream();
                Files.copy(in, Paths.get("paper.jar"), StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (version.equalsIgnoreCase("1.16")) {
            try {
                InputStream in = new URL("https://api.papermc.io/v2/projects/paper/versions/1.16.5/builds/794/downloads/paper-1.16.5-794.jar").openStream();
                Files.copy(in, Paths.get("paper.jar"), StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (version.equalsIgnoreCase("1.15")) {
            try {
                InputStream in = new URL("https://api.papermc.io/v2/projects/paper/versions/1.15.2/builds/393/downloads/paper-1.15.2-393.jar").openStream();
                Files.copy(in, Paths.get("paper.jar"), StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (version.equalsIgnoreCase("1.14")) {
            try {
                InputStream in = new URL("https://api.papermc.io/v2/projects/paper/versions/1.14.4/builds/245/downloads/paper-1.14.4-245.jar").openStream();
                Files.copy(in, Paths.get("paper.jar"), StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (version.equalsIgnoreCase("1.13")) {
            try {
                InputStream in = new URL("https://api.papermc.io/v2/projects/paper/versions/1.13.2/builds/657/downloads/paper-1.13.2-657.jar").openStream();
                Files.copy(in, Paths.get("paper.jar"), StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (version.equalsIgnoreCase("1.12")) {
            try {
                InputStream in = new URL("https://api.papermc.io/v2/projects/paper/versions/1.12.2/builds/1620/downloads/paper-1.12.2-1620.jar").openStream();
                Files.copy(in, Paths.get("paper.jar"), StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (version.equalsIgnoreCase("1.11")) {
            try {
                InputStream in = new URL("https://api.papermc.io/v2/projects/paper/versions/1.11.2/builds/1106/downloads/paper-1.11.2-1106.jar").openStream();
                Files.copy(in, Paths.get("paper.jar"), StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (version.equalsIgnoreCase("1.10")) {
            try {
                InputStream in = new URL("https://api.papermc.io/v2/projects/paper/versions/1.10.2/builds/918/downloads/paper-1.10.2-918.jar").openStream();
                Files.copy(in, Paths.get("paper.jar"), StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (version.equalsIgnoreCase("1.9")) {
            try {
                InputStream in = new URL("https://api.papermc.io/v2/projects/paper/versions/1.9.4/builds/775/downloads/paper-1.9.4-775.jar").openStream();
                Files.copy(in, Paths.get("paper.jar"), StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (version.equalsIgnoreCase("1.8")) {
            try {
                InputStream in = new URL("https://api.papermc.io/v2/projects/paper/versions/1.8.8/builds/445/downloads/paper-1.8.8-445.jar").openStream();
                Files.copy(in, Paths.get("paper.jar"), StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void downloadSoftwareBungeeCord() {
        try {
            InputStream in = new URL("https://api.papermc.io/v2/projects/waterfall/versions/1.19/builds/498/downloads/waterfall-1.19-498.jar").openStream();
            Files.copy(in, Paths.get("waterfall.jar"), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
