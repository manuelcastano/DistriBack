package com.example.distriback.service

import com.example.distriback.entity.Filex
import com.example.distriback.model.FileUploaded
import com.example.distriback.repository.FileRepo
import com.microsoft.azure.storage.CloudStorageAccount
import com.microsoft.azure.storage.blob.CloudBlob
import com.microsoft.azure.storage.blob.CloudBlobClient
import com.microsoft.azure.storage.blob.CloudBlobContainer
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile

@Service
class AppServiceImplementation(val fileRepo: FileRepo) : AppServiceInterface{

    override fun host(): String {
        return "host"
    }

    override fun uploadFile(file: MultipartFile): List<FileUploaded>? {
        var storageConnectionAzure = "DefaultEndpointsProtocol=https;AccountName=manuel12;AccountKey=2y5QWWc2UBQhK9k9QLLJqj/Gkfitk5g+29EuTAFwgUKj+mG1UC6ysjbBzz7kK1shlNrVWXK9oBGd+AStF7X9oQ==;EndpointSuffix=core.windows.net"
        var nameContainer = "files"
        try{
            var account: CloudStorageAccount = CloudStorageAccount.parse(storageConnectionAzure)
            var serviceClient : CloudBlobClient = account.createCloudBlobClient()
            var container : CloudBlobContainer = serviceClient.getContainerReference(nameContainer)
            var blob : CloudBlob = container.getBlockBlobReference(file.name)
            blob.upload(file.inputStream, file.size)

            var filex = Filex(0, file.name, "https://manuel12.blob.core.windows.net/files/"+file.name, file.contentType!!)
            fileRepo.save(filex)
        } catch(e: Exception){
            println(e.message)
        }
        return fileRepo.findAll() as List<FileUploaded>
    }

    override fun capacity(): String {
        return "mucho"
    }

    override fun getFiles(): List<FileUploaded>? {
        return null
    }
}