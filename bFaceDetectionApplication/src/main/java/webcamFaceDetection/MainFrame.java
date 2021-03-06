package webcamFaceDetection;

import javax.swing.JFrame;
import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;

public class MainFrame extends JFrame{

	private static final long serialVersionUID = 1L;
	private Detector processor;
	private CameraPanel cameraPanel;
	
	public MainFrame(){
		super("Face Detection");
		
		//System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		nu.pattern.OpenCV.loadLocally();
		
		processor = new Detector();
		cameraPanel = new CameraPanel();
		
		setContentPane(cameraPanel);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(600, 500);
		setVisible(true);
	}
	
	public void displayScreen(){
		
		Mat webcamImage = new Mat();
		VideoCapture videoCapture = new VideoCapture(0);
		
		if (videoCapture.isOpened()) {
			
			while (true) {
				
				videoCapture.retrieve(webcamImage);
				
				if (!webcamImage.empty()) {
					setSize(webcamImage.width() + 50, webcamImage.height() + 70);
					webcamImage = processor.detect(webcamImage);
					cameraPanel.convertMatToImage(webcamImage); 											
					cameraPanel.repaint();
				} else {
					System.out.println("Problem");
					break;
				}
			}
		}
	}
}
