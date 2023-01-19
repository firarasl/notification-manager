package az.eurodesign.notification.management.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@MappedSuperclass
@Getter @Setter @NoArgsConstructor
public class Base {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreatedBy
    protected String createdBy;

    @LastModifiedBy
    protected String lastUpdatedBy;

    @CreationTimestamp
    @Column(name = "creation_datetime")
    private LocalDateTime creationDateTime;

    @UpdateTimestamp
    @Column(name = "update_datetime")
    private LocalDateTime updateDateTime;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Base base = (Base) o;
        return Objects.equals(id, base.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
