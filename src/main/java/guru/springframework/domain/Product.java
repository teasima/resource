package guru.springframework.domain;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;


import java.math.BigDecimal;

@Entity
@Table(name = "var" )
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
    
    
    
    
	public Long getApartmentSum() {
		return apartmentSum;
	}
	public void setApartmentSum(Long apartmentSum) {
		this.apartmentSum = apartmentSum;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getApartment_id() {
		return apartment_id;
	}
	public void setApartment_id(String apartment_id) {
		this.apartment_id = apartment_id;
	}
	public String getApartment() {
		return apartment;
	}
	public void setApartment(String apartment) {
		this.apartment = apartment;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getHome_id() {
		return home_id;
	}
	public void setHome_id(String home_id) {
		this.home_id = home_id;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getRoom_num() {
		return room_num;
	}
	public void setRoom_num(String room_num) {
		this.room_num = room_num;
	}
	public String getEmpty_room_num() {
		return empty_room_num;
	}
	public void setEmpty_room_num(String empty_room_num) {
		this.empty_room_num = empty_room_num;
	}
	public String getEmpty_room_ratio() {
		return empty_room_ratio;
	}
	public void setEmpty_room_ratio(String empty_room_ratio) {
		this.empty_room_ratio = empty_room_ratio;
	}
	public String getEmpty_average_period_ratio() {
		return empty_average_period_ratio;
	}
	public void setEmpty_average_period_ratio(String empty_average_period_ratio) {
		this.empty_average_period_ratio = empty_average_period_ratio;
	}
	public String getCost_average_square() {
		return cost_average_square;
	}
	public void setCost_average_square(String cost_average_square) {
		this.cost_average_square = cost_average_square;
	}
	public String getReceived_average_square() {
		return received_average_square;
	}
	public void setReceived_average_square(String received_average_square) {
		this.received_average_square = received_average_square;
	}
	public String getGross_average_square() {
		return gross_average_square;
	}
	public void setGross_average_square(String gross_average_square) {
		this.gross_average_square = gross_average_square;
	}
	public String getGross_average_square_ratio() {
		return gross_average_square_ratio;
	}
	public void setGross_average_square_ratio(String gross_average_square_ratio) {
		this.gross_average_square_ratio = gross_average_square_ratio;
	}
	public String getOwner_contract_average_period() {
		return owner_contract_average_period;
	}
	public void setOwner_contract_average_period(String owner_contract_average_period) {
		this.owner_contract_average_period = owner_contract_average_period;
	}
	public String getOwner_average_free_days() {
		return owner_average_free_days;
	}
	public void setOwner_average_free_days(String owner_average_free_days) {
		this.owner_average_free_days = owner_average_free_days;
	}
	public String getDecoration_average_days() {
		return decoration_average_days;
	}
	public void setDecoration_average_days(String decoration_average_days) {
		this.decoration_average_days = decoration_average_days;
	}
	public String getEmpty_average_days() {
		return empty_average_days;
	}
	public void setEmpty_average_days(String empty_average_days) {
		this.empty_average_days = empty_average_days;
	}
	public String getTenant_contract_average_period() {
		return tenant_contract_average_period;
	}
	public void setTenant_contract_average_period(String tenant_contract_average_period) {
		this.tenant_contract_average_period = tenant_contract_average_period;
	}
	public String getActual_average_period() {
		return actual_average_period;
	}
	public void setActual_average_period(String actual_average_period) {
		this.actual_average_period = actual_average_period;
	}
	public String getAhead_average_ratio() {
		return ahead_average_ratio;
	}
	public void setAhead_average_ratio(String ahead_average_ratio) {
		this.ahead_average_ratio = ahead_average_ratio;
	}
	public String getTenant_continue_ratio() {
		return tenant_continue_ratio;
	}
	public void setTenant_continue_ratio(String tenant_continue_ratio) {
		this.tenant_continue_ratio = tenant_continue_ratio;
	}
	public String getShould_receive_tenant_num() {
		return should_receive_tenant_num;
	}
	public void setShould_receive_tenant_num(String should_receive_tenant_num) {
		this.should_receive_tenant_num = should_receive_tenant_num;
	}
	public String getShould_pay_owner_num() {
		return should_pay_owner_num;
	}
	public void setShould_pay_owner_num(String should_pay_owner_num) {
		this.should_pay_owner_num = should_pay_owner_num;
	}
	public String getEstimate_rent_gross() {
		return estimate_rent_gross;
	}
	public void setEstimate_rent_gross(String estimate_rent_gross) {
		this.estimate_rent_gross = estimate_rent_gross;
	}
	public String getEstimate_rent_gross_ratio() {
		return estimate_rent_gross_ratio;
	}
	public void setEstimate_rent_gross_ratio(String estimate_rent_gross_ratio) {
		this.estimate_rent_gross_ratio = estimate_rent_gross_ratio;
	}
	public String getReceived_rent_num() {
		return received_rent_num;
	}
	public void setReceived_rent_num(String received_rent_num) {
		this.received_rent_num = received_rent_num;
	}
	public String getPayment_owner_num() {
		return payment_owner_num;
	}
	public void setPayment_owner_num(String payment_owner_num) {
		this.payment_owner_num = payment_owner_num;
	}
	public String getReceived_rent_gross() {
		return received_rent_gross;
	}
	public void setReceived_rent_gross(String received_rent_gross) {
		this.received_rent_gross = received_rent_gross;
	}
	public String getReceived_rent_num_ratio() {
		return received_rent_num_ratio;
	}
	public void setReceived_rent_num_ratio(String received_rent_num_ratio) {
		this.received_rent_num_ratio = received_rent_num_ratio;
	}
	public String getHydropower_coal_received_num() {
		return hydropower_coal_received_num;
	}
	public void setHydropower_coal_received_num(String hydropower_coal_received_num) {
		this.hydropower_coal_received_num = hydropower_coal_received_num;
	}
	public String getHydropower_coal_payment_num() {
		return hydropower_coal_payment_num;
	}
	public void setHydropower_coal_payment_num(String hydropower_coal_payment_num) {
		this.hydropower_coal_payment_num = hydropower_coal_payment_num;
	}
	public String getServe_received() {
		return serve_received;
	}
	public void setServe_received(String serve_received) {
		this.serve_received = serve_received;
	}
	public String getServe_cost() {
		return serve_cost;
	}
	public void setServe_cost(String serve_cost) {
		this.serve_cost = serve_cost;
	}
	public String getEstimate_hydropower_coal_received_num() {
		return estimate_hydropower_coal_received_num;
	}
	public void setEstimate_hydropower_coal_received_num(String estimate_hydropower_coal_received_num) {
		this.estimate_hydropower_coal_received_num = estimate_hydropower_coal_received_num;
	}
	public String getEstimate_hydropower_coal_payment_num() {
		return estimate_hydropower_coal_payment_num;
	}
	public void setEstimate_hydropower_coal_payment_num(String estimate_hydropower_coal_payment_num) {
		this.estimate_hydropower_coal_payment_num = estimate_hydropower_coal_payment_num;
	}
	public String getEstimate_serve_received_num() {
		return estimate_serve_received_num;
	}
	public void setEstimate_serve_received_num(String estimate_serve_received_num) {
		this.estimate_serve_received_num = estimate_serve_received_num;
	}
	public String getEstimate_serve_payment_num() {
		return estimate_serve_payment_num;
	}
	public void setEstimate_serve_payment_num(String estimate_serve_payment_num) {
		this.estimate_serve_payment_num = estimate_serve_payment_num;
	}
	public String getDecoration_cost_share() {
		return decoration_cost_share;
	}
	public void setDecoration_cost_share(String decoration_cost_share) {
		this.decoration_cost_share = decoration_cost_share;
	}
	public String getLabor_cost_num() {
		return labor_cost_num;
	}
	public void setLabor_cost_num(String labor_cost_num) {
		this.labor_cost_num = labor_cost_num;
	}
	public String getEstimate_labor_cost_num() {
		return estimate_labor_cost_num;
	}
	public void setEstimate_labor_cost_num(String estimate_labor_cost_num) {
		this.estimate_labor_cost_num = estimate_labor_cost_num;
	}
	public String getEstimate_other_received() {
		return estimate_other_received;
	}
	public void setEstimate_other_received(String estimate_other_received) {
		this.estimate_other_received = estimate_other_received;
	}
	public String getOther_received() {
		return other_received;
	}
	public void setOther_received(String other_received) {
		this.other_received = other_received;
	}
	public String getEstimate_other_cost() {
		return estimate_other_cost;
	}
	public void setEstimate_other_cost(String estimate_other_cost) {
		this.estimate_other_cost = estimate_other_cost;
	}
	public String getOther_cost() {
		return other_cost;
	}
	public void setOther_cost(String other_cost) {
		this.other_cost = other_cost;
	}
	public String getEstimate_gross_profit() {
		return estimate_gross_profit;
	}
	public void setEstimate_gross_profit(String estimate_gross_profit) {
		this.estimate_gross_profit = estimate_gross_profit;
	}
	public String getGross_profit() {
		return gross_profit;
	}
	public void setGross_profit(String gross_profit) {
		this.gross_profit = gross_profit;
	}
	public String getEstimate_gross_profit_ratio() {
		return estimate_gross_profit_ratio;
	}
	public void setEstimate_gross_profit_ratio(String estimate_gross_profit_ratio) {
		this.estimate_gross_profit_ratio = estimate_gross_profit_ratio;
	}
	public String getGross_profit_ratio() {
		return gross_profit_ratio;
	}
	public void setGross_profit_ratio(String gross_profit_ratio) {
		this.gross_profit_ratio = gross_profit_ratio;
	}
	public String getEstimate_profit() {
		return estimate_profit;
	}
	public void setEstimate_profit(String estimate_profit) {
		this.estimate_profit = estimate_profit;
	}
	public String getProfit() {
		return profit;
	}
	public void setProfit(String profit) {
		this.profit = profit;
	}
	public String getEstimate_profit_ratio() {
		return estimate_profit_ratio;
	}
	public void setEstimate_profit_ratio(String estimate_profit_ratio) {
		this.estimate_profit_ratio = estimate_profit_ratio;
	}
	public String getProfit_ratio() {
		return profit_ratio;
	}
	public void setProfit_ratio(String profit_ratio) {
		this.profit_ratio = profit_ratio;
	}
	public Product(Long apartmentSum) {
		super();
		this.apartmentSum  = apartmentSum ;
		// TODO Auto-generated constructor stub
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
    
    
    
    
    
//    
//    @ApiModelProperty(notes = "The price of the product", required = true)
//    private BigDecimal price;

    
}
