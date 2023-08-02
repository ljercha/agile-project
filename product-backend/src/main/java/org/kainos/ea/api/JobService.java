package org.kainos.ea.api;

import org.kainos.ea.db.job.JobDao;
import org.kainos.ea.cli.Job;
import java.util.List;
public class JobService {
    JobDao jobDao = new JobDao();
    public List<Job> getJobSpecification() {

        return jobDao.getJobSpecification();

    }
}

