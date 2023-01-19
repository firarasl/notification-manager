package az.eurodesign.notification.management.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "templates")
@Getter @Setter @NoArgsConstructor
public class Template extends Base {

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Column(name = "pattern", nullable = false)
    private String pattern;

    @Column(name = "resent", nullable = false)
    private boolean resent = false;

    @Column(name = "group_id")
    private String groupId;

    @Version
    @Column(name = "version", nullable = false)
    private int version;
}