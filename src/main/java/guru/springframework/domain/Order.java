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
import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "s_order")
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
@DynamicUpdate(true)
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(notes = "The database generated product ID")
	private Integer id;

	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	@ApiModelProperty(notes = "CANCELLED , UNPAID , PAID ,SHIPPED , FINISHED")
	private OrderStatus status;

	@Column(unique = true)
	@ApiModelProperty(notes = "定单编号")
	private String code;

	@ApiModelProperty(notes = "销售员")
	@OneToOne(targetEntity = SalesMan.class)
	@JoinColumn(name = "sales_man_id", referencedColumnName = "id")
	private SalesMan salesMan;

	@ApiModelProperty(notes = "买家")
	@OneToOne(targetEntity = Buyer.class)
	@JoinColumn(name = "buyer_id", referencedColumnName = "id")
	private Buyer Buyer;

	@ApiModelProperty(notes = "货源")
	@ManyToOne(targetEntity = GoodsSource.class, optional = true)
	@JoinColumn(name = "goods_source_id", referencedColumnName = "id")
	private GoodsSource goodssource;

	@ApiModelProperty(notes = "单价")
	private BigDecimal price;

	@ApiModelProperty(notes = "金额")
	private BigDecimal totalPrice;

	@ApiModelProperty(notes = "总量")
	private BigDecimal amount;

	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty(notes = "时间")
	private Date ct;

	@ApiModelProperty(notes = "地区")
	private String area;

	@ApiModelProperty(notes = "详细地址")
	private String address;

	@ApiModelProperty(notes = "支付方式")
	private String payMethod;

}
