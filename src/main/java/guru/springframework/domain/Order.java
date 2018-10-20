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
@Table(name = "s_order" )
@Getter
@Setter	
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "The database generated product ID")
    private Integer id;
 
    @Enumerated(EnumType.STRING)
    @Column(name="status")
    @ApiModelProperty(notes = "UNPAID , PAID ,SHIPPED , FINISHED")
    private OrderStatus status;
    
    
    @ApiModelProperty(notes = "定单编号")
    private String code;
    
    @ApiModelProperty(notes = "销售员")
    @OneToOne(targetEntity = SalesMan.class)
    @JoinColumn(name = "sales_man_id",referencedColumnName = "id")
    private SalesMan salesMan;
    
    @ApiModelProperty(notes = "买家")
    private Integer buyerId;
    
    @ApiModelProperty(notes = "卖家")
    private Integer sellerId;
    
    @ApiModelProperty(notes = "单价")
    private BigDecimal price;
    
    @ApiModelProperty(notes = "金额")
    private BigDecimal totalPrice;
    
    @ApiModelProperty(notes = "总量")
    private BigDecimal amount;
    
    @ApiModelProperty(notes = "时间")
    private Date ct;
    
    
    
}
