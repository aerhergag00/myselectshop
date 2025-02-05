package org.example.rmrdo.myselectshop.dto;

import lombok.Getter;
import org.example.rmrdo.myselectshop.entity.Folder;

@Getter
public class FolderResponseDto {
    private Long   id;
    private String name;

    public FolderResponseDto(Folder folder) {
        this.id = folder.getId();
        this.name = folder.getName();
    }
}
