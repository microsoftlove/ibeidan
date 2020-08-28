package com.ibeidan.web.dutychain4;

public interface Filter {

    void execute(Alarm alarm, FilterChain filterChain);

    void execute(Request request,Response response, FilterChain filterChain);
}
