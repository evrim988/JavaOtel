package org.example.javaotel.mapper;

import org.example.javaotel.dto.request.CreateAdminRequestDto;
import org.example.javaotel.entity.Admin;
import org.mapstruct.Mapper;

import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AdminMapper {

    AdminMapper INSTANCE = Mappers.getMapper(AdminMapper.class);

    Admin fromCreateAdminRequestDto(final CreateAdminRequestDto dto);
}
