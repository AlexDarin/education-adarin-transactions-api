package phoenixit.education.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
public class ModelCard {

    private String id;

    private String name;

    private String comment;

    private Date createAt;

    private Date updateAt;

    private String creator;

    private String updater;

    private ClassInfo classInfo;
}

