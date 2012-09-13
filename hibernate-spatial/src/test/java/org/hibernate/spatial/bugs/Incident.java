package org.hibernate.spatial.bugs;

import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.vividsolutions.jts.geom.Point;

import org.hibernate.annotations.Type;
import org.hibernate.envers.Audited;

/**
 * @author Karel Maesen, Geovise BVBA
 *         creation-date: 9/12/12
 */

@Cacheable(false)
@Entity
@Table(name = "ZDARZENIA")
public class Incident {

     private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)

    @Column(name = "ID_ZD")
    @Audited
    private Long incidentId;
    @Column(name = "NR_ZDARZ")
    @Audited
    private String incidentNo;
    @Column(name = "MIEJSCOWOSC_NAZWA")
    private String locality;
    @Column(name = "DZIELNICA_NAZWA")
    private String district;
    @Column(name = "ULICA_NAZWA")
    private String street;
    @Column(name = "NUMER_BUDYNKU")
    private String buildingNo;
    @Column(name = "NUMER_LOKALU")
    private String locumNo;
    @Column(name = "PIETRO")
    private Short floor;
    @Column(name = "GMINA_NAZWA")
    private String commune;
    @Column(name = "POWIAT_NAZWA")
    private String poviat;


    @Basic(fetch = FetchType.LAZY, optional = true)
    @Column(name = "GEOM")
    @Type(type="org.hibernate.spatial.GeometryType")
    @Audited
    private Point geom;

    public Incident() {
    }


    public Incident(Long incidentId) {
        this.incidentId = incidentId;
    }

    public String getBuildingNo() {
        return buildingNo;
    }

    public void setBuildingNo(String buildingNo) {
        this.buildingNo = buildingNo;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Short getFloor() {
        return floor;
    }

    public void setFloor(Short floor) {
        this.floor = floor;
    }


    public Long getIncidentId() {
        return incidentId;
    }

    public void setIncidentId(Long incidentId) {
        this.incidentId = incidentId;
    }

    public String getIncidentNo() {
        return incidentNo;
    }

    public void setIncidentNo(String incidentNo) {
        this.incidentNo = incidentNo;
    }



    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getLocumNo() {
        return locumNo;
    }

    public void setLocumNo(String locumNo) {
        this.locumNo = locumNo;
    }

    public Point getGeom() {
        return geom;
    }

    public void setGeom(Point geom) {
        this.geom = geom;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (incidentId != null ? incidentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Incident)) {
            return false;
        }
        Incident other = (Incident) object;
        if ((this.incidentId == null && other.incidentId != null) || (this.incidentId != null && !this.incidentId.equals(other.incidentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.ispik.pzk.ejb.domain.Incident[incidentId=" + incidentId + "]";
    }


}
