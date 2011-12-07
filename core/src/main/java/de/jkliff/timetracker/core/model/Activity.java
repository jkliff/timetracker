package de.jkliff.timetracker.core.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import de.jkliff.timetracker.core.persistence.model.PersistentEntity;

@Entity
@Table(name = "activity")
public class Activity
        implements PersistentEntity {

    @Id
    @Generated(GenerationTime.INSERT)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "a_id")
    private Long             id;
    @Column(name = "a_start")
    private Date             start;
    @Column(name = "a_end")
    private Date             end;
    @Column(name = "a_name")
    private String           name;

    @ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    private Set<ActivityTag> tags;

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<ActivityTag> getTags() {
        return tags;
    }

    public void setTags(Set<ActivityTag> tags) {
        this.tags = tags;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Long getPersistentId() {
        return this.getId();
    }

}
