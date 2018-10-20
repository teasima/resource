package guru.springframework.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "f_order" )
@Getter
@Setter	
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
public class FreightOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "The database generated product ID")
    private Integer id;
 
    @Enumerated(EnumType.STRING)
    @Column(name="status")
    @ApiModelProperty(notes = "UNPAID , PAID ,SHIPPED , FINISHED")
    private OrderStatus status;
    
    @Column(unique = true)
    @ApiModelProperty(notes = "定单编号")
    private String code;
    
    @ApiModelProperty(notes = "订单")
    private Integer orderId;
    
    @ApiModelProperty(notes = "运输车")
    private Integer vehicleId;
    
    
    @ApiModelProperty(notes = "金额")
    private BigDecimal totalPrice;
     
    
    @ApiModelProperty(notes = "时间")
    private Date ct;
    
    
    
}
