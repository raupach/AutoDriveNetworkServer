package de.autoDrive.NetworkServer.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@MappedSuperclass
public class BaseEntity 
{

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    //    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id @GeneratedValue(generator="uuid")
    @GenericGenerator(name="uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private String id;


    @Override
    public int hashCode()
    {
        return new HashCodeBuilder()
                .append(id)
                .toHashCode();
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj instanceof BaseEntity == false)
        {
            return false;
        }
        if (this == obj)
        {
            return true;
        }
        BaseEntity otherObject = (BaseEntity) obj;

        return new EqualsBuilder()
                .append(id, otherObject.id)
                .isEquals();
    }

}
