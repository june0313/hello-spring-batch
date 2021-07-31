package io.spring.helloworld.configuration.flow;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.job.flow.Flow;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FlowLastConfiguration {
    private final JobBuilderFactory jobBuilderFactory;

    public FlowLastConfiguration(JobBuilderFactory jobBuilderFactory) {
        this.jobBuilderFactory = jobBuilderFactory;
    }

    @Bean
    public Job flowLastJob(Flow flow, Step myStep) {
        return jobBuilderFactory.get("flowLastJob")
                .start(myStep)
                .on("COMPLETED").to(flow)
                .end()
                .build();
    }
}
