package dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private Long Id;

    private String firstName;

    private String lastName;

    private String email;

    //For example only. In production must be char[]
    private String password;

    @JsonFormat(pattern = "dd.MM.yyyy")
    private Date birthday;
}
