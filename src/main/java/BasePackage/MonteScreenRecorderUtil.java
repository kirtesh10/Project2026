package BasePackage;

import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.io.File;

import org.monte.media.Format;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;

import static org.monte.media.FormatKeys.*;
import static org.monte.media.VideoFormatKeys.*;

public class MonteScreenRecorderUtil extends ScreenRecorder {

    private static ScreenRecorder screenRecorder;
    private static String videoName;

    public MonteScreenRecorderUtil(GraphicsConfiguration cfg,
                                   Rectangle captureArea,
                                   Format fileFormat,
                                   Format screenFormat,
                                   Format mouseFormat,
                                   Format audioFormat,
                                   File movieFolder) throws Exception {

        super(cfg, captureArea, fileFormat, screenFormat, mouseFormat, audioFormat, movieFolder);
    }

    @Override
    protected File createMovieFile(Format fileFormat) {
        return new File(getMovieFolder(), videoName + ".avi");
    }

    private String getMovieFolder() {
		// TODO Auto-generated method stub
		return null;
	}

	// 🔹 Start Recording
    public static void startRecording(String testName) throws Exception {
        videoName = testName;

        File file = new File("./test-recordings/");
        if (!file.exists()) {
            file.mkdirs();
        }

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle captureSize = new Rectangle(0, 0,
                screenSize.width, screenSize.height);

        GraphicsConfiguration gc = GraphicsEnvironment
                .getLocalGraphicsEnvironment()
                .getDefaultScreenDevice()
                .getDefaultConfiguration();

        screenRecorder = new MonteScreenRecorderUtil(
                gc,
                captureSize,
                new Format(MediaTypeKey, MediaType.FILE, MimeTypeKey, MIME_AVI),
                new Format(MediaTypeKey, MediaType.VIDEO,
                        EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
                        CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
                        DepthKey, 24,
                        FrameRateKey, Rational.valueOf(15),
                        QualityKey, 1.0f,
                        KeyFrameIntervalKey, 15 * 60),
                new Format(MediaTypeKey, MediaType.VIDEO,
                        EncodingKey, "black",
                        FrameRateKey, Rational.valueOf(30)),
                null,
                file
        );

        screenRecorder.start();
    }

    // 🔹 Stop Recording
    public static void stopRecording() throws Exception {
        if (screenRecorder != null) {
            screenRecorder.stop();
        }
    }
}
