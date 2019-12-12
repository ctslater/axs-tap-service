
package org.opencadc.tap.ws;

import ca.nrc.cadc.tap.QueryRunner;
import ca.nrc.cadc.uws.server.JobExecutor;
import ca.nrc.cadc.uws.server.MemoryJobPersistence;
// import ca.nrc.cadc.uws.server.impl.PostgresJobPersistence;
import ca.nrc.cadc.uws.server.SimpleJobManager;
import ca.nrc.cadc.uws.server.ThreadPoolExecutor;
import org.apache.log4j.Logger;

public class QueryJobManager extends SimpleJobManager {

    private static Logger log = Logger.getLogger(QueryJobManager.class);

    private static final long MAX_EXEC_DURATION = 4 * 3600L;    // 4 hours to dump a catalog to vpsace
    private static final long MAX_DESTRUCTION = 7 * 24 * 60 * 60L; // 1 week
    private static final long MAX_QUOTE = 24 * 3600L;         // 24 hours since we have a threadpool with

    public QueryJobManager() {
        super();
        MemoryJobPersistence jobPersist = new MemoryJobPersistence();
        log.debug("created: " + jobPersist.getClass().getName());

        // this implementation spawns a new thread for every async job
        //JobExecutor jobExec = new ThreadExecutor(jobPersist, QueryRunner.class);

        // this implementation uses a thread pool for async jobs (with 2 threads)
        JobExecutor jobExec = new ThreadPoolExecutor(jobPersist, QueryRunner.class, 2);
        log.debug("created: " + jobExec.getClass().getName());

        super.setJobPersistence(jobPersist);
        super.setJobExecutor(jobExec);
    }
}
