package backend.face;

import UI.LayerData;
import org.opencv.core.Mat;
import org.opencv.core.Rect;

/**
 * Created by Akihiro on 2017/03/01.
 */
public class LeftEyebrows extends Part {
    public LeftEyebrows(LayerData data, Mat image, Rect rect){
        super(data, image, rect);
    }
}