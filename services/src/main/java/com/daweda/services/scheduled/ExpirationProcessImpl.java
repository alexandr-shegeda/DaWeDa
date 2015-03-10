package com.daweda.services.scheduled;

import com.daweda.services.ExpirationProcess;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by aleksandrsizov on 23.02.15.
 */
@Service
@Component (immediate = true)
public class ExpirationProcessImpl implements ExpirationProcess {
    /**
     * 900 second == 15 minutes
     */
    //TODO should be configurable value
    private static final int EXPIRATION_PERIOD = 900;

    ExecutorService executor;

    @Override
    public void start() {
        executor = Executors.newSingleThreadExecutor();
        executor.submit(new ExpirationProcessImpl());
    }

    @Override
    public void strop() {
        executor.shutdownNow();
    }

    @Override
    public void run() {
        JobDetail job = JobBuilder.newJob(ExpirationEvent.class)
                .withIdentity("dummyJobName", "group1").build();

        Trigger trigger = TriggerBuilder
                .newTrigger()
                .withIdentity("dummyTriggerName", "group1")
                .withSchedule(
                        SimpleScheduleBuilder.simpleSchedule()
                                .withIntervalInSeconds(EXPIRATION_PERIOD).repeatForever())
                .build();

        Scheduler scheduler = null;
        try {
            scheduler = new StdSchedulerFactory().getScheduler();
            scheduler.start();
            scheduler.scheduleJob(job, trigger);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

}
