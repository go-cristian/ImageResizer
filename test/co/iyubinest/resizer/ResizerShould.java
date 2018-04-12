package co.iyubinest.resizer;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;
import javax.imageio.ImageIO;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ResizerShould {

  private static final String OUTPUT_IMAGE = "image_2.png";
  private static final String INPUT_IMAGE = "image.png";
  private static final String RESULT_IMAGE = "resized.png";

  @Before public void before() throws IOException {
    deleteFiles();
  }

  @After public void after() throws IOException {
    deleteFiles();
  }

  @Test public void resize() throws IOException {

    Image resized = new CopyOf(
        OUTPUT_IMAGE,
        new ResizeImage(new PathImage(INPUT_IMAGE))
            .resize(100, 100)
    );
    Image result = new PathImage(RESULT_IMAGE);
    assertThat(resized, is(result));
  }

  private void deleteFiles() throws IOException {
    if (Files.exists(Paths.get(OUTPUT_IMAGE))) {
      Files.delete(Paths.get(OUTPUT_IMAGE));
    }
  }
}











