package phoenixit.education.components;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import phoenixit.education.models.ClassInfo;
import phoenixit.education.models.ClassNode;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ClassMapper {

    @Mapping(source = "mongoId", target = "classMongoId")
    @Mapping(source = "title", target = "classTitle")
    ClassInfo toInfo(ClassNode classNode);
}
