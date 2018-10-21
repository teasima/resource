package guru.springframework.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.math.BigDecimal;

@Entity
@Table(name = "ship_address" )
@Getter
@Setter	
@AllArgsConstructor
@NoArgsConstructor
public class ShipAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "The database generated product ID")
    private Integer id;
 
    
    @ApiModelProperty(notes = "名称")
    private String name;
    
	@ApiModelProperty(notes = "买家")
	@ManyToOne(targetEntity = Buyer.class, cascade= CascadeType.MERGE)
	@JoinColumn(name = "buyer_id", referencedColumnName = "id")
	@JsonManagedReference
	private Buyer Buyer;

    
    @ApiModelProperty(notes = "电话")
    private String tel;
    
   
    @ApiModelProperty(notes = "省市区街道")
    private String aera;
    
    
    @ApiModelProperty(notes = "详细地址")
    private String address;
    
    @ApiModelProperty(notes = "邮编")
    private String postcode;
    
    @ApiModelProperty(notes = "标签")
    private String tag;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((aera == null) ? 0 : aera.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((postcode == null) ? 0 : postcode.hashCode());
		result = prime * result + ((tag == null) ? 0 : tag.hashCode());
		result = prime * result + ((tel == null) ? 0 : tel.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ShipAddress other = (ShipAddress) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (aera == null) {
			if (other.aera != null)
				return false;
		} else if (!aera.equals(other.aera))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (postcode == null) {
			if (other.postcode != null)
				return false;
		} else if (!postcode.equals(other.postcode))
			return false;
		if (tag == null) {
			if (other.tag != null)
				return false;
		} else if (!tag.equals(other.tag))
			return false;
		if (tel == null) {
			if (other.tel != null)
				return false;
		} else if (!tel.equals(other.tel))
			return false;
		return true;
	}
 
}
