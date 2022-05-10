package com.springcloud.eventapp.storage;

import com.springcloud.eventapp.event.FileEvent;
import com.springcloud.eventapp.event.FileEventPublisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@Service
public class FileService {
    @Autowired
    FileEventPublisher fileEventPublisher;

    public void fileUpload(Map<String, Object> data){
        try{
            log.info("file Copy Complete");
            log.info("DB Insert Complete");

            FileEvent completeEvent = FileEvent.toCompeteEvent(data);
            fileEventPublisher.notifyComplete(completeEvent);
        } catch(Exception e){
            log.error("File Upload Fail", e);
            FileEvent errorEvent = FileEvent.toErrorEvent(data);
            fileEventPublisher.notifyError(errorEvent);
        }
    }
}
