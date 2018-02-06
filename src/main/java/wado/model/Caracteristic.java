package wado.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Table(name="caracteristics")
public class Caracteristic implements Serializable{

	private static final long serialVersionUID = -3516853150778243353L;

	@EmbeddedId
	private CaracteristicId pk;
	
	@ManyToOne
	@MapsId("projectId")
	@JoinColumn(name="project_id", referencedColumnName="project_id", nullable=false)
	private Integer projectId;
	
	@ManyToOne
	@MapsId("caracteristicType")
	@JoinColumn(name="caracteristic_type", referencedColumnName="caracteristic_type", nullable=false)
	private String caracteristicType;
	
	@Column(name="caracetristic_value")
	private String caracteristicValue;


	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public String getCaracteristicType() {
		return caracteristicType;
	}

	public void setCaracteristicType(String caracteristicType) {
		this.caracteristicType = caracteristicType;
	}

	public String getCaracteristicValue() {
		return caracteristicValue;
	}

	public void setCaracteristicValue(String caracteristicValue) {
		this.caracteristicValue = caracteristicValue;
	}
	
}

@Embeddable
class CaracteristicId implements Serializable{
	
	@Column(name="project_id")
	private Integer projectId;
	
	@Column(name="caracteristic_type")
	private String caracteristicType;
}