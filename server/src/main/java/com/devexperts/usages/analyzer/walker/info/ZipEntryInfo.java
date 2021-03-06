/**
 * Copyright (C) 2017 Devexperts LLC
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 */
package com.devexperts.usages.analyzer.walker.info;

import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ZipEntryInfo extends FileInfoBase {

    /**
     * Full path of zip entry, for example "./usages.zip!org/log4j.usages"
     */
    private final String fullPath;

    private final ZipFile zipFile;

    private final ZipEntry zipEntry;

    public ZipEntryInfo(String fullPath, ZipFile zipFile, ZipEntry zipEntry) {
        this.fullPath = fullPath;
        this.zipFile = zipFile;
        this.zipEntry = zipEntry;
    }

    @Override
    public String getName() {
        return zipEntry.getName();
    }

    @Override
    public String getPath() {
        return fullPath;
    }

    public InputStream openInputStream() throws IOException {
        return zipFile.getInputStream(zipEntry);
    }
}
