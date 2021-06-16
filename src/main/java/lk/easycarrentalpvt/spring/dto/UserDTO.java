package lk.easycarrentalpvt.spring.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonIgnoreProperties(value = {"uuId","userID"},allowGetters = true,allowSetters = false)
public class UserDTO {
    private int userID;
    private String userName;
    private String password;
    private String role;
    private String uuId;
}
