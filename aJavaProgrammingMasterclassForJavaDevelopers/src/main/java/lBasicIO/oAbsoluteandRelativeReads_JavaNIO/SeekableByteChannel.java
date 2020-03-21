package lBasicIO.oAbsoluteandRelativeReads_JavaNIO;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class SeekableByteChannel {

    public static void main(String[] args) {
//  Seekable Byte Channel most used methods: -->>
//            read(ByteBuffer) - reads bytes beginning at the channel's current position, and after the read,
//                               updates the position accordingly.
//                               Note that now we're talking about the channel's position, not the byte buffer's position.
//                               Of course, the bytes will be placed into the buffer starting at its current position.
//            write(ByteBuffer) - the same as read, except it writes. There's one exception.
//                              If a datasource is opened in APPEND mode, then the first write will take place starting
//                              at the end of the datasource, rather than at position 0. After the write, the position
//                              will be updated accordingly.
//            position() - returns the channel's position.
//            position(long) - sets the channel's position to the passed value.
//            truncate(long) - truncates the size of the attached datasource to the passed value.
//            size() - returns the size of the attached datasource

        try(FileOutputStream binfile = new FileOutputStream("data2.dat");
            FileChannel binChannel = binfile.getChannel();
            FileOutputStream binfile1 = new FileOutputStream("data3.dat");
            FileChannel binChannel1 = binfile1.getChannel()){

            ByteBuffer buffer = ByteBuffer.allocate(100);
            //WRITE to file
            byte[] outputBytes = "Hello World!".getBytes();
            buffer.put(outputBytes);
            long int1Pos = outputBytes.length;
            buffer.putInt(245);
            long int2Pos = int1Pos + Integer.BYTES;
            buffer.putInt(-696969);
            byte[] outputBytes2 = "Nice to meet you".getBytes();
            buffer.put(outputBytes2);
            long int3Pos = int2Pos + Integer.BYTES + outputBytes2.length;
            buffer.putInt(1000);
            // If you don't use .flip() method the buffer position will be set after the last byte in the buffer an nothing will be written to the file
            buffer.flip();

            binChannel.write(buffer);

            RandomAccessFile ra = new RandomAccessFile("data2.dat", "rwd");
            FileChannel channel = ra.getChannel();

            ByteBuffer readBuffer = ByteBuffer.allocate(Integer.BYTES);
            channel.position(int3Pos);
            channel.read(readBuffer);
            readBuffer.flip();
            System.out.println("int 3 = " + readBuffer.getInt());

            readBuffer.flip();
            channel.position(int2Pos);
            channel.read(readBuffer);
            readBuffer.flip();
            System.out.println("int 2 = " + readBuffer.getInt());

            readBuffer.flip();
            channel.position(int1Pos);
            channel.read(readBuffer);
            readBuffer.flip();
            System.out.println("int 1 = " + readBuffer.getInt());

            // Using the FileChannel to copy one file to another file
            RandomAccessFile copyFile = new RandomAccessFile("datacopy.dat", "rw");
            FileChannel copyChannel = copyFile.getChannel();
            long numTransferred = copyChannel.transferFrom(channel, 0, channel.size());
            System.out.println("Num transferred = " + numTransferred);

            channel.close();
            ra.close();
            copyChannel.close();


            RandomAccessFile raf = new RandomAccessFile("data3.dat", "rwd");
            FileChannel channel2 = raf.getChannel();

            byte[] outputString = "Hello, World!".getBytes();
            long str1Pos = 0;
            long newInt1Pos = outputString.length;
            long newInt2Pos = newInt1Pos + Integer.BYTES;
            byte[] outputString2 = "nice to meet you".getBytes();
            long str2Pos = newInt2Pos + Integer.BYTES;
            long newInt3Pos = str2Pos + outputString2.length;

            ByteBuffer intBuffer = ByteBuffer.allocate(Integer.BYTES);
            intBuffer.putInt(245);
            intBuffer.flip();
            binChannel1.position(newInt1Pos);
            binChannel1.write(intBuffer);

            intBuffer.flip();
            intBuffer.putInt(-98765);
            intBuffer.flip();
            binChannel1.position(newInt2Pos);
            binChannel1.write(intBuffer);

            intBuffer.flip();
            intBuffer.putInt(2000);
            intBuffer.flip();
            binChannel1.position(newInt3Pos);
            binChannel1.write(intBuffer);

            binChannel1.position(str1Pos);
            binChannel1.write(ByteBuffer.wrap(outputString));
            binChannel1.position(str2Pos);
            binChannel1.write(ByteBuffer.wrap(outputString2));

        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
