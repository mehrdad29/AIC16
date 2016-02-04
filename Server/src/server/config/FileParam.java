package server.config;

import javax.swing.*;
import java.io.File;

/**
 * Copyright (C) 2016 Hadi
 */
public class FileParam extends Param<File> {
    public FileParam(String paramName, File defaultValue) {
        super(paramName, defaultValue);
    }

    @Override
    public File getValueFromString(String value) {
        File file = new File(value);
        return file.exists() ? file : null;
    }

    @Override
    public File getValueFromUser() {
        File file = null;
        while (file == null) {
            JFileChooser fileChooser = new JFileChooser((String) null);
            fileChooser.showOpenDialog(null);
            file = fileChooser.getSelectedFile();
            if (file == null)
                continue;
            if (!file.exists())
                file = null;
        }
        return file;
    }
}