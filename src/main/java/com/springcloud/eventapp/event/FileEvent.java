package com.springcloud.eventapp.event;

import lombok.Builder;
import lombok.Getter;

import java.util.Map;
import java.util.UUID;

@Getter
@Builder
public class FileEvent {
    private String id;
    private String type;
    private Map<String, Object> data;

    public static FileEvent toCompeteEvent(Map data){
        return FileEvent.builder()
                .id(UUID.randomUUID().toString())
                .type(EventType.COMPLETE.name())
                .data(data)
                .build();
    }

    public static FileEvent toErrorEvent(Map data){
        return FileEvent.builder()
                .id(UUID.randomUUID().toString())
                .type(EventType.ERROR.name())
                .data(data)
                .build();
    }
}
