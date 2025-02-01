package com.example.dislacfle.domain.workSpace.controller;

import com.example.dislacfle.domain.workSpace.entity.dto.WorkSpaceDTO;
import com.example.dislacfle.domain.workSpace.service.WorkSpaceService;
import com.example.dislacfle.global.common.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/v1/workspaces")
@RestController
public class WorkSpaceController {
    private final WorkSpaceService workSpaceService;

    @PostMapping
    public ResponseEntity<ApiResponse<Long>> createWorkSpace(@RequestBody WorkSpaceDTO workSpaceDTO) {
        Long workSpaceId = workSpaceService.createWorkSpace(workSpaceDTO);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ApiResponse.success("WorkSpace created successfully", workSpaceId));
    }
}
