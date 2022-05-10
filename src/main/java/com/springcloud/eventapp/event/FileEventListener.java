package com.springcloud.eventapp.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class FileEventListener {

    @EventListener
    public void onFileEventHandler(FileEvent fileEvent){
        log.info("FileEvent Recive Type : {}  data: {}", fileEvent.getType(), fileEvent.getData());

        if(fileEvent.getType().equals("COMPLETE")){
            //사용자에게 파일 업로드 완료 메시지를 전송함.
        }
    }
}
