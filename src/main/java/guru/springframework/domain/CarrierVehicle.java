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
@Table(name = "vehicle" )
@Getter
@Setter	
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
public class CarrierVehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "The database generated product ID")
    private Integer id;
 
    
    @ApiModelProperty(notes = "司机名称")
    private String name;
    
    @Column(unique = true)
    @ApiModelProperty(notes = "车牌")
    private String plate;
    
    @ApiModelProperty(notes = "电话")
    private String tel;

	@ApiModelProperty(notes = "地区")
	private String area;

	@ApiModelProperty(notes = "详细地址")
	private String address;
 
}
