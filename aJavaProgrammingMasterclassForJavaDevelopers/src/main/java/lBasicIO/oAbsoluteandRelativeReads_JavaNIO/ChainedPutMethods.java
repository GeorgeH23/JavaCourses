package lBasicIO.oAbsoluteandRelativeReads_JavaNIO;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChainedPutMethods {

    public static void main(String[] args) {

        //READING and WRITING binary file format.
        try(FileOutputStream binfile = new FileOutputStream("data1.dat");
            FileChannel binChannel = binfile.getChannel()) {

            ByteBuffer buffer = ByteBuffer.allocate(100);
            //WRITE to file
            byte[] outputBytes = "Hello World!".getBytes();
            buffer.put(outputBytes);
            buffer.putInt(245);
            buffer.putInt(-696969);
            byte[] outputBytes2 = "Nice to meet you".getBytes();
            buffer.put(outputBytes2);
            buffer.putInt(1000);
            // We can also chain the .put() method like this:
              //   buffer.put(outputBytes).putInt(245).putInt(-696969).put(outputBytes2).putInt(1000);
            // If you don't use .flip() method the buffer position will be set after the last byte in the buffer an nothing will be written to the file
            buffer.flip();

            binChannel.write(buffer);

            RandomAccessFile ra = new RandomAccessFile("data1.dat", "rwd");
            FileChannel channel = ra.getChannel();

            ByteBuffer readBuffer = ByteBuffer.allocate(100);
            channel.read(readBuffer);
            readBuffer.flip();

            byte[] inputString = new byte[outputBytes.length];
            readBuffer.get(inputString);
            System.out.println("inputString = " + new String(inputString));
            System.out.println("int1 = " + readBuffer.getInt());
            System.out.println("int2 = " + readBuffer.getInt());
            byte[] inputString2 = new byte[outputBytes2.length];
            readBuffer.get(inputString2);
            System.out.println("inputString2 = " + new String(inputString2));
            System.out.println("int3 = " + readBuffer.getInt());


        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
