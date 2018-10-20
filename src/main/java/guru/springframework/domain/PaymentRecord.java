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
@Table(name = "payment_record" )
@Getter
@Setter	
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
public class PaymentRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "The database generated product ID")
    private Integer id;
 
    
    @ApiModelProperty(notes = "定单")
    private Integer orderId;
    
    @ApiModelProperty(notes = "买家")
    private Integer buyerId;
    
    @ApiModelProperty(notes = "金额")
    private BigDecimal amount;
    
    @ApiModelProperty(notes = "时间")
    private Date ct;
    
}
