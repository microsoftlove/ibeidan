package com.ibeidan.web.dutychain3;

public interface Filter {

    void execute(Alarm alarm, FilterChain filterChain);
}
