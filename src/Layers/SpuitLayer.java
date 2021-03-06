package Layers;

import UI.PickedColorUI;
import UI.UIValues;
import javafx.scene.Cursor;
import javafx.scene.image.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.nio.IntBuffer;

/**
 * Created by takai on 17/04/01.
 */
public class SpuitLayer extends Layer {

    private PickedColorUI ref;

    public SpuitLayer(SystemLayers systemLayers, double width, double height, PickedColorUI pickedColorUI){
        super(width, height);
        ref = pickedColorUI;

        this.canvas.setOnMouseClicked(event -> {

            Image img;
            if((img = systemLayers.getImageLayer().getImage()) != null) {


                int x = (int) (event.getX() * systemLayers.getImageLayer().getBairitsu());
                int y = (int) (event.getY() * systemLayers.getImageLayer().getBairitsu());

                //ピクセル配列取得
                WritablePixelFormat<IntBuffer> format = WritablePixelFormat.getIntArgbInstance();
                int[] pixels = new int[(int) width * (int) height];
                img.getPixelReader().getPixels(0, 0, (int) width, (int) height, format, pixels, 0, (int) width);

                //ピクセルを取得
                int index = (y * (int) width) + x;
                int pixel = pixels[index];

                int r = ((pixel >> 16) & 0xFF);

                int g = ((pixel >> 8) & 0xFF);

                int b = (pixel & 0xFF);

                ref.updateColor(Color.color((double) r / 255.0, (double) g / 255.0, (double) b / 255.0));

            }else{
                ref.updateColor(Color.WHITE);
            }

            this.canvas.toBack();
        });

        canvas.setCursor(Cursor.CROSSHAIR);
    }

    public void setRef(PickedColorUI ref) {
        this.ref = ref;
    }
}
