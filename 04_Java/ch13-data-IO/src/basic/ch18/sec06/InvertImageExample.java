package basic.ch18.sec06;

// 색상 반전

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class InvertImageExample {
  public static void main(String[] args) throws IOException {

    // 이미지 경로
    String source = "resource/pixel-art.png";
    String destination = "resource/pixel-art-invert.png";  // 색상 반전 이미지 저장할 경로

    BufferedImage original = ImageIO.read(new File(source));  // local file 읽어와 buffer 형태로 변환

    int width = original.getWidth();
    int height = original.getHeight();

    // 색상 반전 이미지 크기 지정
    BufferedImage inverted = new BufferedImage(width, height, original.getType());

    System.out.println(original.getRGB(400, 400));

    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        // alpha: 투명도
        int argb = original.getRGB(x, y);  // 해당 픽셀의 색상을 32비트 정수(ARGB)로 변환
        // argb = [AA|RR|GG|BB] 형태

        // 색상 반전
        int a = (argb >> 24) & 0xFF;
        int r = 255 - ((argb >> 16) & 0xFF);
        int g = 255 - ((argb >> 8) & 0xFF);
        int b = 255 - (argb & 0xFF);

        inverted.setRGB(x,y, (a << 24) | (r << 16) | (g << 8) | b);  // bit 재조합
      }
    }

    // 색상 반전 이미지 png 포맷으로 저장
    ImageIO.write(inverted, "png", new File(destination));
  }
}
