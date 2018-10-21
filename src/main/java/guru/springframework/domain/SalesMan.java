package guru.springframework.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import org.hibernate.annotations.DynamicUpdate;

import java.math.BigDecimal;

@Entity
@Table(name = "sales_man" )
@Getter
@Setter	
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
@DynamicUpdate(true)
public class SalesMan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "The database generated product ID")
    private Integer id;
 
    
    @ApiModelProperty(notes = "名称")
    private String name;
    
    @ApiModelProperty(notes = "地址")
    private String address;
    
    @Column(unique = true)
    @ApiModelProperty(notes = "电话")
    private String tel;
    
    
    @ApiModelProperty(notes = "邮箱")
    private String email;
    
    @Column(unique = true)
    @ApiModelProperty(notes = "用户名")
    private String username;
    @ApiModelProperty(notes = "密码")
    private String password;
    
    @ApiModelProperty(notes = "禁用")
    private Byte disabled=0;
    
}
