package com.ibeidan.web.dutychain4;

public interface Filter {

    void execute(Alarm alarm, FilterChain filterChain);
}
