package demo.entity;
// Generated Jul 11, 2017 6:16:49 PM by Hibernate Tools 5.2.3.Final

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

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.Proxy;

/**
 * Album generated by hbm2java
 */
@Entity
@Proxy(lazy = false)
@Table(name = "album", catalog = "db_kara")
public class Album implements java.io.Serializable {

	private Integer id;
	private String albumId;
	private String albumName;
	private Set<Vn> vns = new HashSet<Vn>(0);

	public Album() {
	}

	public Album(String albumId, String albumName) {
		this.albumId = albumId;
		this.albumName = albumName;
	}

	public Album(String albumId, String albumName, Set<Vn> vns) {
		this.albumId = albumId;
		this.albumName = albumName;
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

	@Column(name = "albumId", nullable = false, length = 50)
	public String getAlbumId() {
		return this.albumId;
	}

	public void setAlbumId(String albumId) {
		this.albumId = albumId;
	}

	@Column(name = "album_name", nullable = false, length = 50)
	public String getAlbumName() {
		return this.albumName;
	}

	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}
@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "album")
	public Set<Vn> getVns() {
		return this.vns;
	}

	public void setVns(Set<Vn> vns) {
		this.vns = vns;
	}

}
