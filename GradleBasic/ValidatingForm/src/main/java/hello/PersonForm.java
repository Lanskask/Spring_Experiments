package hello;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
public class PersonForm {

    @Size(min=2, max = 30)
    @NotNull
    private String name;

    @NotNull
    @Min(18)
    private Integer age;

}
