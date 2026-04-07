package edu.tcu.cs.hogwartsartifactsonline.client.imagestorage;

import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobServiceClient;
import edu.tcu.cs.hogwartsartifactsonline.system.exception.CustomBlobStorageException;
import org.springframework.stereotype.Component;

import java.io.InputStream;

@Component
public class AzureBlobImageStorageClient implements ImageStorageClient {

    private final BlobServiceClient blobServiceClient;

    public AzureBlobImageStorageClient(BlobServiceClient blobServiceClient) {
        this.blobServiceClient = blobServiceClient;
    }

    @Override
    public String uploadImage(String containerName, String fileName, InputStream inputStream, long size) {
        try {
            BlobContainerClient containerClient = this.blobServiceClient.getBlobContainerClient(containerName);
            BlobClient blobClient = containerClient.getBlobClient(fileName);
            blobClient.upload(inputStream, size, true);
            return blobClient.getBlobUrl();
        } catch (Exception e) {
            throw new CustomBlobStorageException("Failed to upload image to Azure Blob Storage.", e);
        }
    }

}
