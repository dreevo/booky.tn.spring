package tn.booky.corp.tensor.services;

import tn.booky.corp.tensor.model.*;
import tn.booky.corp.tensor.utils.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.tensorflow.Tensor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ObjectDetector class to detect objects using pre-trained models with TensorFlow Java API.
 */
@Service
public class ObjectDetector {
    private final static Logger LOGGER = LoggerFactory.getLogger(ObjectDetector.class);
    //private TensorProperties applicationProperties;

//    @Autowired
//    public ObjectDetector(final TensorProperties applicationProperties) {
//        //this.applicationProperties = applicationProperties;
//        try {
//            IOUtil.readAllBytesOrExit(applicationProperties.getGraph());
//            IOUtil.readAllLinesOrExit(applicationProperties.getLabel());
//        } catch (ServiceException ex) {
//            LOGGER.error("Download one of my graph file to run the program! \n" +
//                    "You can find my graphs here: https://drive.google.com/open?id=1GfS1Yle7Xari1tRUEi2EDYedFteAOaoN");
//        }
//    }

    /**
     * Detect objects on the given image
     * @param imageLocation the location of the image
     * @return a map with location of the labeled image and recognitions
     */
    public Map<String, Object> detect(final String imageLocation) {
        byte[] image = IOUtil.readAllBytesOrExit(imageLocation);
        try (Tensor<Float> normalizedImage = normalizeImage(image)) {
            List<Recognition> recognitions = new ArrayList<Recognition>();
            printToConsole(recognitions);
            String labeledFilePath="";
            Map<String, Object> result = new HashMap<String, Object>();
            result.put("labeledFilePath", labeledFilePath);
            result.put("recognitions", recognitions);
            return result;
        }
    }

    /**
     * Pre-process input. It resize the image and normalize its pixels
     * @param imageBytes Input image
     * @return Tensor<Float> with shape [1][416][416][3]
     */

    private Tensor<Float> normalizeImage(byte[] image) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
     * Prints out the recognize objects and its confidence
     * @param recognitions list of recognitions
     */
    private void printToConsole(final List<Recognition> recognitions) {
        for (Recognition recognition : recognitions) {
            LOGGER.info("Object: {} - confidence: {}", recognition.getTitle(), recognition.getConfidence());
        }
    }
}
