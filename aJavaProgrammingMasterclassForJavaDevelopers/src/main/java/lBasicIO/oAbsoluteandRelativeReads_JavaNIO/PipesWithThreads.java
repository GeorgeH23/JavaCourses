package lBasicIO.oAbsoluteandRelativeReads_JavaNIO;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PipesWithThreads {

    public static void main(String[] args) {

        try {
            Pipe pipe = Pipe.open();

            Runnable writer = new Runnable() {
                @Override
                public void run() {
                    try {
                        Pipe.SinkChannel sinkChannel = pipe.sink();
                        ByteBuffer buffer = ByteBuffer.allocate(56);

                        for (int i = 0; i < 10; i++) {
                            String currentTime = "The time is: " + System.currentTimeMillis();

                            buffer.put(currentTime.getBytes());
                            buffer.flip();

                            while (buffer.hasRemaining()) {
                                sinkChannel.write(buffer);
                            }
                            buffer.flip();
                            Thread.sleep(1000);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };

            Runnable reader = new Runnable() {
                @Override
                public void run() {
                    try {
                        Pipe.SourceChannel sourceChannel = pipe.source();
                        ByteBuffer buffer = ByteBuffer.allocate(56);

                        for (int i = 0; i < 10; i++) {
                            int bytesRead = sourceChannel.read(buffer);
                            byte[] timeString = new byte[bytesRead];
                            buffer.flip();
                            buffer.get(timeString);
                            System.out.println("Reader Thread: " + new String(timeString));

                            char[] strChr = new String(timeString).toCharArray();
                            StringBuilder sb = new StringBuilder();
                            for (char chr : strChr){
                                if (chr >= '0' && chr <= '9'){
                                    sb.append(chr);
                                }
                            }
                            long dtf = Long.parseLong(sb.toString());
                            System.out.println(DateFormat.getTimeInstance().format(new Date(dtf)));

                            buffer.flip();
                            Thread.sleep(1000);
                        }
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                }
            };

            new Thread(writer).start();
            new Thread(reader).start();

        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
