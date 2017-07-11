package demo.entity;
// Generated Jul 11, 2017 6:17:00 PM by Hibernate Tools 5.2.3.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Volume generated by hbm2java
 */
@Entity
@Table(name = "volume", catalog = "db_kara")
public class Volume implements java.io.Serializable {

	private Integer id;
	private String volId;
	private String volName;
	private Set<Vn> vns = new HashSet<Vn>(0);

	public Volume() {
	}

	public Volume(String volId, String volName) {
		this.volId = volId;
		this.volName = volName;
	}

	public Volume(String volId, String volName, Set<Vn> vns) {
		this.volId = volId;
		this.volName = volName;
		this.vns = vns;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "volId", nullable = false, length = 50)
	public String getVolId() {
		return this.volId;
	}

	public void setVolId(String volId) {
		this.volId = volId;
	}

	@Column(name = "vol_name", nullable = false, length = 50)
	public String getVolName() {
		return this.volName;
	}

	public void setVolName(String volName) {
		this.volName = volName;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "volume")
	public Set<Vn> getVns() {
		return this.vns;
	}

	public void setVns(Set<Vn> vns) {
		this.vns = vns;
	}

}
