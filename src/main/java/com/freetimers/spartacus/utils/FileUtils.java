package com.freetimers.spartacus.utils;

import com.freetimers.spartacus.game.CoreGame;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Base64;

public class FileUtils {
    private static final FileUtils INSTANCE = new FileUtils();
    public static final Logger LOG = LoggerFactory.getLogger(CoreGame.class);

    private FileUtils() {
    }

    public static FileUtils getInstance() {
        return INSTANCE;
    }

    public String getBase64encodedFile(String path) {
        try {
            byte[] defaultAvatar = this.getClass().getClassLoader().getResourceAsStream(path).
                    readAllBytes();
            return Base64.getEncoder().encodeToString(defaultAvatar);
        } catch (IOException e) {
            LOG.error("Failed to get default avatar", e);
            return "";
        }
    }
}
