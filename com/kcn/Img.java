package com.kcn;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Img {
    private final ClassLoader classLoader = this.getClass().getClassLoader();
    private final InputStream appUrl = classLoader.getResourceAsStream("com/kcn/img.png");

    private void write(OutputStream stream) throws IOException {
        byte[] bytes = new byte[1024];
        int len;
        while ((len = appUrl.read(bytes)) != -1) {
            stream.write(bytes, 0, len);
        }
    }

    public void newWrite(OutputStream stream) {
        try {
            write(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            appUrl.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
