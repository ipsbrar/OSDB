package com.osdb.android.utils.rx;

import io.reactivex.Scheduler;

public interface SchedulerProvider
{
    Scheduler ui();

    Scheduler computation();

    Scheduler io();
}
