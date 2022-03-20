package com.faceplusplus.spring.boot.req;

import com.faceplusplus.spring.boot.FaceppApiAddress;

import java.util.function.Function;

public enum SkinAnalyzeType {

    BASIC((x) -> {
        return FaceppApiAddress.FACE_SKIN_ANALYZE;
    }),
    ADVANCED((x) -> {
        return FaceppApiAddress.FACE_SKIN_ANALYZE_ADVANCED;
    }),
    PRO((x) -> {
        return FaceppApiAddress.FACE_SKIN_ANALYZE_PRO;
    });

    Function<Object, FaceppApiAddress> function;

    SkinAnalyzeType(Function<Object, FaceppApiAddress> function){
        this.function = function;
    }

    public FaceppApiAddress getApiAddress(){
        return function.apply(this);
    }


}
