package hiber;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "SITE")
 class Site {
	
	@Id
	@Column(name="SITE_ID")
	int siteId;
	
	@Column(name="BASE_URL")
	String URL;
	
	@Column(name="IS_READY")
	String isReady;
	
	public int getSiteId() {
		return siteId;
	}
	public void setSiteId(int siteId) {
		this.siteId = siteId;
	}
	public String getIsReady() {
		return isReady;
	}
	public void setIsReady(String isReady) {
		this.isReady = isReady;
	}
	public String getName() {
		return URL;
	}
	public void setName(String name) {
		this.URL = name;
	}

	
}
