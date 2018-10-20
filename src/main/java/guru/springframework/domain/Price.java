package guru.springframework.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "price" )
@Getter
@Setter	
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "The database generated product ID")
    private Integer id;
 
    @ApiModelProperty(notes = "货源")
	@OneToOne(targetEntity = GoodsSource.class)
	@JoinColumn(name = "goods_source_id", referencedColumnName = "id")
    @JsonBackReference
	private GoodsSource goodssource;
    
    @ApiModelProperty(notes = "金额")
    private BigDecimal totalPrice;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(notes = "时间")
    private Date ct;
    
    @ApiModelProperty(notes = "单位")
    private String unit;
    
    @ApiModelProperty(notes = "折扣")
    private Float discount;
    
}
