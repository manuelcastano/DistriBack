package com.example.distriback.service

import com.example.distriback.model.FileUploaded
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile

@Service
class AppServiceImplementation : AppServiceInterface{

    override fun host(): String {
        return "host"
    }

    override fun uploadFile(file: MultipartFile): List<FileUploaded>? {
        return null
    }

    override fun capacity(): String {
        return "mucho"
    }


}