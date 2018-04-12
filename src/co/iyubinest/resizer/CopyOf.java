package co.iyubinest.resizer;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;
import javax.imageio.ImageIO;

final class CopyOf implements Image {

  private final Image image;

  CopyOf(String path, Image image) throws IOException {
    copyToPath(path, image.data());
    this.image = new PathImage(path);
  }

  @Override public BufferedImage data() {
    return image.data();
  }

  private void copyToPath(String path, BufferedImage data) throws IOException {
    ImageIO.write(data, "png", new File(path));
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