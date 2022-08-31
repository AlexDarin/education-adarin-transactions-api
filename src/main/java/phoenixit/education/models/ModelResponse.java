package phoenixit.education.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@NoArgsConstructor
@Setter
@ToString
public class ModelResponse {

    private String id;

    private String name;

    private String comment;

    private Date createAt;

    private Date updateAt;

    private String creator;

    private String updater;
}
