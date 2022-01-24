package nl.novi.end.project.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

public class UserRequestDto {

    @NotBlank
    public String userName;

    @NotBlank
    @Size(min = 6, max = 30)
    public long password;

    @NotBlank
    @Email
    public String email;

    @NotBlank
    public List<String> authorities;
}
