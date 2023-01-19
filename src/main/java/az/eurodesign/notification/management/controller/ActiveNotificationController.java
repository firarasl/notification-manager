package az.eurodesign.notification.management.controller;

import az.eurodesign.notification.management.payload.NoTemplateNotificationPayload;
import az.eurodesign.notification.management.service.ActiveNotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("notification")
public class ActiveNotificationController {

    private final ActiveNotificationService activeNotificationService;


    @PostMapping("/without-template")
    public ResponseEntity<?> add(@RequestBody NoTemplateNotificationPayload payload){
        activeNotificationService.save(activeNotificationService.create(payload));
        return ResponseEntity.ok().build();
    }

}
