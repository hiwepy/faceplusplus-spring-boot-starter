package com.faceplusplus.spring.boot.req;

import com.faceplusplus.spring.boot.AgoraApiAddress;

import java.util.function.Function;

public enum SkinAnalyzeType {

    BASIC((x) -> {
        return AgoraApiAddress.FACE_SKIN_ANALYZE;
    }),
    ADVANCED((x) -> {
        return AgoraApiAddress.FACE_SKIN_ANALYZE_ADVANCED;
    }),
    PRO((x) -> {
        return AgoraApiAddress.FACE_SKIN_ANALYZE_PRO;
    });

    Function<Object, AgoraApiAddress> function;

    SkinAnalyzeType(Function<Object, AgoraApiAddress> function){
        this.function = function;
    }

    public AgoraApiAddress getApiAddress(){
        return function.apply(this);
    }


}
