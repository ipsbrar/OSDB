package com.osdb.pro.utils.rx;

import io.reactivex.Scheduler;

public interface SchedulerProvider
{
    Scheduler ui();

    Scheduler computation();

    Scheduler io();
}
