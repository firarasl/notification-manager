//package az.eurodesign.notification.management.repository;
//
//import az.eurodesign.notification.management.model.ArchivedNotification;
//import az.eurodesign.notification.management.model.Base;
//import az.eurodesign.notification.management.model.enums.NotificationType;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.test.context.jdbc.Sql;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Comparator;
//import java.util.List;
//import java.util.stream.Collectors;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@ExtendWith(SpringExtension.class)
//@SpringBootTest
//@Sql(scripts = {"classpath:sql/create-archived-notifications-before.sql"},executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
//@Sql(scripts = {"classpath:sql/create-archived-notifications-after.sql"},executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
//class ArchivedNotificationRepositoryTest {
//
//    @Autowired
//    private ArchivedNotificationRepository archivedNotificationRepository;
//
//    @Test
//    void findAllByUidAndType() {
//        Pageable pageableOne = PageRequest.of(0, 3, Sort.by("sentDateTime").descending());
//        Pageable pageableTwo = PageRequest.of(1, 3, Sort.by("sentDateTime").descending());
//        List<ArchivedNotification> pageZero = archivedNotificationRepository.findAllByUidAndType("one", NotificationType.PUSH, pageableOne);
//        List<ArchivedNotification> pageOne = archivedNotificationRepository.findAllByUidAndType("one", NotificationType.PUSH, pageableTwo);
//        Iterable<ArchivedNotification> allIterator = archivedNotificationRepository.findAll();
//        List<ArchivedNotification> list = new ArrayList<>();
//        allIterator.forEach(list::add);
//
//        list = list.stream()
//                .filter(x -> x.getUid().equals("one") && x.getType() == NotificationType.PUSH)
//                .collect(Collectors.toList());
//
//        list.sort(Comparator.comparing(ArchivedNotification::getSentDateTime));
//        Collections.reverse(list);
//
//        assertEquals(6, list.size());
//        assertEquals(list.get(0), pageZero.get(0));
//        assertEquals(list.get(1), pageZero.get(1));
//        assertEquals(list.get(2), pageZero.get(2));
//        assertEquals(list.get(3), pageOne.get(0));
//        assertEquals(list.get(4), pageOne.get(1));
//        assertEquals(list.get(5), pageOne.get(2));
//
//    }
//}