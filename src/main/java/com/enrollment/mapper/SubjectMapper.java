package com.enrollment.mapper;

import com.enrollment.dto.SubjectDto;
import com.enrollment.entity.Subject;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SubjectMapper {
    SubjectDto subjectToDto(Subject subject);

    Subject subject(SubjectDto subjectDto);
}
