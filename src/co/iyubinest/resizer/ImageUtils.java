package co.iyubinest.resizer;

import java.awt.image.BufferedImage;

final class ImageUtils {

  private ImageUtils() {
    throw new RuntimeException("No instances");
  }

  static boolean compare(BufferedImage a, BufferedImage b) {
    int sizeA = a.getData().getDataBuffer().getSize();
    int sizeB = b.getData().getDataBuffer().getSize();
    if (sizeA == sizeB) {
      for (int i = 0; i < sizeA; i++) {
        if (a.getData().getDataBuffer().getElem(i) != b.getData().getDataBuffer().getElem(i)) {
          return false;
        }
      }
      return true;
    } else {
      return false;
    }
  }
}