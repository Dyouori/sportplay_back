package com.deyunjiaoyu.sportplay.utils;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.encoder.ByteMatrix;
import com.google.zxing.qrcode.encoder.Encoder;
import com.google.zxing.qrcode.encoder.QRCode;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.Base64;
import java.util.Hashtable;
import java.util.Map;

public class BarCodeUtils {


    /** 获取图片的base64
     * @param bufferedImage bufferedImage
     * @return String
     */
    public static String getImage2Base64String(BufferedImage bufferedImage) {
        if (bufferedImage == null) {
            return null;
        } else {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();

            try {
                ImageIO.write(bufferedImage, "png", bos);
                byte[] imageBytes = bos.toByteArray();
                return Base64.getEncoder().encodeToString(imageBytes);
            } catch (Exception var13) {
                var13.printStackTrace();
            } finally {
                try {
                    bos.close();
                } catch (Exception var12) {
                    var12.printStackTrace();
                }

            }

            return null;
        }
    }

    public static BufferedImage generateBarcodeWithoutWhite(String content, Color color) {
        return generateBarcodeWithoutWhite(content, 100, 100, color);
    }

    /**
     * @param content 二维码内容
     * @param width 二维码图片宽
     * @param height 二维码图片高
     * @param color 二维码图片颜色
     * @return  BufferedImage
     */
    private static BufferedImage generateBarcodeWithoutWhite(String content, int width, int height, Color color) {
        try {
            Hashtable<EncodeHintType, Object> hints = new Hashtable<>();
            hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
            hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
            hints.put(EncodeHintType.MARGIN, 0);
            BitMatrix matrix = encode(content, BarcodeFormat.QR_CODE, width, height, hints);
            width = matrix.getWidth();
            height = matrix.getHeight();
            if (color == null) {
                color = Color.BLACK;
            }

            int[] pixels = new int[width * height];

            for(int y = 0; y < height; ++y) {
                for(int x = 0; x < width; ++x) {
                    if (matrix.get(x, y)) {
                        pixels[y * width + x] = color.getRGB();
                    } else {
                        pixels[y * width + x] = Color.WHITE.getRGB();
                    }
                }
            }

            BufferedImage image = new BufferedImage(width, height, 1);
            image.getRaster().setDataElements(0, 0, width, height, pixels);
            return image;
        } catch (Exception var9) {
            return null;
        }
    }

    private static BitMatrix encode(String contents, BarcodeFormat format, int width, int height, Map<EncodeHintType, ?> hints) throws WriterException {
        if (contents.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        } else if (format != BarcodeFormat.QR_CODE) {
            throw new IllegalArgumentException("Can only encode QR_CODE, but got ".concat(String.valueOf(format)));
        } else if (width >= 0 && height >= 0) {
            ErrorCorrectionLevel errorCorrectionLevel = ErrorCorrectionLevel.L;
            int quietZone = 4;
            if (hints != null) {
                if (hints.containsKey(EncodeHintType.ERROR_CORRECTION)) {
                    errorCorrectionLevel = ErrorCorrectionLevel.valueOf(hints.get(EncodeHintType.ERROR_CORRECTION).toString());
                }

                if (hints.containsKey(EncodeHintType.MARGIN)) {
                    quietZone = Integer.parseInt(hints.get(EncodeHintType.MARGIN).toString());
                }
            }

            return renderResult(Encoder.encode(contents, errorCorrectionLevel, hints), width, height, quietZone);
        } else {
            throw new IllegalArgumentException("Requested dimensions are too small: " + width + 'x' + height);
        }
    }

    /** 渲染结果
     * @param code 二维码
     * @param width 二维码宽
     * @param height 二维码高
     * @param quietZone
     * @return BitMatrix
     */
    private static BitMatrix renderResult(QRCode code, int width, int height, int quietZone) {
        ByteMatrix input = code.getMatrix();
        if (input == null) {
            throw new IllegalStateException();
        } else {
            int inputWidth = input.getWidth();
            int inputHeight = input.getHeight();
            int qrWidth = inputWidth + quietZone * 2;
            int qrHeight = inputHeight + quietZone * 2;
            int minSize = Math.min(width, height);
            int scale = calculateScale(qrWidth, minSize);
            int outputWidth;
            int tmpValue;
            if (scale > 0) {
                outputWidth = (minSize - qrWidth * scale) / 4 * quietZone;
                tmpValue = qrWidth * scale + outputWidth;
                if (width == height) {
                    width = tmpValue;
                    height = tmpValue;
                } else if (width > height) {
                    width = width * tmpValue / height;
                    height = tmpValue;
                } else {
                    height = height * tmpValue / width;
                    width = tmpValue;
                }
            }

            outputWidth = Math.max(width, qrWidth);
            tmpValue = Math.max(height, qrHeight);
            int multiple = Math.min(outputWidth / qrWidth, tmpValue / qrHeight);
            int leftPadding = (outputWidth - inputWidth * multiple) / 2;
            int topPadding = (tmpValue - inputHeight * multiple) / 2;
            BitMatrix output = new BitMatrix(outputWidth, tmpValue);
            int inputY = 0;

            for(int outputY = topPadding; inputY < inputHeight; outputY += multiple) {
                int inputX = 0;

                for(int outputX = leftPadding; inputX < inputWidth; outputX += multiple) {
                    if (input.get(inputX, inputY) == 1) {
                        output.setRegion(outputX, outputY, multiple, multiple);
                    }

                    ++inputX;
                }

                ++inputY;
            }

            return output;
        }
    }

    /** 计算比例
     * @param qrCodeSize 二维码大小
     * @param expectSize 期望大小
     * @return int
     */
    private static int calculateScale(int qrCodeSize, int expectSize) {
        if (qrCodeSize >= expectSize) {
            return 0;
        } else {
            int scale = expectSize / qrCodeSize;
            int abs = expectSize - scale * qrCodeSize;
            return (double)abs < (double)expectSize * 0.02D ? 0 : scale;
        }
    }

}
