package com.uet.gts.report.repository;

import com.uet.gts.common.dto.core.ClassroomDTO;
import com.uet.gts.common.dto.core.StudentDTO;
import com.uet.gts.common.dto.core.TeacherDTO;
import com.uet.gts.common.proto.ClassroomProtobuf;

import java.util.List;

public interface ReportRepository {
    List<StudentDTO> findAllStudents();
    List<TeacherDTO> findAllTeachers();
    List<ClassroomDTO> findAllClassrooms();
    List<ClassroomProtobuf> findAllClassroomsAsProtobuf();
}
