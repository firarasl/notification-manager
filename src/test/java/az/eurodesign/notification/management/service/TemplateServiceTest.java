////package az.eurodesign.notification.management.service;
////
////import az.eurodesign.notification.management.dto.TemplateDTO;
////import az.eurodesign.notification.management.exception.NotFoundException;
////import az.eurodesign.notification.management.model.Template;
////import az.eurodesign.notification.management.payload.TemplatePayload;
////import az.eurodesign.notification.management.repository.TemplateRepository;
////import org.junit.jupiter.api.BeforeEach;
////import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
////import org.mockito.Mockito;
////import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
////import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
////
////import java.util.List;
////import java.util.Optional;
////
////import static org.junit.jupiter.api.Assertions.*;
////
//@ExtendWith(SpringExtension.class)
//@SpringBootTest
//class TemplateServiceTest {
////
////    @Autowired
////    private TemplateService templateService;
////
////    @MockBean
////    private TemplateRepository templateRepository;
////
////    private Template t1;
////    private Template t2;
////
////    @BeforeEach
////    public void setUp() {
////        t1 = new Template();
////        t1.setId(1L);
////        t1.setPattern("t1p");
////        t1.setName("t1t");
////        t1.setResent(true);
////        t1.setGroupId("t1g");
////
////        t2 = new Template();
////        t2.setId(2L);
////        t2.setPattern("t2p");
////        t2.setName("t2t");
////        t2.setResent(false);
////        t2.setGroupId("t2g");
////    }
////
////    @Test
////    void get_All() {
////        Mockito.doReturn(List.of(t1, t2)).when(templateRepository).findAll();
////
////        List<TemplateDTO> templates = templateService.get();
////
////        assertEquals(2, templates.size());
////
////        Optional<TemplateDTO> t1dto = templates.stream().filter(x -> x.getId() == 1).findFirst();
////        Optional<TemplateDTO> t2dto = templates.stream().filter(x -> x.getId() == 2).findFirst();
////
////        assertTrue(t1dto.isPresent());
////        assertTrue(t2dto.isPresent());
////
////    }
////
////    @Test
////    void get_OneWhenNotExist() {
////        Mockito.doReturn(Optional.empty()).when(templateRepository).findById(3L);
////        assertThrows(NotFoundException.class, () -> templateService.get(3L));
////    }
////
////    @Test
////    void get_OneWhenExists() {
////        Mockito.doReturn(Optional.of(t1)).when(templateRepository).findById(1L);
////        TemplateDTO templateDTO = templateService.get(1L);
////
////        assertEquals(t1.getId(), templateDTO.getId());
////        assertEquals(t1.getGroupId(), templateDTO.getGroupId());
////        assertEquals(t1.getPattern(), templateDTO.getPattern());
////        assertEquals(t1.getName(), templateDTO.getName());
////    }
////
////    @Test
////    void create_WhenNotExist() {
////        TemplatePayload payload = new TemplatePayload();
////
////        Mockito.doReturn(Optional.empty()).when(templateRepository).findById(3L);
////        assertThrows(NotFoundException.class, () -> templateService.create(3L, payload));
////    }
////
////    @Test
////    void create_WhenExist() {
////        TemplatePayload payload = new TemplatePayload();
////        payload.setPattern("pattern");
////
////        Mockito.doReturn(Optional.of(t1)).when(templateRepository).findById(1L);
////        Template template = templateService.create(1L, payload);
////
////        assertEquals(t1.getId(), template.getId());
////        assertEquals(t1.getGroupId(), template.getGroupId());
////        assertEquals("pattern", template.getPattern());
////        assertEquals(t1.getName(), template.getName());
////    }
////
////    @Test
////    void save() {
////        Mockito.doReturn(t1).when(templateRepository).save(t1);
////        TemplateDTO dto = templateService.save(t1);
////
////        assertEquals(t1.getId(), dto.getId());
////    }
//}