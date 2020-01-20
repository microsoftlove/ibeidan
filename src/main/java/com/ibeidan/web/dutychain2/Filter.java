package com.ibeidan.web.dutychain2;

public interface Filter {

    void execute(Alarm alarm,FilterChain filterChain);
}
