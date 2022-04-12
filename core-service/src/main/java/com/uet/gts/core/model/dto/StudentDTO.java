package com.uet.gts.core.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.uet.gts.core.model.base.EnumPattern;
import com.uet.gts.core.model.entity.Student;
import com.uet.gts.core.model.vo.Gender;
import com.uet.gts.core.model.vo.GroupType;
import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {

    //===============[ Constructor ]=============================
    public StudentDTO(Student student) {
        this.id          = student.getId();
        this.name        = student.getName();
        this.gender      = student.getGender().getCode();
        this.dateOfBirth = student.getDateOfBirth();
        this.parentName  = student.getParentName();
        this.groupType   = student.getGroupType().toString().toLowerCase();
    }

    //===============[ Converter Method ]=======================
    public Student toEntity(boolean withId) {
        return Student.builder()
                .id(withId ? id : null)
                .name(name)
                .gender(Gender.fromCode(gender))
                .dateOfBirth(dateOfBirth)
                .parentName(parentName)
                .groupType(GroupType.fromValue(groupType))
                .build();
    }

    //===============[ Field Definition ]========================
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private Integer id;

//    @Max(value = 255, message = "Max length of name is 255")
//    @NotEmpty(message = "name is required")
    private String name;

    @EnumPattern(regexp = "male$|female$", message = "gender is must be male or female")
    private String gender;

    @JsonFormat(pattern="yyyy/MM/dd")
//    @Past(message = "dateOfBirth must be past")
    private Date dateOfBirth;

//    @Max(value = 255, message = "Max length of parentName is 255")
//    @NotEmpty(message = "parentName is required")
    private String parentName;

//    @EnumPattern(regexp = "normal$|special$", message = "groupType is must be normal or special")
    private String groupType;
}