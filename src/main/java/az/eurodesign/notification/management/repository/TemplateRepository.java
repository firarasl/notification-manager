package az.eurodesign.notification.management.repository;

import az.eurodesign.notification.management.model.Template;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemplateRepository extends JpaRepository<Template, Long> {
}