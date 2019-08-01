package com.ssm.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class StreamResolve {

    final static int BUFFER_SIZE = 4096;

    /**
     * 将输入留转换为byte数组
     * 每次将输入流读取
     * @param in
     * @return
     * @throws IOException
     */
    public static byte[] InputStreamTOByte(InputStream in) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] bytes = new byte[BUFFER_SIZE];

        return outputStream.toByteArray();
    }
}
