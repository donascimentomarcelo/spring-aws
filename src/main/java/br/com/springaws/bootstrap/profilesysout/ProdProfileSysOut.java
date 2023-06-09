package br.com.springaws.bootstrap.profilesysout;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * Created by jt on 5/21/16.
 */
@Component
@Profile("prod")
public class ProdProfileSysOut {

    @Autowired
    public ProdProfileSysOut(@Value("${spring-aws.profile.message}") String msg) {
        System.out.println("##################################");
        System.out.println("##################################");
        System.out.println("##              PROD            ##");
        System.out.println(msg);
        System.out.println("##################################");
        System.out.println("##################################");
    }
}
