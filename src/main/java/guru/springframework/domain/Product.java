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
@Table(name = "var" )
@Getter
@Setter	
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "The database generated product ID")
    private Integer id;
//    @Version
//    @ApiModelProperty(notes = "The auto-generated version of the product")
//    private Integer version;
    @ApiModelProperty(notes = "公寓id")
    private String apartment_id;
    @ApiModelProperty(notes = "公寓名称")
    private String apartment;
    @ApiModelProperty(notes = "市")
    private String city;
    @ApiModelProperty(notes = "区")
    private String district;
    @ApiModelProperty(notes = "home_id")
    private String home_id;
    @ApiModelProperty(notes = "所属自然月")
    private String month;
    @ApiModelProperty(notes = "房间数")
    private String room_num;
    @ApiModelProperty(notes = "空置房间数")
    private String empty_room_num;
    @ApiModelProperty(notes = "房间空置率")
    private String empty_room_ratio;
    @ApiModelProperty(notes = "租期空置率")
    private String empty_average_period_ratio;
    @ApiModelProperty(notes = "每平米房源成本")
    private String cost_average_square;
    @ApiModelProperty(notes = "每平米租金收入")
    private String received_average_square;
    @ApiModelProperty(notes = "每平米毛利")
    private String gross_average_square;
    @ApiModelProperty(notes = "每平米毛利率")
    private String gross_average_square_ratio;
    @ApiModelProperty(notes = "业主合同平均租期")
    private String owner_contract_average_period;
    @ApiModelProperty(notes = "业主年均免租期")
    private String owner_average_free_days;
    @ApiModelProperty(notes = "平均装修天数")
    private String decoration_average_days;
    
    @ApiModelProperty(notes = "平均租前空置天数")
    private String empty_average_days;
    @ApiModelProperty(notes = "租客合同平均租期")
    private String tenant_contract_average_period;
    @ApiModelProperty(notes = "实际平均租期")
    private String actual_average_period;
    @ApiModelProperty(notes = "提前退租率")
    private String ahead_average_ratio;
    @ApiModelProperty(notes = "租客续签率")
    private String tenant_continue_ratio;
    @ApiModelProperty(notes = "应收租客租金总额")
    private String should_receive_tenant_num;
    @ApiModelProperty(notes = "应付业主租金总额")
    private String should_pay_owner_num;
    @ApiModelProperty(notes = "预计租金毛利")
    private String estimate_rent_gross;
    @ApiModelProperty(notes = "预计租金毛利率")
    private String estimate_rent_gross_ratio;
    @ApiModelProperty(notes = "实收租客租金总额")
    private String received_rent_num;
    @ApiModelProperty(notes = "实付业主租金总额")
    private String payment_owner_num;
    
    @ApiModelProperty(notes = "实收租金毛利")
    private String received_rent_gross;
    @ApiModelProperty(notes = "实收租金毛利率")
    private String received_rent_num_ratio;
    @ApiModelProperty(notes = "水电燃煤实际收入")
    private String hydropower_coal_received_num;
    @ApiModelProperty(notes = "水电燃煤实际支出")
    private String hydropower_coal_payment_num;
    @ApiModelProperty(notes = "服务费实际收入")
    private String serve_received;
    @ApiModelProperty(notes = "服务费实际支出")
    private String serve_cost;
    @ApiModelProperty(notes = "水电燃煤预计收入")
    private String estimate_hydropower_coal_received_num;
    @ApiModelProperty(notes = "水电燃煤预计支出")
    private String estimate_hydropower_coal_payment_num;
    @ApiModelProperty(notes = "服务费预计收入")
    private String estimate_serve_received_num;
    @ApiModelProperty(notes = "服务费预计支出")
    private String estimate_serve_payment_num;
    @ApiModelProperty(notes = "装修分摊成本")
    private String decoration_cost_share;
    @ApiModelProperty(notes = "实际人工成本")
    private String labor_cost_num;
    @ApiModelProperty(notes = "预计人工成本")
    private String estimate_labor_cost_num;
    @ApiModelProperty(notes = "预计其他收入")
    private String estimate_other_received;
    @ApiModelProperty(notes = "实际其他收入")
    private String other_received;
    
    @ApiModelProperty(notes = "预计其他支出")
    private String estimate_other_cost;
    @ApiModelProperty(notes = "实际其他支出")
    private String other_cost;
    @ApiModelProperty(notes = "预计毛利润")
    private String estimate_gross_profit;
    @ApiModelProperty(notes = "实际毛利润")
    private String gross_profit;
    @ApiModelProperty(notes = "预计毛利率")
    private String estimate_gross_profit_ratio;
    @ApiModelProperty(notes = "实际毛利率")
    private String gross_profit_ratio;
    @ApiModelProperty(notes = "预计纯利润")
    private String estimate_profit;
    @ApiModelProperty(notes = "实际纯利润")
    private String profit;
    @ApiModelProperty(notes = "预计利润率")
    private String estimate_profit_ratio;
    @ApiModelProperty(notes = "实际利润率")
    private String profit_ratio;
    
    @Transient
    @ApiModelProperty(notes = "公寓总数")
    private Long apartmentSum ;
    
    
     
    
    
    
    
    
//    
//    @ApiModelProperty(notes = "The price of the product", required = true)
//    private BigDecimal price;

    
}
