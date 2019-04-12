package core.savablejfx;

import java.io.Serializable;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Extension of the JavaFX ImageView class to allow for the implementation of
 * the Serialization interface
 */

public class SavableImageView extends ImageView implements Serializable {

    private static final long serialVersionUID = 1L;

    public SavableImageView() {
        super();
    }

    public SavableImageView(Image image) {
        super(image);
    }

    public SavableImageView(String url) {
        super(url);
    }
}