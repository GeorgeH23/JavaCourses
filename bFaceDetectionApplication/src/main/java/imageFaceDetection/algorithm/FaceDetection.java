package imageFaceDetection.algorithm;

import imageFaceDetection.facedetection.constants.Constants;
import imageFaceDetection.facedetection.gui.ImagePanel;
import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;
import java.net.URISyntaxException;

public class FaceDetection {

    // the most efficient way of detecting faces
    private CascadeClassifier cascadeClassifier;

    public FaceDetection() {
        //loading the native library
        //System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        //nu.pattern.OpenCV.loadShared();
        nu.pattern.OpenCV.loadLocally();
        File file = null;
        try {
            file = new File(getClass().getResource(Constants.CASCADE_CLASSIFIER).toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        if (file != null) {
            this.cascadeClassifier = new CascadeClassifier(file.getAbsolutePath());
        }
    }

    public void detectFaces(File file, ImagePanel imagePanel) {

        Mat image = Imgcodecs.imread(file.getAbsolutePath(), Imgcodecs.CV_LOAD_IMAGE_COLOR);

        MatOfRect faceDetections = new MatOfRect();
        cascadeClassifier.detectMultiScale(image, faceDetections, 1.2, 3, 10,
                new Size(20, 20), new Size(500, 500));

        System.out.println("Num of faces detected: " + faceDetections.toArray().length);

        for (Rect rect : faceDetections.toArray()) {
            Imgproc.rectangle(image, new Point(rect.x, rect.y), new Point(
                    rect.x + rect.width, rect.y + rect.height), new Scalar(100,
                    100, 250), 10);
        }

        BufferedImage bufImage = convertMatToImage(image);
        imagePanel.updateImage(bufImage);
    }

    public BufferedImage convertMatToImage(Mat mat) {

        int type = BufferedImage.TYPE_BYTE_GRAY;
        if (mat.channels() > 1) {
            type = BufferedImage.TYPE_3BYTE_BGR;
        }

        int bufferSize = mat.channels() * mat.cols() * mat.rows();
        byte[] bytes = new byte[bufferSize];
        mat.get(0, 0, bytes); // get all the pixels
        BufferedImage image = new BufferedImage(mat.cols(), mat.rows(), type);
        final byte[] targetPixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
        System.arraycopy(bytes, 0, targetPixels, 0, bytes.length);
        return image;
    }
}