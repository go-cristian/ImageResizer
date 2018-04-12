package co.iyubinest.resizer;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;
import javax.imageio.ImageIO;

final class PathImage implements Image {
  private final DataImage image;

  PathImage(String path) throws IOException {
    image = new DataImage(ImageIO.read(new File(path)));
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