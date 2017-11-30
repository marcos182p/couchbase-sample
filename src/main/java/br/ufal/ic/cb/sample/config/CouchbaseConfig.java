package br.ufal.ic.cb.sample.config;

import com.couchbase.client.java.env.CouchbaseEnvironment;
import com.couchbase.client.java.env.DefaultCouchbaseEnvironment;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.config.BeanNames;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;
import org.springframework.data.couchbase.repository.support.IndexManager;

/**
 *
 * @author marcosmelo
 */
@Configuration
@EnableCouchbaseRepositories(basePackages = {"br.ufal.ic.cb.sample.model.repo"})
public class CouchbaseConfig extends AbstractCouchbaseConfiguration {

    @Value("${couchbase.cluster.bucket}")
    private String bucketName;

    @Value("${couchbase.cluster.password}")
    private String password;

    @Value("${couchbase.cluster.ips}")
    private String[] ips;

    @Override
    protected List<String> getBootstrapHosts() {
        System.out.println("ips = " + Arrays.asList(ips));
        return Arrays.asList(ips);
    }

    @Override
    protected String getBucketPassword() {
        return password;
    }

    @Override
    protected String getBucketName() {
        return bucketName;
    }

    @Override
    @Bean(name = BeanNames.COUCHBASE_INDEX_MANAGER)
    public IndexManager indexManager() {
        return new IndexManager(true, true, true);
    }

    @Override
    protected CouchbaseEnvironment getEnvironment() {
//        CouchbaseEnvironment environment = DefaultCouchbaseEnvironment.create();
//        environment.
        return DefaultCouchbaseEnvironment.builder().connectTimeout(60000).build();
//        return super.getEnvironment();
    }

}
