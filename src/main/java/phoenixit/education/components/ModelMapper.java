package phoenixit.education.components;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import phoenixit.education.models.ModelCard;
import phoenixit.education.models.ModelNode;
import phoenixit.education.models.ModelResponse;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ModelMapper {

    @Mapping(source = "id", target = "mongoId")
    @Mapping(source = "name", target = "title")
    @Mapping(target = "id", ignore = true)
    ModelNode responseToNode(ModelResponse modelResponse);

    ModelCard responseToCard(ModelResponse modelNode);
}
