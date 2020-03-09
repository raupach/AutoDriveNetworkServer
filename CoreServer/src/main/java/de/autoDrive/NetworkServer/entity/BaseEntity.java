package de.autoDrive.NetworkServer.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseEntity 
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

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
