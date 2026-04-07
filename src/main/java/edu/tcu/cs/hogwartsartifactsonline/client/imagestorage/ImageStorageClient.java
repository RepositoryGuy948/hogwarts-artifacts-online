package edu.tcu.cs.hogwartsartifactsonline.client.imagestorage;

import java.io.InputStream;

public interface ImageStorageClient {

    String uploadImage(String containerName, String fileName, InputStream inputStream, long size);

}
