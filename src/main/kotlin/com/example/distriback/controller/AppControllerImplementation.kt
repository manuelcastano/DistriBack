package com.example.distriback.controller

import com.example.distriback.model.FileUploaded
import com.example.distriback.service.AppServiceInterface
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

@RestController
class AppControllerImplementation(val appService: AppServiceInterface) : AppControllerInterface{

    @GetMapping("/host")
    override fun host(): String {
        return appService.host()
    }

    @PostMapping("/uploadFile")
    override fun uploadFile(@RequestParam("file") file: MultipartFile): List<FileUploaded>? {
        return appService.uploadFile(file)
    }

    @GetMapping("/capacity")
    override fun capacity(): String {
        return appService.capacity()
    }
}