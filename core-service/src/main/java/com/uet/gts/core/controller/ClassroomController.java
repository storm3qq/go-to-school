package com.uet.gts.core.controller;

import com.uet.gts.common.dto.ResponseDTO;
import com.uet.gts.common.dto.core.ClassroomDTO;
import com.uet.gts.common.dto.core.ClassroomMemberDTO;
import com.uet.gts.core.usecase.ClassroomUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Validated
@RequestMapping(path = "/api/v1/classrooms", produces = MediaType.APPLICATION_JSON_VALUE)
public class ClassroomController {

    @Autowired
    private ClassroomUseCase classroomUseCase;

    @GetMapping("")
    public ResponseDTO list() {
        return new ResponseDTO(
                classroomUseCase.findAll()
        );
    }

    @PostMapping("")
    public ResponseDTO create(@RequestBody @Valid ClassroomDTO dto) {
        return new ResponseDTO(
                classroomUseCase.create(dto)
        );
    }

    @PutMapping("/{id}")
    public ResponseDTO addTeacher(@RequestBody @Valid ClassroomMemberDTO dto, @PathVariable("id") Integer classroomId) {
        return new ResponseDTO(
                classroomUseCase.addMembers(dto, classroomId)
        );
    }

    @GetMapping("/{id}")
    public ResponseDTO getById(@PathVariable("id") Integer id) {
        return new ResponseDTO(
                classroomUseCase.getById(id)
        );
    }
}
