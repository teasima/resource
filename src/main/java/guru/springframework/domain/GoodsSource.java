package guru.springframework.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.math.BigDecimal;

@Entity
@Table(name = "goods_source" )
@Getter
@Setter	
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
public class GoodsSource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "The database generated product ID")
    private Integer id;
 
    @ApiModelProperty(notes = "卖家")
    @OneToOne(targetEntity = Seller.class)
    @JoinColumn(name = "seller_id",referencedColumnName = "id")
    private Seller seller;

    @ApiModelProperty(notes = "销售员")
    @OneToOne(targetEntity = SalesMan.class)
    @JoinColumn(name = "sales_man_id",referencedColumnName = "id")
    private SalesMan salesMan;
    
	@ApiModelProperty(notes = "价格")
	@OneToOne(targetEntity = Price.class,cascade=CascadeType.ALL)
	@JoinColumn(name = "price_id", referencedColumnName = "id")
	@JsonManagedReference
	private Price price;
    
    @ApiModelProperty(notes = "地址")
    private String address;
    
    @ApiModelProperty(notes = "电话")
    private String tel;
   
    
    @ApiModelProperty(notes = "剩余量")
    private BigDecimal remaining;
    
    @ApiModelProperty(notes = "提示")
    private String notice; 
    
}
