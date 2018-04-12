package co.iyubinest.resizer;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

final class DataImage implements Image {

  private final BufferedImage data;

  DataImage(BufferedImage data) throws IOException {
    this.data = data;
  }

  @Override public BufferedImage data() {
    return data;
  }

  @Override public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Image)) return false;
    Image that = (Image) o;
    return ImageUtils.compare(data(), that.data());
  }

  @Override public int hashCode() {
    return Objects.hash(data);
  }

  @Override public String toString() {
    return data.toString();
  }
}