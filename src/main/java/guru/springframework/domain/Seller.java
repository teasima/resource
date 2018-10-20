package guru.springframework.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "seller")
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
public class Seller {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(notes = "The database generated product ID")
	private Integer id;

	@ApiModelProperty(notes = "名称")
	private String name;

	@ApiModelProperty(notes = "地址")
	private String address;

	@ApiModelProperty(notes = "电话")
	private String tel;

	@ApiModelProperty(notes = "纳税号")
	private String taxCode;

	@ApiModelProperty(notes = "邮箱")
	private String email;

	@ApiModelProperty(notes = "用户名")
	private String username;
	@ApiModelProperty(notes = "密码")
	private String password;

	@ApiModelProperty(notes = "禁用")
	private Byte disabled = 0;

}
