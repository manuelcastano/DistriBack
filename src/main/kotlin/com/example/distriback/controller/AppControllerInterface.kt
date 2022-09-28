package com.example.distriback.controller

import com.example.distriback.model.FileUploaded
import org.springframework.web.multipart.MultipartFile

interface AppControllerInterface {

    fun host(): String
    fun uploadFile(file: MultipartFile): List<FileUploaded>?
    fun capacity(): String
}