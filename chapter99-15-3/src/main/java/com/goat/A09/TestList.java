package com.goat.A09;

import org.junit.Test;

import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Created by 64274 on 2019/5/22.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/5/22---14:55
 */

public class TestList {


    @Test
    public void test2() throws IOException {

        FileChannel infchannel= FileChannel.open(
                Paths.get("H:\\java\\nio\\Java NIO.pdf"), StandardOpenOption.READ);

        FileChannel outchannle=FileChannel.open(
                Paths.get("H:\\java\\nio\\Java NIOs.pdf"), StandardOpenOption.READ,StandardOpenOption.WRITE, StandardOpenOption.CREATE);

        infchannel.transferFrom(outchannle, 0, infchannel.size());
        infchannel.close();
        outchannle.close();
    }

}