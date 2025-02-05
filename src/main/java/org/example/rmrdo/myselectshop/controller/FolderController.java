package org.example.rmrdo.myselectshop.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.rmrdo.myselectshop.dto.FolderRequestDto;
import org.example.rmrdo.myselectshop.dto.FolderResponseDto;
import org.example.rmrdo.myselectshop.security.UserDetailsImpl;
import org.example.rmrdo.myselectshop.service.FolderService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class FolderController {

    private final FolderService folderService;

    @PostMapping("/folders")
    public void addFolders(
            @RequestBody FolderRequestDto folderRequestDto,
            @AuthenticationPrincipal UserDetailsImpl userDetails
    ) {

        List<String> folderNames = folderRequestDto.getFolderNames();

        folderService.addFolders(folderNames, userDetails.getUser());
    }

    @GetMapping("/folders")
    public List<FolderResponseDto> getFolders(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        return folderService.getFolders(userDetails.getUser());
    }
}
