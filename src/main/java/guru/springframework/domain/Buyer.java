package guru.springframework.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "buyer")
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
@DynamicUpdate(true)
public class Buyer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(notes = "The database generated product ID")
	private Integer id;

	@Column(unique = true)
	@ApiModelProperty(notes = "名称")
	private String name;

	@ApiModelProperty(notes = "真实姓名")
	private String realName;
	
	@ApiModelProperty(notes = "性别")
	private String gender;
	
	
	@ApiModelProperty(notes = "公司名称")
	private String companyName;
	
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
	private Byte disabled = 0;
	
	@ApiModelProperty(notes = "开票姓名")
	private String invoiceName;
	
	@ApiModelProperty(notes = "开票地址")
	private String invoiceAddress;
	
	
	@ApiModelProperty(notes = "纳税号")
	private String invoiceCode;
	
	@ApiModelProperty(notes = "开票电话")
	private String invoiceTel;

	@JsonIgnore
	@ApiModelProperty(notes = "常用地址")
	@OneToMany(mappedBy ="Buyer" ,targetEntity = ShipAddress.class, fetch = FetchType.LAZY)
	private Set<ShipAddress> allShipAddress = new HashSet<ShipAddress>();

	@ApiModelProperty(notes = "默认地址")
	@OneToOne(targetEntity = ShipAddress.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "ship_address", referencedColumnName = "id")
	@JsonBackReference
	private ShipAddress shipAddress;

}
