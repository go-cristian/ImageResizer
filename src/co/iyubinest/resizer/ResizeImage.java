package co.iyubinest.resizer;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

final class ResizeImage implements Image {

  private final Image image;

  ResizeImage(Image image) {
    this.image = image;
  }

  public Image resize(int width, int height) throws IOException {
    BufferedImage resized = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
    Graphics2D canvas = resized.createGraphics();
    canvas.drawImage(image.data(), 0, 0, width, height, null);
    canvas.dispose();
    return new DataImage(resized);
  }

  @Override public BufferedImage data() {
    return image.data();
  }

  @Override public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Image)) return false;
    Image that = (Image) o;
    return ImageUtils.compare(data(), that.data());
  }

  @Override public int hashCode() {
    return Objects.hash(image.data());
  }

  @Override public String toString() {
    return image.data().toString();
  }
}