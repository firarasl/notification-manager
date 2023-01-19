package az.eurodesign.notification.management.dto;

import az.eurodesign.notification.management.model.Template;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class TemplateDTO {

    private Long id;

    private String name;

    private String pattern;

    private boolean resent;

    private String groupId;

    public TemplateDTO(Template template) {
        this.id = template.getId();
        this.name = template.getName();
        this.pattern = template.getPattern();
        this.resent = template.isResent();
        this.groupId = template.getGroupId();
    }
}
