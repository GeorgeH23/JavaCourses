package lBasicIO.nReadingAndWritingWithJavaNIO;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        //READING and WRITING text file format.
        try {
            /*FileInputStream file = new FileInputStream("data.txt");
            FileChannel channel = file.getChannel();*/

            Path dataPath = FileSystems.getDefault().getPath("data.txt");
            //WRITE to file
            Files.write(dataPath, "\nLine5".getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
            //READ from file
            List<String> lines = Files.readAllLines(dataPath);

            for (String line : lines) {
                System.out.println(line);
            }

        } catch (IOException e){
            System.out.println(e.getMessage());
        }

        //READING and WRITING binary file format.
        try(FileOutputStream binfile = new FileOutputStream("data.dat");
            FileChannel binChannel = binfile.getChannel()) {

            //WRITE to file
            byte[] outputBytes = "Hello World!".getBytes();
            // the ByteBuffer.wrap() method resets the buffer position to 0 when is called
            ByteBuffer buffer = ByteBuffer.wrap(outputBytes);
            int numBytes = binChannel.write(buffer);
            System.out.println("numBytes written was: " + numBytes);

            ByteBuffer intBuffer = ByteBuffer.allocate(Integer.BYTES);
            intBuffer.putInt(245);
            // the binChannel.write() method doesn't reset the buffer position to 0 when is called. It must be done manually by using intBuffer.flip() method
            intBuffer.flip();
            numBytes = binChannel.write(intBuffer);
            System.out.println("numBytes written was: " + numBytes);

            intBuffer.flip();
            intBuffer.putInt(-987);
            intBuffer.flip();
            numBytes = binChannel.write(intBuffer);
            System.out.println("numBytes written was: " + numBytes);

            //Read the file using Java IO
            RandomAccessFile ra = new RandomAccessFile("data.dat", "rwd");
            byte[] bytes = new byte[outputBytes.length];
            ra.read(bytes);
            System.out.println(new String(bytes));

            long int1 = ra.readInt();
            long int2 = ra.readInt();
            System.out.println(int1);
            System.out.println(int2);

            //Read the file using Java NIO
            RandomAccessFile randomAccessFile = new RandomAccessFile("data.dat", "rwd");
            FileChannel channel = randomAccessFile.getChannel();
            outputBytes[0] = 'a';
            outputBytes[1] = 'b';
            buffer.flip();
            long numBytesRead = channel.read(buffer);
            //First method to read
            System.out.println("outputBytes = " + new String(outputBytes));
            //Second method to read
            if (buffer.hasArray()) {
                System.out.println("byte buffer = " + new String(buffer.array()));
            }

            // Absolute read
            intBuffer.flip();
            numBytesRead = channel.read(intBuffer);
            System.out.println(intBuffer.getInt(0));
            intBuffer.flip();
            numBytesRead = channel.read(intBuffer);
            System.out.println(intBuffer.getInt(0));

            // Relative read
            //            intBuffer.flip();
            //            numBytesRead = channel.read(intBuffer);
            //            intBuffer.flip();
            //            System.out.println(intBuffer.getInt());
            //            intBuffer.flip();
            //            numBytesRead = channel.read(intBuffer);
            //            intBuffer.flip();
            //            System.out.println(intBuffer.getInt());

            channel.close();
            randomAccessFile.close();
            ra.close();

        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
