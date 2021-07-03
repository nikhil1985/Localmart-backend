package com.localmart.image.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Component;

import com.localmart.image.ImageCompression;
import com.localmart.image.ImageSource;

@Component
public class JpgImageCompression implements ImageCompression {

	@Override
	public void compress(ImageSource imageSource, String imageName, String imagesPathAsString) {
		try {
			Path imagesPath = Files.createDirectories(Paths.get(imagesPathAsString));
			String compressedImageFileName = imageName + "." + JpgImage.EXTENSION;
			File compressedImageFile = imagesPath.resolve(compressedImageFileName).toFile();

			File imageSourceFile = imageSource.asFile();

			new JpgImage(imageSourceFile, new SquareCompressed(100)).compressTo(compressedImageFile);

			imageSourceFile.delete();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
