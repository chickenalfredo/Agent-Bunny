package core.component;

import java.io.Serializable;
import java.util.ArrayList;

import core.component.Component;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class AnimationComponent implements Component, Serializable {

    private ArrayList<Image> m_images = new ArrayList<Image>();
    private ArrayList<ImageView> m_imageViews = new ArrayList<ImageView>();
    private static final long serialVersionUID = 1L;

    /**
     * @param m_imageViews the m_imageViews to set
     */
    public void setImageViews(ImageView... imageViews) {
        for (ImageView i : imageViews) {
            m_imageViews.add(i);
        }
    }

    /**
     * @param m_images the m_images to set
     */
    public void setImages(Image... images) {
        for (Image i : images) {
            m_images.add(i);
        }
    }

}