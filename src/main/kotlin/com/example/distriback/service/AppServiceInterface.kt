package com.example.distriback.service

import com.example.distriback.model.FileUploaded
import org.springframework.web.multipart.MultipartFile

interface AppServiceInterface {

    fun host(): String
    fun uploadFile(file: MultipartFile): List<FileUploaded>?
    fun capacity(): String
    fun getFiles(): List<FileUploaded>?
}